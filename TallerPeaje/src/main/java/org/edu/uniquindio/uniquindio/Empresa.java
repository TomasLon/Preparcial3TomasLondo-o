package org.edu.uniquindio.uniquindio;

import org.edu.uniquindio.interfaces.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Empresa implements ICRUDCamion, ICRUDCarro, ICRUDMoto, ICRUDRecaudador, ICRUDConductor {

    private String nombre;
    private String nit;
    private LinkedList<Vehiculo> vehiculos;
    private LinkedList<Persona> personas;
    private int vehiculosAtendidos = 0;
    private LinkedList<Vehiculo> vehiculosAtendidosSet = new LinkedList<>();
    private List<Vehiculo> pasosRegistrados = new ArrayList<>();


    public Empresa(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.vehiculos = new LinkedList<>();
        this.personas = new LinkedList<>();
    }

    public void registrarPasoVehiculo(Vehiculo vehiculo) {
        pasosRegistrados.add(vehiculo);
    }


    // Verificaciones de existencia de las instancias Vehículo y Persona

    public boolean verificarVehiculo(String placa) {
        return vehiculos.stream().anyMatch(v -> v.getPlaca().equalsIgnoreCase(placa));
    }

    public boolean verificarPersona(String identificacion) {
        return personas.stream().anyMatch(p -> p.getIdentificacion().equalsIgnoreCase(identificacion));
    }


    public Vehiculo buscarVehiculoPorPlaca(String placa) {
        return vehiculos.stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);
    }

    public Conductor buscarConductorPorId(String identificacion) {
        return personas.stream()
                .filter(p -> p instanceof Conductor && p.getIdentificacion().equalsIgnoreCase(identificacion))
                .map(p -> (Conductor) p)
                .findFirst()
                .orElse(null);
    }


    // ================= CAMION =================

    @Override
    public boolean crearCamion(Camion camion) {
        if (!verificarVehiculo(camion.getPlaca())) {
            vehiculos.add(camion);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarCamion(Camion camion) {
        return vehiculos.removeIf(v -> v instanceof Camion && v.getPlaca().equalsIgnoreCase(camion.getPlaca()));
    }

    @Override
    public boolean actualizarCamion(Camion camion) {
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo v = vehiculos.get(i);
            if (v instanceof Camion && v.getPlaca().equalsIgnoreCase(camion.getPlaca())) {
                vehiculos.set(i, camion);
                return true;
            }
        }
        return false;
    }

    @Override
    public Collection<Camion> listarCamiones() {
        return vehiculos.stream()
                .filter(v -> v instanceof Camion)
                .map(v -> (Camion) v)
                .collect(Collectors.toList());
    }

    // ================= CARRO =================

    @Override
    public boolean crearCarro(Carro carro) {
        if (!verificarVehiculo(carro.getPlaca())) {
            vehiculos.add(carro);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarCarro(Carro carro) {
        return vehiculos.removeIf(v -> v instanceof Carro && v.getPlaca().equalsIgnoreCase(carro.getPlaca()));
    }

    @Override
    public boolean actualizarCarro(Carro carro) {
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo v = vehiculos.get(i);
            if (v instanceof Carro && v.getPlaca().equalsIgnoreCase(carro.getPlaca())) {
                vehiculos.set(i, carro);
                return true;
            }
        }
        return false;
    }

    @Override
    public Collection<Carro> listarCarros() {
        return vehiculos.stream()
                .filter(v -> v instanceof Carro)
                .map(v -> (Carro) v)
                .collect(Collectors.toList());
    }

    // ================= MOTO =================

    @Override
    public boolean crearMoto(Moto moto) {
        if (!verificarVehiculo(moto.getPlaca())) {
            vehiculos.add(moto);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarMoto(Moto moto) {
        return vehiculos.removeIf(v -> v instanceof Moto && v.getPlaca().equalsIgnoreCase(moto.getPlaca()));
    }

    @Override
    public boolean actualizarMoto(Moto moto) {
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo v = vehiculos.get(i);
            if (v instanceof Moto && v.getPlaca().equalsIgnoreCase(moto.getPlaca())) {
                vehiculos.set(i, moto);
                return true;
            }
        }
        return false;
    }

    @Override
    public Collection<Moto> listarMotos() {
        return vehiculos.stream()
                .filter(v -> v instanceof Moto)
                .map(v -> (Moto) v)
                .collect(Collectors.toList());
    }

    // ============ RECAUDADOR ============

    @Override
    public boolean crearRecaudador(Recaudador recaudador) {
        if (!verificarPersona(recaudador.getIdentificacion())) {
            personas.add(recaudador);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarRecaudador(Recaudador recaudador) {
        return personas.removeIf(p -> p instanceof Recaudador && p.getIdentificacion().equalsIgnoreCase(recaudador.getIdentificacion()));
    }

    @Override
    public boolean actualizarRecaudador(Recaudador recaudador) {
        for (int i = 0; i < personas.size(); i++) {
            Persona p = personas.get(i);
            if (p instanceof Recaudador && p.getIdentificacion().equalsIgnoreCase(recaudador.getIdentificacion())) {
                personas.set(i, recaudador);
                return true;
            }
        }
        return false;
    }

    @Override
    public Collection<Recaudador> listarRecaudadores() {
        return personas.stream()
                .filter(p -> p instanceof Recaudador)
                .map(p -> (Recaudador) p)
                .collect(Collectors.toList());
    }

    // ============ CONDUCTOR ============

    @Override
    public boolean crearConductor(Conductor conductor) {
        if (!verificarPersona(conductor.getIdentificacion())) {
            personas.add(conductor);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarConductor(Conductor conductor) {
        return personas.removeIf(p -> p instanceof Conductor && p.getIdentificacion().equalsIgnoreCase(conductor.getIdentificacion()));
    }

    @Override
    public boolean actualizarConductor(Conductor conductor) {
        for (int i = 0; i < personas.size(); i++) {
            Persona p = personas.get(i);
            if (p instanceof Conductor && p.getIdentificacion().equalsIgnoreCase(conductor.getIdentificacion())) {
                personas.set(i, conductor);
                return true;
            }
        }
        return false;
    }

    @Override
    public Collection<Conductor> listarConductores() {
        return personas.stream()
                .filter(p -> p instanceof Conductor)
                .map(p -> (Conductor) p)
                .collect(Collectors.toList());
    }



    // ============ MÉTODOS ADICIONALES ============


    public boolean asignarVehiculoAConductor(String idConductor, String placa) {
        Conductor conductor = buscarConductorPorId(idConductor);
        Vehiculo vehiculo = buscarVehiculoPorPlaca(placa);

        if (conductor != null && vehiculo != null) {
            return conductor.getVehiculosAsignados().add(vehiculo);
        }
        return false;
    }

    public int cantidadVehiculosAtendidos() {
        return vehiculosAtendidosSet.size();
    }

    public void registrarVehiculoAtendido() {
        vehiculosAtendidos++;
    }

    public void registrarVehiculoAtendido(Vehiculo vehiculo) {
        if (!vehiculosAtendidosSet.contains(vehiculo)) {
            vehiculosAtendidosSet.add(vehiculo);
        }
    }

    public Recaudador buscarRecaudadorPorId(String id) {
        for (Recaudador r : recaudadores) {
            if (r.getIdentificacion().equals(id)) {
                return r;
            }
        }
        return null;
    }

    public Collection<Vehiculo> getListaVehiculos() {
        return vehiculos;
    }


    // Métodos de peaje

    public double calcularValorPeaje(Vehiculo vehiculo) {
        double peaje = 0;

        if (vehiculo instanceof Camion) {
            Camion camion = (Camion) vehiculo;
            peaje = 7000 * camion.getCantidadEjes();
            if (camion.getCapacidadCargaTon() > 10) {
                peaje += peaje * 0.10; // recargo 10%
            }

        } else if (vehiculo instanceof Carro) {
            Carro carro = (Carro) vehiculo;
            peaje = 10000;
            if (carro.isMotorElectrico()) {
                peaje -= peaje * 0.20; // descuento 20%
            }
            if (carro.isVehiculoPublico()) {
                peaje += peaje * 0.15; // incremento 15%
            }

        } else if (vehiculo instanceof Moto) {
            Moto moto = (Moto) vehiculo;
            peaje = 5000;
            if (moto.getCilindraje() > 200) {
                peaje += 2000;
            }
        }
        return peaje;
    }

                // ======== Tíquet del peaje =========

    public String generarInformeDetallado() {
        StringBuilder informe = new StringBuilder("=== INFORME DE VEHÍCULOS Y PEAJES ===\n\n");
        double totalRecaudado = 0;

        for (Vehiculo v : pasosRegistrados) {
            double valorPeaje = calcularValorPeaje(v);
            totalRecaudado += valorPeaje;

            informe.append("Vehículo: ").append(v.toString())
                    .append("\nValor peaje: $").append(String.format("%.0f", valorPeaje))
                    .append("\nDetalle cálculo: ");

            if (v instanceof Camion camion) {
                double base = 7000 * camion.getCantidadEjes();
                informe.append("Base ($7,000 x ").append(camion.getCantidadEjes()).append(" ejes): $").append(String.format("%.2f", base));

                if (camion.getCapacidadCargaTon() > 10) {
                    double recargo = base * 0.10;
                    informe.append(" + Recargo por alta capacidad (10%): $").append(String.format("%.2f", recargo));
                }
            } else if (v instanceof Carro carro) {
                informe.append("Base: $10,000");

                if (carro.isMotorElectrico()) {
                    informe.append(" - Descuento por vehículo eléctrico (20%): $").append(String.format("%.2f", 10000 * 0.20));
                }

                if (carro.isVehiculoPublico()) {
                    double base = carro.isMotorElectrico() ? 10000 * 0.8 : 10000;
                    informe.append(" + Incremento por vehículo público (15%): $").append(String.format("%.2f", base * 0.15));
                }
            } else if (v instanceof Moto moto) {
                informe.append("Base: $5,000");

                if (moto.getCilindraje() > 200) {
                    informe.append(" + Recargo por alto cilindraje: $2,000");
                }
            }

            informe.append("\n\n");
        }

        informe.append("Total recaudado: $").append(String.format("%.2f", totalRecaudado));
        return informe.toString();
    }

    // Métodos gestión Personas

    public Recaudador buscarRecaudadorPorNombreCompleto(String nombreCompleto) {
        if (nombreCompleto == null || nombreCompleto.trim().isEmpty()) {
            return null;}

        String nombreNormalizado = nombreCompleto.trim().toLowerCase().replaceAll("\\s+", " ");

        return personas.stream()
                .filter(p -> p instanceof Recaudador)
                .map(p -> (Recaudador) p)
                .filter(r -> {
                    String nombreRecaudador = (r.getNombre() + " " + r.getApellido()).trim().toLowerCase().replaceAll("\\s+", " ");
                    return nombreRecaudador.equals(nombreNormalizado);
                })
                .findFirst()
                .orElse(null);
    }

    public List<Conductor> obtenerConductoresConCamionesPesados() {
        return personas.stream()
                .filter(p -> p instanceof Conductor)
                .map(p -> (Conductor) p)
                .filter(conductor ->
                        conductor.getVehiculosAsignados().stream()
                                .anyMatch(vehiculo ->
                                        vehiculo instanceof Camion &&
                                                ((Camion) vehiculo).getCapacidadCargaTon() > 10
                                )
                )
                .collect(Collectors.toList());
    }


    public String calcularTotalPeajesConductor(String idConductor) {
        Conductor conductor = buscarConductorPorId(idConductor);
        if (conductor == null) {
            return "Conductor no encontrado";
        }

        StringBuilder informe = new StringBuilder();
        informe.append("=== INFORME DE PEAJES PARA ").append(conductor.getNombre())
                .append(" ").append(conductor.getApellido()).append(" ===\n\n");

        double totalPagado = 0;

        for (Vehiculo v : conductor.getVehiculosAsignados()) {
            double valorPeaje = calcularValorPeaje(v);
            totalPagado += valorPeaje;

            informe.append("Vehículo: ").append(v.toString())
                    .append("\nValor peaje: $").append(String.format("%.2f", valorPeaje))
                    .append("\n\n");
        }

        informe.append("Total pagado en peajes: $").append(String.format("%.2f", totalPagado));
        return informe.toString();
    }

}