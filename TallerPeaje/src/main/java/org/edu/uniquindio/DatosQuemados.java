package org.edu.uniquindio;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatosQuemados {

    // Listas de personas
    private static List<Conductor> conductores = new ArrayList<>();
    private static List<Recaudador> recaudadores = new ArrayList<>();

    // Listas de vehículos
    private static List<Carro> carros = new ArrayList<>();
    private static List<Moto> motos = new ArrayList<>();
    private static List<Camion> camiones = new ArrayList<>();

    static {
        // Datos quemados personas
        conductores.add(new Conductor("Juan", "Perez", LocalDate.of(1980, 5, 15), "123456789", "EMP001"));
        conductores.add(new Conductor("Ana", "Martinez", LocalDate.of(1985, 3, 20), "987654321", "EMP002"));

        recaudadores.add(new Recaudador("Maria", "Lopez", LocalDate.of(1990, 7, 10), "1122334455", "EMP003"));
        recaudadores.add(new Recaudador("Carlos", "Gomez", LocalDate.of(1982, 12, 5), "5566778899", "EMP004"));

        // Datos quemados vehículos
        carros.add(new Carro("ABC123", "Toyota", true, false, 10));
        carros.add(new Carro("XYZ789", "Honda", true, true, 10));

        motos.add(new Moto("MOTO001", "Yamaha YZF-R3", 800));
        motos.add(new Moto("MOTO002", "Kawasaki Ninja 400", 400));

        camiones.add(new Camion("CAMION01", "Volvo FH16", 6, 9));
        camiones.add(new Camion("CAMION02", "Scania R500", 10, 15));
    }

    // Métodos para obtener listas de personas
    public static List<Conductor> getConductores() {
        return conductores;
    }

    public static List<Recaudador> getRecaudadores() {
        return recaudadores;
    }

    // Métodos para agregar personas
    public static void agregarConductor(Conductor c) {
        conductores.add(c);
    }

    public static void agregarRecaudador(Recaudador r) {
        recaudadores.add(r);
    }

    // Métodos para obtener listas de vehículos
    public static List<Carro> getCarros() {
        return carros;
    }

    public static List<Moto> getMotos() {
        return motos;
    }

    public static List<Camion> getCamiones() {
        return camiones;
    }

    // Métodos para agregar vehículos
    public static void agregarCarro(Carro c) {
        carros.add(c);
    }

    public static void agregarMoto(Moto m) {
        motos.add(m);
    }

    public static void agregarCamion(Camion c) {
        camiones.add(c);
    }

    // Retorna una lista unificada de todas las personas
    public static List<Persona> getTodasLasPersonas() {
        List<Persona> todas = new ArrayList<>();
        todas.addAll(conductores);
        todas.addAll(recaudadores);
        return todas;
    }

    // Retorna una lista unificada de todos los vehículos
    public static List<Vehiculo> getTodosLosVehiculos() {
        List<Vehiculo> todos = new ArrayList<>();
        todos.addAll(carros);
        todos.addAll(motos);
        todos.addAll(camiones);
        return todos;
    }

    public static void asignarVehiculoAConductor(String idConductor, Vehiculo vehiculo) {
        for (Conductor conductor : conductores) {
            if (conductor.getIdentificacion().equals(idConductor)) {
                conductor.getVehiculosAsignados().add(vehiculo);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Conductor no encontrado con ID: " + idConductor);
    }


}
