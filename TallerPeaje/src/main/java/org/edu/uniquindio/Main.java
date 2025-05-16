package org.edu.uniquindio;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("UNIQUINDIO S.A.", "890123456-7");
        DatosEjemplo.cargarDatosEjemplo(empresa);

        while (true) {
            String[] opciones = {
                    "Registrar paso por peaje",
                    "Consultar vehículos atendidos",
                    "Ver dinero recaudado",
                    "CRUD Vehículos",
                    "CRUD Personas",
                    "Salir"
            };

            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción",
                    "Menú Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            switch (seleccion) {
                case 0 -> registrarPasoPeaje(empresa);
                case 1 -> JOptionPane.showMessageDialog(null, "Vehículos atendidos: " + empresa.listarVehiculos().size());
                case 2 -> JOptionPane.showMessageDialog(null, "Dinero recaudado: $" + empresa.getDineroRecaudado());
                case 3 -> CrudVehiculoUIEmpresa.mostrarMenu(empresa);
                case 4 -> CrudPersonaUIEmpresa.mostrarMenu(empresa);
                case 5 -> System.exit(0);
                default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }

    private static void registrarPasoPeaje(Empresa empresa) {
        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
        Vehiculo vehiculo = empresa.buscarVehiculo(placa);

        if (vehiculo == null) {
            JOptionPane.showMessageDialog(null, "Vehículo no encontrado. Regístrelo primero.");
            return;
        }

        double valorPeaje = Peaje.calcularValorPeaje(vehiculo);
        empresa.registrarPasoVehiculo(vehiculo, valorPeaje);
        JOptionPane.showMessageDialog(null, "Paso registrado. Valor del peaje: $" + valorPeaje);
    }
}
