package org.edu.uniquindio;

import org.edu.uniquindio.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

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
                // Recaudadores
                case "1" -> crearRecaudador();
                case "2" -> mostrarRecaudadores();
                case "3" -> actualizarRecaudador();
                case "4" -> eliminarRecaudador();
                case "5" -> buscarRecaudadorPorNombre();

                // Conductores
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

    // =============== RECAUDADORES ===============

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

    private void actualizarRecaudador() {
        String identificacion = JOptionPane.showInputDialog("Ingrese la identificación del recaudador a actualizar:");
        if (identificacion == null || identificacion.trim().isEmpty()) return;

        // Buscar el recaudador por identificación
        Recaudador recaudadorExistente = null;
        for (Recaudador r : empresa.listarRecaudadores()) {
            if (r.getIdentificacion().equals(identificacion)) {
                recaudadorExistente = r;
                break;
            }
        }

        if (recaudadorExistente == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún recaudador con esa identificación.");
            return;
        }

        // Solicitar nuevos datos
        String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre (actual: " + recaudadorExistente.getNombre() + "):");
        String apellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido (actual: " + recaudadorExistente.getApellido() + "):");
        String fechaNacStr = JOptionPane.showInputDialog("Ingrese la nueva fecha de nacimiento yyyy-MM-dd (actual: " + recaudadorExistente.getFechaNacimiento() + "):");
        String numeroEmpleado = JOptionPane.showInputDialog("Ingrese el nuevo número de empleado (actual: " + recaudadorExistente.getNumeroEmpleado() + "):");

        if (nombre == null || apellido == null || fechaNacStr == null || numeroEmpleado == null) return;

        LocalDate fechaNacimiento;
        try {
            fechaNacimiento = LocalDate.parse(fechaNacStr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fecha inválida. Use formato yyyy-MM-dd.");
            return;
        }

        // Crear el recaudador actualizado
        Recaudador recaudadorActualizado = new Recaudador(
                nombre,
                apellido,
                fechaNacimiento,
                identificacion, // Mantener la misma identificación
                numeroEmpleado
        );

        boolean actualizado = empresa.actualizarRecaudador(recaudadorActualizado);
        String mensaje = actualizado ? "Recaudador actualizado exitosamente." : "Error al actualizar el recaudador.";
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private void eliminarRecaudador() {
        String identificacion = JOptionPane.showInputDialog("Ingrese la identificación del recaudador a eliminar:");
        if (identificacion == null || identificacion.trim().isEmpty()) return;

        // Buscar el recaudador por identificación
        Recaudador recaudadorExistente = null;
        for (Recaudador r : empresa.listarRecaudadores()) {
            if (r.getIdentificacion().equals(identificacion)) {
                recaudadorExistente = r;
                break;
            }
        }

        if (recaudadorExistente == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún recaudador con esa identificación.");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro de eliminar al recaudador " + recaudadorExistente.getNombre() + " " + recaudadorExistente.getApellido() + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            boolean eliminado = empresa.eliminarRecaudador(recaudadorExistente);
            String mensaje = eliminado ? "Recaudador eliminado exitosamente." : "Error al eliminar el recaudador.";
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    private void mostrarRecaudadores() {
        StringBuilder sb = new StringBuilder("=== Lista de Recaudadores ===\n");
        for (Recaudador r : empresa.listarRecaudadores()) {
            sb.append("Nombre: ").append(r.getNombre()).append(" ").append(r.getApellido())
                    .append(", ID: ").append(r.getIdentificacion())
                    .append(", Nº Empleado: ").append(r.getNumeroEmpleado())
                    .append(", Fecha Nac: ").append(r.getFechaNacimiento())
                    .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }


    private void buscarRecaudadorPorNombre() {
        String nombreCompleto = JOptionPane.showInputDialog("Ingrese el nombre completo del recaudador:");
        if (nombreCompleto == null || nombreCompleto.trim().isEmpty()) return;

        Recaudador recaudador = empresa.buscarRecaudadorPorNombreCompleto(nombreCompleto);

        if (recaudador != null) {
            JOptionPane.showMessageDialog(null, "Recaudador encontrado:\n" + recaudador);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún recaudador con ese nombre.");
        }
    }

    // =============== CONDUCTORES ===============

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

    private void actualizarConductor() {
        String identificacion = JOptionPane.showInputDialog("Ingrese la identificación del conductor a actualizar:");
        if (identificacion == null || identificacion.trim().isEmpty()) return;

        // Buscar el conductor por identificación
        Conductor conductorExistente = empresa.buscarConductorPorId(identificacion);

        if (conductorExistente == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún conductor con esa identificación.");
            return;
        }

        // Solicitar nuevos datos
        String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre (actual: " + conductorExistente.getNombre() + "):");
        String apellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido (actual: " + conductorExistente.getApellido() + "):");
        String fechaNacStr = JOptionPane.showInputDialog("Ingrese la nueva fecha de nacimiento yyyy-MM-dd (actual: " + conductorExistente.getFechaNacimiento() + "):");
        String numeroEmpleado = JOptionPane.showInputDialog("Ingrese el nuevo número de empleado (actual: " + conductorExistente.getNumeroEmpleado() + "):");

        if (nombre == null || apellido == null || fechaNacStr == null || numeroEmpleado == null) return;

        LocalDate fechaNacimiento;
        try {
            fechaNacimiento = LocalDate.parse(fechaNacStr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fecha inválida. Use formato yyyy-MM-dd.");
            return;
        }

        // Crear el conductor actualizado conservando los vehículos asignados
        Conductor conductorActualizado = new Conductor(
                nombre,
                apellido,
                fechaNacimiento,
                identificacion, // Mantener la misma identificación
                numeroEmpleado
        );
        // Transferir los vehículos asignados al conductor actualizado
        conductorActualizado.getVehiculosAsignados().addAll(conductorExistente.getVehiculosAsignados());

        boolean actualizado = empresa.actualizarConductor(conductorActualizado);
        String mensaje = actualizado ? "Conductor actualizado exitosamente." : "Error al actualizar el conductor.";
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private void eliminarConductor() {
        String identificacion = JOptionPane.showInputDialog("Ingrese la identificación del conductor a eliminar:");
        if (identificacion == null || identificacion.trim().isEmpty()) return;

        // Buscar el conductor por identificación
        Conductor conductorExistente = empresa.buscarConductorPorId(identificacion);

        if (conductorExistente == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún conductor con esa identificación.");
            return;
        }

        // Verificar si tiene vehículos asignados
        if (!conductorExistente.getVehiculosAsignados().isEmpty()) {
            int confirmacionVehiculos = JOptionPane.showConfirmDialog(
                    null,
                    "Este conductor tiene vehículos asignados. ¿Desea continuar con la eliminación?",
                    "Advertencia",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirmacionVehiculos != JOptionPane.YES_OPTION) {
                return;
            }
        }

        int confirmacion = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro de eliminar al conductor " + conductorExistente.getNombre() + " " + conductorExistente.getApellido() + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            boolean eliminado = empresa.eliminarConductor(conductorExistente);
            String mensaje = eliminado ? "Conductor eliminado exitosamente." : "Error al eliminar el conductor.";
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    private void mostrarConductores() {
        StringBuilder sb = new StringBuilder("=== Lista de Conductores ===\n");
        for (Conductor c : empresa.listarConductores()) {
            sb.append("Nombre: ").append(c.getNombre()).append(" ").append(c.getApellido())
                    .append(", ID: ").append(c.getIdentificacion())
                    .append(", Nº Empleado: ").append(c.getNumeroEmpleado())
                    .append(", Fecha Nac: ").append(c.getFechaNacimiento())
                    .append("\n");

            if (!c.getVehiculosAsignados().isEmpty()) {
                sb.append("  Vehículos asignados:\n");
                for (Vehiculo v : c.getVehiculosAsignados()) {
                    sb.append("  - Placa: ").append(v.getPlaca())
                            .append(", Modelo: ").append(v.getModelo());

                    if (v instanceof Camion) {
                        Camion camion = (Camion) v;
                        sb.append(", Capacidad: ").append(camion.getCapacidadCargaTon())
                                .append(" ton, Ejes: ").append(camion.getCantidadEjes());
                    } else if (v instanceof Carro) {
                        Carro carro = (Carro) v;
                        sb.append(", Eléctrico: ").append(carro.isMotorElectrico() ? "Sí" : "No")
                                .append(", Público: ").append(carro.isVehiculoPublico() ? "Sí" : "No");
                    } else if (v instanceof Moto) {
                        Moto moto = (Moto) v;
                        sb.append(", Cilindraje: ").append(moto.getCilindraje());
                    }

                    sb.append("\n");
                }
            }
            sb.append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }


    private void asignarVehiculoAConductor() {
        String idConductor = JOptionPane.showInputDialog("Ingrese la identificación del conductor:");
        if (idConductor == null || idConductor.trim().isEmpty()) return;

        Conductor conductor = empresa.buscarConductorPorId(idConductor);
        if (conductor == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún conductor con esa identificación.");
            return;
        }

        String placaVehiculo = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
        if (placaVehiculo == null || placaVehiculo.trim().isEmpty()) return;

        boolean asignado = empresa.asignarVehiculoAConductor(idConductor, placaVehiculo);
        if (asignado) {
            JOptionPane.showMessageDialog(null, "Vehículo asignado exitosamente al conductor.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al asignar vehículo. Verifique que el vehículo exista y no esté ya asignado.");
        }
    }

    private void listarConductoresConCamionesPesados() {
        List<Conductor> conductores = empresa.obtenerConductoresConCamionesPesados();

        if (conductores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay conductores con camiones de alta capacidad (>10 ton).");
            return;
        }

        StringBuilder sb = new StringBuilder("Conductores con camiones de alta capacidad (>10 ton):\n\n");
        for (Conductor c : conductores) {
            sb.append("- ").append(c.getNombre()).append(" ").append(c.getApellido());
            sb.append(" (ID: ").append(c.getIdentificacion()).append(")\n");

            sb.append("  Camiones asignados de alta capacidad:\n");
            c.getVehiculosAsignados().stream()
                    .filter(v -> v instanceof Camion && ((Camion) v).getCapacidadCargaTon() > 10)
                    .forEach(v -> {
                        Camion camion = (Camion) v;
                        sb.append("  * Placa: ").append(camion.getPlaca())
                                .append(", Capacidad: ").append(camion.getCapacidadCargaTon())
                                .append(" ton\n");
                    });
            sb.append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}