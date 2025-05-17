package com.duoc.alumnos.controller;

import com.duoc.alumnos.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
