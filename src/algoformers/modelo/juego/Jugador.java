/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.modelo.juego;

import algoformers.modelo.tablero.Tablero;
import algoformers.modelo.tablero.Posicion;
import algoformers.modelo.algoformer.Algoformer;
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
    public void atacarPosicion(Algoformer alf, Posicion destino) {
        juego.verificarTurno(this);
        alf.atacar(tablero.obtenerUbicable(destino));
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
}
