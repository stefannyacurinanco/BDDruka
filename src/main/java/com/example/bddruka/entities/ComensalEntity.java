package com.example.bddruka.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comensal")
@NoArgsConstructor //Constructor vacio
@AllArgsConstructor //Constructor lleno
@Getter //Getters
@Setter //Setters
public class ComensalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ComensalId;
    private String ComensalName;
    private String ComensalApellido;
    private String ComensalCorreo;
    private Integer ComensalTelefono;



//dejar registro simple
    //crear tabla para rol admi relacion con usuario segun rol se diferencian funciones se limita acceso a rutas
    //rol entity


}
