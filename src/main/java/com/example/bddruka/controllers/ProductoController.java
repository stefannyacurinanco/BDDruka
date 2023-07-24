package com.example.bddruka.controllers;

import com.example.bddruka.entities.CategoriaProductoEntity;
import com.example.bddruka.entities.ProductoEntity;
import com.example.bddruka.services.CategoriaProductoServiceImpl;
import com.example.bddruka.services.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")//Nos permite indica que se aceptan peticiones desde cualquier lado
@RequestMapping("/productos")//Esta anotación nos permite indicar el enrutamiento base
public class ProductoController {

    @Autowired
    private ProductoServiceImpl productoService;

    @Autowired
    CategoriaProductoServiceImpl categoriaProductoService;

    @GetMapping("buscarproducto/{id}")
    //ResponseEntity es una clase que además de permitirnos traer nuestro objeto, nos permite indicar el status de la petición
    private ResponseEntity<ProductoEntity> obtenerProductosPorId(@PathVariable("id") Long id) {
        Optional<ProductoEntity> productoElegido = productoService.obtenerProductosPorId(id);
        return ResponseEntity.ok(productoElegido.get());//El Optional(No ResponseEntity) tiene un método .get() qué permite obtener el valor
    }

    @GetMapping("lista")
    public List<ProductoEntity> obtenerProductos() {
        return productoService.obtenerProductos();
    }

    @PostMapping("nuevo/{id}")
    public  ResponseEntity<ProductoEntity> guardarProducto(@RequestBody ProductoEntity productoEntity, @PathVariable Long id) {
        ProductoEntity productoNuevo = productoEntity;
        List<CategoriaProductoEntity> categoriasProductos= new ArrayList<>();
        categoriasProductos.add(categoriaProductoService.buscarPorId(id));
        productoNuevo.setCategoriaProducto(categoriasProductos);
        return ResponseEntity.ok(productoService.guardarProducto(productoNuevo));
    }

    @DeleteMapping("borrar/{id}")
    public void borrarPlatoPorId(@PathVariable("id")Long id) {
        productoService.borrarProductoPorId(id);
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<ProductoEntity> editarProductoPorId(@PathVariable Long id, @RequestBody
    ProductoEntity productoEditar) {return ResponseEntity.ok(productoService.editarProductoPorId(id, productoEditar));
    }


}
