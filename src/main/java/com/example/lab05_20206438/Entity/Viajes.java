package com.example.lab05_20206438.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Viajes")
public class Viajes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idViajes",nullable = false)
    private  Integer idViajes;
    @ManyToOne
    @JoinColumn(name="Persona_idPersona")
    private Persona persona;
    @ManyToOne
    @JoinColumn(name="Lugares_idLugares")
    private Lugares lugares;
    @Column(name="punto_recojo")
    private String puntoRecojo;
    @Column(name="cant_personas")
    private String cantPersonas;
    
}
