package com.example.bddruka.repositories;

import com.example.bddruka.entities.SalonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRepository extends JpaRepository<SalonEntity,Long> {
}
