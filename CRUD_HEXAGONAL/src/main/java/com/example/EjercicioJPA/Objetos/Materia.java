package com.example.EjercicioJPA.Objetos;

import com.example.EjercicioJPA.Controlador.DTO.Out.MateriaOutputDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Materia")
public class Materia {


    @Id
    @GeneratedValue
    @Column(name = "id_materia",updatable = false,nullable = false)
    private Integer materia;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    private Branch branch;


    @JsonIgnore
    @OneToOne(mappedBy = "materia", fetch = FetchType.LAZY)
    private Profesor profesor;


    public MateriaOutputDto materia(){
        MateriaOutputDto materia = new MateriaOutputDto();
        materia.setNombre(this.getNombre());
        materia.setDescripcion(this.getDescripcion());
        materia.setMateria(this.getMateria());
        return materia;
    }

}
