package com.example.api.controllers;

import com.example.api.models.Dueños;
import com.example.api.service.DuenosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DuenosController {
    @Autowired
    DuenosService duenosService;

    @GetMapping("/findAll")
    public List<Dueños> findAll(){
        return duenosService.devolverTodosLosdueños();
    }



}
