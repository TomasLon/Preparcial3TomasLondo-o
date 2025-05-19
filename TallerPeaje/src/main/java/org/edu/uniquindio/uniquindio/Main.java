package org.edu.uniquindio.uniquindio;

import javax.swing.*;
import java.util.List;

public class Main {
    static Empresa empresa = new Empresa("Empresa de Transporte", "123456789");
    static Peaje peaje = new Peaje("Armenia", "Peaje Principal");
    static List<Vehiculo> vehiculos = DatosQuemados.getTodosLosVehiculos();
    static List<Persona> personas = DatosQuemados.getTodasLasPersonas();


    static {
        for (Vehiculo v : vehiculos) {
            if (v instanceof Camion) {
                empresa.crearCamion((Camion) v);
            } else if (v instanceof Carro) {
                empresa.crearCarro((Carro) v);
            } else if (v instanceof Moto) {
                empresa.crearMoto((Moto) v);
            }
        }

        for (Persona p : personas) {
            if (p instanceof Conductor) {
                empresa.crearConductor((Conductor) p);
            } else if (p instanceof Recaudador) {
                empresa.crearRecaudador((Recaudador) p);
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            String opcion = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione una opción:",
                    "Menú Principal",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    new String[]{
                            "Administrar Vehículos",
                            "Administrar Personas",
                            "Asignar vehículo a conductor",
                            "Registrar paso de vehículo",
                            "Consultar vehículos atendidos",
                            "Ver dinero recaudado",
                            "Salir"
                    },
                    "Administrar Vehículos"
            );

            if (opcion == null || opcion.equals("Salir")) {
                JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                break;
            }

            manejarMenuPrincipal(opcion);
        }
    }

    private static void manejarMenuPrincipal(String opcion) {
        switch (opcion) {
            case "Administrar Vehículos":
                MenuCRUDPersona menuVehiculo = new MenuCRUDPersona();
                menuPerso.mostrarMenu(personas);
                break;
            case "Administrar Personas":
                MenuCRUDVehiculo menuVehiculo = new MenuCRUDVehiculo();
                menuVehiculo.mostrarMenu(vehiculos);
                break;
            case "Registrar paso de vehículo":
                registrarPaso();
                break;
            case "Consultar vehículos atendidos":
                mostrarVehiculosAtendidos();
                break;
            case "Ver dinero recaudado":
                mostrarDineroRecaudado();
                break;
            case "Asignar vehículo a conductor":
                asignarVehiculoAConductor();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida.");
                break;
        }
    }

    private static void registrarPaso() {
        String placa = JOptionPane.showInputDialog("Ingrese placa del vehículo para registrar paso:");

        if (placa == null || placa.isBlank()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una placa válida.");
            return;
        }

        Vehiculo vehiculo = empresa.buscarVehiculoPorPlaca(placa);
        if (vehiculo != null) {
            double valorPeaje = empresa.calcularValorPeaje(vehiculo);
            empresa.registrarPasoVehiculo(vehiculo);
            empresa.registrarVehiculoAtendido();
            JOptionPane.showMessageDialog(null,
                    "Paso registrado para vehículo:\n" +
                            vehiculo.getPlaca() + " - " + vehiculo.getModelo() +
                            "\nValor Peaje: $" + valorPeaje);
        } else {
            JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
        }
    }

    private static void asignarVehiculoAConductor() {
        String idConductor = JOptionPane.showInputDialog("Ingrese ID del conductor:");
        if (idConductor == null || idConductor.isBlank()) {
            JOptionPane.showMessageDialog(null, "ID inválido.");
            return;
        }

        String placa = JOptionPane.showInputDialog("Ingrese placa del vehículo:");
        if (placa == null || placa.isBlank()) {
            JOptionPane.showMessageDialog(null, "Placa inválida.");
            return;
        }

        boolean resultado = empresa.asignarVehiculoAConductor(idConductor, placa);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Vehículo asignado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error asignando vehículo.");
        }
    }

    private static void mostrarVehiculosAtendidos() {
        JOptionPane.showMessageDialog(null, "Vehículos atendidos: " + empresa.cantidadVehiculosAtendidos());
    }

    private static void mostrarDineroRecaudado() {
        JOptionPane.showMessageDialog(null, String.format("Dinero recaudado: $%.2f", peaje.getDineroRecaudado()));
    }

    public static void procesarPasoVehiculo(String placa) {
        Vehiculo vehiculo = empresa.buscarVehiculoPorPlaca(placa);
        if (vehiculo == null) {
            JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
            return;
        }

        double valorPeaje = empresa.calcularValorPeaje(vehiculo);
        empresa.registrarPasoVehiculo(vehiculo);

        JOptionPane.showMessageDialog(null,
                "Paso registrado exitosamente.\n" +
                        "Vehículo: " + vehiculo.getPlaca() + "\n" +
                        "Valor peaje: $" + String.format("%.2f", valorPeaje));
    }

}
