package org.edu.uniquindio.uniquindio;

import org.edu.uniquindio.Conductor;
import org.edu.uniquindio.Empresa;
import org.edu.uniquindio.Recaudador;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class MenuCRUDPersona {

    private Empresa empresa;

    public MenuCRUDPersona(Empresa empresa) {
        this.empresa = empresa;
    }

    public void mostrarMenu() {
        String opcion;
        do {
            opcion = JOptionPane.showInputDialog(null,
                    """
                    === CRUD PERSONAS ===
                    === RECAUDADORES ===
                    1. Crear Recaudador
                    2. Mostrar Recaudadores
                    3. Actualizar Recaudador
                    4. Eliminar Recaudador
                    5. Buscar Recaudador por Nombre
                    
                    === CONDUCTORES ===
                    6. Crear Conductor
                    7. Mostrar Conductores
                    8. Actualizar Conductor
                    9. Eliminar Conductor
                    10. Asignar Vehículo a Conductor
                    11. Listar Conductores con Camiones Pesados
                    
                    0. Volver al menú principal
                    """, "Menú Personas", JOptionPane.PLAIN_MESSAGE);

            if (opcion == null) return;

            switch (opcion) {
                case "1" -> crearRecaudador();
                case "2" -> mostrarRecaudadores();
                case "3" -> actualizarRecaudador();
                case "4" -> eliminarRecaudador();
                case "5" -> buscarRecaudadorPorNombre();
                case "6" -> crearConductor();
                case "7" -> mostrarConductores();
                case "8" -> actualizarConductor();
                case "9" -> eliminarConductor();
                case "10" -> asignarVehiculoAConductor();
                case "11" -> listarConductoresConCamionesPesados();
                case "0" -> JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (!"0".equals(opcion));
    }

    // === RECAUDADORES ===

    private void crearRecaudador() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");
        String fechaNac = JOptionPane.showInputDialog("Fecha de nacimiento (yyyy-MM-dd):");
        String id = JOptionPane.showInputDialog("Identificación:");
        String numeroEmpleado = JOptionPane.showInputDialog("Número de empleado:");

        if (nombre == null || apellido == null || fechaNac == null || id == null || numeroEmpleado == null) return;

        try {
            LocalDate fecha = LocalDate.parse(fechaNac);
            Recaudador recaudador = new Recaudador(nombre, apellido, fecha, id, numeroEmpleado);
            boolean exito = empresa.crearRecaudador(recaudador);
            JOptionPane.showMessageDialog(null, exito ? "Recaudador creado." : "Ya existe un recaudador con esa identificación.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fecha inválida.");
        }
    }

    private void mostrarRecaudadores() {
        Collection<Recaudador> lista = empresa.listarRecaudadores();
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay recaudadores.");
            return;
        }
        StringBuilder sb = new StringBuilder("=== Recaudadores ===\n");
        for (Recaudador r : lista) {
            sb.append(r).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private void actualizarRecaudador() {
        String id = JOptionPane.showInputDialog("ID del recaudador a actualizar:");
        Recaudador recaudador = empresa.buscarRecaudadorPorId(id);
        if (recaudador == null) {
            JOptionPane.showMessageDialog(null, "No encontrado.");
            return;
        }

        String nombre = JOptionPane.showInputDialog("Nuevo nombre:", recaudador.getNombre());
        String apellido = JOptionPane.showInputDialog("Nuevo apellido:", recaudador.getApellido());
        String fechaNacStr = JOptionPane.showInputDialog("Nueva fecha de nacimiento (yyyy-MM-dd):", recaudador.getFechaNacimiento().toString());
        String numeroEmpleado = JOptionPane.showInputDialog("Nuevo número de empleado:", recaudador.getNumeroEmpleado());

        try {
            LocalDate fechaNacimiento = LocalDate.parse(fechaNacStr);
            Recaudador actualizado = new Recaudador(nombre, apellido, fechaNacimiento, id, numeroEmpleado);
            boolean exito = empresa.actualizarRecaudador(actualizado);
            JOptionPane.showMessageDialog(null, exito ? "Actualizado." : "Error al actualizar.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fecha inválida.");
        }
    }

    private void eliminarRecaudador() {
        String id = JOptionPane.showInputDialog("ID del recaudador a eliminar:");
        Recaudador recaudador = empresa.buscarRecaudadorPorId(id);
        if (recaudador == null) {
            JOptionPane.showMessageDialog(null, "No encontrado.");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar recaudador?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            boolean eliminado = empresa.eliminarRecaudador(recaudador);
            JOptionPane.showMessageDialog(null, eliminado ? "Eliminado." : "Error al eliminar.");
        }
    }

    private void buscarRecaudadorPorNombre() {
        String nombreCompleto = JOptionPane.showInputDialog("Nombre completo:");
        Recaudador r = empresa.buscarRecaudadorPorNombreCompleto(nombreCompleto);
        JOptionPane.showMessageDialog(null, r != null ? r.toString() : "No encontrado.");
    }

    // === CONDUCTORES ===

    private void crearConductor() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");
        String fechaNac = JOptionPane.showInputDialog("Fecha de nacimiento (yyyy-MM-dd):");
        String id = JOptionPane.showInputDialog("Identificación:");
        String numeroEmpleado = JOptionPane.showInputDialog("Número de empleado:");

        if (nombre == null || apellido == null || fechaNac == null || id == null || numeroEmpleado == null) return;

        try {
            LocalDate fecha = LocalDate.parse(fechaNac);
            Conductor conductor = new Conductor(nombre, apellido, fecha, id, numeroEmpleado);
            boolean exito = empresa.crearConductor(conductor);
            JOptionPane.showMessageDialog(null, exito ? "Conductor creado." : "Ya existe un conductor con esa identificación.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fecha inválida.");
        }
    }

    private void mostrarConductores() {
        Collection<Conductor> lista = empresa.listarConductores();
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay conductores.");
            return;
        }
        StringBuilder sb = new StringBuilder("=== Conductores ===\n");
        for (Conductor c : lista) {
            sb.append(c).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private void actualizarConductor() {
        String id = JOptionPane.showInputDialog("ID del conductor a actualizar:");
        Conductor conductor = empresa.buscarConductorPorId(id);
        if (conductor == null) {
            JOptionPane.showMessageDialog(null, "No encontrado.");
            return;
        }

        String nombre = JOptionPane.showInputDialog("Nuevo nombre:", conductor.getNombre());
        String apellido = JOptionPane.showInputDialog("Nuevo apellido:", conductor.getApellido());
        String fechaNacStr = JOptionPane.showInputDialog("Nueva fecha de nacimiento (yyyy-MM-dd):", conductor.getFechaNacimiento().toString());
        String numeroEmpleado = JOptionPane.showInputDialog("Nuevo número de empleado:", conductor.getNumeroEmpleado());

        try {
            LocalDate fechaNacimiento = LocalDate.parse(fechaNacStr);
            Conductor actualizado = new Conductor(nombre, apellido, fechaNacimiento, id, numeroEmpleado);
            boolean exito = empresa.actualizarConductor(actualizado);
            JOptionPane.showMessageDialog(null, exito ? "Actualizado." : "Error al actualizar.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fecha inválida.");
        }
    }

    private void eliminarConductor() {
        String id = JOptionPane.showInputDialog("ID del conductor a eliminar:");
        Conductor conductor = empresa.buscarConductorPorId(id);
        if (conductor == null) {
            JOptionPane.showMessageDialog(null, "No encontrado.");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(null, "¿Eliminar conductor?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            boolean eliminado = empresa.eliminarConductor(conductor);
            JOptionPane.showMessageDialog(null, eliminado ? "Eliminado." : "Error al eliminar.");
        }
    }

    private void asignarVehiculoAConductor() {
        String idConductor = JOptionPane.showInputDialog("Ingrese ID del conductor:");
        String placaVehiculo = JOptionPane.showInputDialog("Ingrese placa del vehículo:");

        if (idConductor == null || placaVehiculo == null) return;

        boolean exito = empresa.asignarVehiculoAConductor(idConductor, placaVehiculo);
        JOptionPane.showMessageDialog(null, exito ? "Vehículo asignado." : "Error: verifique conductor y vehículo.");
    }

    private void listarConductoresConCamionesPesados() {
        List<Conductor> conductores = empresa.obtenerConductoresConCamionesPesados();
        if (conductores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay conductores con camiones pesados.");
            return;
        }
        StringBuilder sb = new StringBuilder("Conductores con camiones > 10t:\n");
        for (Conductor c : conductores) {
            sb.append(c).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
