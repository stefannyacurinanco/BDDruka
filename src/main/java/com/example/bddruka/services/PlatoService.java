package com.example.bddruka.services;

import com.example.bddruka.entities.PlatoEntity;

import java.util.List;
import java.util.Optional;

public interface PlatoService {

    List<PlatoEntity> obtenerPlatos();
    Optional<PlatoEntity> obtenerPlatosPorId(Long id);
    PlatoEntity guardarPlato(PlatoEntity platoEntity);
    void borrarPlatoPorId(Long id);
    PlatoEntity editarPlatoPorId(Long id, PlatoEntity platoEntity);

}
