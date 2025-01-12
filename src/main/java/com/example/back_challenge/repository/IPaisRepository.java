package com.example.back_challenge.repository;


import com.example.back_challenge.models.PaisModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaisRepository extends JpaRepository<PaisModel, Long> {
}
