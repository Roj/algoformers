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
    	// Obtengo los casilleros a donde se puede atacar desde ell casillero actual
    	Casilla casillaActual = this.contenedorJuego.getCasillaActual();
    	List<Casilla> adyascentes = this.contenedorJuego.getCasillasPosiblesAtaque(casillaActual);
    	
        if (adyascentes.contains(casilla)) {
    		this.contenedorJuego.setCasillaActual(casilla);    		
    		
    		// Cuando al menos alguien marca una casilla, tengo que habilitar el boton
    		this.contenedorJuego.crearBotonRealizarAtaque(false);
    	}
    }

}
