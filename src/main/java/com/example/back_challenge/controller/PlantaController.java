package com.example.back_challenge.controller;

import com.example.back_challenge.dto.*;
import com.example.back_challenge.models.PlantasModel;
import com.example.back_challenge.service.PlantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/planta")
public class PlantaController {
    @Autowired
    private PlantaService plantasService;

    @PostMapping("/{id_usuario}")
    public ResponseEntity<String> postPlanta(
            @PathVariable Long id_usuario,
            @RequestBody PlantaDto planta) {
        try {
            this.plantasService.postPlanta(id_usuario, planta.getId_pais(), planta.getNombre());

            return ResponseEntity.ok("Planta agregada correctamente.");
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor.");
        }
    }

    @GetMapping
    public ArrayList<PlantasModel> getPlantas()
    {
           return  this.plantasService.getPlantasTodas();
           }

    @GetMapping("/plantas/{id}")
    public ArrayList<PlantaResponseDto> getPlantaPorId(@PathVariable Long id)
    {
        return PlantaResponseDto.arregloDTO(this.plantasService.getPlantasPorId(id));
    }

    @GetMapping("/caracteristicas/{id}")
    public List<CaracteristicaDto> getCaracteristicas(@PathVariable Long id)
    {
        return  this.plantasService.getCaracteristicas(id);
    }
    @GetMapping("/alertas/{id}")
    public AlertasDto getAlertas(@PathVariable Long id)
    {
        return  this.plantasService.getAlertas(id);
    }
    @GetMapping("/alertas/usuario/{id}")
    public AlertasDto getAlertasUsuario(@PathVariable Long id)
    {
        return  this.plantasService.getAlertasUsuario(id);
    }

    @PutMapping("/{id}")
    public void putAlertas(@PathVariable Long id, @RequestBody PlantaRequesDto planta)
    {
        this.plantasService.ModificarPlanta(id,planta);
    }

}
