/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.modelo.buffs;

import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.buffs.Buff;
import java.util.Iterator;

/**
 *
 * @author joaquintz
 */
public class Psionizado implements Buff {
    private int UID = 4444444;
    public Psionizado() {
    }
    @Override
    public void avisarAtaque(Algoformer algof) {
        //no es afectado por ataque
    }
    @Override
    public void avisarMovimiento(Algoformer algof) {
        //no es afectado por movimientos
    }
    @Override
    public void accionSobreAlgoformer(Algoformer algof) {
        //no es necesario verificar el modo pues solo se puede entrar aqui
        //si se ha entrado en una tormenta psionica (en modo alterno unicamente)
        int nuevoAtaque = (int) (algof.obtenerModoActual().obtenerPuntosAtaque()*0.6);
        algof.obtenerModoActual().establecerPuntosAtaque(nuevoAtaque);
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Psionizado other = (Psionizado) obj;
        if (this.UID != other.UID) {
            return false;
        }
        return true;
    }
    
    @Override
    public void pasarTurno(Algoformer algoformer,Iterator iter) {
        //es permanente, no hace nada con los turnos
    }
    
    
}
