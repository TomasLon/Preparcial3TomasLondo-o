package org.edu.uniquindio;

import java.util.LinkedList;
import java.util.List;

public class Peaje {

    private String ubicacion;
    private String nombre;
    private double dineroRecaudado;
    private LinkedList<Vehiculo> vehiculosRegistrados;  // Vehículos registrados
    private LinkedList<Vehiculo> pasosRegistrados;     // Cada paso por peaje (puede repetirse un vehículo)

    public Peaje(String ubicacion, String nombre) {
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.vehiculosRegistrados = new LinkedList<>();
        this.pasosRegistrados = new LinkedList<>();
    }

    public void registrarPasoPorPeaje(Vehiculo vehiculo) {
        pasosRegistrados.add(vehiculo);
        dineroRecaudado += calcularValorPeaje(vehiculo);
        if (!vehiculosRegistrados.contains(vehiculo)) {
            vehiculosRegistrados.add(vehiculo);
        }
    }

    // Buscar vehículo por placa
    public Vehiculo buscarVehiculoPorPlaca(String placa) {
        for (Vehiculo v : vehiculosRegistrados) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    public int cantidadVehiculosAtendidos() {
        return vehiculosRegistrados.size();
    }

    public double obtenerTotalRecaudado() {
        return dineroRecaudado;
    }

    public double calcularValorPeaje(Vehiculo vehiculo) {
        double peaje = 0;

        if (vehiculo instanceof Camion) {
            Camion camion = (Camion) vehiculo;
            peaje = 7000 * camion.getCantidadEjes();

            if (camion.getCapacidadCargaTon() > 10) {
                peaje += peaje * 0.10; // recargo 10%
            }

        } else if (vehiculo instanceof Carro) {
            Carro carro = (Carro) vehiculo;
            peaje = 10000;

            if (carro.isMotorElectrico()) {
                peaje -= peaje * 0.20; // descuento 20%
            }

            if (carro.isVehiculoPublico()) {
                peaje += peaje * 0.15; // incremento 15%
            }

        } else if (vehiculo instanceof Moto) {
            Moto moto = (Moto) vehiculo;
            peaje = 5000;

            if (moto.getCilindraje() > 200) {
                peaje += 2000;
            }
        }
        return peaje;
    }

    public double getDineroRecaudado() {
        return dineroRecaudado;
    }

}
