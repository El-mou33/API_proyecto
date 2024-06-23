package com.example.api.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DuenoDtoResponse {

    private Long idDueno;

    private String nombre;

    private String apellidos;

    private String dni;

    private Long telefono;

    private String email;


}
