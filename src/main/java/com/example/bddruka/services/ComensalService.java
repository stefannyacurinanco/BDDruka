package com.example.bddruka.services;

import com.example.bddruka.entities.ComensalEntity;

import java.util.List;
import java.util.Optional;

public interface ComensalService {
    List<ComensalEntity> obtenerComensales();
    Optional<ComensalEntity> obtenerComensalPorId(Long id);
    ComensalEntity guardarComensal(ComensalEntity comensalEntity);
    void borrarComensalPorId(Long id);
    ComensalEntity editarComensalPorId(Long id, ComensalEntity comensalEntity);


}
