package com.example.bddruka.services;

import com.example.bddruka.entities.ComensalEntity;
import com.example.bddruka.entities.ReservaEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservaService {
    Optional<ReservaEntity>obtenerReservaporid(Long id);

    static List<ReservaEntity> obtenerRegistrosPorFecha(java.sql.Date fecha) {
        return null;
    }

    ReservaEntity crearNuevaReserva(ReservaEntity nuevaReserva);

    List<ReservaEntity> obtenerReservas();

    //Método para mostrar reservas por fecha, hacer recorrido de reservas
    List<ReservaEntity> obtenerRegistrosPorFecha(Date fecha);
    void borrarReservaPorId(Long id);


    //Método para mostrar reservas por fecha, hacer recorrido de reservas

}
//
