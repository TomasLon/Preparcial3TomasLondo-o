package org.edu.uniquindio.uniquindio.interfaces;

import org.edu.uniquindio.Carro;

import java.util.Collection;

public interface ICRUDCarro {
    boolean crearCarro(Carro carro);
    boolean eliminarCarro(Carro carro);
    boolean actualizarCarro(Carro carro);
    Collection<Carro> listarCarros();
}