package algoformers.controlador;

import algoformers.modelo.juego.Juego;
import algoformers.vista.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AccionPasarTurno implements EventHandler<ActionEvent> {
	
	ContenedorJuego contenedorJuego;
	Juego juego;
	
    public AccionPasarTurno(ContenedorJuego contJuego, Juego juego) {
    	this.contenedorJuego = contJuego;
    	this.juego = juego;
    }

    @Override
    public void handle(ActionEvent event) {   
    	this.juego.obtenerJugadorActual().pasarTurno();
    	this.contenedorJuego.pasarTurno();
    }

}
