package com.example.api.service;

import com.example.api.models.Dueños;
import com.example.api.repository.DuenosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DuenosService {
    @Autowired
    DuenosRepository duenosRepository;

    public List<Dueños> devolverTodosLosdueños(){

        return duenosRepository.findAll();
    }


}
