package com.example.back_challenge.models;

import jakarta.persistence.*;

@Entity
@Table(name= "alerta")
public class AlertasModel {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;
    private Long roja;
    private Long lectura;
    private Long media;
    private Long desabilitados;
    public AlertasModel() {
    }

    public AlertasModel(Long id, Long roja, Long lectura, Long media, Long desabilitados) {
        Id = id;
        this.roja = roja;
        this.lectura = lectura;
        this.media = media;
        this.desabilitados = desabilitados;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getRoja() {
        return roja;
    }

    public void setRoja(Long roja) {
        this.roja = roja;
    }

    public Long getLectura() {
        return lectura;
    }

    public void setLectura(Long lectura) {
        this.lectura = lectura;
    }

    public Long getMedia() {
        return media;
    }

    public void setMedia(Long media) {
        this.media = media;
    }

    public Long getDesabilitados() {
        return desabilitados;
    }

    public void setDesabilitados(Long desabilitados) {
        this.desabilitados = desabilitados;
    }
}
