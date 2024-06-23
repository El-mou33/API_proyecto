package com.example.api.controllers;

import com.example.api.dtos.DuenoDtoResponse;
import com.example.api.dtos.DuenosDtoRequest;
import com.example.api.models.Dueños;
import com.example.api.service.DuenosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DuenosController {
    @Autowired
    DuenosService duenosService;

    @Transactional(readOnly = true)
    @GetMapping("/findAll")
    public List<DuenoDtoResponse> findAll() {
        return duenosService.devolverTodosLosdueños();
    }

    @Transactional(readOnly = true)
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> encontrarPorId(@PathVariable("id") Long id) {
        DuenoDtoResponse dueñoDtoResponse = duenosService.findById(id).get();
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

    @Transactional
    @GetMapping("/findByEmail/{email}")
    public List<Dueños> findByEmail(@PathVariable("email")String email){
        return  duenosService.findByemail(email);
    }


}
