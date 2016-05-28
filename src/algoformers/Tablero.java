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
                this.tablero.put(posicion,new Vacio(posicion));
            }
        }   
    }
    
    public void colocarAlgoformer(Posicion posicion,Algoformer algoformer){
        Ubicable ubicableEnPosicion = this.tablero.get(posicion);
        ubicableEnPosicion.superponer(this,algoformer);
    }
    
    public void agregarUbicable(Posicion posicion,Ubicable nuevoUbicable){
        this.tablero.put(posicion, nuevoUbicable);
    }
    
    public void borrarUbicable(Posicion posicion){
        this.tablero.put(posicion,new Vacio(posicion));
    }

    public boolean estaVacio(Posicion posicion){
         return this.tablero.get(posicion) instanceof Vacio;
    }
}
