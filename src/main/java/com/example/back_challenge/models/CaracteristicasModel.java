package com.example.back_challenge.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "caracteristica")
public class CaracteristicasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;

    @Column(unique = true)
    private String nombre;




    public CaracteristicasModel() {
    }

    public CaracteristicasModel(Long id, String nombre, Set<DetalleModel> plantas) {
        Id = id;
        this.nombre = nombre;
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


}
