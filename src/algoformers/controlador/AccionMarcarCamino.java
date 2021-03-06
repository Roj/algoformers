package algoformers.controlador;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.BlendMode;
import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.juego.Juego;
import algoformers.modelo.tablero.Ubicable;
import algoformers.modelo.tablero.Vacio;
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
    	List<Casilla> adyacentes = this.contenedorJuego.getCasillasPosiblesMovimiento(casillaActual);
        
    	if (adyacentes.contains(casilla)) {
    		this.contenedorJuego.setCasillaActual(casilla);    		
    		
    		List<Casilla> nuevosAdyascentes = this.contenedorJuego.getCasillasPosiblesMovimiento(casilla);
    		
    		this.contenedorJuego.dejarDeMostrarCasillas(adyacentes);
    		this.contenedorJuego.agregarCasillaACamino(casilla);
    		this.contenedorJuego.mostrarCasillas(nuevosAdyascentes);
    		// Cuando al menos alguien me marca un camino, tengo que habilitar el boton
    		this.contenedorJuego.crearBotonRealizarMovida(false);
    	}
    }
}
