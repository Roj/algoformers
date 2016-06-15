/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.controlador;

import algoformers.vista.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Matias
 */
public class AccionEmpezar implements EventHandler<ActionEvent> {
    
    Stage stage;
    Scene proximaEscena;
    
    public AccionEmpezar(Stage stage, Scene proximaEscena) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(ActionEvent event) {
        stage.setScene(proximaEscena);
    }
    
    
}
