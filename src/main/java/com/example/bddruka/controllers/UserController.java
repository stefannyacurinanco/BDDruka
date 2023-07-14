package com.example.bddruka.controllers;

import com.example.bddruka.dto.RegistroDto;
import com.example.bddruka.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    MyUserDetailsService myUserDetailsService;


    @PostMapping("/register")
    public ResponseEntity<?> crearNuevoUsuario(@RequestBody RegistroDto datosUsuario) {
        myUserDetailsService.guardarNuevoUsuario(datosUsuario);
        return new ResponseEntity<>("Registro fue exitoso", HttpStatus.OK);
    }


}
