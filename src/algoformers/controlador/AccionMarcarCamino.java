package algoformers.controlador;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.BlendMode;
import algoformers.modelo.Algoformer;
import algoformers.modelo.Juego;
import algoformers.modelo.Ubicable;
import algoformers.modelo.Vacio;
import algoformers.vista.Casilla;
import algoformers.vista.ContenedorJuego;

public class AccionMarcarCamino extends AccionCasilla {

	ContenedorJuego contenedorJuego;
	
    public AccionMarcarCamino(ContenedorJuego contJuego) {
    	this.contenedorJuego = contJuego;
    }

    public void accion(Casilla casilla) {
    	// Obtengo los casilleros adyascentes al casillero actual
    	Casilla casillaActual = this.contenedorJuego.getCasillaActual();
    	List<Casilla> adyascentes = this.contenedorJuego.getCasillerosPosiblesMovimiento(casillaActual);
    	
    	if (adyascentes.contains(casilla)) {
    		this.contenedorJuego.setCasillaActual(casilla);    		
    		this.contenedorJuego.agregarCasillaACamino(casilla);
    		this.contenedorJuego.dejarDeMostrarCasillasAdyascentes(casillaActual);
    		this.contenedorJuego.mostrarCasillasAdyascentesPosibles(casilla);
    		// Cuando al menos alguien me marca un camino, tengo que habilitar el boton
    		this.contenedorJuego.crearBotonRealizarMovida(false);
    	}
    }
}
