/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.vista;


import algoformers.controlador.AccionConfirmarJugador;
import algoformers.controlador.AccionComenzarJuego;
import algoformers.controlador.AccionEmpezar;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 *
 * @author Matias
 */
public class VistaMenuPrincipal extends Stage {
    
    StackPane pane;
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
    
    
    public VistaMenuPrincipal(){
        this.setTitle("Algoformers");
        
        //Setea dimensiones de la ventana al tamaño de la pantalla
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double width = primaryScreenBounds.getWidth();
        double height = primaryScreenBounds.getHeight(); 
        this.setX(primaryScreenBounds.getMinX());
        this.setY(primaryScreenBounds.getMinY());
        this.setWidth(width);
        this.setHeight(height);
        this.setResizable(false);

        this.pane = new StackPane();
        
        //Setea el background con imagen de Transformers
        this.pane.setId("background");
        this.scene = new Scene(this.pane,300,250);
        this.scene.getStylesheets().add("background.css");
        
        //Boton para iniciar juego nuevo
        this.juegoNuevo = new Button();
        this.juegoNuevo.setId("boton-juego");
        this.juegoNuevo.setText("Juego Nuevo");
        this.juegoNuevo.getStylesheets().add("botones.css");
        this.juegoNuevo.setStyle("-fx-font-size: 40px");
        
        this.pane.getChildren().add(this.juegoNuevo);
        
        this.juegoNuevo.setOnAction(new AccionEmpezar(this));

        
        this.setScene(this.scene);
    }

    public void panelDeCargaDeDatos() {
        //Mi idea es hacer una clase panelDeCargaDeDatos que encapsule todo esto, y no hacer todo aca, pero no pude
        //Alguno trata de emprolijarlo?
        
        //Cambio background con personajes
        this.scene.getStylesheets().remove("background.css");
        this.pane.setId("background-personajes");
        this.scene.getStylesheets().add("background-personajes.css");
        this.pane.getChildren().remove(this.juegoNuevo);
        
        //Boton para comenzar juego 
        this.comenzarJuego = new Button();
        this.comenzarJuego.setId("boton-juego");
        this.comenzarJuego.setText("Comenzar Juego");
        this.comenzarJuego.getStylesheets().add("botones.css");
        this.comenzarJuego.setStyle("-fx-font-size: 30px");
        this.pane.getChildren().add(this.comenzarJuego);
        this.comenzarJuego.setTranslateX(450);
        this.comenzarJuego.setTranslateY(-300);
        this.comenzarJuego.setOnAction(new AccionComenzarJuego(this));
        
        //Casilleros para completar nombres de jugador
        this.casilleroJugador1 = new TextField();
        this.casilleroJugador1.setId("text-field");
        this.casilleroJugador1.getStylesheets().add("text-field.css");
        this.casilleroJugador1.setMaxWidth(300);
        this.casilleroJugador1.setTranslateY(-100);
        this.casilleroJugador1.setTranslateX(-500);
        
        this.casilleroJugador2 = new TextField();
        this.casilleroJugador2.setId("text-field");
        this.casilleroJugador2.getStylesheets().add("text-field.css");
        this.casilleroJugador2.setMaxWidth(300);
        this.casilleroJugador2.setTranslateY(100);
        this.casilleroJugador2.setTranslateX(-500);

        this.pane.getChildren().add(this.casilleroJugador1);
        this.pane.getChildren().add(this.casilleroJugador2);
        
        //Botones para confirmar nombres
        this.confirmacionJugador1 = new Button();
        this.confirmacionJugador1.setId("boton-juego");;
        this.confirmacionJugador1.setText("Confirmar nombre");
        this.confirmacionJugador1.getStylesheets().add("botones.css");
        this.confirmacionJugador1.setStyle("-fx-font-size: 20px");
        this.pane.getChildren().add(this.confirmacionJugador1);
        this.confirmacionJugador1.setTranslateY(-100);
        this.confirmacionJugador1.setTranslateX(-200);
        this.confirmacionJugador1.setOnAction(new AccionConfirmarJugador(1,this));
                
        this.confirmacionJugador2 = new Button();
        this.confirmacionJugador2.setId("boton-juego");;
        this.confirmacionJugador2.setText("Confirmar nombre");
        this.confirmacionJugador2.getStylesheets().add("botones.css");
        this.confirmacionJugador2.setStyle("-fx-font-size: 20px");
        this.pane.getChildren().add(this.confirmacionJugador2);
        this.confirmacionJugador2.setTranslateY(100);
        this.confirmacionJugador2.setTranslateX(-200);
        this.confirmacionJugador2.setOnAction(new AccionConfirmarJugador(2,this));        
        
        //Imagenes de bando de cada jugador
        this.logoAutobots = new Image("logoAutobots.png");
        ImageView viewLogoAutobots = new ImageView();
        viewLogoAutobots.setImage(logoAutobots);
        viewLogoAutobots.setFitWidth(100);
        viewLogoAutobots.setPreserveRatio(true);
        viewLogoAutobots.setSmooth(true);
        viewLogoAutobots.setCache(true);
        this.pane.getChildren().add(viewLogoAutobots);
        viewLogoAutobots.setTranslateY(-100);
        viewLogoAutobots.setTranslateX(0);
        
        this.logoDecepticons = new Image("logoDecepticons.png");
        ImageView viewLogoDecepticons = new ImageView();
        viewLogoDecepticons.setImage(logoDecepticons);
        viewLogoDecepticons.setFitWidth(100);
        viewLogoDecepticons.setPreserveRatio(true);
        viewLogoDecepticons.setSmooth(true);
        viewLogoDecepticons.setCache(true);
        this.pane.getChildren().add(viewLogoDecepticons);
        viewLogoDecepticons.setTranslateY(100);
        viewLogoDecepticons.setTranslateX(0);        
   
    }

    public void confirmarJugador(int jugador) {
        //Perdonen esto, hay que ver como resolverlo mejor
        if (jugador==1){
            this.casilleroJugador1.setEditable(false);
            this.nombreJugador1 = this.casilleroJugador1.getText();
            System.out.println(this.nombreJugador1);
        }
        if (jugador==2){
            this.casilleroJugador2.setEditable(false);
            this.nombreJugador2 = this.casilleroJugador2.getText();
            System.out.println(this.nombreJugador1);
        }
    }
    
    
}
