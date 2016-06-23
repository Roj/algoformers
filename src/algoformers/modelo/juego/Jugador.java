/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.modelo.juego;

import algoformers.modelo.superficie.SuperficieNoAtravesableException;
import algoformers.modelo.superficie.Tierra;
import algoformers.modelo.tablero.Tablero;
import algoformers.modelo.tablero.Posicion;
import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.algoformer.FabricaAlgoformers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author joaquintz
 */
public class Jugador {
    private String nombre;
    private List<Algoformer> algoformers;
    private Tablero tablero;
    private Juego juego;
    
    public Jugador(String nombre, Tablero tablero, Juego juego) {
        this.nombre = nombre;
        this.tablero = tablero;
        this.algoformers = new ArrayList<>();
        this.juego = juego;
    }
    public void agregarAlgoformer(Algoformer nuevoAlgoformer) {
        algoformers.add(nuevoAlgoformer);
    }
    public List<Algoformer> obtenerListaAlgoformers() {
        return this.algoformers;
    }
    public void atacarPosicion(Algoformer algoformer, Posicion destino) {
        juego.verificarTurno(this);
        
        Algoformer algoformerEnemigo = (Algoformer) tablero.obtenerUbicable(destino);
        algoformer.atacar(algoformerEnemigo);
        if (!algoformerEnemigo.esta_vivo()){
            this.tablero.borrarUbicable(destino);
        }
        juego.avanzarTurno();
        this.avisarAlgoformersPaseDeTurno();
    }
    
    public void moverAPosiciones(Algoformer algof, List<Posicion> destino) {
        juego.verificarTurno(this);
        Movimiento mov = new Movimiento(algof,destino,tablero);
        mov.mover();
        
        juego.avanzarTurno();
        this.avisarAlgoformersPaseDeTurno();
    }
    
    public void cambiarModo(Algoformer algof) {
        juego.verificarTurno(this);
        algof.cambiarModo();
        juego.avanzarTurno();    	
        this.avisarAlgoformersPaseDeTurno();
    }
    public void avisarAlgoformersPaseDeTurno() {
        for(Iterator<Algoformer> i = algoformers.iterator(); i.hasNext();) {
            Algoformer algoformer = i.next();
            algoformer.pasarTurno();
        }
    }
    public String obtenerNombre() {
        return this.nombre;
    }
    
    public void pasarTurno() {
    	juego.avanzarTurno();
    }
    public void combinarAlgoformers(Posicion posFinal, List<Algoformer> algos) {
    	int vidaTotal = 0;
    	List<Posicion> posAux = new ArrayList<Posicion>();
    	Algoformer supremo = this.algoformers.get(3);
    	
    	for (Algoformer algoformer : algoformers) {
                vidaTotal += algoformer.obtenerVida();
    		
    		Posicion pos = algoformer.obtenerPosicion();
    		    		
    		this.tablero.borrarUbicable(algoformer.obtenerPosicion());
    		posAux.add(pos);
    	}
    	
		try {
			supremo.obtenerModoActual().aceptarSuperficie(posFinal.obtenerSuperficie(), supremo);
			supremo.setVida(vidaTotal);
			this.tablero.colocarAlgoformer(posFinal, supremo);
		} catch (NoSuperponibleException|SuperficieNoAtravesableException e) {
			for (int i = 0; i < algos.size(); i++) {
				this.tablero.colocarAlgoformer(posAux.get(i), algos.get(i));
			}
			throw new NoSePuedeCombinarException();
		} 
    	
		this.juego.avanzarTurno();
    }
}
