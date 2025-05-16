package org.edu.uniquindio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatosQuemados {

    public static List<Persona> obtenerPersonasEjemplo() {
        List<Persona> personas = new ArrayList<>();

        personas.add(new Conductor("12345678", "Juan Pérez", LocalDate.of(1994, 5, 10), "123"));
        personas.add(new Conductor("87654321", "María Gómez", LocalDate.of(1999, 8, 22), "456"));
        personas.add(new Recaudador("11223344", "Carlos López", LocalDate.of(1983, 3, 15), "789", "12345"));
        personas.add(new Recaudador("44332211", "Ana Martínez", LocalDate.of(1988, 11, 5), "012", "67890"));

        return personas;
    }

    public static List<Vehiculo> obtenerVehiculosEjemplo() {
        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Carro("ABC123", "Toyota Corolla", false, false, 3));
        vehiculos.add(new Moto("XYZ789", "Honda CBR", 250));
        vehiculos.add(new Camion("JKL456", "Volvo FH", 4, 12.5));

        return vehiculos;
    }
}
