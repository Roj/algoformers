package algoformers.controlador;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.BlendMode;
import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.juego.Juego;
import algoformers.modelo.juego.ObjetivoMuyLejosException;
import algoformers.modelo.superficie.SuperficieNoAtravesableException;
import algoformers.modelo.tablero.Posicion;
import algoformers.modelo.tablero.Ubicable;
import algoformers.modelo.tablero.Vacio;
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
    	// Todo lo de mover al algoformer
    	List<Casilla> caminoMarcado = this.contenedorJuego.getCaminoMarcado();
    	List<Posicion> caminoAlgoformer = new ArrayList<Posicion>();
    	Casilla casillaActual = this.contenedorJuego.getCasillaActual();
    	Casilla casillaInicioMov = this.contenedorJuego.getCasillaInicioMovimiento();
    	Algoformer algActual = this.contenedorJuego.getAlgoformerActual();
    	
    	for (Casilla casillaCamino : caminoMarcado) {
    		caminoAlgoformer.add(casillaCamino.getUbicable().obtenerPosicion());
    	}
    	
    	try {
    		this.juego.obtenerJugadorActual().moverAPosiciones(algActual, caminoAlgoformer);
    	
    		Ubicable aux = casillaActual.getUbicable();
    		casillaActual.setUbicable(casillaInicioMov.getUbicable());
    		casillaInicioMov.setUbicable(aux);
    		casillaInicioMov.getStyleClass().remove(algActual.getStyle());
    	} catch (ObjetivoMuyLejosException|SuperficieNoAtravesableException e) {
    		Posicion posFinalAlgoformer = algActual.obtenerPosicion();
    		Casilla casillaAnterior = casillaInicioMov;
    		for (Casilla casilla : caminoMarcado) {
    			if (casilla.getX() == posFinalAlgoformer.obtenerX() &&
    				casilla.getY() == posFinalAlgoformer.obtenerY()) {
    	    		Ubicable aux = casilla.getUbicable();
    	    		casilla.setUbicable(casillaInicioMov.getUbicable());
    	    		casillaInicioMov.setUbicable(aux);   				
    	    		casillaAnterior.getStyleClass().remove(algActual.getStyle());
    	    		casillaAnterior = casilla;
    	    		// esto es feo
    	    		this.juego.avanzarTurno();
    			}    				
    		}
    	}
    	
    	List<Casilla> casillasPosiblesMovimiento = this.contenedorJuego.getCasillasPosiblesMovimiento(casillaActual);
    	
        this.contenedorJuego.pasarTurno();
        //this.contenedorJuego.cambiarEstadoCasilla();
        this.contenedorJuego.cambiarEstadoCasilla(new AccionMarcarCasilla(this.contenedorJuego, juego));
        
    	this.contenedorJuego.dejarDeMostrarCasillas(casillasPosiblesMovimiento);
    	
    	this.contenedorJuego.borrarCaminoMarcado();  
    	casillaInicioMov.setBlendMode(null);
    }
    
}

