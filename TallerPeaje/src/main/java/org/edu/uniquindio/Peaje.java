package org.edu.uniquindio;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class Peaje {

    private String ubicacion;
    private String nombre;
    private double dineroRecaudado;
    private LinkedList<Vehiculo> vehiculosAtendidos;
    private LinkedList<Vehiculo> listaVehiculos;

    public Peaje(String ubicacion, String nombre, LinkedList<Vehiculo> vehiculosAtendidos) {
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.vehiculosAtendidos = new LinkedList<>();
    }

    public String getUbicacion() {return ubicacion;}

    public void setUbicacion(String ubicacion) {this.ubicacion = ubicacion;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}


    public void clasificarVehiculos( List<Vehiculo> vehiculos,
                                     LinkedList<Camion> camiones, LinkedList<Carro> carros,
                                     LinkedList<Moto> motos) {

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Camion) {
                camiones.add((Camion) vehiculo);
            } else if (vehiculo instanceof Carro) {
                carros.add((Carro) vehiculo);
            } else if (vehiculo instanceof Moto) {
                motos.add((Moto) vehiculo);
            }
        }
    }

    public double calcularValorPeaje(Vehiculo vehiculo) {
        double peaje = 0;

        if (vehiculo instanceof Camion) {
            Camion camion = (Camion) vehiculo;
            peaje = 7000 * camion.getCantidadEjes();

            if (camion.getCapacidadCargaTon() > 10) {
                peaje += peaje * 0.10; // recargo del 10% si supera 10 toneladas
            }

        } else if (vehiculo instanceof Carro) {
            Carro carro = (Carro) vehiculo;
            peaje = 10000;

            if (carro.isMotorElectrico()) {
                peaje -= peaje * 0.20; // descuento del 20%
            }

            if (carro.isVehiculoPublico()) {
                peaje += peaje * 0.15; // incremento del 15%
            }

        } else if (vehiculo instanceof Moto) {
            Moto moto = (Moto) vehiculo;
            peaje = 5000;

            if (moto.getCilindraje() > 200) {
                peaje += 2000; // recargo por cilindraje alto
            }
        }
        return peaje;
    }

    public double calcularTotalRecaudado(List<Vehiculo> vehiculos) {
        double total = 0;

        for (Vehiculo v : vehiculos) {
            total += calcularValorPeaje(v);
        }
        return total;
    }




}
