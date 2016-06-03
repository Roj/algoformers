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
    
    public Bonus(){
        
    }
    @Override
    public void establecerPosicion(Posicion pos) {
        this.posicion = pos;
    }
    @Override
    public Posicion obtenerPosicion() {
        return this.posicion;
    }
    @Override
    public void reemplazar(Algoformer algoformer){
        this.accion(algoformer);
        
    }
    @Override
    public void recibirAtaque(Decepticon algoformer){
        //Metodo vacio
    	throw new AtaqueInvalidoException();
    }
    @Override
    public void recibirAtaque(Autobot algoformer){
        //Metodo vacio
    	throw new AtaqueInvalidoException();
    }
    
    public abstract void accion(Algoformer algoformer);
    
}
