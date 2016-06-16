package algoformers.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import algoformers.modelo.Algoformer;
import algoformers.modelo.Juego;
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
    	//this.contenedorJuego.setCasillaActual(this.casilla);
    	this.contenedorJuego.getEstadoCasilla().accion(this.casilla);
        //Ubicable ubicable = this.casilla.getUbicable();
        // Tengo que ver si es un algoformer de una manera decente
                
        /*for ( Algoformer algoformer : this.juego.obtenerJugadorActual().obtenerListaAlgoformers() ) {
        	if (ubicable == algoformer) {
        		//this.casilla.setBlendMode(Color.ALICEBLUE); // Marcar a la casilla seleccionada
        		this.contenedorJuego.crearBotonMover(false);
        		this.contenedorJuego.setCasillaActual(this.casilla); 
        		return;
        	}
        }*/
        // Todo lo que no sea eso desactiva el boton de mover
        //this.contenedorJuego.crearBotonMover(true);
        
       /* if (ubicable instanceof Vacio) {
        	//this.casilla.setBlendMode(BlendMode.LIGHTEN);
        	this.contenedorJuego.crearBotonMover(false);
        	this.contenedorJuego.setCasillaActual(this.casilla); 
        }*/
    }

}
