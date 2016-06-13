/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.controlador;

import algoformers.vista.VistaMenuPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

/**
 *
 * @author Matias
 */
public class AccionConfirmarJugador implements EventHandler<ActionEvent> {
    
    int jugador;
    VistaMenuPrincipal menuPrincipal;
    
    public AccionConfirmarJugador(int n, VistaMenuPrincipal menu) {
        this.jugador = n;
        this.menuPrincipal = menu;
    }

    @Override
    public void handle(ActionEvent event) {
        menuPrincipal.confirmarJugador(jugador);
    }
    
}
