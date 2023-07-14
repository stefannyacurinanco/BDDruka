package com.example.bddruka.services;

import com.example.bddruka.entities.ComensalEntity;
import com.example.bddruka.repositories.ComensalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComensalServiceImpl implements ComensalService {

    @Autowired
    private ComensalRepository comensalRepository;

    @Override
    public List<ComensalEntity> obtenerComensales() {
        List<ComensalEntity> listaUsuarios = comensalRepository.findAll();
        return listaUsuarios;
    }

    @Override
    public Optional<ComensalEntity> obtenerComensalPorId(Long id) {
        Optional<ComensalEntity> comensalElegido = comensalRepository.findById(id);
        return comensalElegido;
    }
    /*@Override
    public ComensalEntity obtenerComensalPorId(Long id) {
        return comensalRepository.findById(id).get();
    }*/

    @Override
    public ComensalEntity guardarComensal(ComensalEntity comensalEntity) {
        ComensalEntity nuevoComensal = comensalRepository.save(comensalEntity);
        return nuevoComensal;
    }

    @Override
    public void borrarComensalPorId(Long id) {
        comensalRepository.deleteById(id);
    }

    @Override
    public ComensalEntity editarComensalPorId(Long usuarioId, ComensalEntity usuarioEditar) {

        Boolean existe = comensalRepository.existsById(usuarioId);

        if (existe) {
            ComensalEntity usuarioSeleccionado = comensalRepository.findById(usuarioId).get();
            usuarioSeleccionado.setComensalName(usuarioEditar.getComensalName());
            usuarioSeleccionado.setComensalCorreo(usuarioEditar.getComensalCorreo());
            usuarioSeleccionado.setComensalTelefono(usuarioEditar.getComensalTelefono());
            return comensalRepository.save(usuarioSeleccionado);
        }
        return null;

    }


}
