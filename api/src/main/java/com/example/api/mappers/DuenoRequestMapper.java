package com.example.api.mappers;

import com.example.api.dtos.DuenosDtoRequest;
import com.example.api.dtos.DueñoDtoResponse;
import com.example.api.models.Dueños;

import java.util.ArrayList;
import java.util.List;

public class DuenoRequestMapper {

    public static DuenosDtoRequest entityToDto(Dueños dueno){
        DuenosDtoRequest nuevo = new DuenosDtoRequest();
        nuevo.setDni(dueno.getDni());
        nuevo.setIdDueno(dueno.getIdDueno());
        nuevo.setApellidos(dueno.getApellidos());
        nuevo.setNombre(dueno.getNombre());
        nuevo.setEmail(dueno.getEmail());
        nuevo.setTelefono(dueno.getTelefono());

        return nuevo;

    }

    public static List<DuenosDtoRequest> entitystoDtos(List<Dueños>duenos){
        List<DuenosDtoRequest> dtos = new ArrayList<>();
        for (Dueños entity:
                duenos) {
            dtos.add(DuenoRequestMapper.entityToDto(entity));
        }
        return dtos;
    }

    public static Dueños DtoToEntity(DuenosDtoRequest dto){
        Dueños nuevo = new Dueños();
        nuevo.setDni(dto.getDni());
        nuevo.setIdDueno(dto.getIdDueno());
        nuevo.setApellidos(dto.getApellidos());
        nuevo.setNombre(dto.getNombre());
        nuevo.setEmail(dto.getEmail());
        nuevo.setTelefono(dto.getTelefono());

        return nuevo;

    }
}
