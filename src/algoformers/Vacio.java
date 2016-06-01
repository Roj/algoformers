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
class Vacio implements Ubicable {

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
    public void superponer(Algoformer algoformer) {
        //Metodo vacio
    }
    @Override
    public void recibirAtaque(Autobot algoformer){
        //Metodo vacio
    }
    @Override
    public void recibirAtaque(Decepticon algoformer){
        //Metodo vacio
    }
    
}
