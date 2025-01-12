package com.example.back_challenge.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "usuario")
public class UserModel {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;

    private String nombre;

    @Column(unique = true)
    @Email(message = "formato mail invalido")
    private String email;

    @Column
    @Size(min = 8, message = "contraseña no valida")
    private  String password;



    public UserModel() {
    }

    public UserModel(Long id, String nombre, String email, String password, Set<PlantasModel> plantas) {
        Id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
