package com.example.bddruka.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "reservasalones")
@NoArgsConstructor //Constructor vacio
@AllArgsConstructor //Constructor lleno
@Getter //Getters
@Setter //Setters
public class ReservaSalonesEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long SalonId;
        private Long ReservaId;

}
