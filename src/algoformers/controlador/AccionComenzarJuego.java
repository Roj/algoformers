/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.controlador;

import algoformers.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 *
 * @author Matias
 */
public class AccionComenzarJuego implements EventHandler<ActionEvent> {

    Stage stage;

    public AccionComenzarJuego(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        
    }
    
}
