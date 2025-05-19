package com.duoc.alumnos.controller;

import com.duoc.alumnos.model.Alumno;
import com.duoc.alumnos.repository.AlumnoRepository;
import com.duoc.alumnos.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
        if (alumno == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el alumno");
        }

        return ResponseEntity.status(200).body(alumno);
    }

    @PostMapping("/api/v1/alumno")
    public ResponseEntity<?> addAlumno(@RequestBody Alumno alumno) {
        Alumno nuevoAlumno = alumnoService.save(alumno);
        return ResponseEntity.status(201).body(nuevoAlumno);
    }

    @PutMapping("/api/v1/alumno/{id}")
    public ResponseEntity<?> updateAlumno(@PathVariable Integer id, @RequestBody Alumno alumno) {
        // buscando al alumno
        Alumno alumnoActual = alumnoService.findById(id);
        if (alumnoActual == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el alumno");
        }

        alumnoActual.setNombres(alumno.getNombres());
        alumnoActual.setApellidos(alumno.getApellidos());
        alumnoActual.setEmail(alumno.getEmail());
        alumnoActual.setRut(alumno.getRut());

        alumnoService.save(alumnoActual);

        return ResponseEntity.status(201).body("Alumno actualizado");
    }

    @DeleteMapping("/api/v1/alumno/{id}")
    public ResponseEntity<?> deleteAlumno(@PathVariable Integer id) {
        Alumno alumno = alumnoService.findById(id);
        if (alumno == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el alumno");
        }
        alumnoService.delete(alumno);

        return ResponseEntity.status(200).body("Alumno eliminado");
    }
}
