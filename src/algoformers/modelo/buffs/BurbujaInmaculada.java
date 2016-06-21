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
public class BurbujaInmaculada implements Buff {
    protected int turnosRestantes;
    private int UID = 7788899;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.UID;
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
        final BurbujaInmaculada other = (BurbujaInmaculada) obj;
        if (this.UID != other.UID) {
            return false;
        }
        return true;
    }
    
    public BurbujaInmaculada() {
        this.turnosRestantes = 2;
    }
    
    @Override
    public void avisarMovimiento(Algoformer algof) {
        //no es afectado por movimientos
    }

    @Override
    public void accionSobreAlgoformer(Algoformer algof) {
    }

    @Override
    public void pasarTurno(Algoformer algoformer, Iterator iter) {
        this.turnosRestantes -= 1;
        if (this.turnosRestantes <=0) {
            iter.remove();
        }
    }

    @Override
    public void avisarAtaque(Algoformer algof) {
        throw new NoPuedeSerAtacado();
    }

    public void setEfecto(Casilla casilla) {
        casilla.setEfecto(this);
    }
    
}
