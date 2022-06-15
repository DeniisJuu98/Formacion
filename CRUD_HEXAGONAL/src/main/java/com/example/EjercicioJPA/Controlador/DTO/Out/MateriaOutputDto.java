package com.example.EjercicioJPA.Controlador.DTO.Out;

import com.example.EjercicioJPA.Objetos.Materia;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MateriaOutputDto {

    private Integer materia;
    private String nombre;
    private String descripcion;

    public MateriaOutputDto(Materia m){
        this.materia=m.getMateria();
        this.nombre=m.getNombre();
        this.descripcion=m.getDescripcion();
    }

}
