package org.edu.uniquindio;


abstract class Vehiculo {

    private Conductor conductorAsignado;

    protected String placa;
    protected String modelo;

    public Vehiculo(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
        this.conductorAsignado = conductorAsignado;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public Conductor getConductorAsignado() {
        return conductorAsignado;
    }
    public void setConductorAsignado(Conductor conductorAsignado) {
        this.conductorAsignado = conductorAsignado;
    }
}
