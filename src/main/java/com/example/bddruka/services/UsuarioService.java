package com.example.bddruka.services;

import com.example.bddruka.entities.UsuarioEntity;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<UsuarioEntity> obtenerUsuarios();
    Optional<UsuarioEntity> obtenerUsuarioPorId(Long id);
    UsuarioEntity guardarUsuario(UsuarioEntity usuarioEntity);
    void borrarUsuarioPorId(Long id);
    UsuarioEntity editarUsuarioPorId(Long id,UsuarioEntity usuarioEntity);


}
