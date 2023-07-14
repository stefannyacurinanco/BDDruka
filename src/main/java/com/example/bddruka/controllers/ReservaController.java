package com.example.bddruka.controllers;

import com.example.bddruka.entities.ComensalEntity;
import com.example.bddruka.entities.ReservaEntity;
import com.example.bddruka.services.ComensalService;
import com.example.bddruka.services.ComensalServiceImpl;
import com.example.bddruka.services.ReservaService;
import com.example.bddruka.services.ReservaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("reserva")
public class ReservaController {

    //implementar funcion para que doña ruka vea las reservar y otra para el usuario vea la disponibilidad

//implementar el status reservado o no

    @Autowired
    private ReservaServiceImpl reservaService;

    @Autowired
    ComensalServiceImpl comensalService;

    @GetMapping("lista")
    public List<ReservaEntity> obtenerReservas() {
        //System.out.println(usuarioService.findAll());
        //System.out.println("hola");
        return reservaService.obtenerReservas();
    }

    @GetMapping("/reserva/{fecha}")
    public List<ReservaEntity> obtenerRegistrosPorFecha(@RequestParam("fecha") Date fecha) {
        return ReservaService.obtenerRegistrosPorFeacha(fecha);
    }

   /*@Autowired
    RegistroUsuarioServiceImpl registroUsuarioService;

    @PostMapping("/nuevaReserva/{id}")
    public ResponseEntity<ReservaEntity> crearNuevaReserva(@PathVariable Long id,
                                                           @RequestBody ReservaEntity nuevaReserva) {
        RegistroUsuarioEntity usuarioElegido = registroUsuarioService.buscarUsuarioPorId(id);
        nuevaReserva.setUsuarioReserva(usuarioElegido);
        return ResponseEntity.ok(reservaService.crearNuevaReserva(nuevaReserva));*/
    }





