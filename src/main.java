/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Matias
 */

import algoformers.vista.ContenedorCargaDeDatos;
import algoformers.vista.ContenedorPrincipal;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Algoformers");
        
        //Setea dimensiones de la ventana al tamaño de la pantalla
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double width = primaryScreenBounds.getWidth();
        double height = primaryScreenBounds.getHeight(); 
        stage.setX(primaryScreenBounds.getMinX());
        stage.setY(primaryScreenBounds.getMinY());
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setResizable(false);
                
        ContenedorCargaDeDatos cargaDatos = new ContenedorCargaDeDatos(stage);
        Scene escenaCarga = new Scene(cargaDatos,640,480);
        
        ContenedorPrincipal menu = new ContenedorPrincipal(stage,escenaCarga);
        Scene escenaPrincipal = new Scene(menu,640,480);
        
        stage.setScene(escenaPrincipal);
        
        stage.show();
    }
    
}
