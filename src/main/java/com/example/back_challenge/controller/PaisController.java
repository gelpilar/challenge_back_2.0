package com.example.back_challenge.controller;

import com.example.back_challenge.models.PaisModel;
import com.example.back_challenge.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/pais")
@CrossOrigin(origins = "http://localhost:4200")
public class PaisController {
    @Autowired
    private PaisService paisService;

    @GetMapping
    public ArrayList<PaisModel> getPais()
    {
        return this.paisService.getPaises();
    }
}
