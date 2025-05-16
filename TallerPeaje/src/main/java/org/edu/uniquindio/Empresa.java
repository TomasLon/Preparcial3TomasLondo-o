package org.edu.uniquindio;

import org.edu.uniquindio.interfaces.*;

import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Empresa implements ICRUDCamion, ICRUDCarro, ICRUDMoto, ICRUDRecaudador, ICRUDConductor {

    private String nombre;
    private String nit;

    private LinkedList<Vehiculo> vehiculos;
    private LinkedList<Persona> personas;

    public Empresa(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
    }
    

    public boolean verificarVehiculo(String placa) {
        boolean centinela = false;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                centinela = true;
            }
        }
        return centinela;
    }

    public boolean verificarPersona(String identificacion) {
        boolean centinela = false;
        for (Persona persona : personas) {
            if (persona.getIdentificacion().equals(identificacion)) {
                centinela = true;
            }
        }
        return centinela;
    }

// ========================= OVERRIDE METHODS =============================



    // ================= CAMION =================

    @Override
    public boolean crearCamion(Camion camion) {
        boolean centinela = false;
        if (!verificarVehiculo(camion.getPlaca())) {
            vehiculos.add(camion);
            centinela = true;
        }
        return centinela;
    }

    @Override
    public boolean eliminarCamion(Camion camion) {
        return vehiculos.removeIf(v -> v instanceof Camion && v.getPlaca().equals(camion.getPlaca()));
    }

    @Override
    public boolean actualizarCamion(Camion camion) {
        boolean eliminado = eliminarCamion(camion);
        if (eliminado) {
            crearCamion(camion);
        }
        return eliminado;
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
        boolean centinela = false;
        if (!verificarVehiculo(carro.getPlaca())) {
            vehiculos.add(carro);
            centinela = true;
        }
        return centinela;
    }

    @Override
    public boolean eliminarCarro(Carro carro) {
        return vehiculos.removeIf(v -> v instanceof Carro && v.getPlaca().equals(carro.getPlaca()));
    }

    @Override
    public boolean actualizarCarro(Carro carro) {
        boolean eliminado = eliminarCarro(carro);
        if (eliminado) {
            crearCarro(carro);
        }
        return eliminado;
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
        boolean centinela = false;
        if (!verificarVehiculo(moto.getPlaca())) {
            vehiculos.add(moto);
            centinela = true;
        }
        return centinela;
    }

    @Override
    public boolean eliminarMoto(Moto moto) {
        return vehiculos.removeIf(v -> v instanceof Moto && v.getPlaca().equals(moto.getPlaca()));
    }

    @Override
    public boolean actualizarMoto(Moto moto) {
        boolean eliminado = eliminarMoto(moto);
        if (eliminado) {
            crearMoto(moto);
        }
        return eliminado;
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
        boolean centinela = false;
        if (!verificarPersona(recaudador.getIdentificacion())) {
            personas.add(recaudador); // se asume que personas incluye a los recaudadores
            centinela = true;
        }
        return centinela;
    }

    @Override
    public boolean eliminarRecaudador(Recaudador recaudador) {
        return personas.removeIf(p -> p instanceof Recaudador && p.getIdentificacion().equals(recaudador.getIdentificacion()));
    }

    @Override
    public boolean actualizarRecaudador(Recaudador recaudador) {
        boolean eliminado = eliminarRecaudador(recaudador);
        if (eliminado) {
            crearRecaudador(recaudador);
        }
        return eliminado;
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
        boolean centinela = false;
        if (!verificarPersona(conductor.getIdentificacion())) {
            personas.add(conductor); // misma lógica: una lista genérica de personas
            centinela = true;
        }
        return centinela;
    }

    @Override
    public boolean eliminarConductor(Conductor conductor) {
        return personas.removeIf(p -> p instanceof Conductor && p.getIdentificacion().equals(conductor.getIdentificacion()));
    }

    @Override
    public boolean actualizarConductor(Conductor conductor) {
        boolean eliminado = eliminarConductor(conductor);
        if (eliminado) {
            crearConductor(conductor);
        }
        return eliminado;
    }

    @Override
    public Collection<Conductor> listarConductores() {
        return personas.stream()
                .filter(p -> p instanceof Conductor)
                .map(p -> (Conductor) p)
                .collect(Collectors.toList());
    }

}
