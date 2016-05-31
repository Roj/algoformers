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
    
    public Vacio(Posicion ubicacion){
        this.posicion = ubicacion;
    }

    @Override
    public void superponer(Algoformer algoformer) {
        //Metodo vacio
    }
    
}
