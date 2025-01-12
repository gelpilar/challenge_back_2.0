package com.example.back_challenge.dto;

public class UserRequestDto {
    private String email;

    public UserRequestDto(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
