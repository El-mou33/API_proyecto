package com.example.api.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "duenos")
public class Dueños {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDueno;

    private String nombre;

    private String apellidos;

    @Column(unique = true)
    private String dni;

    private Long telefono;
    @Column(unique = true)
    private String email;


    @OneToMany(mappedBy = "duenos",cascade = CascadeType.ALL)
    List<AdoptedDogs> perros;



}
