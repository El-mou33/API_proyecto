package com.example.api.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DuenosDtoRequest
{

    private Long idDueno;

    private String nombre;

    private String apellidos;

    private String dni;

    private Long telefono;

    private String email;


}
