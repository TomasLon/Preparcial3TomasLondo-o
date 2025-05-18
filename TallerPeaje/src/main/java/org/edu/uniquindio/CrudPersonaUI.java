package org.edu.uniquindio;

import org.edu.uniquindio.*;

import javax.swing.*;
import java.time.LocalDate;

public class CrudPersonaUI {

    private Empresa empresa;

    public CrudPersonaUI(Empresa empresa) {
        this.empresa = empresa;
    }

    public void mostrarMenu() {
        String opcion;
        do {
            opcion = JOptionPane.showInputDialog(null,
                    """
                    === CRUD PERSONAS ===
                    1. Crear Recaudador
                    2. Crear Conductor
                    3. Mostrar Recaudadores
                    4. Mostrar Conductores
                    5. Asignar Vehículo a Conductor
                    0. Volver al menú principal
                    """, "Menú Personas", JOptionPane.PLAIN_MESSAGE);

            if (opcion == null) return;

            switch (opcion) {
                case "1" -> crearRecaudador();
                case "2" -> crearConductor();
                case "3" -> mostrarRecaudadores();
                case "4" -> mostrarConductores();
                case "5" -> asignarVehiculoAConductor();
                case "0" -> JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (!"0".equals(opcion));
    }

    private void crearRecaudador() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del recaudador:");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del recaudador:");
        String fechaNacStr = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento (yyyy-MM-dd):");
        String identificacion = JOptionPane.showInputDialog("Ingrese la identificación:");
        String numeroEmpleado = JOptionPane.showInputDialog("Ingrese el número de empleado:");

        if (nombre == null || apellido == null || fechaNacStr == null || identificacion == null || numeroEmpleado == null) return;

        LocalDate fechaNacimiento;
        try {
            fechaNacimiento = LocalDate.parse(fechaNacStr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fecha inválida. Use formato yyyy-MM-dd.");
            return;
        }

        Recaudador recaudador = new Recaudador(nombre, apellido, fechaNacimiento, identificacion, numeroEmpleado);
        boolean creado = empresa.crearRecaudador(recaudador);

        String mensaje = creado ? "Recaudador creado exitosamente." : "El recaudador ya existe.";
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private void crearConductor() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del conductor:");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del conductor:");
        String fechaNacStr = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento (yyyy-MM-dd):");
        String identificacion = JOptionPane.showInputDialog("Ingrese la identificación:");
        String numeroEmpleado = JOptionPane.showInputDialog("Ingrese el número de empleado:");

        if (nombre == null || apellido == null || fechaNacStr == null || identificacion == null || numeroEmpleado == null) return;

        LocalDate fechaNacimiento;
        try {
            fechaNacimiento = LocalDate.parse(fechaNacStr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fecha inválida. Use formato yyyy-MM-dd.");
            return;
        }

        Conductor conductor = new Conductor(nombre, apellido, fechaNacimiento, identificacion, numeroEmpleado);
        boolean creado = empresa.crearConductor(conductor);

        String mensaje = creado ? "Conductor creado exitosamente." : "El conductor ya existe.";
        JOptionPane.showMessageDialog(null, mensaje);
    }


    private void mostrarRecaudadores() {
        StringBuilder sb = new StringBuilder("=== Lista de Recaudadores ===\n");
        for (Recaudador r : empresa.listarRecaudadores()) {
            sb.append(r).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private void mostrarConductores() {
        StringBuilder sb = new StringBuilder("=== Lista de Conductores ===\n");
        for (Conductor c : empresa.listarConductores()) {
            sb.append(c).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private void asignarVehiculoAConductor() {
        String idConductor = JOptionPane.showInputDialog("Ingrese la identificación del conductor:");
        String placaVehiculo = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");

        if (idConductor == null || placaVehiculo == null) return;

        empresa.asignarVehiculoAConductor(idConductor, placaVehiculo);
    }
}
