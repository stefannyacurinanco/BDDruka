package com.example.bddruka.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "platos")
@NoArgsConstructor//Constructor vacío
@AllArgsConstructor//Constructor lleno
@Getter//Accesador
@Setter//Mutador

public class PlatoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long platoId;
    private String nombrePlato;
    /*private Integer precioPlato;*se borra si se usa en card*/
    private String descripcionPlato;
    private String urlImagen;

    @ManyToMany
    @JoinTable(
            name = "categorias_platos",
            joinColumns = @JoinColumn(name = "id_plato"),
            inverseJoinColumns = @JoinColumn(name = "id_categoriaPlato")
    )
    private List<CategoriaPlatoEntity> categoriaPlato;




} //Pendiente hay que evaluar su uso y relacion
//impletar url para que el cliente pueda cambiar fotos de productos y platos
//ver si dejar para card de platos destacados
