package com.example.bddruka.services;


import com.example.bddruka.entities.ProductoEntity;
import com.example.bddruka.entities.SalonEntity;
import com.example.bddruka.repositories.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalonServiceImpl implements SalonService{

    @Autowired
    private SalonRepository salonRepository;

    @Override
    public List<SalonEntity> obtenerSalones() {
        List<SalonEntity> listaSalones = salonRepository.findAll();
        return listaSalones;
    }

    @Override
    public Optional<SalonEntity> obtenerSalonesPorId(Long id) {
        Optional<SalonEntity> salonElegido = salonRepository.findById(id);
        return salonElegido;
    }

    @Override
    public SalonEntity guardarSalon(SalonEntity salonEntity) {
        SalonEntity nuevoSalon = salonRepository.save(salonEntity);
        return nuevoSalon;
    }

    @Override
    public void borrarSalonPorId(Long id) {
        salonRepository.deleteById(id);
    }


    @Override
    public SalonEntity editarSalonPorId(Long usuarioId, SalonEntity salonEditar) {

        Boolean existe = salonRepository.existsById(usuarioId);

        if (existe) {
            SalonEntity salonSeleccionado = salonRepository.findById(usuarioId).get();
            salonSeleccionado.setTipo(salonEditar.getTipo());
            salonSeleccionado.setCapacidad(salonEditar.getCapacidad());
            salonSeleccionado.setUrl(salonEditar.getUrl());
            return salonRepository.save(salonSeleccionado);
        }
        return null;
    }

}
