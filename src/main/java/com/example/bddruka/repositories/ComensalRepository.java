package com.example.bddruka.repositories;

import com.example.bddruka.entities.ComensalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComensalRepository extends JpaRepository<ComensalEntity, Long> {

}
