/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.modelo;

import algoformers.modelo.superficie.Superficie;
import java.util.Objects;

/**
 *
 * @author Matias
 */
public class Posicion {
    int X;
    int Y;
    
    Superficie superficie;
    
    public Posicion(int i, int j, Superficie sup){
        this.X = i;
        this.Y = j;
        this.superficie = sup;
    }  
    public int obtenerX() {
        return this.X;
    }
    public int obtenerY() {
        return this.Y;
    }   
    public Superficie obtenerSuperficie() {
    	return this.superficie;
    }
    
    public int calcularDistancia(Posicion otra) {
        return Math.max(Math.abs(this.X - otra.obtenerX()),Math.abs(this.Y - otra.obtenerY()));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.X;
        hash = 97 * hash + this.Y;
        hash = 97 * hash + this.superficie.hash();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Posicion other = (Posicion) obj;
        if (this.X != other.X) {
            return false;
        }
        if (this.Y != other.Y) {
            return false;
        }
        if (Objects.equals(this.superficie, other.superficie)) {
            return true;
        }
        else {
            Class <?> clase = (other.superficie).getClass();
            if(!clase.isInstance(this.superficie)) {                
                return false;
            }
        }
        
        return true;
    }
    
    
}
