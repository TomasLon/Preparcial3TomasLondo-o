package org.edu.uniquindio.uniquindio;

import java.time.LocalDate;

public class Recaudador extends Persona {

    private String numeroEmpleado;

    public Recaudador(String nombre, String apellido, LocalDate fechaNacimiento, String identificacion, String numeroEmpleado) {
        super(nombre, apellido, fechaNacimiento, identificacion);
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }
}
