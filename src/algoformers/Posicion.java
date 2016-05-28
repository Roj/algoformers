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
public class Posicion {
    int X;
    int Y;
    
    public Posicion(int i, int j){
        this.X = i;
        this.Y = j;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.X;
        hash = 97 * hash + this.Y;
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
        return true;
    }
    
    
}
