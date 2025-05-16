package org.edu.uniquindio.interfaces;

import org.edu.uniquindio.Conductor;

import java.util.Collection;

public interface ICRUDConductor {

    boolean crearConductor(Conductor conductor);
    boolean eliminarConductor(Conductor conductor);
    boolean actualizarConductor(Conductor conductor);
    Collection<Conductor> listarConductores();
}
