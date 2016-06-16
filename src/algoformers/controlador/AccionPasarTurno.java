package algoformers.controlador;

import algoformers.modelo.Juego;
import algoformers.vista.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AccionPasarTurno implements EventHandler<ActionEvent> {
	
	ContenedorJuego contenedorJuego;
	
    public AccionPasarTurno(ContenedorJuego contJuego) {
    	this.contenedorJuego = contJuego;
    }

    @Override
    public void handle(ActionEvent event) {   
    	this.contenedorJuego.pasarTurno();
    }

}
