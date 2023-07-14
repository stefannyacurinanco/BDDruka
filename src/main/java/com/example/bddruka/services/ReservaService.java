package com.example.bddruka.services;

import com.example.bddruka.entities.ComensalEntity;
import com.example.bddruka.entities.ReservaEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservaService {
    static List<ReservaEntity> obtenerRegistrosPorFeacha(java.sql.Date fecha) {
        return null;
    }

    ReservaEntity crearNuevaReserva(ReservaEntity nuevaReserva);

    List<ReservaEntity> obtenerReservas();

    List<ReservaEntity> obtenerRegistrosPorFecha(Date fecha);

    //Método para mostrar reservas por fecha, hacer recorrido de reservas

}
//
