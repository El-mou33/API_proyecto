package com.example.api.mappers;

import com.example.api.dtos.DuenoDtoResponse;
import com.example.api.models.Dueños;

import java.util.ArrayList;
import java.util.List;

public  class DuenosMapper {


    public static DuenoDtoResponse entityToDto(Dueños dueno){
        DuenoDtoResponse nuevo = new DuenoDtoResponse();
        nuevo.setDni(dueno.getDni());
        nuevo.setIdDueno(dueno.getIdDueno());
        nuevo.setApellidos(dueno.getApellidos());
        nuevo.setNombre(dueno.getNombre());
        nuevo.setEmail(dueno.getEmail());
        nuevo.setTelefono(dueno.getTelefono());

        return nuevo;

    }

    public static List<DuenoDtoResponse> entitystoDtos(List<Dueños>duenos){
        List<DuenoDtoResponse> dtos = new ArrayList<>();
        for (Dueños entity:
             duenos) {
            dtos.add(DuenosMapper.entityToDto(entity));
        }
        return dtos;
    }

}
