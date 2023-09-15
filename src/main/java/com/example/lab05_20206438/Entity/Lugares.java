package com.example.lab05_20206438.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="Lugares")
public class Lugares {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLugares",nullable = false)
    private  Integer idLugares;
    @Column(name="nombre_lugar",nullable = false)
    private String nombreLugar;
    @Column(name="descrip_lugar")
    private String descripcion;
    @Column(name="fecha_lugar")
    private Date fecha;


}
