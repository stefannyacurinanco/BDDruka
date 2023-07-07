package com.example.bddruka.controllers;

import com.example.bddruka.entities.UsuarioEntity;
import com.example.bddruka.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")//Nos permite indica que se aceptan peticiones desde cualquier lado
@RequestMapping("/usuario")//Esta anotación nos permite indicar el enrutamiento base
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @GetMapping("telefono/{a}")
    private Long telefono(@PathVariable("a") Integer telefono) {
        return "El año es: " + telefono;
    }

    @GetMapping("ususario/{id}")
    //ResponseEntity es una clase que además de permitirnos traer nuestro objeto, nos permite indicar el status de la petición
    private ResponseEntity<UsuarioEntity> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        Optional<UsuarioEntity> usuarioElegido = usuarioService.obtenerUsuarioPorId(id);
        return ResponseEntity.ok(usuarioElegido.get());//El Optional(No ResponseEntity) tiene un método .get() qué permite obtener el valor
    }

    @GetMapping("lista")
    public List<UsuarioEntity> obtenerUsuarios() {
        //System.out.println(usuarioService.findAll());
        //System.out.println("hola");
        return usuarioService.obtenerUsuarios();
    }

}
