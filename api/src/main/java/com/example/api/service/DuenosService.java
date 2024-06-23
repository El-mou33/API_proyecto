package com.example.api.service;

import com.example.api.dtos.DuenosDtoRequest;
import com.example.api.dtos.DuenoDtoResponse;
import com.example.api.mappers.DuenoRequestMapper;
import com.example.api.mappers.DuenosMapper;
import com.example.api.models.Dueños;
import com.example.api.repository.DuenosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DuenosService {
    @Autowired
    DuenosRepository duenosRepository;

    public List<DuenoDtoResponse> devolverTodosLosdueños(){

        return DuenosMapper.entitystoDtos(duenosRepository.findAll());
    }
    public Optional<DuenoDtoResponse> findById (Long id){
        Dueños dueños = duenosRepository.findById(id).orElseThrow();
        return Optional.of(DuenosMapper.entityToDto(dueños));

    }

    public DuenosDtoRequest save(DuenosDtoRequest dueno){
        Dueños entity = DuenoRequestMapper.DtoToEntity(dueno);
        Dueños dueños = duenosRepository.save(entity);
        return DuenoRequestMapper.entityToDto(dueños);
    }

    public DuenosDtoRequest actualizado(DuenosDtoRequest duenos,Long id){
        Dueños entity = DuenoRequestMapper.DtoToEntity(duenos);
        Optional<Dueños> byId = duenosRepository.findById(id);
        if(byId.isPresent()){
            duenos.setIdDueno(id);
          return DuenoRequestMapper.entityToDto(duenosRepository.save(entity));
        }
        return null;

    }


    public List<Dueños> findByemail(String email){
      return   duenosRepository.findByEmail(email);
    }
}
