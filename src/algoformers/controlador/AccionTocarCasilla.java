package algoformers.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.juego.Juego;
import algoformers.modelo.Ubicable;
import algoformers.modelo.Vacio;
import algoformers.vista.Casilla;
import algoformers.vista.ContenedorJuego;

public class AccionTocarCasilla implements EventHandler<ActionEvent> {
	
	int x;
	int y;
	Casilla casilla;
	Juego juego;
	ContenedorJuego contenedorJuego;
	
    public AccionTocarCasilla(ContenedorJuego contJuego, Casilla cas, Juego juego, int X, int Y) {
    	this.casilla = cas;
    	this.juego = juego;
    	this.contenedorJuego = contJuego;
    }

    @Override
    public void handle(ActionEvent event) {
    	this.contenedorJuego.getEstadoCasilla().accion(this.casilla);
    }

}
