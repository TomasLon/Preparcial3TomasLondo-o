package org.edu.uniquindio;

public class Carro extends Vehiculo {

    private boolean motorElectrico;
    private boolean vehiculoPublico;

    public Carro(String placa, String modelo, boolean motorElectrico, boolean vehiculoPublico) {
        super(placa, modelo);
        this.motorElectrico = motorElectrico;
        this.vehiculoPublico = vehiculoPublico;
    }

    public boolean isMotorElectrico() {return motorElectrico;}
    public void setMotorElectrico(boolean motorElectrico) {this.motorElectrico = motorElectrico;}
    public boolean isVehiculoPublico() {return vehiculoPublico;}
    public void setVehiculoPublico(boolean vehiculoPublico) {this.vehiculoPublico = vehiculoPublico;}

}
