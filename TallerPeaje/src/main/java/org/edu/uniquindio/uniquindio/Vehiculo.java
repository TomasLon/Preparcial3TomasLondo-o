package org.edu.uniquindio.uniquindio;

abstract class Vehiculo {

    protected Conductor conductorAsignado;
    protected String placa;
    protected String modelo;
    protected int cantidadPeajesPagados;

    public Vehiculo(String placa, String modelo, int cantidadPeajesPagados) {
        this.placa = placa;
        this.modelo = modelo;
        this.conductorAsignado = conductorAsignado;
        this.cantidadPeajesPagados = cantidadPeajesPagados;
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
    public int getCantidadPeajesPagados() {
        return cantidadPeajesPagados;
    }
    public void setCantidadPeajesPagados(int cantidadPeajesPagados) {
        this.cantidadPeajesPagados = cantidadPeajesPagados;
    }

    @Override
    public String toString() {
        return String.format("Vehículo [Placa: %s, Modelo: %s, Cantidad Peajes: %s, Cantidad de Peajes Pagados: %s]",
                placa, modelo, cantidadPeajesPagados, conductorAsignado);
    }

}
