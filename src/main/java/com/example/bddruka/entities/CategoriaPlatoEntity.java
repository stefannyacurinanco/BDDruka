package com.example.bddruka.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "categoríasPlatos")
@NoArgsConstructor//Constructor vacío
@AllArgsConstructor//Constructor lleno
@Getter//Accesador
@Setter//Mutador
public class CategoriaPlatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoriaPlatoId;
    private String nombreCategoriaPlato;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "categorias_platos",
            joinColumns = @JoinColumn(name = "id_categoriaPlato"),
            inverseJoinColumns = @JoinColumn(name = "id_plato")
    )
    private List<PlatoEntity> platoCategoria;
}

