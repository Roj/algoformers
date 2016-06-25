package algoformers.controlador;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import algoformers.vista.Casilla;
import algoformers.vista.ContenedorJuego;

public class AccionAtacar implements EventHandler<ActionEvent> {
	
	ContenedorJuego contenedorJuego;

    public AccionAtacar(ContenedorJuego contJuego) {
    	this.contenedorJuego = contJuego;
    }

    @Override
    public void handle(ActionEvent event) {
    	Casilla casillaActual = this.contenedorJuego.getCasillaActual();
    	List<Casilla> casillasPosiblesAtaque = this.contenedorJuego.getCasillasPosiblesAtaque(casillaActual);
    	
    	this.contenedorJuego.mostrarCasillas(casillasPosiblesAtaque);
        this.contenedorJuego.crearBotonRealizarAtaque(true);
        this.contenedorJuego.cambiarEstadoCasilla(new AccionMarcarAtaque(this.contenedorJuego));
        this.contenedorJuego.crearBotonPasarTurno(true);
        this.contenedorJuego.crearBotonMover(true);
        this.contenedorJuego.crearBotonCambiarModo(true);
        this.contenedorJuego.crearBotonCombinarAlgos(true);
        
        this.contenedorJuego.resetearScroll();
    }
}

