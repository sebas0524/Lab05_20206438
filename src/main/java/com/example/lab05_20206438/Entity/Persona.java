package com.example.lab05_20206438.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="Persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona",nullable = false)
    private  Integer idPersona;
    @Column(name="nombre",nullable = false)
    private String nombre;
    @Column(name="dni")
    private String dni;
    @Column(name="celular")
    private String celular;
    @Column(name="tipo_persona")
    private String tipoPersona;

}
