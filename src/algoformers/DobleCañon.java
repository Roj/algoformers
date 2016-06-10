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
public class DobleCañon implements Buff{
    
    protected int turnosRestantes;
    public DobleCañon() {
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
    public void repetir(Algoformer algof) {
        //Que hace aca?
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
