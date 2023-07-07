package com.example.bddruka.controllers;

import com.example.bddruka.entities.UsuarioEntity;
import com.example.bddruka.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")//Nos permite indica que se aceptan peticiones desde cualquier lado
@RequestMapping("/usuario")//Esta anotación nos permite indicar el enrutamiento base
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @GetMapping("lista")
    public List<UsuarioEntity> obtenerUsuario() {
        //System.out.println(usuarioService.findAll());
        //System.out.println("hola");
        return usuarioService.obtenerUsuario();
    }

}
