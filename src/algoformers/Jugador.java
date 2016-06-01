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
    
    public Jugador(String nombre, Tablero tablero) {
        this.nombre = nombre;
        this.tablero = tablero;
        this.algoformers = new ArrayList<>();
    }
    public void agregarAlgoformer(Algoformer nuevoAlgoformer) {
        algoformers.add(nuevoAlgoformer);
    }
    public void colocarAlgoformer(int indice, Posicion posicion) {
        //Esta funcion se usara para ubicar los algoformers inicialmente
        //El jugador tiene la posibilidad de ubicar sus algoformers inicialmente
        //Dentro de un lugar no tan cerca de la chispa
        Algoformer algoformer;
        
        try {
            algoformer = algoformers.get(indice);
        } catch(IndexOutOfBoundsException e) {
            throw new AlgoformerNoExisteException();
        }
        
        tablero.colocarAlgoformer(posicion, algoformer);
    }
    public String obtenerNombre() {
        return this.nombre;
    }
}
