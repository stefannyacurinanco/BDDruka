package com.example.bddruka.services;

import com.example.bddruka.entities.UsuarioEntity;
import com.example.bddruka.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioEntity> obtenerUsuario() {
        List<UsuarioEntity> listaUsuario = usuarioRepository.findAll();
        return listaUsuario;
    }




}
