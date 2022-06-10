package com.example.demo;

public class Ciudad {
    String nombre;
    int numeroHabitantes;

    public Ciudad(String nombre, int numeroHabitantes) {
        this.nombre = nombre;
        this.numeroHabitantes = numeroHabitantes;
    }

    public Ciudad() {
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroHabitantes() {
        return numeroHabitantes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroHabitantes(int numeroHabitantes) {
        this.numeroHabitantes = numeroHabitantes;
    }
}
