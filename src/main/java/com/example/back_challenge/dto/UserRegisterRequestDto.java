package com.example.back_challenge.dto;

public class UserRegisterRequestDto {
    private String email;
    private String nombre;
    private String pass;

    public UserRegisterRequestDto(String email, String nombre, String pass) {
        this.email = email;
        this.nombre = nombre;
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
