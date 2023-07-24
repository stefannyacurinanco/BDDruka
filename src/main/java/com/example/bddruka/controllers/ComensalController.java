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
    private ComensalServiceImpl comensalService;

    @GetMapping("telefono/{comensal}")
    private String telefono(@PathVariable("comensal") Integer telefono) {
        return "El telefono es: " + telefono;
    }

    @GetMapping("comensal/{id}")
    //ResponseEntity es una clase que además de permitirnos traer nuestro objeto, nos permite indicar el status de la petición
    private ResponseEntity<ComensalEntity> obtenerComensalPorId(@PathVariable("id") Long id) {
        Optional<ComensalEntity> comensalElegido = comensalService.obtenerComensalPorId(id);
        return ResponseEntity.ok(comensalElegido.get());//El Optional(No ResponseEntity) tiene un método .get() qué permite obtener el valor
    }

    @GetMapping("lista")
    public List<ComensalEntity> obtenerComensales() {
        //System.out.println(usuarioService.findAll());
        //System.out.println("hola");
        return comensalService.obtenerComensales();
    }


    @PostMapping("nuevo")
    public  ResponseEntity<ComensalEntity> guardarNuevoComensal(@RequestBody ComensalEntity comensalEntity) {
        System.out.println(comensalEntity.getComensalName());
        return ResponseEntity.ok(comensalService.guardarComensal(comensalEntity));
    }

    @DeleteMapping("borrar/{id}")
    public void borrarComensalPorId(@PathVariable("id")Long id) {comensalService.borrarComensalPorId(id);
    }


    @PutMapping("editar/{id}")
    public ResponseEntity<ComensalEntity> editarComensalPorId(@PathVariable Long id, @RequestBody
    ComensalEntity usuarioEditar) {return ResponseEntity.ok(comensalService.editarComensalPorId(id, usuarioEditar));
    }



    //Ver como agregar a la base de datos el caso de que se quiera ver las reservas para x fecha-para reserva controller

}
