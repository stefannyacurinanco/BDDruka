package com.example.bddruka.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//Dto no es una entidad, no es guardado en la BDD
//Es una representación
//Dto significa Data Transfer Object

public class RegistroDto {
    String username;
    String password;
    String email;
}
