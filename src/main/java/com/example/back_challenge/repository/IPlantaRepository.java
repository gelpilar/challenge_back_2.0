package com.example.back_challenge.repository;


import com.example.back_challenge.dto.AlertasDto;
import com.example.back_challenge.dto.CaracteristicaDto;
import com.example.back_challenge.models.PlantasModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface IPlantaRepository extends JpaRepository<PlantasModel, Long> {


    @Procedure(procedureName = "introducirPlanta")
    void introducir(
            @Param("id_usuario") Long idUsuario,
            @Param("id_pais") Long idPais,
            @Param("nombre") String nombre
    );

    @Transactional
    @Query("SELECT p FROM PlantasModel p")
    List<PlantasModel> obtener();

    @Transactional
    @Query("SELECT p FROM PlantasModel p WHERE p.usuario.id= :id")
    List<PlantasModel> obtenerPlantarPorId(@Param("id") Long id);

    @Transactional
    @Query(value = "SELECT c.nombre, d.primero, d.segundo, d.tercero " +
            "FROM detalle_caracteristica_planta d " +
            "INNER JOIN caracteristica c ON d.id_caracteristica = c.id " +
            "WHERE d.id_planta = :idPlanta " +
            "ORDER BY c.id", nativeQuery = true)
    List<CaracteristicaDto> findCaracteristicasByPlantaId(@Param("idPlanta") Long idPlanta);

    @Transactional
    @Query(value = "SELECT a.roja, a.lectura, a.media, a.desabilitados " +
            "FROM planta p " +
            "INNER JOIN alerta a ON a.id = p.id_alerta " +
            "WHERE p.id = :idPlanta " +
            "ORDER BY a.roja", nativeQuery = true)
    AlertasDto findAlertasByPlantaId(@Param("idPlanta") Long idPlanta);


    @Transactional
    @Query(value = "SELECT CAST(SUM(a.roja) AS SIGNED) AS roja, " +
            "CAST(SUM(a.lectura) AS SIGNED) AS lectura, " +
            "CAST(SUM(a.media) AS SIGNED) AS media, " +
            "CAST(SUM(a.desabilitados) AS SIGNED) AS deshabilitados " +
            "FROM planta p " +
            "INNER JOIN alerta a ON a.id = p.id_alerta " +
            "INNER JOIN usuario u ON p.id_usuario = u.id " +
            "WHERE u.id = :idUsuario " +
            "ORDER BY a.roja", nativeQuery = true)
    AlertasDto encontrarTodasLasAlertas(@Param("idUsuario") Long idUsuario);

    @Modifying
    @Transactional
    @Query(value = "UPDATE alerta a " +
            "INNER JOIN planta p ON p.id_alerta = a.id " +
            "SET a.roja = :roja, " +
            "a.media = :media, " +
            "a.lectura = :lectura, " +
            "a.desabilitados = :desabilitados " +
            "WHERE p.id = :plantaId", nativeQuery = true)
    void actualizarCampos(@Param("roja") Long roja,
                          @Param("media") Long media,
                          @Param("lectura") Long lectura,
                          @Param("desabilitados") Long desabilitados,
                          @Param("plantaId") Long plantaId);



}
