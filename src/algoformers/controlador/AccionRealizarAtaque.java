package algoformers.controlador;

import algoformers.modelo.algoformer.Algoformer;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import algoformers.modelo.juego.Juego;
import algoformers.modelo.tablero.Posicion;
import algoformers.modelo.tablero.Ubicable;
import algoformers.modelo.tablero.Vacio;
import algoformers.vista.Casilla;
import algoformers.vista.ContenedorJuego;

public class AccionRealizarAtaque implements EventHandler<ActionEvent> {

	ContenedorJuego contenedorJuego;
	Juego juego;
    
    public AccionRealizarAtaque(ContenedorJuego contJuego, Juego juego) {
        this.contenedorJuego = contJuego;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent event) {

        Casilla casillaActual = this.contenedorJuego.getCasillaActual();
    	List<Casilla> casillasPosiblesAtaque = this.contenedorJuego.getCasillasPosiblesAtaque(casillaActual);
        Algoformer algoformerActual = this.contenedorJuego.getAlgoformerActual();
        if (casillasPosiblesAtaque.contains(casillaActual)){
            Algoformer algoformerEnemigo = (Algoformer) casillaActual.getUbicable();
            Posicion posicionAlgoformerEnemigo = algoformerEnemigo.obtenerPosicion();
            this.juego.obtenerJugadorActual().atacarPosicion(algoformerActual, posicionAlgoformerEnemigo);
            if(!algoformerEnemigo.esta_vivo()){
    		casillaActual.getStyleClass().remove(algoformerEnemigo.getStyle());
    		Ubicable vacio = new Vacio();
    		casillaActual.setUbicable(vacio);
            }
        }
        
        this.contenedorJuego.pasarTurno();
        this.contenedorJuego.cambiarEstadoCasilla(new AccionMarcarCasilla(this.contenedorJuego, juego));
        
    	this.contenedorJuego.dejarDeMostrarCasillas(casillasPosiblesAtaque);

    }
    
}

