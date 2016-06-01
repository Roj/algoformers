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
    public Algoformer obtenerAlgoformer(int indice) {
        Algoformer algoformer;
        
        try {
            algoformer = algoformers.get(indice);
        } catch(IndexOutOfBoundsException e) {
            throw new AlgoformerNoExisteException();
        }
        return algoformer;
    }
    public void colocarAlgoformer(int indice, Posicion posicion) {
        //Esta funcion se usara para ubicar los algoformers inicialmente
        //El jugador tiene la posibilidad de ubicar sus algoformers inicialmente
        //Dentro de un lugar no tan cerca de la chispa
        Algoformer algoformer = this.obtenerAlgoformer(indice);
        tablero.colocarAlgoformer(posicion, algoformer);
    }
    public void atacarPosicion(int indiceTransformerAtacante, Posicion destino) {
        
        Algoformer algoformerAtacante = this.obtenerAlgoformer(indiceTransformerAtacante);
        
        juego.verificarTurno(this);
        
        algoformerAtacante.atacar(tablero.obtenerUbicable(destino));
        
        juego.avanzarTurno();
        
    }
    public String obtenerNombre() {
        return this.nombre;
    }
}
