package com.example.demo;

public class Persona {
    String nombre;
    String pobleacion;
    int edad;

    public Persona() {
    }

    public Persona(String nombre, String pobleacion, int edad) {
        this.nombre = nombre;
        this.pobleacion = pobleacion;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPobleacion() {
        return pobleacion;
    }

    public void setPobleacion(String pobleacion) {
        this.pobleacion = pobleacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
