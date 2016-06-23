/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.vista;

/**
 *
 * @author Matias
 */
public class VistaAlgoformer{

    String nombre;
    String styleModoActual;
    String styleOtroModo;
    
    public VistaAlgoformer(String nombre,String styleActual,String styleOtro){
        this.nombre = nombre;
        this.styleModoActual = styleActual;
        this.styleOtroModo = styleOtro;
    }
    
    public String getStyle() {
        return this.styleModoActual;
    }
    
    public String getName() {
        return this.nombre;
    }
    
    public void cambiarStyle(){
        String aux = this.styleModoActual;
        this.styleModoActual = this.styleOtroModo;
        this.styleOtroModo = aux;
    }
}
