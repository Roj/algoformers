package algoformers.vista;


import algoformers.controlador.AccionSetearTablero;
import algoformers.controlador.AccionComenzarJuego;
import algoformers.controlador.AccionConfirmarJugador;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
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

    String nombreJugador1;
    String nombreJugador2;
    int tamañoTableroX;
    int tamañoTableroY;

    private Stage stage;
    private Button comenzarJuego;
    private TextField casilleroJugador1;
    private TextField casilleroJugador2;    
    private Button confirmacionJugador1;
    private Button confirmacionJugador2;
    private ImageView logoAutobots;
    private ImageView logoDecepticons;
    private Button tableroChico;
    private Button tableroMediano;
    private Button tableroGrande;
    private Label titulo;
    
    public ContenedorCargaDeDatos(Stage stage) {
        
        super();
        
        this.stage = stage;
        
        //Setea el background con imagen de personajes
        this.setId("background-personajes");
        this.getStylesheets().add("backgrounds.css");
        
        //Titulo: Nombre de jugadores
        //Se podria cambiar la tipografia para que quede más copado
        this.titulo = new Label();
        this.titulo.setText("Nombre de jugadores");
        this.titulo.setId("titulo");
        this.titulo.getStylesheets().add("texto.css");
        this.titulo.setTranslateX(-450);
        this.titulo.setTranslateY(-200);
        this.getChildren().add(this.titulo);
        
        //Boton para comenzar el juego
        //Queda hacer que este desactivado mientras no fueron ingresados los nombres
        this.comenzarJuego = new Button();
        this.colocarBoton(comenzarJuego, "Comenzar Juego", 30, 450, -300);
        this.comenzarJuego.setOnAction(new AccionComenzarJuego(this));
//        this.comenzarJuego.setDisable(true);
        
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
        //Alguno podria cambiar esto?
        if (jugador==1){
            this.casilleroJugador1.setEditable(false);
            this.confirmacionJugador1.setDisable(true);
            this.nombreJugador1 = this.casilleroJugador1.getText();
        }
        if (jugador==2){
            this.casilleroJugador2.setEditable(false);
            this.confirmacionJugador2.setDisable(true);
            this.nombreJugador2 = this.casilleroJugador2.getText();
        }
    }
    
    public void seleccionDeMapa(){
        //Elimino botones que no se utilizan
        this.getChildren().removeAll(this.casilleroJugador1,this.casilleroJugador2,this.confirmacionJugador1,this.confirmacionJugador2);
        this.getChildren().remove(this.logoAutobots);
       
        //Setea background con imagen de planeta (Cybertron)
        this.setId("background-planeta");
        
        //Cambia nombre de titulo
        this.titulo.setText("Tamaño tablero");
        
        this.tableroChico = new Button();
        this.colocarBoton(this.tableroChico,"Chico (16x16)",30,-300,0);
        this.tableroChico.setOnAction(new AccionSetearTablero(16,this));
        this.tableroMediano = new Button();
        this.colocarBoton(this.tableroMediano,"Mediano (32x32)",30,0,0);
        this.tableroMediano.setOnAction(new AccionSetearTablero(32,this));
        this.tableroGrande = new Button();
        this.colocarBoton(this.tableroGrande,"Grande (64x64)",30,300,0);
        this.tableroGrande.setOnAction(new AccionSetearTablero(64,this));

    }

    public void setearDimensionTablero(int dimension) {
        //Consideramos el tablero cuadrado
        this.tamañoTableroX = dimension;
        this.tamañoTableroY = dimension;
    }
}