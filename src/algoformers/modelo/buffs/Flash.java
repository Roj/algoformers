/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.modelo.buffs;

import algoformers.modelo.algoformer.Algoformer;
import algoformers.vista.Casilla;
import java.util.Iterator;

/**
 *
 * @author Matias
 */
public class Flash implements Buff {
    private int UID = 123123123;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.UID;
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
        final Flash other = (Flash) obj;
        if (this.UID != other.UID) {
            return false;
        }
        return true;
    }
    protected int turnosRestantes;
    public Flash() {
        this.turnosRestantes = 3;
    }

    @Override
    public void avisarAtaque(Algoformer algof) {
        //no es afectado por ataque
    }

    @Override
    public void avisarMovimiento(Algoformer algof) {
        //no es afectado por movimiento
    }


    @Override
    public void accionSobreAlgoformer(Algoformer algof) {
        int nuevaVelocidad = (int) (algof.obtenerModoActual().obtenerVelocidad()*3);
        algof.obtenerModoActual().establecerVelocidad(nuevaVelocidad);
    }

    @Override
    public void pasarTurno(Algoformer algoformer,Iterator iter) {
        this.turnosRestantes -= 1;
        if (this.turnosRestantes <=0) {
            int velocidad = (int) (algoformer.obtenerModoActual().obtenerVelocidad()/3);
            algoformer.obtenerModoActual().establecerVelocidad(velocidad);
            iter.remove();
        }    
    }

    @Override
    public void setEfecto(Casilla casilla) {
        casilla.setEfecto(this);
    }
}
