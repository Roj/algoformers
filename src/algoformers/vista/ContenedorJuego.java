package algoformers.vista;

import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.juego.Juego;
import algoformers.modelo.juego.Jugador;
import algoformers.modelo.algoformer.ModoAlgoformer;
import algoformers.modelo.juego.NoSuperponibleException;
import algoformers.modelo.tablero.Posicion;
import algoformers.modelo.tablero.Tablero;
import algoformers.modelo.superficie.Tierra;
import algoformers.modelo.tablero.Ubicable;
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
import algoformers.controlador.AccionCambiarModo;
import algoformers.controlador.AccionCasilla;
import algoformers.controlador.AccionMarcarCamino;
import algoformers.controlador.AccionMarcarCasilla;
import algoformers.controlador.AccionMover;
import algoformers.controlador.AccionPasarTurno;
import algoformers.controlador.AccionRealizarAtaque;
import algoformers.controlador.AccionRealizarMovida;
import algoformers.controlador.AccionTocarCasilla;
import algoformers.modelo.superficie.Aire;
import algoformers.modelo.superficie.Superficie;
import algoformers.modelo.superficie.SuperficieNoAtravesableException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;


public class ContenedorJuego extends Contenedor {
	
    Stage stage;
    ScrollPane scroll;   
    GridPane grilla;
    Button botonMover;
    Button botonPasarTurno;
    Button botonAtacar;
    Button botonRealizarAtaque;
    Button botonRealizarMovida;
    Button botonCambiarModo;
    Juego juego;
    Label etiquetaTurnoActual;
    Label etiquetaEstadisticasAlgoformer;
    Casilla casillaActual;
    Casilla casillaInicialMovimiento;
    List<Casilla> caminoMarcado = new ArrayList<Casilla>();
    AccionCasilla estadoCasilla;
    //AccionCasilla otroEstadoCasilla;
    Algoformer algoformerActual;
            
    int dimX = 16;
    int dimY = 16;
    
    private Casilla[][] casillas_tierra;
    private Casilla[][] casillas_aire;
    
    public ContenedorJuego(Stage stage, Juego juego) {
        
        super();
        
        casillas_tierra = new Casilla[dimX][dimY];
        casillas_aire = new Casilla[dimX][dimY];
        
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
        this.crearBotonCambiarModo(true);
        this.crearEtiquetaJugadorActual();
        this.crearTablero();        

        //this.getChildren().add(this.grilla);
    }
    private void crearScroll() {
        this.scroll = new ScrollPane();
        //this.scroll.setVmax();
        this.scroll.setPrefSize(100, 100);
        this.scroll.setMaxSize(1000, 700);
        this.scroll.setContent(this.grilla);
        this.getChildren().add(this.scroll);
    }
    private void crearTablero() {    
    	// Por ahora crea un tablero de tierra unicamente
    	Tablero tablero = this.juego.obtenerTablero();
    	List<Posicion> posiciones = tablero.obtenerListaDePosiciones();
        
        
        this.grilla.setGridLinesVisible(true);
        
        for (Posicion pos : posiciones) {
            Casilla casilla = new Casilla(pos.obtenerX(),pos.obtenerY(),pos.obtenerSuperficie());
            casilla.setTamanio(120, 100);
            casilla.setUbicable(tablero.obtenerUbicable(pos));
            if (pos.obtenerSuperficie() instanceof Aire){
                casillas_aire[pos.obtenerX()][pos.obtenerY()] = casilla;
                this.grilla.add(casilla,pos.obtenerX(),pos.obtenerY());
                //Minimizado
                casilla.setTamanio(60, 50);
                casilla.setTranslateY(-25);
                casilla.getStyleClass().add("Minimizado");
                casilla.toFront();
            }
            else{
                casillas_tierra[pos.obtenerX()][pos.obtenerY()] = casilla;
                this.grilla.add(casilla,pos.obtenerX(),pos.obtenerY());
                //Maximizado
                casilla.getStyleClass().add("Maximizado");
                casilla.toBack();
            }
            casilla.setOnAction(new AccionTocarCasilla(this, casilla, this.juego, pos.obtenerX(), pos.obtenerY()));
            // Necesito hacer esto para el metodo setCasillaActual
            this.casillaActual = casilla;
        }  
    }

    public List<Casilla> getCasillasAdyacentes(Casilla casilla) {
    	List<Casilla> adyacentes = new ArrayList<Casilla>();
    	Casilla[][] casillas = new Casilla[dimX][dimY];
        int coordX = casilla.getX();
        int coordY = casilla.getY();
        
        //Agrego a adyacentes la casilla en misma posicion y otra superficie
        if (casillas_tierra[coordX][coordY] == casilla){
                    casillas = casillas_tierra;
                    adyacentes.add(casillas_aire[coordX][coordY]);
                }
        if (casillas_aire[casilla.getX()][casilla.getY()] == casilla){
                    casillas = casillas_aire;
                    adyacentes.add(casillas_tierra[coordX][coordY]);
        }
        
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
//cambiar
                        adyacentes.add(casillas[vecinoX][vecinoY]);  	
    		}
    	}
    	
    	return adyacentes;
    }
    public List<Casilla> getCasillasPosiblesMovimiento(Casilla casilla) {
    	List<Casilla> adyacentes = getCasillasAdyacentes(casilla);
    	Algoformer algoformerActual = this.getAlgoformerActual();
        
    	for (Iterator<Casilla> iterador = adyacentes.iterator(); iterador.hasNext(); ) {
    		Casilla casillaAdyacente = iterador.next();
    		try {
//    			casillaAdyacente.getUbicable().reemplazar(this.algoformerActual);
                        casillaAdyacente.getUbicable().puedeSerReemplazado();
                        Superficie superficieAdyacente = casillaAdyacente.getSuperficie();
                        algoformerActual.puedeAtravesarSuperficie(superficieAdyacente);
                        
        		if (caminoMarcado.contains(casillaAdyacente)) {
        			iterador.remove();
        		}    		
        		
    		} catch (NoSuperponibleException e) {
    			iterador.remove();
                } catch (SuperficieNoAtravesableException e) {
                        iterador.remove();
                }
    	}
    	
    	return adyacentes;
    }
    
    public List<Casilla> getCasillasPosiblesAtaque(Casilla casilla) {
    	List<Casilla> casillasPosiblesAtaques = new ArrayList<Casilla>();
    	    			    
    	int distanciaAtaque = algoformerActual.obtenerDistanciaAtaque();
    	
    	getAdyacentesAtacables(casilla, distanciaAtaque, casillasPosiblesAtaques);
    	//getAdyacentesAtacables(casilla, distanciaAtaque, casillasPosiblesAtaques, casilla);
    	
    	return casillasPosiblesAtaques;
    }
    private void getAdyacentesAtacables(Casilla casilla, int distanciaAtaque, List<Casilla> casillasPosiblesAtaques) {
    	if (distanciaAtaque == 0)
    		return;
    	
    	List<Casilla> adyacentes = getCasillasAdyacentes(casilla);
    	List<Algoformer> algoformersEnemigos = this.juego.obtenerJugadorEnEspera().obtenerListaAlgoformers();
    	  	
    	for (Casilla adyascente : adyacentes) {
    			if (algoformersEnemigos.contains(adyascente.getUbicable())) {
    				casillasPosiblesAtaques.add(adyascente);
    			}
    			// Aca deberia incluir los bonus al igual que los algoformers
    			getAdyacentesAtacables(adyascente, distanciaAtaque - 1, casillasPosiblesAtaques);		
    	}
    }    
    /*private void getAdyacentesAtacables(Casilla casilla, int distanciaAtaque, List<Casilla> casillasPosiblesAtaques, Casilla excluir) {
    	if (distanciaAtaque == 0)
    		return;
    	
    	List<Casilla> adyacentes = getCasillasAdyacentes(casilla);
    	
    	for (Casilla adyascente : adyacentes) {
			if (adyascente != excluir) {
				casillasPosiblesAtaques.add(adyascente);
				getAdyacentesAtacables(adyascente, distanciaAtaque - 1, casillasPosiblesAtaques, excluir);
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
    
    public void crearBotonCambiarModo(boolean desactivado) {
    	// Boton para mover al algoformer
    	this.getChildren().remove(botonCambiarModo);
		this.botonCambiarModo = new Button();
		this.colocarBoton(botonCambiarModo, "Cambiar Modo", 20, -630, -220);
		this.botonCambiarModo.setPrefSize(170, 50);
		this.botonCambiarModo.setOnAction(new AccionCambiarModo(this, this.juego));
        this.botonCambiarModo.setDisable(desactivado);   	
    }
    
    public void crearBotonPasarTurno(boolean desactivado) {
        // Boton para pasar turno
    	this.getChildren().remove(botonPasarTurno);
		this.botonPasarTurno = new Button();
		this.colocarBoton(botonPasarTurno, "Pasar Turno", 20, -630, -170);
		this.botonPasarTurno.setPrefSize(170, 50);
		this.botonPasarTurno.setOnAction(new AccionPasarTurno(this, this.juego));    
		this.botonPasarTurno.setDisable(desactivado); 
    }
    
    public void crearEstadisticasAlgoformer(Algoformer algoformer) {
    	etiquetaEstadisticasAlgoformer = new Label();
        etiquetaEstadisticasAlgoformer.getStyleClass().add("texto");
        etiquetaEstadisticasAlgoformer.getStylesheets().add("texto.css");
    	etiquetaEstadisticasAlgoformer.setText(
                        "Nombre: " + algoformer.getName() + "\n" +
        		"Vida: " + String.valueOf(algoformer.obtenerVida()) + "\n" +
        		"Ataque: " + String.valueOf(algoformer.obtenerPuntosAtaque()) + "\n" +
        		"Velocidad: " + String.valueOf(algoformer.obtenerVelocidad()) + "\n" +
        		"Dist. Ataque: " + String.valueOf(algoformer.obtenerDistanciaAtaque()) + "\n"
        );
        this.getChildren().add(etiquetaEstadisticasAlgoformer);
        etiquetaEstadisticasAlgoformer.setTranslateX(-620);
        etiquetaEstadisticasAlgoformer.setTranslateY(0);      	
    }
    public void borrarEstadisticasAlgoformer() {
    	this.getChildren().remove(etiquetaEstadisticasAlgoformer);
    }
    public void setCasillaActual(Casilla casilla) {    	
        this.casillaActual.getStyleClass().remove("CasillaActual");
        this.casillaActual = casilla;
        this.casillaActual.getStyleClass().add("CasillaActual");
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
        casilla.getStyleClass().add("CasillaCamino");
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
    	for ( Casilla casilla : casillas) {
            casilla.getStyleClass().add("CasillaMostrar");
        }
    }
    public void dejarDeMostrarCasillas(List<Casilla> casillas) {
    	for ( Casilla casilla : casillas) {
                casilla.getStyleClass().removeAll("CasillaMostrar","CasillaCamino","CasillaActual");
                casilla.setSuperficie();
        }
    }
    public List<Casilla> getCaminoMarcado() {
    	return this.caminoMarcado;
    }
    public void borrarCaminoMarcado() {
    	this.dejarDeMostrarCasillas(this.caminoMarcado);
        this.caminoMarcado.clear();
        
    }   
    public void pasarTurno() {
    	//this.juego.avanzarTurno();    	
    	this.crearEtiquetaJugadorActual(); 
    	
    	//this.casillaActual.setBlendMode(null);
    	this.crearBotonPasarTurno(false);
    	this.crearBotonMover(true);
    	this.crearBotonAtacar(true);
    }
    
    public void setCasillaInicioMovimiento(Casilla cas) {
    	this.casillaInicialMovimiento = cas;
    }
    public Casilla getCasillaInicioMovimiento() {
    	return this.casillaInicialMovimiento;
    }
}
