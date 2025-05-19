package org.edu.uniquindio.uniquindio;

import org.edu.uniquindio.Vehiculo;

public class Moto extends Vehiculo {
    private double cilindraje;

    public Moto(String placa,String modelo, double cilindraje, int cantidadPeajesPagados) {
        super(placa, modelo, cantidadPeajesPagados);
        this.cilindraje = cilindraje;
    }

    public double getCilindraje() {return cilindraje;}
    public void setCilindraje(double cilindraje) {this.cilindraje = cilindraje;}

    @Override
    public String toString() {
        return String.format("Moto [Placa: %s, Modelo: %s, Cantidad Peajes: %d, Conductor: %s, Cilindraje: %.0f]",
                placa, modelo, cantidadPeajesPagados, conductorAsignado, cilindraje);
    }

}
