package com.example.EjercicioJPA.Servicios.Interfaces;

import com.example.EjercicioJPA.Objetos.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepositorio extends JpaRepository<Materia, Integer> {
}
