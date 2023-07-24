package com.example.bddruka.controllers;

import com.example.bddruka.entities.SalonEntity;
import com.example.bddruka.services.SalonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")//Nos permite indica que se aceptan peticiones desde cualquier lado
@RequestMapping("/salones")
public class SalonController {

    @Autowired
    private SalonServiceImpl salonService;

    @GetMapping("buscarsalon/{id}")
    //ResponseEntity es una clase que además de permitirnos traer nuestro objeto, nos permite indicar el status de la petición
    private ResponseEntity<SalonEntity> obtenerSalonesPorId(@PathVariable("id") Long id) {
        Optional<SalonEntity> salonElegido = salonService.obtenerSalonesPorId(id);
        return ResponseEntity.ok(salonElegido.get());//El Optional(No ResponseEntity) tiene un método .get() qué permite obtener el valor
    }

    @GetMapping("lista")
    public List<SalonEntity> obtenerSalones() {
        return salonService.obtenerSalones();
    }

    @PostMapping("nuevo")
    public  ResponseEntity<SalonEntity> guardarSalon(@RequestBody SalonEntity salonEntity) {
        return ResponseEntity.ok(salonService.guardarSalon(salonEntity));
    }

    @DeleteMapping("borrar/{id}")
    public void borrarSalonPorId(@PathVariable("id")Long id) {
        salonService.borrarSalonPorId(id);
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<SalonEntity> editarSalonPorId(@PathVariable Long id, @RequestBody
    SalonEntity salonEditar) {return ResponseEntity.ok(salonService.editarSalonPorId(id, salonEditar));
    }

}
