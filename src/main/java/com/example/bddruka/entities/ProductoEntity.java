package com.example.bddruka.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "medicamentos")
@NoArgsConstructor//Constructor vacío
@AllArgsConstructor//Constructor lleno
@Getter//Accesador
@Setter//Mutador

public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productoId;
    private String nombreProducto;
    private Integer precioProducto;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "categorias_productos",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<CategoriaEntity> categoriasProducto;

}
