package com.example.back_challenge.service;

import com.example.back_challenge.dto.AlertasDto;
import com.example.back_challenge.dto.CaracteristicaDto;
import com.example.back_challenge.dto.PlantaRequesDto;
import com.example.back_challenge.models.PlantasModel;
import com.example.back_challenge.repository.IPlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlantaService {
    @Autowired
    private  IPlantaRepository plantaRepository;


    public void postPlanta(Long idUsuario, Long idPais, String nombre) {
        if (idUsuario == null || idPais == null  || nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }
        plantaRepository.introducir(idUsuario, idPais, nombre);
    }

    public ArrayList<PlantasModel> getPlantasTodas()
    {


        return (ArrayList<PlantasModel>)  plantaRepository.findAll();
    }

    public ArrayList<PlantasModel> getPlantasPorId(Long id)
    {

        return (ArrayList<PlantasModel>)  plantaRepository.obtenerPlantarPorId(id);
    }

    public List<CaracteristicaDto> getCaracteristicas(Long id)
    {
        return this.plantaRepository.findCaracteristicasByPlantaId(id);
    }
    public AlertasDto getAlertas(Long id)
    {
        return  this.plantaRepository.findAlertasByPlantaId(id);
    }
    public AlertasDto getAlertasUsuario(Long id)
    {
        return  this.plantaRepository.encontrarTodasLasAlertas(id);
    }

    public void ModificarPlanta(Long id, PlantaRequesDto planta)
    {
       this.plantaRepository.actualizarCampos(planta.getRoja(),planta.getMedia(),planta.getLectura(), planta.getDesabilitados(),id);
    }

}
