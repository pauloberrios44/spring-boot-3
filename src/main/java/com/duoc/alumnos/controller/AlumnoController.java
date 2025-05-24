package com.duoc.alumnos.controller;

import com.duoc.alumnos.model.Alumno;
import com.duoc.alumnos.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AlumnoController {

    @Autowired
    public AlumnoService alumnoService;

    @GetMapping("/api/v1/home")
    public String home() {
        return "Bienvenido";
    }

    @GetMapping("/api/v1/alumnos")
    public ResponseEntity<?> getAlumnos() {
        return ResponseEntity.status(200).body(alumnoService.findAll());
    }

    @GetMapping("/api/v1/alumno/{id}")
    public ResponseEntity<?> getAlumno(@PathVariable Integer id) {
        Alumno alumno = alumnoService.findById(id);

        if (null == alumno) {
            return ResponseEntity.status(404).body("Alumno no encontrado");
        }

        return ResponseEntity.status(200).body(alumno);
    }

    @DeleteMapping("/api/v1/alumno/{id}")
    public ResponseEntity<?> deleteAlumno(@PathVariable Integer id) {
        Alumno alumno = alumnoService.findById(id);
        if (null == alumno) {
            return ResponseEntity.status(404).body("Alumno no encontrado");
        }

        alumnoService.delete(id);

        return ResponseEntity.status(200).body("Alumno eliminado");
    }

    @GetMapping("/api/v1/alumno/buscar")
    public ResponseEntity<?> buscarAlumno(@RequestParam String correo) {
        Alumno alumno = alumnoService.findByEmail(correo);

        return ResponseEntity.status(200).body(alumno);
    }

    @GetMapping("/api/v1/alumnos/listado/{nombre}")
    public ResponseEntity<?> buscarAlumnoPorNombre(@PathVariable String nombre) {
        List<Alumno> alumnos = alumnoService.findByNombres(nombre);
        return ResponseEntity.status(200).body(alumnos);
    }

    @PostMapping("/api/v1/alumno")
    public ResponseEntity<?> guardarAlumno(@RequestBody Alumno alumno) {
        Alumno alumnoGuardado = alumnoService.save(alumno);
        return ResponseEntity.status(201).body(alumnoGuardado);
    }
}
