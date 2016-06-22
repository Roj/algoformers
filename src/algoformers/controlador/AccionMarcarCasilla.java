package algoformers.controlador;

import java.util.List;

import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.juego.Juego;
import algoformers.modelo.tablero.Tablero;
import algoformers.modelo.tablero.Ubicable;
import algoformers.modelo.tablero.Vacio;
import algoformers.vista.Casilla;
import algoformers.vista.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.BlendMode;

public class AccionMarcarCasilla extends AccionCasilla {
	
	Juego juego;
	ContenedorJuego contenedorJuego;
	
	public AccionMarcarCasilla(ContenedorJuego contJuego, Juego juego) {
		this.contenedorJuego = contJuego;
		this.juego = juego;
	}
    @Override
    public void accion(Casilla casilla) {
    	Ubicable ubicable = casilla.getUbicable();
              
    	// Descomentar esto cuando existan algoformers en el tablero, comentado para testeo
        this.contenedorJuego.crearBotonMover(true);
        this.contenedorJuego.crearBotonAtacar(true);
        
    	this.contenedorJuego.borrarEstadisticasAlgoformer();
    	
    	List<Algoformer> algoformersJugadorActual = this.juego.obtenerJugadorActual().obtenerListaAlgoformers();
    	List<Algoformer> algoformersJugadorEnEspera = this.juego.obtenerJugadorEnEspera().obtenerListaAlgoformers();
    	
        for ( Algoformer algoformer : algoformersJugadorEnEspera ) {
        	if (ubicable == algoformer) {
        		this.contenedorJuego.getCasillaActual().setSuperficie();
        		this.contenedorJuego.setCasillaActual(casilla);
        		this.contenedorJuego.crearEstadisticasAlgoformer(algoformer);
        	}
        }         
        
        for ( Algoformer algoformer : algoformersJugadorActual ) {
        	if (ubicable == algoformer) {
        		this.contenedorJuego.crearBotonMover(false);
                        this.contenedorJuego.crearBotonCambiarModo(false);
        		this.contenedorJuego.getCasillaActual().setSuperficie();
        		this.contenedorJuego.setCasillaActual(casilla);
        		this.contenedorJuego.crearEstadisticasAlgoformer(algoformer);       		
        		this.contenedorJuego.setAlgoformerActual(algoformer);
        		
        		// Habilito el boton de atacar solo si hay un enemigo cerca para atacar
        		List<Casilla> casillasPosiblesAtaque = this.contenedorJuego.getCasillasPosiblesAtaque(casilla);
        		
        		if (!casillasPosiblesAtaque.isEmpty()) {
        			this.contenedorJuego.crearBotonAtacar(false);
        		}
        	}
        }
        
        //Esto es para testear unicamente
        /*if (ubicable instanceof Vacio) {
        	this.contenedorJuego.crearBotonMover(false);
        	this.contenedorJuego.getCasillaActual().setBlendMode(null);
        	this.contenedorJuego.setCasillaActual(casilla);
        }*/
    }

}
