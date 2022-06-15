package com.example.EjercicioJPA.Controlador.DTO.Input;

import com.example.EjercicioJPA.Objetos.Estudiante;

import lombok.Data;

import java.util.Date;

@Data
public class EstudianteInputDto {

    private String name;
    private String apellido;
    private String email;
    private String ciudad;
    private Integer num_horas;
    private String comentarios;
    private Boolean activo;
    private Date fechaInicio;
    private Date fechaFin;
    private Integer id_profesor;

    public Estudiante estudiante(){
        Estudiante estudiante = new Estudiante();
        estudiante.setName(this.getName());
        estudiante.setApellido(this.getApellido());
        estudiante.setEmail(this.getEmail());
        estudiante.setCiudad(this.getCiudad());
        estudiante.setNum_horas(this.getNum_horas());
        estudiante.setComentarios(this.getComentarios());
        estudiante.setActivo(this.getActivo());
        estudiante.setFechaInicio(getFechaInicio());
        estudiante.setFechaFin(getFechaFin());
        return estudiante;
    }

}
