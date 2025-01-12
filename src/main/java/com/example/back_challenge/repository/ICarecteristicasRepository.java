package com.example.back_challenge.repository;


import com.example.back_challenge.models.CaracteristicasModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarecteristicasRepository extends JpaRepository<CaracteristicasModel,Long> {
}
