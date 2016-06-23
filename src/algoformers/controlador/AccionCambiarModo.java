/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoformers.controlador;

import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.juego.Juego;
import algoformers.vista.Casilla;
import algoformers.vista.ContenedorJuego;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * 
 * @author John
 */
public class AccionCambiarModo implements EventHandler<ActionEvent>{
    	Juego juego;
	ContenedorJuego contenedorJuego;

    public AccionCambiarModo(ContenedorJuego contJuego, Juego juego) {
    	this.contenedorJuego = contJuego;
        this.juego = juego;
    }

        @Override
    public void handle(ActionEvent event) {
    	Algoformer algActual = this.contenedorJuego.getAlgoformerActual(); 
        Casilla casillaActual = this.contenedorJuego.getCasillaActual();
        casillaActual.getStyleClass().remove(algActual.getStyle());
        algActual.cambiarModo();
        casillaActual.getStyleClass().add(algActual.getStyle());
        this.contenedorJuego.crearBotonPasarTurno(true);
        this.contenedorJuego.crearBotonAtacar(true);
        this.contenedorJuego.crearBotonMover(true);
        this.contenedorJuego.crearBotonCambiarModo(true);
        this.contenedorJuego.crearBotonCombinarAlgos(true);
        this.contenedorJuego.borrarEstadisticasAlgoformer();
        this.contenedorJuego.crearEstadisticasAlgoformer(algActual);

        this.juego.avanzarTurno();
        this.contenedorJuego.pasarTurno();
        
    }
    
}
