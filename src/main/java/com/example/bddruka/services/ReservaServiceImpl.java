package com.example.bddruka.services;

import com.example.bddruka.entities.ReservaEntity;
import com.example.bddruka.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService{
    @Autowired
    private ReservaRepository reservaRepository;
    //antes de guardar setear el status
    @Override
    public ReservaEntity crearNuevaReserva(ReservaEntity nuevaReserva) {

        if (nuevaReserva.getStatus()==false) {
            nuevaReserva.setStatus(true);
            ReservaEntity reservaParaGuardar = reservaRepository.save(nuevaReserva);
            return reservaParaGuardar;

        }
        return null;

    }

    @Override
    public List<ReservaEntity> obtenerReservas() {
        List<ReservaEntity> listaReservas = reservaRepository.findAll();
        return listaReservas;
    }

    //Método para mostrar reservas por fecha, hacer recorrido de reservas
    @Override
    public List<ReservaEntity> obtenerRegistrosPorFecha(Date fecha) {
        return ReservaRepository.findByFecha(fecha);
    }

    //Método para eliminar reservas del día anterior


}
