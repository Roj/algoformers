/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.controlador;

import algoformers.vista.ContenedorCargaDeDatos;
import algoformers.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

/**
 *
 * @author Matias
 */
public class AccionConfirmarJugador implements EventHandler<ActionEvent> {
    
    int jugador;
    ContenedorCargaDeDatos contenedorDeCarga;
    
    public AccionConfirmarJugador(int n, ContenedorCargaDeDatos contenedorDeCarga) {
        this.jugador = n;
        this.contenedorDeCarga = contenedorDeCarga;
    }

    @Override
    public void handle(ActionEvent event) {
        contenedorDeCarga.confirmarJugador(jugador);
    }
    
}
