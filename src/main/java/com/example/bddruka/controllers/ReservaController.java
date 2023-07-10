package com.example.bddruka.controllers;

import com.example.bddruka.entities.ReservaEntity;
import com.example.bddruka.services.ReservaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("reserva")
public class ReservaController {

    //implementar funcion para que doña ruka vea las reservar y otra para el usuario vea la disponibilidad

//implementar el status reservado o no

    @Autowired
    ReservaServiceImpl reservaService;

    /*@Autowired
    RegistroUsuarioServiceImpl registroUsuarioService;

    @PostMapping("/nuevaReserva/{id}")
    public ResponseEntity<ReservaEntity> crearNuevaReserva(@PathVariable Long id,
                                                           @RequestBody ReservaEntity nuevaReserva) {
        RegistroUsuarioEntity usuarioElegido = registroUsuarioService.buscarUsuarioPorId(id);
        nuevaReserva.setUsuarioReserva(usuarioElegido);
        return ResponseEntity.ok(reservaService.crearNuevaReserva(nuevaReserva));*/
    }





