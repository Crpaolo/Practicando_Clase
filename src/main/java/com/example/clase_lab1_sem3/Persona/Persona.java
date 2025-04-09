package com.example.clase_lab1_sem3.Persona;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre" , unique = true)
    private String nombre;

    @Column(name = "apellido" , unique = false)
    private String apellido;

}
