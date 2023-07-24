package com.example.bddruka.controllers;

import com.example.bddruka.entities.CategoriaProductoEntity;
import com.example.bddruka.services.CategoriaProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/categoriaproducto")
public class CategoriaProductoController {

        @Autowired
        CategoriaProductoServiceImpl categoriaProductoService;

        @GetMapping("buscarcategoria/{id}")
        //ResponseEntity es una clase que además de permitirnos traer nuestro objeto, nos permite indicar el status de la petición
        private ResponseEntity<CategoriaProductoEntity> obtenerCategoriaProductoPorId(@PathVariable("id") Long id) {
            Optional<CategoriaProductoEntity> categoriaProductoElegida = Optional.ofNullable(categoriaProductoService.buscarPorId(id));
            return ResponseEntity.ok(categoriaProductoElegida.get());//El Optional(No ResponseEntity) tiene un método .get() qué permite obtener el valor
        }

        @GetMapping("lista")
        public List<CategoriaProductoEntity> obtenerCategoria() {
            return categoriaProductoService.obtenerCategoriaProductos();
        }

        @PostMapping("nueva")
        public  ResponseEntity<CategoriaProductoEntity> guardarCategoriaProducto(@RequestBody CategoriaProductoEntity categoriaProductoEntity) {
            return ResponseEntity.ok(categoriaProductoService.guardarCategoriaProducto(categoriaProductoEntity));
        }

        @DeleteMapping("borrar/{id}")
        public void borrarCategoriaPlatoPorId(@PathVariable("id")Long id) {
            categoriaProductoService.borrarCategoriaProductoPorId(id);
        }

        @PutMapping("editar/{id}")
        public ResponseEntity<CategoriaProductoEntity> editarCategoriaProductoPorId(@PathVariable Long id, @RequestBody
        CategoriaProductoEntity categoriaProductoEditar) {return ResponseEntity.ok(categoriaProductoService.editarCategoriaProductoPorId(id, categoriaProductoEditar));
        }

}
