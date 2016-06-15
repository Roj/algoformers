package algoformers.vista;


import algoformers.controlador.AccionComenzarJuego;
import algoformers.controlador.AccionConfirmarJugador;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matias
 */
public class ContenedorCargaDeDatos extends Contenedor {

    Stage stage;
    Button comenzarJuego;
    TextField casilleroJugador1;
    TextField casilleroJugador2;
    String nombreJugador1;
    String nombreJugador2;
    private Button confirmacionJugador1;
    private Button confirmacionJugador2;
    private Image logoAutobots;
    private Image logoDecepticons;
    
    public ContenedorCargaDeDatos(Stage stage) {
        
        super();
        
        this.stage = stage;
        
        //Setea el background con imagen de personajes
        this.setId("background-personajes");
        this.getStylesheets().add("background-personajes.css");
        
        //Boton para comenzar el juego
        this.comenzarJuego = new Button();
        this.colocarBoton(comenzarJuego, "Comenzar Juego", 30, 450, -300);
        this.comenzarJuego.setOnAction(new AccionComenzarJuego(stage));

        //Casilleros para completar nombre de jugador
        this.casilleroJugador1 = new TextField();
        this.colocarCasillero(casilleroJugador1,300,-500,-100);
        this.casilleroJugador2 = new TextField();
        this.colocarCasillero(casilleroJugador2,300,-500,100);
        
        //Botones para confirmar nombres
        this.confirmacionJugador1 = new Button();
        this.colocarBoton(this.confirmacionJugador1,"Confirmar nombre",20,-200,-100);
        this.confirmacionJugador1.setOnAction(new AccionConfirmarJugador(1,this));
                
        this.confirmacionJugador2 = new Button();
        this.colocarBoton(this.confirmacionJugador2,"Confirmar nombre", 20,-200,100);
        this.confirmacionJugador2.setOnAction(new AccionConfirmarJugador(2,this));

        //Imagenes de bando de cada jugador
        this.colocarImagen(this.logoAutobots, "logoAutobots.png",0,-100);
        this.colocarImagen(this.logoDecepticons,"logoDecepticons.png",0,100);
        
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