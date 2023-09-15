package com.example.lab05_20206438.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Mascotas")
public class Mascotas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMascotas",nullable = false)
    private  Integer idMascota;
    @Column(name="nombre_mascota",nullable = false)
    private String nombre;
    @Column(name="genero")
    private String genero;
    @Column(name="edad")
    private String edad;
    @Column(name="fecha_nacimiento")
    private String fecha;
    @Column(name="Vacunado")
    private String vacunado;
    @Column(name="Desparasitado")
    private String desparasitado;
    @ManyToOne
    @JoinColumn(name="Persona_idPersona")
    private Persona persona;



}
