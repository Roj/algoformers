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
        try {
            Ubicable ubicableEnPosicion = this.tablero.get(posicion);
            ubicableEnPosicion.superponer(algoformer);
            algoformer.establecerPosicion(posicion);
            this.agregarUbicable(posicion, algoformer);
        } catch (NullPointerException|NoSuperponibleException e){
            if (e instanceof NullPointerException){
                throw new FueraDeRangoDeTableroException();
            }
            throw e;
        }
    }
    
    public void moverAlgoformer(Posicion posicion,Algoformer algoformer){
        try {
            Ubicable ubicableEnPosicion = this.tablero.get(posicion);
            ubicableEnPosicion.superponer(algoformer);
            algoformer.mover(posicion);
            this.agregarUbicable(posicion, algoformer);
        } catch (NullPointerException|NoSuperponibleException e){
            if (e instanceof NullPointerException){
                throw new FueraDeRangoDeTableroException();
            }
            throw e;
        }
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
        if (ubicable == null) {
            throw new FueraDeRangoDeTableroException();
        }
        return ubicable;
    }
}
