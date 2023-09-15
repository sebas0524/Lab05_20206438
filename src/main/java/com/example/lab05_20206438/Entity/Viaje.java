package com.example.lab05_20206438.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Viajes")
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idViajes",nullable = false)
    private  Integer idViaje;
    @Column(name="punto_recojo",nullable = false)
    private String puntoRecojo;
    @Column(name="cant_personas")
    private String cantPersonas;
    @Column(name="cant_perros")
    private String cantPerros;
    @ManyToOne
    @JoinColumn(name="Persona_idPersona")
    private Persona persona;
    @ManyToOne
    @JoinColumn(name="Lugares_idLugares")
    private Lugares lugares;

    
}
