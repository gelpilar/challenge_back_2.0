package com.example.back_challenge.dto;

public class CaracteristicaDto {
    private String nombre;
    private  Long primero;
    private  Long segundo;
    private  Long Tercero;

    public CaracteristicaDto(String nombre, Long primero, Long segundo, Long tercero) {
        this.nombre = nombre;
        this.primero = primero;
        this.segundo = segundo;
        Tercero = tercero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return Tercero;
    }

    public void setTercero(Long tercero) {
        Tercero = tercero;
    }
}
