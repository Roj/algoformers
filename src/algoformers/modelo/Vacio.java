/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.modelo;

import algoformers.modelo.juego.AtaqueInvalidoException;
import algoformers.modelo.algoformer.Decepticon;
import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.algoformer.Autobot;

/**
 *
 * @author Matias
 */
public class Vacio implements Ubicable {

    Posicion posicion;
    
    @Override
    public void establecerPosicion(Posicion pos) {
        this.posicion = pos;
    }
    @Override
    public Posicion obtenerPosicion() {
        return this.posicion;
    }

    @Override
    public void reemplazar(Algoformer algoformer) {
        //Metodo vacio
    }
    @Override
    public void recibirAtaque(Autobot algoformer){
        //Metodo vacio
    	throw new AtaqueInvalidoException();
    }
    @Override
    public void recibirAtaque(Decepticon algoformer){
        //Metodo vacio
    	throw new AtaqueInvalidoException();
    }
    
}
