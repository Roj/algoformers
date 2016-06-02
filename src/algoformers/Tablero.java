/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Matias
 */
public class Tablero {
    private Map<Posicion,Ubicable> tablero;
    int dimX;
    int dimY;
            
    public Tablero(int X,int Y){
        this.tablero = new HashMap<Posicion,Ubicable>();
        this.dimX = X;
        this.dimY = Y;
        this.inicializarTablero();
    }

    private void inicializarTablero(){
        for (int i=0;i<this.dimX;i++){
            for (int j=0;j<this.dimY;j++){
                Posicion posicion = new Posicion(i,j);
                Vacio nuevoEspacio = new Vacio();
                nuevoEspacio.establecerPosicion(posicion);
                this.tablero.put(posicion,nuevoEspacio);
            }
        }   
    }
    
    public void colocarAlgoformer(Posicion posicion,Algoformer algoformer){
        Ubicable ubicableEnPosicion = this.tablero.get(posicion);
        ubicableEnPosicion.reemplazar(algoformer);
        algoformer.establecerPosicion(posicion);
        this.agregarUbicable(posicion, algoformer);
    }
    
    public void moverAlgoformer(Posicion posicion,Algoformer algoformer){
        Posicion viejaPos = algoformer.obtenerPosicion();
        algoformer.verificarMovida(posicion);
        this.colocarAlgoformer(posicion, algoformer);
        this.borrarUbicable(viejaPos);
    }
    
    public void agregarUbicable(Posicion posicion,Ubicable nuevoUbicable){
        this.tablero.put(posicion, nuevoUbicable);
        nuevoUbicable.establecerPosicion(posicion);
    }
    
    public void borrarUbicable(Posicion posicion){
        Vacio nuevoEspacio = new Vacio();
        nuevoEspacio.establecerPosicion(posicion);
        this.tablero.put(posicion,nuevoEspacio);
    }

    public boolean estaVacio(Posicion posicion){
         return this.tablero.get(posicion) instanceof Vacio;
    }
    
    public Ubicable obtenerUbicable(Posicion posicion) {
        Ubicable ubicable = tablero.get(posicion);
        return ubicable;
    }
}
