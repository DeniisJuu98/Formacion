package com.example.EjercicioJPA.Controlador.DTO.Input;

import com.example.EjercicioJPA.Objetos.Materia;
import lombok.Data;

@Data
public class MateriaInputDto {

    private String nombre;
    private String descripcion;

    public Materia materia(){
        Materia materia = new Materia();
        materia.setNombre(this.getNombre());
        materia.setDescripcion(this.getDescripcion());
        return materia;
    }

}
