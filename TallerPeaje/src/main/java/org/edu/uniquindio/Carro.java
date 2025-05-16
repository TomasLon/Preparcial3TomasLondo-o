package org.edu.uniquindio;

public class Carro extends Vehiculo {

    private boolean motorElectrico;
    private boolean vehiculoPublico;
    private double cantidadPeajesPagados;


    public Carro(String placa, String modelo, boolean motorElectrico, boolean vehiculoPublico, double cantidadPeajesPagados) {
        super(placa, modelo);
        this.motorElectrico = motorElectrico;
        this.vehiculoPublico = vehiculoPublico;
        this.cantidadPeajesPagados = cantidadPeajesPagados;

    }

    public boolean isMotorElectrico() {return motorElectrico;}
    public void setMotorElectrico(boolean motorElectrico) {this.motorElectrico = motorElectrico;}
    public boolean isVehiculoPublico() {return vehiculoPublico;}
    public void setVehiculoPublico(boolean vehiculoPublico) {this.vehiculoPublico = vehiculoPublico;}
    public double getCantidadPeajesPagados() {return cantidadPeajesPagados;}
    public void setCantidadPeajesPagados(double cantidadPeajesPagados) {this.cantidadPeajesPagados = cantidadPeajesPagados;}

}
