package com.example.EjercicioJPA.Controlador.DTO.Input;

import com.example.EjercicioJPA.Objetos.Profesor;
import lombok.Data;

import java.util.Date;

@Data
public class ProfesorInputDto {

    private String name;
    private String apellido;
    private String email;
    private String ciudad;
    private String comentarios;
    private Boolean activo;
    private Date fechaInicio;
    private Date fechaFin;
    private Integer materia;

    public Profesor profesor(){
        Profesor profesor = new Profesor();
        profesor.setName(this.getName());
        profesor.setApellido(this.getApellido());
        profesor.setEmail(this.getEmail());
        profesor.setCiudad(this.getCiudad());
        profesor.setComentarios(this.getComentarios());
        profesor.setActivo(this.getActivo());
        profesor.setFechaInicio(getFechaInicio());
        profesor.setFechaFin(getFechaFin());
        return profesor;
    }
}
