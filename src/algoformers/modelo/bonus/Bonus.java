/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.modelo.bonus;

import algoformers.modelo.juego.AtaqueInvalidoException;
import algoformers.modelo.tablero.Posicion;
import algoformers.modelo.tablero.Ubicable;
import algoformers.modelo.algoformer.Decepticon;
import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.algoformer.Autobot;
import algoformers.modelo.buffs.Buff;

/**
 *
 * @author Matias
 */
public class Bonus implements Ubicable {
    
    Posicion posicion;
    Buff buffer;

    public Bonus(Buff efecto) {
        this.buffer = efecto;
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
        algoformer.agregarBuff(buffer);
        //Borrar de posicion
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
    public Buff obtenerEfecto(){
        return this.buffer;
    }
        
}
