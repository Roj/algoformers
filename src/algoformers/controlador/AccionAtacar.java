package algoformers.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import algoformers.vista.ContenedorJuego;

public class AccionAtacar implements EventHandler<ActionEvent> {
	
	ContenedorJuego contenedorJuego;

    public AccionAtacar(ContenedorJuego contJuego) {
    	this.contenedorJuego = contJuego;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}

