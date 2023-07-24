package com.example.bddruka.controllers;

import com.example.bddruka.entities.CategoriaPlatoEntity;
import com.example.bddruka.services.CategoriaPlatoService;
import com.example.bddruka.services.CategoriaPlatoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/categoriaplato")
public class CategoriaPlatoController {

    @Autowired
    CategoriaPlatoServiceImpl categoriaPlatoService;

    @GetMapping("buscarcategoriaplato/{id}")
    //ResponseEntity es una clase que además de permitirnos traer nuestro objeto, nos permite indicar el status de la petición
    private ResponseEntity<CategoriaPlatoEntity> obtenerCategoriaPlatoPorId(@PathVariable("id") Long id) {
        Optional<CategoriaPlatoEntity> categoriaPlatoElegida = Optional.ofNullable(categoriaPlatoService.buscarPorId(id));
        return ResponseEntity.ok(categoriaPlatoElegida.get());//El Optional(No ResponseEntity) tiene un método .get() qué permite obtener el valor
    }

    @GetMapping("lista")
    public List<CategoriaPlatoEntity> obtenerCategoriaPlatos() {
        return categoriaPlatoService.obtenerCategoriaPlatos();
    }

    @PostMapping("nueva")
        public  ResponseEntity<CategoriaPlatoEntity> guardarCategoriaPlato(@RequestBody CategoriaPlatoEntity categoriaPlatoEntity) {
        return ResponseEntity.ok(categoriaPlatoService.guardarCategoriaPlato(categoriaPlatoEntity));
    }

    @DeleteMapping("borrar/{id}")
    public void borrarCategoriaPlatoPorId(@PathVariable("id")Long id) {
        categoriaPlatoService.borrarCategoriaPlatoPorId(id);
    }


}
