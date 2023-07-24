package com.example.bddruka.controllers;

import com.example.bddruka.entities.*;
import com.example.bddruka.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    SalonServiceImpl salonService;

    @GetMapping("lista")
    public List<ReservaEntity> obtenerReservas() {
        //System.out.println(usuarioService.findAll());
        //System.out.println("hola");
        return reservaService.obtenerReservas();
    }

    @GetMapping("/{fecha}")
    public List<ReservaEntity> obtenerRegistrosPorFecha(@RequestParam("fecha") Date fecha) {
        return ReservaService.obtenerRegistrosPorFecha(fecha);
    }

    @PostMapping("{idc}/nueva/{ids}")
    public  ResponseEntity<ReservaEntity> crearReserva(@RequestBody ReservaEntity nuevaReserva, @PathVariable Long idc, @PathVariable Long ids) {
        ReservaEntity reservaNueva = nuevaReserva;
        List<SalonEntity> salones = new ArrayList<>();
        salones.add(salonService.obtenerSalonesPorId(ids).get());
        ComensalEntity comensalElegido = comensalService.obtenerComensalPorId(idc).get();
        reservaNueva.setComensalEntity(comensalElegido);
        reservaNueva.setSalonesReserva(salones);
        return ResponseEntity.ok(reservaService.crearNuevaReserva(nuevaReserva));
    }


    //opcion 2
    /*
    @PostMapping("nuevaReserva")
    public ResponseEntity<ReservaEntity> crearReserva(@RequestBody ReservaEntity reserva) {
        // Asignar los salones a la reserva (los salones deben existir en la base de datos con sus respectivos IDs)
        List<SalonEntity> salones = reserva.getSalonesReserva();
        if (salones != null && !salones.isEmpty()) {
            salones.forEach(salon -> salon.setReservaSalones(Collections.singletonList(reserva)));
        }
        */

    @DeleteMapping("borrar/{id}")
    public void borrarreservaPorId(@PathVariable("id")Long id) {
        reservaService.borrarReservaPorId(id);
    }

    
}


