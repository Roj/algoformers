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
public interface Ubicable {
    
    public void establecerPosicion(Posicion pos);
    public Posicion obtenerPosicion();
    
    public void reemplazar(Algoformer algoformer);
    
    public void recibirAtaque(Autobot algoformer);
    
    public void recibirAtaque(Decepticon algoformer);
}

