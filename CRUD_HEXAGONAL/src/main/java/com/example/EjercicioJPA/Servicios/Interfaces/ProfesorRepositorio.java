package com.example.EjercicioJPA.Servicios.Interfaces;

import com.example.EjercicioJPA.Objetos.Estudiante;
import com.example.EjercicioJPA.Objetos.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorRepositorio extends JpaRepository<Profesor, Integer> {
    List<Profesor> findByName(String name);

    List<Profesor> findByEmail(String email);
}
