package com.example.bddruka.repositories;

import com.example.bddruka.entities.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository <RolEntity, Long>{
    RolEntity findRolEntityByNombreRol(String nombre);
}
