package com.duoc.alumnos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sedes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable = false, length = 100, unique = true)
    public String nombreSede;

    @Column(nullable = false, length = 100)
    public String direccion;

    @Column(nullable = false, unique = false, length = 20)
    public String comuna;

    @Column(nullable = false, unique = false, length = 50)
    public String ciudad;
}
