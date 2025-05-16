package org.edu.uniquindio;

import java.time.LocalDate;
import java.util.LinkedList;

public class Conductor extends Persona{

    private LinkedList<Vehiculo> vehiculosAsignados = new LinkedList<Vehiculo>();
    private String numeroEmpleado;


    public Conductor(String nombre, String apellido, LocalDate fechaNacimiento, String identificacion) {
        super(nombre, apellido, fechaNacimiento, identificacion);
    }

    public LinkedList<Vehiculo> getVehiculosAsignados() {
        return vehiculosAsignados;
    }

    public void setVehiculosAsignados(LinkedList<Vehiculo> vehiculosAsignados) {
        this.vehiculosAsignados = vehiculosAsignados;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }
}
