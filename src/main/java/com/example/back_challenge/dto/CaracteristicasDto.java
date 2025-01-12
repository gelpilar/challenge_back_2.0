package com.example.back_challenge.dto;

import com.example.back_challenge.models.CaracteristicasModel;
import com.example.back_challenge.models.DetalleModel;

import java.util.ArrayList;
import java.util.List;

public class CaracteristicasDto {

    private ArrayList<CaracteristicaDto> caracteristicas;

    public CaracteristicasDto(ArrayList<CaracteristicaDto> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public ArrayList<CaracteristicaDto> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(ArrayList<CaracteristicaDto> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }


}


