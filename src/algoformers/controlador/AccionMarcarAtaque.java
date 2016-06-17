package algoformers.controlador;

import java.util.List;

import algoformers.modelo.juego.Juego;
import algoformers.vista.Casilla;
import algoformers.vista.ContenedorJuego;

public class AccionMarcarAtaque extends AccionCasilla {

	ContenedorJuego contenedorJuego;
	
    public AccionMarcarAtaque(ContenedorJuego contJuego) {
    	this.contenedorJuego = contJuego;
    }

    public void accion(Casilla casilla) {
    	
    }

}
