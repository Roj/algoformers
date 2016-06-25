package algoformers.controlador;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.juego.Juego;
import algoformers.modelo.juego.Jugador;
import algoformers.modelo.tablero.Ubicable;
import algoformers.modelo.tablero.Vacio;
import algoformers.vista.Casilla;
import algoformers.vista.ContenedorJuego;

public class AccionCombinarAlgoformers implements EventHandler<ActionEvent> {
	
	ContenedorJuego contenedorJuego;
	Juego juego;

    public AccionCombinarAlgoformers(ContenedorJuego contJuego, Juego juego) {
    	this.contenedorJuego = contJuego;
    	this.juego = juego;
    }

    @Override
    public void handle(ActionEvent event) {
    	Jugador jugadorActual = this.juego.obtenerJugadorActual();
    	List<Algoformer> combinables = jugadorActual.obtenerListaAlgoformers();
    	Casilla casillaActual = this.contenedorJuego.getCasillaActual();  	
    	List<Casilla> casillasPosiblesCombinar = this.contenedorJuego.getCasillasCombinar(casillaActual);
    	
    	Ubicable supremo = jugadorActual.obtenerSupremo();
    	
    	jugadorActual.combinarAlgoformers(casillaActual.getUbicable().obtenerPosicion(), combinables);
    	
    	for (Casilla cas : casillasPosiblesCombinar) {
    		Algoformer algoCas = (Algoformer) cas.getUbicable();
    		cas.getStyleClass().remove(algoCas.getStyle());
    		Ubicable vacio = new Vacio();
    		cas.setUbicable(vacio);
    	}
    	
    	casillaActual.setUbicable(supremo);
    	
    	this.contenedorJuego.pasarTurno();
    }

}
