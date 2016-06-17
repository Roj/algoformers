package algoformers.controlador;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import algoformers.modelo.juego.Juego;
import algoformers.vista.Casilla;
import algoformers.vista.ContenedorJuego;

public class AccionRealizarMovida implements EventHandler<ActionEvent> {

	ContenedorJuego contenedorJuego;
	Juego juego;
    
    public AccionRealizarMovida(ContenedorJuego contJuego, Juego juego) {
        this.contenedorJuego = contJuego;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent event) {
    	/* Todo lo de mover al algoformer
    	
    	
    	
    	*/
    	Casilla casillaActual = this.contenedorJuego.getCasillaActual();
    	List<Casilla> casillasPosiblesMovimiento = this.contenedorJuego.getCasillasPosiblesMovimiento(casillaActual);
    	
        this.contenedorJuego.pasarTurno();
        //this.contenedorJuego.cambiarEstadoCasilla();
        this.contenedorJuego.cambiarEstadoCasilla(new AccionMarcarCasilla(this.contenedorJuego, juego));
        
    	this.contenedorJuego.dejarDeMostrarCasillas(casillasPosiblesMovimiento);
    	
    	for ( Casilla casilla : this.contenedorJuego.getCaminoMarcado()) {
    		casilla.setBlendMode(null);
    	}
    	
    	this.contenedorJuego.borrarCaminoMarcado();  
    }
    
}

