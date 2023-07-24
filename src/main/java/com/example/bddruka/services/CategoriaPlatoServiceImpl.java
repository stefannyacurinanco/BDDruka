package com.example.bddruka.services;

import com.example.bddruka.entities.CategoriaPlatoEntity;
import com.example.bddruka.repositories.CategoriaPlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaPlatoServiceImpl implements CategoriaPlatoService {

    @Autowired
    CategoriaPlatoRepository categoriaPlatoRepository;

    @Override
    public CategoriaPlatoEntity buscarPorId(Long id){
        return categoriaPlatoRepository.findById(id).get();
    }

    @Override
    public List<CategoriaPlatoEntity> obtenerCategoriaPlatos() {
        List<CategoriaPlatoEntity> listaCategoriasPlatos = categoriaPlatoRepository.findAll();
        return listaCategoriasPlatos;
    }

    @Override
    public CategoriaPlatoEntity guardarCategoriaPlato(CategoriaPlatoEntity categoriaPlatoEntity) {
        CategoriaPlatoEntity nuevaCategoriaPlato = categoriaPlatoRepository.save(categoriaPlatoEntity);
        return nuevaCategoriaPlato;
    }


    @Override
    public void borrarCategoriaPlatoPorId(Long id) {
        categoriaPlatoRepository.deleteById(id);
    }

}

