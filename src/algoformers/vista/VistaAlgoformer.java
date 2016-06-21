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
    String style;
    
    public VistaAlgoformer(String nombre,String style){
        this.nombre = nombre;
        this.style = style;
    }
    
    public String getStyle() {
        return this.style;
    }
    
    public String getName() {
        return this.nombre;
    }
    
}
