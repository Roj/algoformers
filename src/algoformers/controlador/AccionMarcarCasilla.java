package algoformers.controlador;

import algoformers.modelo.Algoformer;
import algoformers.modelo.Juego;
import algoformers.modelo.Tablero;
import algoformers.modelo.Ubicable;
import algoformers.modelo.Vacio;
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
                
        for ( Algoformer algoformer : this.juego.obtenerJugadorActual().obtenerListaAlgoformers() ) {
        	if (ubicable == algoformer) {
        		this.contenedorJuego.crearBotonMover(false);
        		this.contenedorJuego.getCasillaActual().setBlendMode(null);
        		this.contenedorJuego.setCasillaActual(casilla);
        		return;
        	}
        }
        
        // Todo lo que no sea eso desactiva el boton de mover
        //this.contenedorJuego.crearBotonMover(true);
        
        //Esto es para testear unicamente
        if (ubicable instanceof Vacio) {
        	this.contenedorJuego.crearBotonMover(false);
        	this.contenedorJuego.getCasillaActual().setBlendMode(null);
        	this.contenedorJuego.setCasillaActual(casilla);
        }
    }

}
