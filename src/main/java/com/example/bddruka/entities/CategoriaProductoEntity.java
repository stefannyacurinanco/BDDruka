package com.example.bddruka.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "categoríasProductos")
@NoArgsConstructor//Constructor vacío
@AllArgsConstructor//Constructor lleno
@Getter//Accesador
@Setter//Mutador
public class CategoriaProductoEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoriaProductoId;
    private String nombreCategoriaProducto;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "categorias_productos",
            joinColumns = @JoinColumn(name = "categoriaProducto_id"),
            inverseJoinColumns = @JoinColumn(name = "id_producto")
    )
    private List<ProductoEntity> productoCategoria;
}
