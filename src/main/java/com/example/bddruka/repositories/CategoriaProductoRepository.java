package com.example.bddruka.repositories;

import com.example.bddruka.entities.CategoriaProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaProductoRepository extends JpaRepository <CategoriaProductoEntity, Long> {
}
