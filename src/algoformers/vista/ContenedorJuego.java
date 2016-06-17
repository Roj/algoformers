package algoformers.vista;

import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.Juego;
import algoformers.modelo.Jugador;
import algoformers.modelo.algoformer.ModoAlgoformer;
import algoformers.modelo.NoSuperponibleException;
import algoformers.modelo.Posicion;
import algoformers.modelo.Tablero;
import algoformers.modelo.superficie.Tierra;
import algoformers.modelo.Ubicable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import algoformers.controlador.AccionAtacar;
import algoformers.controlador.AccionCasilla;
import algoformers.controlador.AccionMarcarCamino;
import algoformers.controlador.AccionMarcarCasilla;
import algoformers.controlador.AccionMover;
import algoformers.controlador.AccionPasarTurno;
import algoformers.controlador.AccionRealizarAtaque;
import algoformers.controlador.AccionRealizarMovida;
import algoformers.controlador.AccionTocarCasilla;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ContenedorJuego extends Contenedor {
	
    Stage stage;
    ScrollPane scroll;   
    GridPane grilla;
    Button botonMover;
    Button botonPasarTurno;
    Button botonAtacar;
    Button botonRealizarAtaque;
    Button botonRealizarMovida;
    Juego juego;
    Label etiquetaTurnoActual;
    Label etiquetaEstadisticasAlgoformer;
    Casilla casillaActual;
    List<Casilla> caminoMarcado = new ArrayList<Casilla>();
    AccionCasilla estadoCasilla;
    //AccionCasilla otroEstadoCasilla;
    Algoformer algoformerActual;
            
    int dimX = 16;
    int dimY = 16;
    
    private Casilla[][] casillas;
    
    public ContenedorJuego(Stage stage, Juego juego) {
        
        super();
        
        casillas = new Casilla[dimX][dimY];
                
        this.juego = juego;
        
        this.estadoCasilla = new AccionMarcarCasilla(this, juego);
        //this.otroEstadoCasilla = new AccionMarcarCamino(this, juego);
                
        // Fondo temporal para el juego
        this.setId("background-personajes");
        this.getStylesheets().add("backgrounds.css");
        
        this.stage = stage;                   
        
        this.grilla = new GridPane();
        
        this.crearScroll();
        this.crearBotonPasarTurno(false);
		this.crearBotonMover(true);
		this.crearBotonAtacar(true);
        this.crearEtiquetaJugadorActual();
        this.crearTablero();        

        //this.getChildren().add(this.grilla);
    }
    private void crearScroll() {
        this.scroll = new ScrollPane();
        //this.scroll.setVmax();
        this.scroll.setPrefSize(100, 100);
        this.scroll.setContent(this.grilla);
        this.getChildren().add(this.scroll);
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
                		
                        //casilla.setPosicion(-400 + i*60, -380 + j*50);
                		casilla.setTamanio(120, 100);
                		casilla.setSuperficie(pos.obtenerSuperficie());
                		casilla.setUbicable(tablero.obtenerUbicable(pos));
                		casillas[i][j] = casilla;     
                		
                		casilla.setOnAction(new AccionTocarCasilla(this, casilla, this.juego, i, j));
                		//this.getChildren().add(casilla);
                		this.grilla.add(casilla, i, j);
                		// Necesito hacer esto para el metodo setCasillaActual
                		this.casillaActual = casilla;
        			}
        		}

        	}
        }

    }

    public List<Casilla> getCasillasAdyascentes(Casilla casilla) {
    	List<Casilla> adyascentes = new ArrayList<Casilla>();
    	
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
    		
    		if (vecinoX >= 0 && vecinoX < dimX && vecinoY >= 0 && vecinoY < dimY) {
    				adyascentes.add(casillas[vecinoX][vecinoY]);  	
    		}
    	}
    	
    	return adyascentes;
    }
    
    public List<Casilla> getCasillasPosiblesMovimiento(Casilla casilla) {
    	List<Casilla> adyascentes = getCasillasAdyascentes(casilla);
    	
    	for (Iterator<Casilla> iterador = adyascentes.iterator(); iterador.hasNext(); ) {
    		Casilla casillaAdyascente = iterador.next();
    		try {
    			casillaAdyascente.getUbicable().reemplazar(this.algoformerActual);
    			
        		if (caminoMarcado.contains(casillaAdyascente)) {
        			iterador.remove();
        		}    		
        		
    		} catch (NoSuperponibleException e) {
    			iterador.remove();
    		}
    	}
    	
    	return adyascentes;
    }
    
    public List<Casilla> getCasillasPosiblesAtaque(Casilla casilla) {
    	List<Casilla> casillasPosiblesAtaques = new ArrayList<Casilla>();
    	    			    
    	int distanciaAtaque = algoformerActual.obtenerDistanciaAtaque();
    	
    	getAdyascentesAtacables(casilla, distanciaAtaque, casillasPosiblesAtaques);
    	//getAdyascentesAtacables(casilla, distanciaAtaque, casillasPosiblesAtaques, casilla);
    	
    	return casillasPosiblesAtaques;
    }
    private void getAdyascentesAtacables(Casilla casilla, int distanciaAtaque, List<Casilla> casillasPosiblesAtaques) {
    	if (distanciaAtaque == 0)
    		return;
    	
    	List<Casilla> adyascentes = getCasillasAdyascentes(casilla);
    	List<Algoformer> algoformersEnemigos = this.juego.obtenerJugadorEnEspera().obtenerListaAlgoformers();
    	  	
    	for (Casilla adyascente : adyascentes) {
    			if (algoformersEnemigos.contains(adyascente.getUbicable())) {
    				casillasPosiblesAtaques.add(adyascente);
    			}
    			// Aca deberia incluir los bonus al igual que los algoformers
    			getAdyascentesAtacables(adyascente, distanciaAtaque - 1, casillasPosiblesAtaques);		
    	}
    }    
    /*private void getAdyascentesAtacables(Casilla casilla, int distanciaAtaque, List<Casilla> casillasPosiblesAtaques, Casilla excluir) {
    	if (distanciaAtaque == 0)
    		return;
    	
    	List<Casilla> adyascentes = getCasillasAdyascentes(casilla);
    	
    	for (Casilla adyascente : adyascentes) {
			if (adyascente != excluir) {
				casillasPosiblesAtaques.add(adyascente);
				getAdyascentesAtacables(adyascente, distanciaAtaque - 1, casillasPosiblesAtaques, excluir);
			}    		
    	}
    }*/
    
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
    
    public void crearBotonAtacar(boolean desactivado) {
    	// Boton para empezar a armar un camino
    	this.getChildren().remove(botonAtacar);
    	this.getChildren().remove(botonRealizarAtaque);
		this.botonAtacar = new Button();
		this.colocarBoton(botonAtacar, "Atacar", 20, -630, -320);
		this.botonAtacar.setPrefSize(170, 50);
		this.botonAtacar.setOnAction(new AccionAtacar(this));
        this.botonAtacar.setDisable(desactivado);   	
    }
    public void crearBotonRealizarAtaque(boolean desactivado) {
    	// Boton para empezar a armar un camino
    	this.getChildren().remove(botonAtacar);
    	this.getChildren().remove(botonRealizarAtaque);
		this.botonRealizarAtaque = new Button();
		this.colocarBoton(botonRealizarAtaque, "Realizar Ataque", 20, -630, -320);
		this.botonRealizarAtaque.setPrefSize(170, 50);
		this.botonRealizarAtaque.setOnAction(new AccionRealizarAtaque(this, this.juego));
        this.botonRealizarAtaque.setDisable(desactivado);   	
    }
    public void crearBotonMover(boolean desactivado) {
    	// Boton para empezar a armar un camino
    	this.getChildren().remove(botonRealizarMovida);
    	this.getChildren().remove(botonMover);
		this.botonMover = new Button();
		this.colocarBoton(botonMover, "Mover", 20, -630, -270);
		this.botonMover.setPrefSize(170, 50);
		this.botonMover.setOnAction(new AccionMover(this));
        this.botonMover.setDisable(desactivado);   	
    }
    
    public void crearBotonRealizarMovida(boolean desactivado) {
    	// Boton para mover al algoformer
    	this.getChildren().remove(botonRealizarMovida);
    	this.getChildren().remove(botonMover);
		this.botonRealizarMovida = new Button();
		this.colocarBoton(botonRealizarMovida, "Realizar Movida", 20, -630, -270);
		this.botonRealizarMovida.setPrefSize(170, 50);
		this.botonRealizarMovida.setOnAction(new AccionRealizarMovida(this, this.juego));
        this.botonRealizarMovida.setDisable(desactivado);   	
    }
    
    public void crearBotonPasarTurno(boolean desactivado) {
        // Boton para pasar turno
    	this.getChildren().remove(botonPasarTurno);
		this.botonPasarTurno = new Button();
		this.colocarBoton(botonPasarTurno, "Pasar Turno", 20, -630, -220);
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
    /*public void cambiarEstadoCasilla() {
        AccionCasilla aux = this.estadoCasilla;
        
        this.estadoCasilla = this.otroEstadoCasilla;
        this.otroEstadoCasilla = aux;
    }*/
    public void cambiarEstadoCasilla(AccionCasilla accion) {        
        this.estadoCasilla = accion;
    }    
    public void mostrarCasillas(List<Casilla> casillas) {
    	for ( Casilla cas : casillas) {
        	cas.setBlendMode(BlendMode.GREEN);
        }
    }
    public void dejarDeMostrarCasillas(List<Casilla> casillas) {
    	for ( Casilla cas : casillas) {
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
    	this.crearBotonAtacar(true);
    }
}
