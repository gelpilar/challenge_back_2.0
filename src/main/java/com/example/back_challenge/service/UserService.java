package com.example.back_challenge.service;

import com.example.back_challenge.models.UserModel;
import com.example.back_challenge.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    public UserModel obtenerPorMail(String email)
    {
        UserModel user = userRepository.encontrarPorEmail(email);
        if (user == null) {
            throw new Error("No se encontró un usuario con el correo electrónico: " + email);
        }
        return user;
    }
    public UserModel saveUser(UserModel user)
    {
        return  userRepository.save(user);
    }


}
