package algoformers.controlador;

import java.util.List;

import algoformers.modelo.Juego;
import algoformers.vista.Casilla;
import algoformers.vista.ContenedorJuego;

public class AccionMarcarAtaque extends AccionCasilla {

	Juego juego;
	ContenedorJuego contenedorJuego;
	
    public AccionMarcarAtaque(ContenedorJuego contJuego, Juego juego) {
    	this.juego = juego;
    	this.contenedorJuego = contJuego;
    }

    public void accion(Casilla casilla) {
    	
    }

}
