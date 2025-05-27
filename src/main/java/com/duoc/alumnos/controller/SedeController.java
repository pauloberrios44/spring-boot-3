package com.duoc.alumnos.controller;

import com.duoc.alumnos.model.Sede;
import com.duoc.alumnos.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SedeController {

    @Autowired
    public SedeService sedeService;

    @GetMapping("/api/v1/sedes")
    public ResponseEntity<?> getSedes() {
        return ResponseEntity.status(200).body(sedeService.findAll());
    }

    @PostMapping("/api/v1/sede")
    public ResponseEntity<?> guardarSede(@RequestBody Sede sede) {
        Sede sedeGuardado = sedeService.save(sede);
        return ResponseEntity.status(201).body(sedeGuardado);
    }
}
