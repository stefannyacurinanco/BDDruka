package com.example.bddruka.services;

import com.example.bddruka.entities.ComensalEntity;
import com.example.bddruka.entities.ProductoEntity;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<ProductoEntity> obtenerProductos();
    Optional<ProductoEntity> obtenerProductosPorId(Long id);
    ProductoEntity guardarProducto(ProductoEntity productoEntity);
    void borrarProductoPorId(Long id);
    ProductoEntity editarProductoPorId(Long id, ProductoEntity productoEntity);

}
