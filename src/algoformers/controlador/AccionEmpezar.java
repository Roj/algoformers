/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.controlador;

import algoformers.vista.VistaMenuPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Matias
 */
public class AccionEmpezar implements EventHandler<ActionEvent> {
    
    VistaMenuPrincipal menuPrincipal;
    
    public AccionEmpezar(VistaMenuPrincipal menu) {
        this.menuPrincipal = menu;
    }

    @Override
    public void handle(ActionEvent event) {
        this.menuPrincipal.panelDeCargaDeDatos();
    }
    
    
}
