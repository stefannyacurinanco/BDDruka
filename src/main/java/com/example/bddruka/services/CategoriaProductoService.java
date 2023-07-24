package com.example.bddruka.services;

import com.example.bddruka.entities.CategoriaPlatoEntity;
import com.example.bddruka.entities.CategoriaProductoEntity;
import com.example.bddruka.entities.ComensalEntity;

import java.util.List;

public interface CategoriaProductoService {

    CategoriaProductoEntity buscarPorId(Long id);

    List<CategoriaProductoEntity> obtenerCategoriaProductos();

    CategoriaProductoEntity guardarCategoriaProducto(CategoriaProductoEntity categoriaProductoEntity);

    void borrarCategoriaProductoPorId(Long id);

    CategoriaProductoEntity editarCategoriaProductoPorId(Long id, CategoriaProductoEntity categoriaProductoEntity);

}
