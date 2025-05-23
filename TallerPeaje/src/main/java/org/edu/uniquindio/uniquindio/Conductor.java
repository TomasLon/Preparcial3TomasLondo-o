package org.edu.uniquindio.uniquindio;

import org.edu.uniquindio.Vehiculo;

import java.time.LocalDate;
import java.util.LinkedList;

public class Conductor extends Persona{

    private LinkedList<Vehiculo> vehiculosAsignados = new LinkedList<Vehiculo>();
    private String numeroEmpleado;


    public Conductor(String nombre, String apellido, LocalDate fechaNacimiento, String identificacion, String numeroEmpleado) {
        super(nombre, apellido, fechaNacimiento, identificacion);
        this.numeroEmpleado = numeroEmpleado;
        this.vehiculosAsignados = new LinkedList<>();
    }

    public LinkedList<Vehiculo> getVehiculosAsignados() {return vehiculosAsignados;}
    public void setVehiculosAsignados(LinkedList<Vehiculo> vehiculosAsignados) {this.vehiculosAsignados = vehiculosAsignados;}
    public String getNumeroEmpleado() {return numeroEmpleado;}
    public void setNumeroEmpleado(String numeroEmpleado) {this.numeroEmpleado = numeroEmpleado;}

    @Override
    public String toString() {
        return String.format("Conductor [Nombre: %s, Número Identificación: %s, Empleado Nº: %s]",
                nombre, identificacion, numeroEmpleado);
    }


}