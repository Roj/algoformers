/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.vista;


import algoformers.controlador.AccionEmpezar;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Matias
 */
public class ContenedorPrincipal extends Contenedor {

    Stage stage;

    Scene scene;
    Button juegoNuevo; //Boton inicial que comienza la configuracion de una partida
    Button comenzarJuego;
    String nombreJugador1;
    String nombreJugador2;
    TextField casilleroJugador1;
    TextField casilleroJugador2;
    Button confirmacionJugador1;
    Button confirmacionJugador2;
    Image logoAutobots;
    Image logoDecepticons;
    
    
    public ContenedorPrincipal(Stage stage, Scene proximaEscena){
        
        super();
        
        this.stage = stage;
        
        //Setea el background con imagen de Transformers
        this.setId("background-optimusvsmegatron");
        this.getStylesheets().add("backgrounds.css");
        
        //Boton para iniciar juego nuevo
        this.juegoNuevo = new Button();
        this.colocarBoton(juegoNuevo,"Juego Nuevo",40,0,0);        
        this.juegoNuevo.setOnAction(new AccionEmpezar(stage,proximaEscena));
    }    
    
}
