package com.example.back_challenge.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pais")
public class PaisModel {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;

    @Column(unique = true)
    private String nombre;

    private  String icono;
    @OneToMany (mappedBy = "pais", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PlantasModel> plantas = new HashSet<>();
    public PaisModel() {
    }

    public PaisModel(Long id, String nombre, String icono) {
        Id = id;
        this.nombre = nombre;
        this.icono = icono;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
}

