package com.example.back_challenge.config;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class AuthResponse {
    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }
    public AuthResponse() {
        this.token = "";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
