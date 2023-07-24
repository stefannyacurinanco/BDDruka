package com.example.bddruka.services;

import com.example.bddruka.entities.CategoriaPlatoEntity;

import java.util.List;

public interface CategoriaPlatoService {

    CategoriaPlatoEntity buscarPorId(Long id);

    List<CategoriaPlatoEntity> obtenerCategoriaPlatos();

    CategoriaPlatoEntity guardarCategoriaPlato(CategoriaPlatoEntity categoriaPlatoEntity);

    void borrarCategoriaPlatoPorId(Long id);
}
