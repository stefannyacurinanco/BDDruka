package com.example.bddruka.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="reservas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ReservaId;
    private Integer NumeroPersonas;
    private String Comentario;
    private String Salón;  //Hacer entidad
    private Boolean Status = false; //indicara el estado de la reserva si estara o no disponible,
    //nota agregar estatus//o boolean// setear como true



  //Preguntar el formato para fecha y hora
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date Fecha;

    @JsonFormat(pattern = "HH:mm")
    private Time Hora;

    /*@JsonManagedReference//Indicamos que es la dueña de la relación
    @OneToOne(mappedBy = "comensalConsulta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ComensalEntity> comensalEntity;*/

    /*@OneToOne
    private ComensalEntity comensalEntity;*/

    @OneToOne(mappedBy = "reserva", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ComensalEntity comensalEntity;

    @ManyToMany
    @JoinTable(
            name = "reserva_salones",
            joinColumns = @JoinColumn(name = "reserva_id"),
            inverseJoinColumns = @JoinColumn(name = "salon_id")
    )
    private List<SalonEntity> salonesReserva;

   //definimos funciones aqui en vez de en impl y service, bc nada funcionada.Prueba1
    public ComensalEntity getComensal() {
        return comensalEntity;
    }
    public void setComensal(ComensalEntity comensal) {
        this.comensalEntity = comensal;
    }



}


