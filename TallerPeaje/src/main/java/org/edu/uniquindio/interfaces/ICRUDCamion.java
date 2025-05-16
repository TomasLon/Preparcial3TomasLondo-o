package org.edu.uniquindio.interfaces;

import org.edu.uniquindio.Camion;

import java.util.Collection;

public interface ICRUDCamion {

    boolean crearCamion(Camion camion);
    boolean eliminarCamion(Camion camion);
    boolean actualizarCamion(Camion camion);
    Collection<Camion> listarCamiones();
}
