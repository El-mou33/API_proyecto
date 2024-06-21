package com.example.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "adoptados")
public class AdoptedDogs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdoptado;

    private String nombre;
    @Column(unique = true)
    private Long identificador;
    @Column(length = 1000)
    private String imagenes;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "duenos_id")
    private Dueños duenos;


}
