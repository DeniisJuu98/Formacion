package com.example.EjercicioJPA.Objetos;

import com.example.EjercicioJPA.Controlador.DTO.Out.EstudianteOutputDto;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "Estudiante")
public class Estudiante {


    @Id
    @GeneratedValue
    @Column(name = "id_estudiante",updatable = false,nullable = false)
    private Integer estudiante;


    @Column(name = "name")
    private String name;
    @Column(name="apellido")
    private String apellido;
    @Column(name="email")
    private String email;
    @Column(name="ciudad")
    private String ciudad;
    @Column(name="numero_horas")
    private Integer num_horas;
    @Column(name="comentarios")
    private String comentarios;
    @Column(name="activo")
    private Boolean activo;
    @Column(name="fecha_inicio")
    private Date fechaInicio;
    @Column(name="fecha_fin")
    private Date fechaFin;
    private Branch branch;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor")
    private Profesor profesor;

    public EstudianteOutputDto estudiante(){
        EstudianteOutputDto estudiante = new EstudianteOutputDto();
        estudiante.setName(this.getName());
        estudiante.setApellido(this.getApellido());
        estudiante.setEmail(this.getEmail());
        estudiante.setCiudad(this.getCiudad());
        estudiante.setNum_horas(this.getNum_horas());
        estudiante.setComentarios(this.getComentarios());
        estudiante.setActivo(this.getActivo());
        estudiante.setFechaInicio(getFechaInicio());
        estudiante.setFechaFin(getFechaFin());
        estudiante.setProfesor(this.getProfesor().profesor());
        return estudiante;
    }


}
