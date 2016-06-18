/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.modelo.buffs;

import algoformers.modelo.algoformer.Algoformer;
import java.util.Iterator;

/**
 *
 * @author joaquintz
 */
//
public class EncadenadoEnAndromeda implements Buff {
    protected int turnosRestantes;
    private int UID = 44555666;
    public EncadenadoEnAndromeda() {
        this.turnosRestantes = 3;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.UID;
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
        final EncadenadoEnAndromeda other = (EncadenadoEnAndromeda) obj;
        if (this.UID != other.UID) {
            return false;
        }
        return true;
    }
    @Override
    public void avisarAtaque(Algoformer algof){
        //no es afectado por ataque
    }
    
    @Override
    public void avisarMovimiento(Algoformer algof) {
        throw new EncadenadoException();
    }


    @Override
    public void accionSobreAlgoformer(Algoformer algof) {
        //no hace nada en especial
    }

    @Override
    public void pasarTurno(Algoformer algoformer, Iterator iter) {
        this.turnosRestantes -= 1;
        if (this.turnosRestantes <=0) {
            iter.remove();
        }
    }
    
}
