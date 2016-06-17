/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.modelo.tablero;

import algoformers.modelo.algoformer.Decepticon;
import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.algoformer.Autobot;

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

