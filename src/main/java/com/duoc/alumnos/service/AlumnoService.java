package com.duoc.alumnos.service;

import com.duoc.alumnos.model.Alumno;
import com.duoc.alumnos.repository.AlumnoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AlumnoService {

    @Autowired
    public AlumnoRepository alumnoRepository;

    // traer todos los alumnos registrados en la tabla
    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    // traer un alumno consultado por el usuario
    public Alumno findById(Integer id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    // metodo para borrar un alumno
    public void delete(Integer id) {
        alumnoRepository.deleteById(id);
    }

    // metodo para buscar por correo
    public Alumno findByEmail(String email) {
        return alumnoRepository.findByEmail(email);
    }

    public List<Alumno> findByNombres(String nombre) {
        return alumnoRepository.findByNombres(nombre);
    }

    // guardando un alumno
    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }
}
