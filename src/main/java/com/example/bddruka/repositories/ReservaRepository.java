package com.example.bddruka.repositories;

import com.example.bddruka.entities.ReservaEntity;
import com.example.bddruka.entities.RolEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity,Long> {

    static List<ReservaEntity>findByFecha(Date fecha) {
        return null;
    }

}
//crear metodos para el status que mostrara una lista de reservas por dia, esto se conecta con reserva entity