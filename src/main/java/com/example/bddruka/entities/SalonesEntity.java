package com.example.bddruka.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

public class SalonesEntity {

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "reserva_salones",
            joinColumns = @JoinColumn(name = "salon_id"),
            inverseJoinColumns = @JoinColumn(name = "reserva_id")
    )
}
