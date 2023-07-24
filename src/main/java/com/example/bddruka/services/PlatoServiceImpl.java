package com.example.bddruka.services;

import com.example.bddruka.entities.PlatoEntity;
import com.example.bddruka.repositories.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatoServiceImpl implements PlatoService {

    @Autowired
    private PlatoRepository platoRepository;

    @Override
    public List<PlatoEntity> obtenerPlatos() {
        List<PlatoEntity> listaPlatos = platoRepository.findAll();
        return listaPlatos;
    }

    @Override
    public Optional<PlatoEntity> obtenerPlatosPorId(Long id) {
        Optional<PlatoEntity> platoElegido = platoRepository.findById(id);
        return platoElegido;
    }

    @Override
    public PlatoEntity guardarPlato(PlatoEntity platoEntity) {
        PlatoEntity nuevoPlato = platoRepository.save(platoEntity);
        return nuevoPlato;
    }

    @Override
    public void borrarPlatoPorId(Long id) {platoRepository.deleteById(id);
    }

    @Override
    public PlatoEntity editarPlatoPorId(Long usuarioId, PlatoEntity platoEditar) {

        Boolean existe = platoRepository.existsById(usuarioId);

        if (existe) {
            PlatoEntity platoSeleccionado = platoRepository.findById(usuarioId).get();
            platoSeleccionado.setCategoriaPlato(platoEditar.getCategoriaPlato());
            platoSeleccionado.setNombrePlato(platoEditar.getNombrePlato());
            platoSeleccionado.setDescripcionPlato(platoEditar.getDescripcionPlato());
            platoSeleccionado.setUrlImagen(platoEditar.getUrlImagen());
            return platoRepository.save(platoSeleccionado);
        }
        return null;
    }

}
