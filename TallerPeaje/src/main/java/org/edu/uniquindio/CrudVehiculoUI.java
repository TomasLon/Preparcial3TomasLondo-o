package org.edu.uniquindio;

import javax.swing.*;
import java.util.List;

public class CrudVehiculoUI {

    public static void mostrarMenu(List<Vehiculo> vehiculos) {
        while (true) {
            String opcion = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione acción para Vehículos:",
                    "Administrar Vehículos",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    new String[]{"Crear", "Listar", "Actualizar", "Eliminar", "Volver"},
                    "Listar"
            );

            if (opcion == null || opcion.equals("Volver")) break;

            switch (opcion) {
                case "Crear" -> crearVehiculo(vehiculos);
                case "Listar" -> listarVehiculos(vehiculos);
                case "Actualizar" -> actualizarVehiculo(vehiculos);
                case "Eliminar" -> eliminarVehiculo(vehiculos);
            }
        }
    }

    private static void crearVehiculo(List<Vehiculo> vehiculos) {

        String placa = JOptionPane.showInputDialog("Ingrese placa:");
        String modelo = JOptionPane.showInputDialog("Ingrese modelo:");
        String tipo = (String) JOptionPane.showInputDialog(null, "Tipo de vehículo:", "Tipo",
                JOptionPane.PLAIN_MESSAGE, null, new String[]{"Carro", "Moto", "Camion"}, "Carro");

        Vehiculo nuevo = null;
        if (placa != null && modelo != null && tipo != null) {
            switch (tipo) {
                case "Carro" -> {
                    boolean electrico = JOptionPane.showConfirmDialog(null, "¿Es eléctrico?", "Motor eléctrico", JOptionPane.YES_NO_OPTION) == 0;
                    boolean publico = JOptionPane.showConfirmDialog(null, "¿Es público?", "Vehículo público", JOptionPane.YES_NO_OPTION) == 0;
                    nuevo = new Carro(placa, modelo, electrico, publico, 0);
                }
                case "Moto" -> {
                    double cilindraje = Double.parseDouble(JOptionPane.showInputDialog("Cilindraje:"));
                    nuevo = new Moto(placa, modelo, cilindraje);
                }
                case "Camion" -> {
                    int ejes = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de ejes:"));
                    double carga = Double.parseDouble(JOptionPane.showInputDialog("Capacidad de carga (ton):"));
                    nuevo = new Camion(placa, modelo, ejes, carga);
                }
            }
            if (nuevo != null) {
                vehiculos.add(nuevo);
                JOptionPane.showMessageDialog(null, "Vehículo creado exitosamente.");
            }
        }
    }

    private static void listarVehiculos(List<Vehiculo> vehiculos) {
        StringBuilder sb = new StringBuilder("Vehículos registrados:\n");
        for (Vehiculo v : vehiculos) {
            sb.append(v.getClass().getSimpleName())
                    .append(" - Placa: ").append(v.getPlaca())
                    .append(", Modelo: ").append(v.getModelo())
                    .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void actualizarVehiculo(List<Vehiculo> vehiculos) {
        String placa = JOptionPane.showInputDialog("Ingrese placa del vehículo a actualizar:");
        Vehiculo v = vehiculos.stream().filter(veh -> veh.getPlaca().equalsIgnoreCase(placa)).findFirst().orElse(null);
        if (v == null) {
            JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
            return;
        }
        String nuevoModelo = JOptionPane.showInputDialog("Nuevo modelo:", v.getModelo());
        if (nuevoModelo != null && !nuevoModelo.isBlank()) {
            v.setModelo(nuevoModelo);
            JOptionPane.showMessageDialog(null, "Modelo actualizado.");
        }
    }

    private static void eliminarVehiculo(List<Vehiculo> vehiculos) {
        String placa = JOptionPane.showInputDialog("Ingrese placa del vehículo a eliminar:");
        Vehiculo v = vehiculos.stream().filter(veh -> veh.getPlaca().equalsIgnoreCase(placa)).findFirst().orElse(null);
        if (v == null) {
            JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
            return;
        }
        vehiculos.remove(v);
        JOptionPane.showMessageDialog(null, "Vehículo eliminado.");
    }


}