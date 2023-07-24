package com.example.bddruka.repositories;

import com.example.bddruka.entities.PlatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepository extends JpaRepository<PlatoEntity, Long> {


}
