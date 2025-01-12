package com.example.back_challenge.models;

import jakarta.persistence.*;

@Entity
@Table(name= "detalle_caracteristica_planta")
public class DetalleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;

    @ManyToOne
    @JoinColumn(name = "id_planta")
    private PlantasModel planta;

    @ManyToOne
    @JoinColumn(name = "id_caracteristica")
    private CaracteristicasModel caracteristica;

    public PlantasModel getPlanta() {
        return planta;
    }

    public void setPlanta(PlantasModel planta) {
        this.planta = planta;
    }

    public CaracteristicasModel getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(CaracteristicasModel caracteristica) {
        this.caracteristica = caracteristica;
    }

    private Long primero;
    private Long segundo;
    private Long tercero;

    public DetalleModel() {
    }

    public DetalleModel(Long id, Long primero, Long segundo, Long tercero) {
        Id = id;
        this.primero = primero;
        this.segundo = segundo;
        this.tercero = tercero;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getPrimero() {
        return primero;
    }

    public void setPrimero(Long primero) {
        this.primero = primero;
    }

    public Long getSegundo() {
        return segundo;
    }

    public void setSegundo(Long segundo) {
        this.segundo = segundo;
    }

    public Long getTercero() {
        return tercero;
    }

    public void setTercero(Long tercero) {
        this.tercero = tercero;
    }
}
