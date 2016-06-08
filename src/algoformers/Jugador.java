/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joaquintz
 */
class Jugador {
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
    }
    
    public void moverAPosicion(Algoformer algof, Posicion destino) {
        juego.verificarTurno(this);
        tablero.moverAlgoformer(destino, algof);
        juego.avanzarTurno();
    }
    
    public void cambiarModo(Algoformer algof) {
        juego.verificarTurno(this);
        algof.cambiarModo();
        juego.avanzarTurno();    	
    }
    public String obtenerNombre() {
        return this.nombre;
    }
}
