package com.example.EjercicioJPA.Controlador;

import com.example.EjercicioJPA.Excepciones.NotFoundException;
import com.example.EjercicioJPA.Excepciones.UnprocessableEntityException;
import com.example.EjercicioJPA.Servicios.Interfaces.EstudianteRepositorio;
import com.example.EjercicioJPA.Servicios.Interfaces.ProfesorRepositorio;
import com.example.EjercicioJPA.Objetos.Estudiante;
import com.example.EjercicioJPA.Controlador.DTO.Input.EstudianteInputDto;

import com.example.EjercicioJPA.Objetos.Profesor;
import com.example.EjercicioJPA.Controlador.DTO.Out.EstudianteOutputDto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("estudiante")
public class EstudianteControlador {

    @Autowired
    EstudianteRepositorio estudianteRepositorio;

    @Autowired
    ProfesorRepositorio profesorRepositorio;

    @GetMapping
    public List<Estudiante> getAll() {
        return estudianteRepositorio.findAll();
    }

    @GetMapping("{nombre}")
    public List<EstudianteOutputDto> findByLikeName(@PathVariable String nombre) throws Exception {
        List<Estudiante> aux;
        List<EstudianteOutputDto> list = new ArrayList<>();
        aux = estudianteRepositorio.findByName(nombre);
        return aux.stream().
                map(i -> new EstudianteOutputDto(i)).
                collect(Collectors.toList());
    }

    @GetMapping("{email}")
    public List<EstudianteOutputDto> findByLikeEmail(@PathVariable String email) throws Exception {
        List<Estudiante> aux;
        List<EstudianteOutputDto> list = new ArrayList<>();
        aux = estudianteRepositorio.findByEmail(email);
        return aux.stream().
                map(i -> new EstudianteOutputDto(i)).
                collect(Collectors.toList());
    }


    @GetMapping("{id}")
    public Estudiante getByID(@PathVariable Integer id) throws Exception {

        return estudianteRepositorio.findById(id).orElseThrow(() -> new Exception("No encontrado"));
    }

    @PostMapping
    public EstudianteOutputDto anadirEstudiante(@RequestBody EstudianteInputDto estudiante) throws Exception {

        System.out.println("añadiendo estudiante");
        Estudiante aux = new Estudiante();
        Profesor prof = profesorRepositorio.findById(estudiante.getId_profesor()).orElseThrow(() -> new Exception("No encontrado"));

        if (prof==null)
            throw new NotFoundException("No hay profesores");

        aux = estudiante.estudiante();
        aux.setProfesor(prof);
        estudianteRepositorio.save(aux);

        EstudianteOutputDto estudianteOutputDto = new EstudianteOutputDto();
        estudianteOutputDto = aux.estudiante();
        return estudianteOutputDto;
    }

    @DeleteMapping("{id}")
    public void borrarEstudiante(@PathVariable Integer id) throws Exception {

        System.out.println("borrando estudiante");
        estudianteRepositorio.deleteById(id);
    }

    @PutMapping("{idEstudiante}")
    public Estudiante modificarEstudiante(@PathVariable Integer idEstudiante, @RequestBody EstudianteInputDto estuDto) throws Exception {

        System.out.println("modificando estudiante");
        Estudiante estuRep = estudianteRepositorio.findById(idEstudiante).orElseThrow(() -> new Exception("Id: " + idEstudiante + " No encontrado"));

        if (true) {
            if (estuDto.getName() != null)
                estuRep.setName(estuDto.getName());

            if (estuDto.getApellido() != null)
                estuRep.setApellido(estuDto.getApellido());

            if (estuDto.getEmail() != null)
                estuRep.setEmail(estuDto.getEmail());

            if (estuDto.getCiudad() != null)
                estuRep.setCiudad(estuDto.getCiudad());

            if (estuDto.getNum_horas() != null)
                estuRep.setNum_horas(estuDto.getNum_horas());

            if (estuDto.getComentarios() != null)
                estuRep.setComentarios(estuDto.getComentarios());

            if (estuDto.getActivo() != null)
                estuRep.setActivo(estuDto.getActivo());

            if (estuDto.getFechaInicio() != null)
                estuRep.setFechaInicio(estuDto.getFechaInicio());

            if (estuDto.getFechaFin() != null)
                estuRep.setFechaFin(estuDto.getFechaFin());
        } else {
            throw new UnprocessableEntityException("La persona no puede ser nula");
        }
        estudianteRepositorio.save(estuRep);
        return estuRep;
    }

}
