package com.example.bddruka.services;

import com.example.bddruka.entities.CategoriaProductoEntity;
import com.example.bddruka.entities.ComensalEntity;
import com.example.bddruka.entities.ProductoEntity;
import com.example.bddruka.entities.ReservaEntity;
import com.example.bddruka.repositories.CategoriaProductoRepository;
import com.example.bddruka.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaProductoRepository categoriaProductoRepository;

    @Override
    public List<ProductoEntity> obtenerProductos() {
        List<ProductoEntity> listaProductos = productoRepository.findAll();
        return listaProductos;
    }

    @Override
    public Optional<ProductoEntity> obtenerProductosPorId(Long id) {
        Optional<ProductoEntity> productoElegido = productoRepository.findById(id);
        return productoElegido;
    }

    @Override
    public ProductoEntity guardarProducto(ProductoEntity productoEntity) {
        ProductoEntity nuevoProducto = productoRepository.save(productoEntity);
        return nuevoProducto;
    }

    @Override
    public void borrarProductoPorId(Long id) {
        productoRepository.deleteById(id);
    }


    @Override
    public ProductoEntity editarProductoPorId(Long usuarioId, ProductoEntity productoEditar) {

        Boolean existe = productoRepository.existsById(usuarioId);

        if (existe) {
            ProductoEntity productoSeleccionado = productoRepository.findById(usuarioId).get();
            productoSeleccionado.setNombreProducto(productoEditar.getNombreProducto());
            productoSeleccionado.setPrecioProducto(productoEditar.getPrecioProducto());
            productoSeleccionado.setDescripcion(productoEditar.getDescripcion());
            productoSeleccionado.setUrlImagen(productoEditar.getUrlImagen());
            productoSeleccionado.setCategoriaProducto(productoEditar.getCategoriaProducto());
            return productoRepository.save(productoSeleccionado);
        }
        return null;
    }


}
