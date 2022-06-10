package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class ServicioCiudad {

    ArrayList<Ciudad> listaCiudades = new ArrayList<>();

    public void addCiudad(String nombre, int nHabitantes) {
        Ciudad c = new Ciudad();
        c.setNombre(nombre);
        c.setNumeroHabitantes(nHabitantes);
        listaCiudades.add(c);
    }

    public ArrayList getCiudad()
    {
        return listaCiudades;
    }
}
