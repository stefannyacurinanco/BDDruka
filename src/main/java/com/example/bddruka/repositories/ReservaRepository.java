package com.example.bddruka.repositories;

import com.example.bddruka.entities.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity,Long> {
}
//crear metodos para el status que mostrara una lista de reservas por dia, esto se conecta con reserva entity