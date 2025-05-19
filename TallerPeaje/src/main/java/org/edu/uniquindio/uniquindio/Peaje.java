package org.edu.uniquindio.uniquindio;

public class Peaje {

    private String ubicacion;
    private String nombre;
    private double dineroRecaudado;


    public Peaje(String ubicacion, String nombre) {
        this.ubicacion = ubicacion;
        this.nombre = nombre;
    }

    public double obtenerTotalRecaudado() {
        return dineroRecaudado;
    }

    // Getters & Setters

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDineroRecaudado(double dineroRecaudado) {
        this.dineroRecaudado = dineroRecaudado;
    }

    public double getDineroRecaudado() {
        return dineroRecaudado;
    }

}