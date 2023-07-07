package com.example.bddruka.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categorías")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CategoriaId;
    private String nombreCategoria;

    @ManyToMany
    @JoinTable(
            name = "categorias_productos",
            joinColumns = @JoinColumn(name = "categoria_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<ProductoEntity> productoCategoria;
}
