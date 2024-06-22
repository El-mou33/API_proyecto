package com.example.api.service;

import com.example.api.dtos.DuenosDtoRequest;
import com.example.api.dtos.DueñoDtoResponse;
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

    public List<DueñoDtoResponse> devolverTodosLosdueños(){

        return DuenosMapper.entitystoDtos(duenosRepository.findAll());
    }
    public Optional<Dueños> findById (Long id){

    return duenosRepository.findById(id);

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

}
