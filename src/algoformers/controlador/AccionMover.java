package algoformers.controlador;

import java.util.List;

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
    	Casilla casillaActual = this.contenedorJuego.getCasillaActual();
    	List<Casilla> casillasPosiblesMovimiento = this.contenedorJuego.getCasillasPosiblesMovimiento(casillaActual);
    	
    	this.contenedorJuego.mostrarCasillas(casillasPosiblesMovimiento);
        this.contenedorJuego.crearBotonRealizarMovida(true);
        //this.contenedorJuego.cambiarEstadoCasilla();
        this.contenedorJuego.cambiarEstadoCasilla(new AccionMarcarCamino(this.contenedorJuego));
        this.contenedorJuego.crearBotonPasarTurno(true);
        this.contenedorJuego.crearBotonAtacar(true);
    }
}
