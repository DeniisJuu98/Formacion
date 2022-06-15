package com.example.EjercicioJPA.Controlador.DTO.Out;

import com.example.EjercicioJPA.Objetos.Profesor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ProfesorOutputDto {

    private Integer profesor;
    private String name;
    private String apellido;
    private String email;
    private String ciudad;
    private String comentarios;
    private Boolean activo;
    private Date fechaInicio;
    private Date fechaFin;
    private MateriaOutputDto materia;

    public ProfesorOutputDto(Profesor p){
        this.profesor=p.getProfesor();
        this.name=p.getName();
        this.apellido=p.getApellido();
        this.email=p.getEmail();
        this.ciudad=p.getCiudad();
        this.comentarios=p.getComentarios();
        this.activo=p.getActivo();
        this.fechaInicio=p.getFechaInicio();
        this.fechaFin=p.getFechaFin();
    }

}
