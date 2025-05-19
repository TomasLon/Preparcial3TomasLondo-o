package org.edu.uniquindio.uniquindio;

import org.edu.uniquindio.Vehiculo;

public class Carro extends Vehiculo {

    private boolean motorElectrico;
    private boolean vehiculoPublico;

    public Carro(String placa, String modelo, boolean motorElectrico, boolean vehiculoPublico, int cantidadPeajesPagados) {
        super(placa, modelo, cantidadPeajesPagados);
        this.motorElectrico = motorElectrico;
        this.vehiculoPublico = vehiculoPublico;
    }

    public boolean isMotorElectrico() {return motorElectrico;}
    public void setMotorElectrico(boolean motorElectrico) {this.motorElectrico = motorElectrico;}
    public boolean isVehiculoPublico() {return vehiculoPublico;}
    public void setVehiculoPublico(boolean vehiculoPublico) {this.vehiculoPublico = vehiculoPublico;}

    @Override
    public String toString() {
        return String.format("Carro [Placa: %s, Modelo: %s, Cantidad Peajes: %d, Conductor Asignado: %s]",
                placa, modelo, cantidadPeajesPagados, conductorAsignado);
    }



}
