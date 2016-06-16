package algoformers.vista;


import algoformers.controlador.AccionJugar;
import algoformers.controlador.AccionSetearTablero;
import algoformers.controlador.AccionComenzarJuego;
import algoformers.controlador.AccionConfirmarJugador;
import algoformers.modelo.Juego;
import algoformers.modelo.mapa.Mapa;
import algoformers.modelo.mapa.MapaChico;
import static com.sun.javafx.fxml.expression.Expression.and;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
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

    StringBuffer nombreJugador1 = new StringBuffer();
    StringBuffer nombreJugador2 = new StringBuffer();
    //Por default el tamaño de tablero es el mediano de 32x32
    Mapa mapa = new MapaChico();
    Juego juego;
    
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
    private Label indicadorDimensionTablero;
    private BooleanBinding jugadoresConfirmados;
    
    public ContenedorCargaDeDatos(Stage stage) {
        
        super();
        
        this.stage = stage;
        
        //Setea el background con imagen de personajes
        this.setId("background-personajes");
        this.getStylesheets().add("backgrounds.css");
        
        //Titulo: "Nombre de jugadores"
        //Se podria cambiar la tipografia para que quede más copado
        this.titulo = new Label();
        this.titulo.setText("Nombre de jugadores");
        this.titulo.getStyleClass().add("titulo");
        this.titulo.getStylesheets().add("texto.css");
        this.titulo.setTranslateX(-450);
        this.titulo.setTranslateY(-200);
        this.getChildren().add(this.titulo);
        
        //Boton para comenzar el juego
        //Queda hacer que este desactivado mientras no fueron ingresados los nombres
        this.comenzarJuego = new Button();
        this.colocarBoton(comenzarJuego, "Comenzar Juego", 30, 450, -300);
        this.comenzarJuego.setOnAction(new AccionComenzarJuego(this));
        
        //Casilleros para completar nombre de jugador
        this.casilleroJugador1 = new TextField();
        this.colocarCasillero(casilleroJugador1,300,-500,-100);
        this.casilleroJugador2 = new TextField();
        this.colocarCasillero(casilleroJugador2,300,-500,100);
        
        //Botones para confirmar nombres
        this.confirmacionJugador1 = new Button();
        this.colocarBoton(this.confirmacionJugador1,"Confirmar nombre",20,-200,-100);
        this.confirmacionJugador1.setOnAction(new AccionConfirmarJugador(this.nombreJugador1,this.casilleroJugador1,this.confirmacionJugador1,this));
        
        this.confirmacionJugador2 = new Button();
        this.colocarBoton(this.confirmacionJugador2,"Confirmar nombre", 20,-200,100);
        this.confirmacionJugador2.setOnAction(new AccionConfirmarJugador(this.nombreJugador2,this.casilleroJugador2,this.confirmacionJugador2,this));
        
        
        //Si los dos botones estan desactivas ya se ingresaron los nombres
        this.jugadoresConfirmados = Bindings.or(this.confirmacionJugador1.disableProperty().not(),this.confirmacionJugador2.disableProperty().not());
        this.comenzarJuego.disableProperty().bind(this.jugadoresConfirmados);
        
        //Imagenes de bando de cada jugador
        this.colocarImagen(this.logoAutobots, "logoAutobots.png",0,-100);
        this.colocarImagen(this.logoDecepticons,"logoDecepticons.png",0,100);
        
    }

    public void confirmarJugador(StringBuffer nombre, TextField casillero, Button botonConfirmacion) {
        nombre.append(casillero.getText());
        botonConfirmacion.setDisable(true);
        casillero.setDisable(true);
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
        this.tableroChico.setOnAction(new AccionSetearTablero(new MapaChico(),this));
        this.tableroMediano = new Button();
        this.colocarBoton(this.tableroMediano,"Mediano (32x32)",30,0,0);
        //Cambiar MapaChico por MapaMediano
        this.tableroMediano.setOnAction(new AccionSetearTablero(new MapaChico(),this));
        this.tableroGrande = new Button();
        //Cambiar MapaChico por MapaGrande
        this.colocarBoton(this.tableroGrande,"Grande (64x64)",30,300,0);
        this.tableroGrande.setOnAction(new AccionSetearTablero(new MapaChico(),this));
        
        //Indicador de tablero seleccionado
        this.indicadorDimensionTablero = new Label();
        this.indicadorDimensionTablero.getStyleClass().add("titulo");
        this.indicadorDimensionTablero.getStylesheets().add("texto.css");
        this.indicadorDimensionTablero.setTranslateY(200);
        this.getChildren().add(this.indicadorDimensionTablero);
        this.indicadorDimensionTablero.setText(String.valueOf(mapa.obtenerDimX())+"x"+String.valueOf(mapa.obtenerDimY()));
        
        //Creo juego y escena de juego
        this.juego = new Juego(this.nombreJugador1.toString(),this.nombreJugador2.toString(),this.mapa);
        ContenedorJuego contenedorJuego = new ContenedorJuego(this.stage, this.juego);
        Scene escenaJuego = new Scene(contenedorJuego,640,480);
        
        //Cambio la accion del boton comenzar juego para que inicie el juego
        this.comenzarJuego.setOnAction(new AccionJugar(this.stage,escenaJuego));
    }

    public void setearDimensionTablero(Mapa mapa) {
        //Consideramos el tablero cuadrado
        this.mapa = mapa;
        this.indicadorDimensionTablero.setText(String.valueOf(mapa.obtenerDimX())+"x"+String.valueOf(mapa.obtenerDimY()));
        
    }
}