package com.example.bddruka.services;

import com.example.bddruka.entities.ReservaEntity;
import com.example.bddruka.repositories.ComensalRepository;
import com.example.bddruka.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ComensalRepository comensalRepository;

    /*@Override
    public ReservaEntity findById(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }*/
    //antes de guardar setear el status
    @Override
    public Optional<ReservaEntity> obtenerReservaporid(Long id) {
        Optional<ReservaEntity> reservaElegida = reservaRepository.findById(id);
        return reservaElegida;
    }

    @Override
    public ReservaEntity crearNuevaReserva(ReservaEntity nuevaReserva) {
        //buscar id comensal y setear comensal
        if (nuevaReserva.getStatus() == false) {
            ReservaEntity reservaParaGuardar = reservaRepository.save(nuevaReserva);
            nuevaReserva.setStatus(true);
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

    @Override
    public void borrarReservaPorId(Long id) {
        reservaRepository.deleteById(id);
    }


}
