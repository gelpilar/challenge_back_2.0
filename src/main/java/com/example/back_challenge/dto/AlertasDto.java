package com.example.back_challenge.dto;

public class AlertasDto {
    private Long roja;
    private Long lectura;
    private Long media;
    private Long desabilitados;

    public AlertasDto(Long roja, Long lectura, Long media, Long desabilitados) {
        this.roja = roja;
        this.lectura = lectura;
        this.media = media;
        this.desabilitados = desabilitados;
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
