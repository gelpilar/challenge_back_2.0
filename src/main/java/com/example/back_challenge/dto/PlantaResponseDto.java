package com.example.back_challenge.dto;

import com.example.back_challenge.models.PlantasModel;

import java.util.ArrayList;
import java.util.Arrays;

public class PlantaResponseDto {
    private Long id;
    private String nombre;
    private String icono_pais;
    private String nombre_pais;
    private Long roja;
    private Long lectura;
    private Long media;
    private Long desabilitados;

    public PlantaResponseDto(Long id,String nombre, String icono_pais, String nombre_pais, Long roja, Long lectura, Long media, Long desabilitados) {
        this.id=id;
        this.nombre = nombre;
        this.icono_pais = icono_pais;
        this.nombre_pais = nombre_pais;
        this.roja = roja;
        this.lectura = lectura;
        this.media = media;
        this.desabilitados = desabilitados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static ArrayList<PlantaResponseDto> arregloDTO(ArrayList<PlantasModel> plantasModels)
    {
        ArrayList<PlantaResponseDto> arreglo= new ArrayList<PlantaResponseDto>();
        for (int i = 0; i < plantasModels.size(); i++) {
            arreglo.add(cambiarDTO(plantasModels.get(i)));
        }
        return arreglo;
    }
    public static PlantaResponseDto cambiarDTO(PlantasModel planta)
    {
        PlantaResponseDto plantaNueva= new PlantaResponseDto(planta.getId(),planta.getNombre(),planta.getPais().getIcono(),
                planta.getPais().getNombre(),planta.getAlertas().getRoja(),planta.getAlertas().getLectura(),
                planta.getAlertas().getMedia(),planta.getAlertas().getDesabilitados());
        return plantaNueva;

    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIcono_pais() {
        return icono_pais;
    }

    public void setIcono_pais(String icono_pais) {
        this.icono_pais = icono_pais;
    }

    public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }

    public Long getRoja() {
        return roja;
    }

    public void setRoja(Long roja) {
        this.roja = roja;
    }

    public Long getLectura() {
        return lectura;
    }

    public void setLectura(Long lectura) {
        this.lectura = lectura;
    }

    public Long getMedia() {
        return media;
    }

    public void setMedia(Long media) {
        this.media = media;
    }

    public Long getDesabilitados() {
        return desabilitados;
    }

    public void setDesabilitados(Long desabilitados) {
        this.desabilitados = desabilitados;
    }
}
