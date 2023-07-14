package com.example.bddruka.controllers;

import com.example.bddruka.entities.ComensalEntity;
import com.example.bddruka.services.ComensalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")//Nos permite indica que se aceptan peticiones desde cualquier lado
@RequestMapping("/comensal")//Esta anotación nos permite indicar el enrutamiento base
public class ComensalController {

    @Autowired
    private ComensalServiceImpl usuarioService;

    @GetMapping("telefono/{comensal}")
    private String telefono(@PathVariable("comensal") Integer telefono) {
        return "El telefono es: " + telefono;
    }

    @GetMapping("comensal/{id}")
    //ResponseEntity es una clase que además de permitirnos traer nuestro objeto, nos permite indicar el status de la petición
    private ResponseEntity<ComensalEntity> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        Optional<ComensalEntity> usuarioElegido = usuarioService.obtenerComensalPorId(id);
        return ResponseEntity.ok(usuarioElegido.get());//El Optional(No ResponseEntity) tiene un método .get() qué permite obtener el valor
    }

    @GetMapping("lista")
    public List<ComensalEntity> obtenerUsuarios() {
        //System.out.println(usuarioService.findAll());
        //System.out.println("hola");
        return usuarioService.obtenerComensales();
    }


    @PostMapping("nuevo")
    public  ResponseEntity<ComensalEntity> guardarNuevoUsuario(@RequestBody ComensalEntity comensalEntity) {
        //System.out.println(personajeEntity.getPersonajeName());
        //PersonajeEntity nuevoPersonaje = personajeService.save(personajeEntity);
        return ResponseEntity.ok(usuarioService.guardarComensal(comensalEntity));
    }

    @DeleteMapping("borrar/{id}")
    public void borrarUsuariojePorId(@PathVariable("id")Long id) {
        usuarioService.borrarComensalPorId(id);
    }


    @PutMapping("editar/{id}")
    public ResponseEntity<ComensalEntity> editarUsuarioPorId(@PathVariable Long id, @RequestBody
    ComensalEntity usuarioEditar) {
        return ResponseEntity.ok(usuarioService.editarComensalPorId(id, usuarioEditar));
    }

    //Ver como agregar a la base de datos el caso de que se quiera ver las reservas para x fecha-para reserva controller

}
