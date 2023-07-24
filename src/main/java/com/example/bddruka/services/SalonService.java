package com.example.bddruka.services;

import com.example.bddruka.entities.PlatoEntity;
import com.example.bddruka.entities.SalonEntity;

import java.util.List;
import java.util.Optional;

public interface SalonService {

    List<SalonEntity> obtenerSalones();
    Optional<SalonEntity> obtenerSalonesPorId(Long id);
    SalonEntity guardarSalon(SalonEntity salonEntity);
    void borrarSalonPorId(Long id);
    SalonEntity editarSalonPorId(Long id, SalonEntity salonEntity);

}
