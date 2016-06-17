/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.modelo.juego;

import algoformers.modelo.Posicion;
import algoformers.modelo.Ubicable;
import algoformers.modelo.Vacio;
import algoformers.modelo.bonus.Bonus;
import algoformers.modelo.bonus.FabricaBonus;
import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.mapa.Mapa;
import algoformers.modelo.superficie.Superficie;
import algoformers.modelo.superficie.Rocosa;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Matias
 */
public class Tablero {
    private Map<Posicion,Ubicable> tablero;
    int dimX;
    int dimY;
            
    public Tablero(Mapa mapa){
        this.tablero = new HashMap<>();
        
        this.dimX = mapa.obtenerDimX();
        this.dimY = mapa.obtenerDimY();
        
        this.rellenarSuperficies(mapa.obtenerMapaAire());
        this.rellenarSuperficies(mapa.obtenerMapaTierra());
    }
    
    private void rellenarSuperficies(Superficie[][] modelo){
        for (int i=0;i<this.dimX;i++){
            for (int j=0;j<this.dimY;j++){            	
                Posicion posicion = new Posicion(i,j,modelo[i][j]);                     
                Vacio nuevoEspacio = new Vacio();
                agregarUbicable(posicion,nuevoEspacio);
            }
        }
    }

    void ubicarChispaEnElCentro() {
        FabricaBonus fabricaBonus = new FabricaBonus();
        Bonus chispaSuprema = fabricaBonus.crearChispaSuprema();
        Posicion centro = new Posicion((this.dimX-1)/2, (this.dimY-1)/2, new Rocosa());
        chispaSuprema.establecerPosicion(centro);
        this.agregarUbicable(centro, chispaSuprema);
    }
    public void verificarReemplazable(Posicion pos, Algoformer algof) {
        Ubicable ubicableEnPosicion = this.tablero.get(pos);
        ubicableEnPosicion.reemplazar(algof);
    }
    
    public void colocarAlgoformer(Posicion posicion,Algoformer algoformer){
        //Este metodo se utiliza para ubicar los algoformers inicialmente.
        this.verificarReemplazable(posicion,algoformer);
        algoformer.establecerPosicion(posicion);
        this.agregarUbicable(posicion, algoformer);        
    }
    
    public void moverAlgoformer(Posicion siguientePos,Algoformer algoformer){    	    	
        this.verificarReemplazable(siguientePos,algoformer);
        Posicion viejaPos = algoformer.obtenerPosicion();
        
        algoformer.mover(siguientePos);

        //Si todo sale bien
        this.agregarUbicable(siguientePos, algoformer); 
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
    public int obtenerDimension(){
        return dimX;
    }
    public List<Posicion> obtenerListaDePosiciones() {
    	return new ArrayList<Posicion>(this.tablero.keySet());
    }
}
