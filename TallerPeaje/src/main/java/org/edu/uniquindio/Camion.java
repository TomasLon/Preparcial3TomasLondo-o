package org.edu.uniquindio;

public class Camion extends Vehiculo {

    private double cantidadEjes;
    private double capacidadCargaTon;

    public Camion(String placa, String modelo, double cantidadEjes, double capacidadCargaTon) {
        super(placa, modelo);
        this.cantidadEjes = cantidadEjes;
        this.capacidadCargaTon = capacidadCargaTon;
    }

    public double getCapacidadCargaTon() {return capacidadCargaTon;}
    public void setCapacidadCargaTon(double capacidadCargaTon) {this.capacidadCargaTon = capacidadCargaTon;}
    public double getCantidadEjes() {return cantidadEjes;}
    public void setCantidadEjes(double cantidadEjes) {this.cantidadEjes = cantidadEjes;}


}
