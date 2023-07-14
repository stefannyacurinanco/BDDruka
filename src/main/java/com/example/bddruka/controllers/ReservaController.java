package com.example.bddruka.controllers;

import com.example.bddruka.dto.ReservaDto;
import com.example.bddruka.entities.ComensalEntity;
import com.example.bddruka.entities.ReservaEntity;
import com.example.bddruka.repositories.ReservaRepository;
import com.example.bddruka.services.ComensalService;
import com.example.bddruka.services.ComensalServiceImpl;
import com.example.bddruka.services.ReservaService;
import com.example.bddruka.services.ReservaServiceImpl;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
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
        return ReservaService.obtenerRegistrosPorFecha(fecha);
    }


    /*@PostMapping("/nuevaReserva/{id}")
    public ResponseEntity<ReservaEntity> crearNuevaReserva(@PathVariable Long id,
                                                           @RequestBody ReservaEntity nuevaReserva) {
        comensalEntity comensalElegido = comensalService.obtenerComensalPorId(id);
        nuevaReserva.setComensalReserva(comensalElegido);
        return ResponseEntity.ok(reservaService.crearNuevaReserva(nuevaReserva));
    }*/

    /*@PostMapping("/nuevaReserva/{id}")
    public ResponseEntity<ReservaEntity> crearNuevaReserva(@PathVariable Long id, @RequestBody ReservaEntity nuevaReserva) {
        Optional<ComensalEntity> comensalOptional = comensalService.obtenerComensalPorId(id);

        if (comensalOptional.isPresent()) {
            ComensalEntity comensalElegido = comensalOptional.get();
            nuevaReserva.setComensalReserva(comensalElegido);
            return ResponseEntity.ok(reservaService.crearNuevaReserva(nuevaReserva));
        } else {
            // Aquí puedes manejar el caso en el que no se encuentre el comensal por el ID proporcionado
            return ResponseEntity.notFound().build();
        }
    }*/



    @GetMapping("/reservas/{id}")
    public ReservaDto getReserva(@PathVariable Long id) {
        ReservaEntity reserva = reservaService.obtenerReservaporid(id).orElse(null);

        if (reserva != null) {
            ComensalEntity comensal = reserva.getComensal();
            ReservaDto reservaDto = new ReservaDto(reserva.getReservaId(), reserva.getFecha(), reserva.getHora(), reserva.getNumeroPersonas(),
                    reserva.getSalón(), reserva.getComentario(),
                    comensal.getComensalName(), comensal.getComensalApellido(),
                    comensal.getComensalCorreo(), comensal.getComensalTelefono());
            return new ReservaDto();
        }

        return null;
    }

   /* @PostMapping("/nuevaReserva/{id}")
    public ReservaDto setReserva(@PathVariable Long id) {
        ReservaEntity reserva = reservaService.obtenerReservaporid(id).orElse(null);

        if (reserva == null) {
            ComensalEntity comensal = reserva.setComensal();
            ReservaDto reservaDto = new ReservaDto(reserva.setReservaId(), reserva.setFecha(), reserva.setHora(), reserva.setNumeroPersonas(),
                    reserva.setSalón(), reserva.setComentario(),
                    comensal.setComensalName(), comensal.setComensalApellido(),
                    comensal.setComensalCorreo(), comensal.setComensalTelefono());
            return new ReservaDto();
        }
}
        return null;*/

    @PostMapping("nuevaReserva")
    public  ResponseEntity<ReservaEntity> crearReserva(@RequestBody ReservaEntity reservaEntity) {
        //System.out.println(personajeEntity.getPersonajeName());
        //PersonajeEntity nuevoPersonaje = personajeService.save(personajeEntity);
        return ResponseEntity.ok(reservaService.crearNuevaReserva(reservaEntity));
    }
}




