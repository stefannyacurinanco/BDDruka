package com.example.bddruka.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@NoArgsConstructor //Constructor vacio
@AllArgsConstructor //Constructor lleno
@Getter //Getters
@Setter //Setters
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UsuarioId;
    private String UsuarioName;
    private String UsuarioCorreo;
    private String UsuarioContraseña;
    private Integer UsuarioTelefono;



}
