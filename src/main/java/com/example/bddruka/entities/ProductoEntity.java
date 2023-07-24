package com.example.bddruka.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "producto")
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
    private String descripcion;
    private String urlImagen;//cambiar cuando de edite o se quiera ingresar algo nuevo

    //revisar
    @OneToMany
    @JoinTable(
            name = "categorias_productos",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "categoriaProducto_id")
    )
    private List<CategoriaProductoEntity> categoriaProducto;

}
