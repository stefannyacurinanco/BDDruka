package com.example.bddruka.repositories;

import com.example.bddruka.entities.CategoriaPlatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaPlatoRepository extends JpaRepository<CategoriaPlatoEntity, Long> {
}
