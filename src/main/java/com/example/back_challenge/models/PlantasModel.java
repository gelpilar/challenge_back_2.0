package com.example.back_challenge.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "planta")
public class PlantasModel {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;

    private  String nombre;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UserModel usuario;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private PaisModel pais;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name ="id_alerta",referencedColumnName = "id")
    private AlertasModel alertas;



    public Long getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "PlantasModel{" +
                "Id=" + Id +
                ", nombre='" + nombre + '\'' +
                ", usuario=" + usuario +
                ", pais=" + pais +
                ", alertas=" + alertas +
                ", caracteristicas="  +
                '}';
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

    public UserModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UserModel usuario) {
        this.usuario = usuario;
    }

    public PaisModel getPais() {
        return pais;
    }

    public void setPais(PaisModel pais) {
        this.pais = pais;
    }

    public AlertasModel getAlertas() {
        return alertas;
    }

    public void setAlertas(AlertasModel alertas) {
        this.alertas = alertas;
    }



   

    public PlantasModel() {
    }
}
