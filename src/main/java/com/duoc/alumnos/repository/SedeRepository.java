package com.duoc.alumnos.repository;

import com.duoc.alumnos.model.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface SedeRepository extends JpaRepository<Sede, Integer> {
}
