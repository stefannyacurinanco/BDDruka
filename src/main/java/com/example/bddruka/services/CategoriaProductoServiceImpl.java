package com.example.bddruka.services;

import com.example.bddruka.entities.CategoriaProductoEntity;
import com.example.bddruka.entities.ProductoEntity;
import com.example.bddruka.repositories.CategoriaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaProductoServiceImpl implements CategoriaProductoService{

    @Autowired
    CategoriaProductoRepository categoriaProductoRepository;

    @Override
    public CategoriaProductoEntity buscarPorId(Long id){
        return categoriaProductoRepository.findById(id).get();
    }

    @Override
    public List<CategoriaProductoEntity> obtenerCategoriaProductos() {
        List<CategoriaProductoEntity> listaCategoriaProductos = categoriaProductoRepository.findAll();
        return listaCategoriaProductos;
    }

    @Override
    public CategoriaProductoEntity guardarCategoriaProducto(CategoriaProductoEntity categoriaProductoEntity) {
        CategoriaProductoEntity nuevaCategoriaProducto = categoriaProductoRepository.save(categoriaProductoEntity);
        return nuevaCategoriaProducto;
    }

    @Override
    public void borrarCategoriaProductoPorId(Long id) {
        categoriaProductoRepository.deleteById(id);
    }

    @Override
    public CategoriaProductoEntity editarCategoriaProductoPorId(Long usuarioId, CategoriaProductoEntity categoriaProductoEditar) {

        Boolean existe = categoriaProductoRepository.existsById(usuarioId);

        if (existe) {
            CategoriaProductoEntity categoriaProductoSeleccionado = categoriaProductoRepository.findById(usuarioId).get();
            categoriaProductoSeleccionado.setNombreCategoriaProducto(categoriaProductoEditar.getNombreCategoriaProducto());
            return categoriaProductoRepository.save(categoriaProductoSeleccionado);
        }
        return null;
    }

}
