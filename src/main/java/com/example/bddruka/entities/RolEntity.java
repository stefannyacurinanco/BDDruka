package com.example.bddruka.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rolId;
    private String nombreRol;
}
