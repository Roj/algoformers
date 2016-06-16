package algoformers.controlador;

import algoformers.vista.Casilla;
import algoformers.vista.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.BlendMode;

public class AccionMover implements EventHandler<ActionEvent> {
	
	ContenedorJuego contenedorJuego;

    public AccionMover(ContenedorJuego contJuego) {
    	this.contenedorJuego = contJuego;
    }

    @Override
    public void handle(ActionEvent event) {
    	this.contenedorJuego.mostrarCasillasAdyascentesPosibles(this.contenedorJuego.getCasillaActual());
        this.contenedorJuego.crearBotonRealizarMovida(true);
        this.contenedorJuego.cambiarEstadoCasilla();
        this.contenedorJuego.crearBotonPasarTurno(true);
    }
}
