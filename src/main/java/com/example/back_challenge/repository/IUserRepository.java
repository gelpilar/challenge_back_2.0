package com.example.back_challenge.repository;


import com.example.back_challenge.models.UserModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {



    @Transactional
    @Query("SELECT u FROM UserModel u WHERE u.email = :email ")
    UserModel encontrarPorEmail(@Param("email") String email);

}
