package com.example.back_challenge.controller;

import com.example.back_challenge.dto.UserRegisterRequestDto;
import com.example.back_challenge.dto.UserRequestDto;
import com.example.back_challenge.models.UserModel;
import com.example.back_challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UserService userService;

    @PostMapping("/email")
    public UserModel getUsuarioPorMail(@RequestBody UserRequestDto user)
    {
        return this.userService.obtenerPorMail(user.getEmail());
    }
    @PostMapping
    public  UserModel saveModel(@RequestBody UserRegisterRequestDto user)
    {
        UserModel userCreate= new UserModel();
        userCreate.setEmail(user.getEmail());
        userCreate.setNombre(user.getNombre());
        userCreate.setPassword(user.getPass());
        return  this.userService.saveUser(userCreate);
    }
}
