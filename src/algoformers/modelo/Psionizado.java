/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.modelo;

import algoformers.modelo.Buff;

/**
 *
 * @author joaquintz
 */
public class Psionizado implements Buff {

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
    public void repetir(Algoformer algof) {
        //solo se aplica una vez, por lo cual no hace nada al repetirse
    }
    @Override
    public void accionSobreAlgoformer(Algoformer algof) {
        //no es necesario verificar el modo pues solo se puede entrar aqui
        //si se ha entrado en una tormenta psionica (en modo alterno unicamente)
        int nuevoAtaque = (int) (algof.obtenerModoActual().obtenerPuntosAtaque()*0.6);
        algof.obtenerModoActual().establecerPuntosAtaque(nuevoAtaque);
    }
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Psionizado);
    }
    @Override
    public int hashCode() {
        //solo es necesario que los buffs sean equivalentes entre si
        //i.e. Psionizado es igual a cualquier otro Psionizado,
        //pero no a un buff de otro tipo
        return 0; 
    }
    @Override
    public void pasarTurno(Algoformer algoformer) {
        //es permanente, no hace nada con los turnos
    }
    
}
