package com.example.EjercicioJPA.Controlador;

import com.example.EjercicioJPA.Objetos.Materia;
import com.example.EjercicioJPA.Controlador.DTO.Input.MateriaInputDto;
import com.example.EjercicioJPA.Servicios.Interfaces.MateriaRepositorio;
import com.example.EjercicioJPA.Controlador.DTO.Out.MateriaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("materia")
public class MateriaControlador {

    @Autowired
    MateriaRepositorio materiaRepositorio;

    @GetMapping
    public List<Materia> getAll(){

        return materiaRepositorio.findAll();
    }

    @GetMapping("{id}")
    public Materia getByID(@PathVariable Integer id) throws Exception{

        return materiaRepositorio.findById(id).orElseThrow(() -> new Exception("No encontrado"));
    }

    @PostMapping
    public MateriaOutputDto anadirMateria(@RequestBody MateriaInputDto materia){

        System.out.println("añadiendo materia");

        Materia aux = new Materia();

        aux = materia.materia();
        materiaRepositorio.save(aux);
        MateriaOutputDto materiaOutputDto = new MateriaOutputDto();
        materiaOutputDto = aux.materia();

        return materiaOutputDto;
    }

    @DeleteMapping("{id}")
    public void borrarMateria(@PathVariable Integer id) throws Exception{

        System.out.println("borrando materia");
        materiaRepositorio.deleteById(id);
    }

    @PutMapping("{idMateria}")
    public Materia modificarMateria(@PathVariable Integer idMateria, @RequestBody MateriaInputDto mateDto) throws Exception{

        System.out.println("modificando materia");
        Materia mateRep=materiaRepositorio.findById(idMateria).orElseThrow(() -> new Exception("Id: " + idMateria + " No encontrado"));

        if (mateDto.getNombre()!=null)
            mateRep.setNombre(mateDto.getNombre());

        if (mateDto.getDescripcion()!=null)
            mateRep.setDescripcion(mateDto.getDescripcion());

        materiaRepositorio.save(mateRep);
        return mateRep;
    }

}
