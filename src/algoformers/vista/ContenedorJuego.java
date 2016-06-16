package algoformers.vista;

import algoformers.modelo.Algoformer;
import algoformers.modelo.Juego;
import algoformers.modelo.Jugador;
import algoformers.modelo.ModoAlgoformer;
import algoformers.modelo.NoSuperponibleException;
import algoformers.modelo.Posicion;
import algoformers.modelo.Tablero;
import algoformers.modelo.Tierra;
import algoformers.modelo.Ubicable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import algoformers.controlador.AccionCasilla;
import algoformers.controlador.AccionMarcarCamino;
import algoformers.controlador.AccionMarcarCasilla;
import algoformers.controlador.AccionMover;
import algoformers.controlador.AccionPasarTurno;
import algoformers.controlador.AccionRealizarMovida;
import algoformers.controlador.AccionTocarCasilla;

import java.util.ArrayList;
import java.util.List;


public class ContenedorJuego extends Contenedor {
	
    Stage stage;
    Button botonMover;
    Button botonPasarTurno;
    Button botonRealizarMovida;
    Juego juego;
    Label etiquetaTurnoActual;
    Label etiquetaEstadisticasAlgoformer;
    Casilla casillaActual;
    List<Casilla> caminoMarcado = new ArrayList<Casilla>();
    AccionCasilla estadoCasilla;
    AccionCasilla otroEstadoCasilla;
    Algoformer algoformerActual;
            
    int dimX = 16;
    int dimY = 16;
    
    private Casilla[][] casillas;
    
    public ContenedorJuego(Stage stage, Juego juego) {
        
        super();
        
        casillas = new Casilla[dimX][dimY];
                
        this.juego = juego;
        
        this.estadoCasilla = new AccionMarcarCasilla(this, juego);
        this.otroEstadoCasilla = new AccionMarcarCamino(this, juego);
        
        // Fondo temporal para el juego
        this.setId("background-personajes");
        this.getStylesheets().add("backgrounds.css");
        
        this.stage = stage;                   
        
        this.crearBotonPasarTurno(false);
		this.crearBotonMover(true);
        this.crearEtiquetaJugadorActual();
        this.crearTablero();        
    }
    
    private void crearTablero() {    
    	// Por ahora crea un tablero de tierra unicamente
    	Tablero tablero = this.juego.obtenerTablero();
    	List<Posicion> posiciones = tablero.obtenerListaDePosiciones();
    	
        for (int i = 0; i < dimX; i++) {
        	for (int j = 0; j < dimY; j++) {       		
        		
        		for (Posicion pos : posiciones) {
        			if (pos.obtenerX() == i && pos.obtenerY() == j && pos.obtenerSuperficie() instanceof Tierra) {
                		Casilla casilla = new Casilla(i, j);
                		
                                casilla.setPosicion(-400 + i*60, -380 + j*50);
                		casilla.setTamanio(60, 50);
                		casilla.setSuperficie(pos.obtenerSuperficie());
                		casilla.setUbicable(tablero.obtenerUbicable(pos));
                		casillas[i][j] = casilla;     
                		
                		casilla.setOnAction(new AccionTocarCasilla(this, casilla, this.juego, i, j));
                		this.getChildren().add(casilla);
                		
                		// Necesito hacer esto para el metodo setCasillaActual
                		this.casillaActual = casilla;
        			}
        		}

        	}
        }

    }

    public ArrayList<Casilla> obtenerCasillerosAdyascentesPosibles(Casilla casilla) {
    	ArrayList<Casilla> adyascentes = new ArrayList<Casilla>();
    	
    	int[] puntosVecinos = new int[] { 
    			-1, 0,
    			1, 0,
    			0, -1,
    			0, 1
    	};
    	
    	for (int i = 0; i < puntosVecinos.length; i++) {
    		int diferenciaX = puntosVecinos[i];
    		int diferenciaY = puntosVecinos[++i];
    		
    		int vecinoX = casilla.getX() + diferenciaX;
    		int vecinoY = casilla.getY() + diferenciaY;
    		
    		if (vecinoX >= 0 && vecinoX < dimX && vecinoY >= 0 && vecinoY < dimY
    			&& !caminoMarcado.contains(casillas[vecinoX][vecinoY])) {
    			try {
    				casillas[vecinoX][vecinoY].getUbicable().reemplazar(this.algoformerActual);
    				adyascentes.add(casillas[vecinoX][vecinoY]);  	
    			} catch (NoSuperponibleException e) {}
    		}
    	}
    	
    	return adyascentes;
    }
    
    public void crearEtiquetaJugadorActual() {
        // Etiqueta que muestra jugador actual
    	this.getChildren().remove(etiquetaTurnoActual);
        etiquetaTurnoActual = new Label();
        etiquetaTurnoActual.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));

        etiquetaTurnoActual.setText("Turno actual: " + juego.obtenerJugadorActual().obtenerNombre());
        etiquetaTurnoActual.setTextFill(Color.web("#FFFFFF"));        
        this.getChildren().add(etiquetaTurnoActual);
        etiquetaTurnoActual.setTranslateX(-620);
        etiquetaTurnoActual.setTranslateY(-380);            	
    }
    
    public void crearBotonMover(boolean desactivado) {
    	// Boton para empezar a armar un camino
    	this.getChildren().remove(botonRealizarMovida);
    	this.getChildren().remove(botonMover);
		this.botonMover = new Button();
		this.colocarBoton(botonMover, "Mover", 20, -630, -320);
		this.botonMover.setPrefSize(170, 50);
		this.botonMover.setOnAction(new AccionMover(this));
        this.botonMover.setDisable(desactivado);   	
    }
    
    public void crearBotonRealizarMovida(boolean desactivado) {
    	// Boton para mover al algoformer
    	this.getChildren().remove(botonRealizarMovida);
    	this.getChildren().remove(botonMover);
		this.botonRealizarMovida = new Button();
		this.colocarBoton(botonRealizarMovida, "Realizar Movida", 20, -630, -320);
		this.botonRealizarMovida.setPrefSize(170, 50);
		this.botonRealizarMovida.setOnAction(new AccionRealizarMovida(this));
        this.botonRealizarMovida.setDisable(desactivado);   	
    }
    
    public void crearBotonPasarTurno(boolean desactivado) {
        // Boton para pasar turno
    	this.getChildren().remove(botonPasarTurno);
		this.botonPasarTurno = new Button();
		this.colocarBoton(botonPasarTurno, "Pasar Turno", 20, -630, -270);
		this.botonPasarTurno.setPrefSize(170, 50);
		this.botonPasarTurno.setOnAction(new AccionPasarTurno(this));    
		this.botonPasarTurno.setDisable(desactivado); 
    }
    
    public void crearEstadisticasAlgoformer(Algoformer algoformer) {
    	etiquetaEstadisticasAlgoformer = new Label();
    	etiquetaEstadisticasAlgoformer.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));

    	etiquetaEstadisticasAlgoformer.setText(
        		"Vida: " + String.valueOf(algoformer.obtenerVida()) + "\n" +
        		"Ataque: " + String.valueOf(algoformer.obtenerPuntosAtaque()) + "\n" +
        		"Velocidad: " + String.valueOf(algoformer.obtenerVelocidad()) + "\n" +
        		"Dist. Ataque: " + String.valueOf(algoformer.obtenerDistanciaAtaque()) + "\n"
        );
    	etiquetaEstadisticasAlgoformer.setTextFill(Color.web("#F8FF15"));        
        this.getChildren().add(etiquetaEstadisticasAlgoformer);
        etiquetaEstadisticasAlgoformer.setTranslateX(-620);
        etiquetaEstadisticasAlgoformer.setTranslateY(0);      	
    }
    public void borrarEstadisticasAlgoformer() {
    	this.getChildren().remove(etiquetaEstadisticasAlgoformer);
    }
    public void setCasillaActual(Casilla casilla) {    	
    	this.casillaActual = casilla;
    	this.casillaActual.setBlendMode(BlendMode.LIGHTEN);
    }
    
    public Casilla getCasillaActual() {
    	return this.casillaActual;
    }    
    public void setAlgoformerActual(Algoformer alg) {
    	this.algoformerActual = alg;
    }
    public Algoformer getAlgoformerActual() {
    	return this.algoformerActual;
    }
    public void agregarCasillaACamino(Casilla casilla) {
    	caminoMarcado.add(casilla);
    	casilla.setBlendMode(BlendMode.DIFFERENCE);
    }
    
    public AccionCasilla getEstadoCasilla() {
    	return this.estadoCasilla;
    }
    public void cambiarEstadoCasilla() {
        AccionCasilla aux = this.estadoCasilla;
        
        this.estadoCasilla = this.otroEstadoCasilla;
        this.otroEstadoCasilla = aux;
    }
    public void mostrarCasillasAdyascentes(Casilla casilla) {
    	for ( Casilla cas : this.obtenerCasillerosAdyascentesPosibles(casilla)) {
        	cas.setBlendMode(BlendMode.GREEN);
        }
    }
    public void dejarDeMostrarCasillasAdyascentes(Casilla casilla) {
    	for ( Casilla cas : this.obtenerCasillerosAdyascentesPosibles(casilla)) {
        	cas.setBlendMode(null);
        }
    }    
    public List<Casilla> getCaminoMarcado() {
    	return this.caminoMarcado;
    }
    public void borrarCaminoMarcado() {
    	this.caminoMarcado.clear();
    }   
    public void pasarTurno() {
    	this.juego.avanzarTurno();    	
    	this.crearEtiquetaJugadorActual(); 
    	
    	this.crearBotonPasarTurno(false);
    	this.crearBotonMover(true);
    }
}
