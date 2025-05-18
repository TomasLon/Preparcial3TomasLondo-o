package org.edu.uniquindio;

import java.util.LinkedList;
import java.util.List;

public class Peaje {

    private String ubicacion;
    private String nombre;
    private double dineroRecaudado;
    private LinkedList<Vehiculo> pasosRegistrados;     // Cada paso por peaje (puede repetirse un vehículo)

    public Peaje(String ubicacion, String nombre) {
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.pasosRegistrados = new LinkedList<>();
    }

    public void registrarPasoPorPeaje(Vehiculo vehiculo, double peaje) {
        pasosRegistrados.add(vehiculo);
        dineroRecaudado += peaje;
    }

    public double obtenerTotalRecaudado() {
        return dineroRecaudado;
    }

    public double getDineroRecaudado() {
        return dineroRecaudado;
    }
}