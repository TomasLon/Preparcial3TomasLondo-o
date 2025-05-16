package org.edu.uniquindio.interfaces;

import org.edu.uniquindio.Moto;

import java.util.Collection;

public interface ICRUDMoto {

    boolean eliminarMoto(Moto moto);
    boolean actualizarMoto(Moto moto);
    Collection<Moto> listarMotos();
    boolean crearMoto(Moto moto);

}

