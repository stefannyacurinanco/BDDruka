package com.example.bddruka.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDto {
    private Long reservaId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date Fecha;
    @JsonFormat(pattern = "HH:mm")
    private Time Hora;
    private Integer NumeroPersonas;
    private String Salón;
    private String Comentario;
    private String ComensalName;
    private String ComensalApellido;
    private String ComensalCorreo;
    private Integer ComensalTelefono;



}
