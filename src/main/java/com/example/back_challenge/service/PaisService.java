package com.example.back_challenge.service;

import com.example.back_challenge.models.PaisModel;
import com.example.back_challenge.repository.IPaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PaisService {
@Autowired
    IPaisRepository paisRepository;
public ArrayList<PaisModel> getPaises()
{
    return (ArrayList<PaisModel>) paisRepository.findAll();
}
}
