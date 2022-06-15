package com.example.EjercicioJPA.Controlador;

import com.example.EjercicioJPA.Servicios.Interfaces.MateriaRepositorio;
import com.example.EjercicioJPA.Objetos.Materia;
import com.example.EjercicioJPA.Objetos.Profesor;
import com.example.EjercicioJPA.Controlador.DTO.Input.ProfesorInputDto;
import com.example.EjercicioJPA.Servicios.Interfaces.ProfesorRepositorio;
import com.example.EjercicioJPA.Controlador.DTO.Out.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("profesor")
public class ProfesorControlador {

    @Autowired
    ProfesorRepositorio profesorRepositorio;

    @Autowired
    MateriaRepositorio materiaRepositorio;

    @GetMapping
    public List<Profesor> getAll(){

        return profesorRepositorio.findAll();
    }

    @GetMapping("{id}")
    public Profesor getByID(@PathVariable Integer id) throws Exception{

        return profesorRepositorio.findById(id).orElseThrow(() -> new Exception("No encontrado"));
    }

    @GetMapping("{nombre}")
    public List<ProfesorOutputDto> findByLikeName(@PathVariable String nombre) throws Exception{
        List<Profesor> aux;
        List<ProfesorOutputDto>list= new ArrayList<>();
        aux = profesorRepositorio.findByName(nombre);
        return aux.stream().
                map( i -> new ProfesorOutputDto(i)).
                collect(Collectors.toList());
    }

    @GetMapping("{email}")
    public List<ProfesorOutputDto> findByLikeEmail(@PathVariable String email) throws Exception{
        List<Profesor> aux;
        List<ProfesorOutputDto>list= new ArrayList<>();
        aux = profesorRepositorio.findByEmail(email);
        return aux.stream().
                map( i -> new ProfesorOutputDto(i)).
                collect(Collectors.toList());
    }


    @PostMapping
    public ProfesorOutputDto anadirProfesor(@RequestBody ProfesorInputDto profesor) throws Exception{
        System.out.println("añadiendo profesor");
        Profesor aux = new Profesor();
        Materia materia = materiaRepositorio.findById(profesor.getMateria()).orElseThrow(() -> new Exception("No encontrado"));
        aux = profesor.profesor();
        aux.setMateria(materia);
        profesorRepositorio.save(aux);
        ProfesorOutputDto profesorOutputDto = new ProfesorOutputDto();
        profesorOutputDto = aux.profesor();
        return profesorOutputDto;
    }



    @DeleteMapping("{id}")
    public void borrarProfesor(@PathVariable Integer id) throws Exception{

        System.out.println("borrando profesor");
        profesorRepositorio.deleteById(id);
    }

    @PutMapping("{idProfesor}")
    public Profesor modificarProfesor(@PathVariable Integer idProfesor, @RequestBody ProfesorInputDto profeDto) throws Exception{

        System.out.println("modificando profesor");
        Profesor ProfeRep=profesorRepositorio.findById(idProfesor).orElseThrow(() -> new Exception("Id: " + idProfesor + " No encontrado"));

        if (profeDto.getName()!=null)
            ProfeRep.setName(profeDto.getName());

        if (profeDto.getApellido()!=null)
            ProfeRep.setApellido(profeDto.getApellido());

        if (profeDto.getEmail()!=null)
            ProfeRep.setEmail(profeDto.getEmail());

        if (profeDto.getCiudad()!=null)
            ProfeRep.setCiudad(profeDto.getCiudad());

        if (profeDto.getComentarios()!=null)
            ProfeRep.setComentarios(profeDto.getComentarios());

        if (profeDto.getActivo()!=null)
            ProfeRep.setActivo(profeDto.getActivo());

        if (profeDto.getFechaInicio()!=null)
            ProfeRep.setFechaInicio(profeDto.getFechaInicio());

        if (profeDto.getFechaFin()!=null)
            ProfeRep.setFechaFin(profeDto.getFechaFin());

        profesorRepositorio.save(ProfeRep);
        return ProfeRep;
    }

}
