package com.example.EjercicioJPA.Servicios.Interfaces;

import com.example.EjercicioJPA.Objetos.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Integer> {

    List<Estudiante> findByName(String name);

    List<Estudiante> findByEmail(String email);
}
