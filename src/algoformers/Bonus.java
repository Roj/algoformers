/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers;

/**
 *
 * @author Matias
 */
public abstract class Bonus implements Ubicable {
    
    Posicion posicion;
    
    public Bonus(Posicion ubicacion){
        this.posicion = ubicacion;
    }
    
    @Override
    public void superponer(Tablero tablero, Algoformer algoformer){
        this.accion(algoformer);
        tablero.agregarUbicable(this.posicion, algoformer);
        
    }
    
    public abstract void accion(Algoformer algoformer);
    
}
