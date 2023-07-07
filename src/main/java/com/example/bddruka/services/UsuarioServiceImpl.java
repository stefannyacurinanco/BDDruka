package com.example.bddruka.services;

import com.example.bddruka.entities.UsuarioEntity;
import com.example.bddruka.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioEntity> obtenerUsuarios() {
        List<UsuarioEntity> listaUsuarios = usuarioRepository.findAll();
        return listaUsuarios;
    }

    @Override
    public Optional<UsuarioEntity> obtenerUsuarioPorId(Long id) {
        Optional<UsuarioEntity> usuarioElegido = usuarioRepository.findById(id);
        return usuarioElegido;
    }

    @Override
    public UsuarioEntity guardarUsuario(UsuarioEntity usuarioEntity) {
        UsuarioEntity nuevoUsuario = usuarioRepository.save(usuarioEntity);
        return nuevoUsuario;
    }

    @Override
    public void borrarUsuarioPorId(Long id) {usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioEntity editarUsuarioPorId(Long usuarioId, UsuarioEntity usuarioEditar) {

        Boolean existe = usuarioRepository.existsById(usuarioId);

        if (existe) {
            UsuarioEntity usuarioSeleccionado = usuarioRepository.findById(usuarioId).get();
            usuarioSeleccionado.setUsuarioName(usuarioEditar.getUsuarioName());
            usuarioSeleccionado.setUsuarioCorreo(usuarioEditar.getUsuarioCorreo());
            usuarioSeleccionado.setUsuarioContrasena(usuarioEditar.getUsuarioContrasena());
            usuarioSeleccionado.setUsuarioTelefono(usuarioEditar.getUsuarioTelefono());
            return usuarioRepository.save(usuarioSeleccionado);
        }
        return null;

    }


}
