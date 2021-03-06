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
import algoformers.modelo.tablero.Tablero;
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
    		caminoAlgoformer.add(casillaCamino.getPosicion());//getUbicable().obtenerPosicion());
    	}
    	
    	try {
    		//Intento moverlo
                this.juego.obtenerJugadorActual().moverAPosiciones(algActual, caminoAlgoformer);
    	} catch (ObjetivoMuyLejosException|SuperficieNoAtravesableException e) {
                //Lanzar excepcion
    	}
        
        Tablero tablero = this.juego.obtenerTablero();
        
    	casillaInicioMov.getStyleClass().remove(algActual.getStyle());        
        Posicion posicion = casillaInicioMov.obtenerPosicion();
        casillaInicioMov.setUbicable(tablero.obtenerUbicable(posicion));
        
        for (Casilla casilla: caminoMarcado){
            posicion = casilla.obtenerPosicion();
            casilla.setUbicable(tablero.obtenerUbicable(posicion));
        }    
        
    	List<Casilla> casillasPosiblesMovimiento = this.contenedorJuego.getCasillasPosiblesMovimiento(casillaActual);
    	
        this.contenedorJuego.pasarTurno();
        //this.contenedorJuego.cambiarEstadoCasilla();
        this.contenedorJuego.cambiarEstadoCasilla(new AccionMarcarCasilla(this.contenedorJuego, juego));
        
    	this.contenedorJuego.dejarDeMostrarCasillas(casillasPosiblesMovimiento);
    	
    	this.contenedorJuego.borrarCaminoMarcado();  
        
         if (this.juego.obtenerGanador() != null){
            this.contenedorJuego.crearEtiquetaGanador(this.juego.obtenerGanador().obtenerNombre());
        }       
    }
    
}

