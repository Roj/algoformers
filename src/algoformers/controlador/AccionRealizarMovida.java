package algoformers.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import algoformers.modelo.Juego;
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
        this.contenedorJuego.pasarTurno();
        //this.contenedorJuego.cambiarEstadoCasilla();
        this.contenedorJuego.cambiarEstadoCasilla(new AccionMarcarCasilla(this.contenedorJuego, juego));
        
    	this.contenedorJuego.dejarDeMostrarCasillasAdyascentes(this.contenedorJuego.getCasillaActual());
    	
    	for ( Casilla casilla : this.contenedorJuego.getCaminoMarcado()) {
    		casilla.setBlendMode(null);
    	}
    	
    	this.contenedorJuego.borrarCaminoMarcado();  
    }
    
}

