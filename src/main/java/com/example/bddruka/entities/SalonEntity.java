package com.example.bddruka.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "salones")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SalonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long SalonId;
    private String Tipo;
    private Long Capacidad;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "reserva_salones",
            joinColumns = @JoinColumn(name = "salon_id"),
            inverseJoinColumns = @JoinColumn(name = "reserva_id")
    )
    private List<ReservaEntity> reservaSalones;

}
