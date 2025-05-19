package org.edu.uniquindio.uniquindio;

public class Camion extends Vehiculo {

    private double cantidadEjes;
    private double capacidadCargaTon;

    public Camion(String placa, String modelo, double cantidadEjes, double capacidadCargaTon, int cantidadPeajesPagados) {
        super(placa, modelo, cantidadPeajesPagados);
        this.cantidadEjes = cantidadEjes;
        this.capacidadCargaTon = capacidadCargaTon;
    }

    public double getCapacidadCargaTon() {return capacidadCargaTon;}
    public void setCapacidadCargaTon(double capacidadCargaTon) {this.capacidadCargaTon = capacidadCargaTon;}
    public double getCantidadEjes() {return cantidadEjes;}
    public void setCantidadEjes(double cantidadEjes) {this.cantidadEjes = cantidadEjes;}

    @Override
    public String toString() {
        return String.format("Camión [Placa: %s, Modelo: %s, Cantidad Peajes: %d, " +
                        "Conductor Asignado: %s, Cantidad Ejes: %.0f, Capacidad de Carga (Toneladas): %.0f]",
                placa, modelo, cantidadPeajesPagados, conductorAsignado, cantidadEjes, capacidadCargaTon);
    }


}
