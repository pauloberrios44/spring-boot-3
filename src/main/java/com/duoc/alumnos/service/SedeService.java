package com.duoc.alumnos.service;

import com.duoc.alumnos.model.Sede;
import com.duoc.alumnos.repository.SedeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SedeService {

    @Autowired
    private SedeRepository sedeRepository;

    // traer todos los alumnos registrados en la tabla
    public List<Sede> findAll() {
        return sedeRepository.findAll();
    }

    // traer un sede consultado por el usuario
    public Sede findById(Integer id) {
        return sedeRepository.findById(id).orElse(null);
    }

    // metodo para borrar un sede
    public void delete(Integer id) {
        sedeRepository.deleteById(id);
    }

    public Sede save(Sede sede) {
        return sedeRepository.save(sede);
    }
}
