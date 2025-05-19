package org.edu.uniquindio.uniquindio.interfaces;

import org.edu.uniquindio.Recaudador;

import java.util.Collection;

public interface ICRUDRecaudador {

    boolean crearRecaudador(Recaudador recaudador);
    boolean eliminarRecaudador(Recaudador recaudador);
    boolean actualizarRecaudador(Recaudador recaudador);
    Collection<Recaudador> listarRecaudadores();

}
