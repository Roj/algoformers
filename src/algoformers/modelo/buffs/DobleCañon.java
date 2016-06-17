/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.modelo.buffs;

import algoformers.modelo.algoformer.Algoformer;

/**
 *
 * @author Matias
 */
public class DobleCañon implements Buff{
    
    protected int turnosRestantes;
    private int UID = 1122233;
    
    public DobleCañon() {
        this.turnosRestantes = 3;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.UID;
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
        final DobleCañon other = (DobleCañon) obj;
        if (this.UID != other.UID) {
            return false;
        }
        return true;
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
        int nuevoAtaque = (int) (algof.obtenerModoActual().obtenerPuntosAtaque()*2);
        algof.obtenerModoActual().establecerPuntosAtaque(nuevoAtaque);
    }

    @Override
    public void pasarTurno(Algoformer algoformer) {
        this.turnosRestantes -= 1;
        if (this.turnosRestantes <=0) {
            int ataque = (int) (algoformer.obtenerModoActual().obtenerPuntosAtaque()/2);
            algoformer.obtenerModoActual().establecerPuntosAtaque(ataque);
            algoformer.borrarBuff(this);
        }
    }

}
