package org.edu.uniquindio;

public class Moto extends Vehiculo {
    private double cilindraje;

    public Moto(String placa,String modelo, double cilindraje) {
        super(placa, modelo);
        this.cilindraje = cilindraje;
    }

    public double getCilindraje() {return cilindraje;}
    public void setCilindraje(double cilindraje) {this.cilindraje = cilindraje;}

}
