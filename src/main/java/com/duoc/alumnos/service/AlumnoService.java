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

    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    public Alumno findById(Integer id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public void delete(Alumno alumno) {
        alumnoRepository.delete(alumno);
    }
}
