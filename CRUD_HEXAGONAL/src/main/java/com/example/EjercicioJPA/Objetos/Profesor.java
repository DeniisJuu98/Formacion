package com.example.EjercicioJPA.Objetos;

import com.example.EjercicioJPA.Controlador.DTO.Out.ProfesorOutputDto;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Profesor")
public class Profesor {


    @Id
    @GeneratedValue
    @Column(name = "id_profesor",updatable = false,nullable = false)
    private Integer profesor;

    @Column(name = "name")
    private String name;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email")
    private String email;
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "comentarios")
    private String comentarios;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    private Date fechaFin;
    private Branch branch;


    @OneToMany(mappedBy = "profesor", cascade = { CascadeType.ALL })
    private List<Estudiante> estudiante;



    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "materia")
    private Materia materia;

    public ProfesorOutputDto profesor(){
        ProfesorOutputDto profesor = new ProfesorOutputDto();
        profesor.setName(this.getName());
        profesor.setApellido(this.getApellido());
        profesor.setEmail(this.getEmail());
        profesor.setCiudad(this.getCiudad());
        profesor.setComentarios(this.getComentarios());
        profesor.setActivo(this.getActivo());
        profesor.setFechaInicio(getFechaInicio());
        profesor.setFechaFin(getFechaFin());
        profesor.setMateria(this.getMateria().materia());

        return profesor;
    }

}
