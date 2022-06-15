package com.example.EjercicioJPA.Controlador.DTO.Out;

import com.example.EjercicioJPA.Objetos.Estudiante;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class EstudianteOutputDto {

    private Integer estudiante;
    private String name;
    private String apellido;
    private String email;
    private String ciudad;
    private Integer num_horas;
    private String comentarios;
    private Boolean activo;
    private Date fechaInicio;
    private Date fechaFin;
    private ProfesorOutputDto profesor;


    public EstudianteOutputDto(Estudiante e){
        this.estudiante=e.getEstudiante();
        this.name=e.getName();
        this.apellido=e.getApellido();
        this.email=e.getEmail();
        this.ciudad=e.getCiudad();
        this.num_horas=e.getNum_horas();
        this.comentarios=e.getComentarios();
        this.activo=e.getActivo();
        this.fechaInicio=e.getFechaInicio();
        this.fechaFin=e.getFechaFin();
    }

}
