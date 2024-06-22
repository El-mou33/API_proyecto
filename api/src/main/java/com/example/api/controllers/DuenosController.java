package com.example.api.controllers;

import com.example.api.dtos.DuenosDtoRequest;
import com.example.api.dtos.DueñoDtoResponse;
import com.example.api.mappers.DuenosMapper;
import com.example.api.models.Dueños;
import com.example.api.service.DuenosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DuenosController {
    @Autowired
    DuenosService duenosService;

    @Transactional(readOnly = true)
    @GetMapping("/findAll")
    public List<DueñoDtoResponse> findAll() {
        return duenosService.devolverTodosLosdueños();
    }

    @Transactional(readOnly = true)
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> encontrarPorId(@PathVariable("id") Long id) {
        DueñoDtoResponse dueñoDtoResponse = DuenosMapper.entityToDto(duenosService.findById(id).get());
        return ResponseEntity.ok(dueñoDtoResponse);

    }

    @Transactional
    @PostMapping("/add")
    public ResponseEntity<?> guardar(@RequestBody DuenosDtoRequest dueno) {

        DuenosDtoRequest save = duenosService.save(dueno);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @Transactional
    @PutMapping("/update/{id}")
    public ResponseEntity<?> actualizar(@PathVariable("id") Long id, @RequestBody DuenosDtoRequest dueno) {

        DuenosDtoRequest actualizado = duenosService.actualizado(dueno, id);
        return ResponseEntity.status(201).body(actualizado);

    }


}
