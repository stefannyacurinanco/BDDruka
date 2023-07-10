package com.example.bddruka.services;

import com.example.bddruka.entities.ReservaEntity;
import com.example.bddruka.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
//Indicar la lista del status de la reserva implementada


}
