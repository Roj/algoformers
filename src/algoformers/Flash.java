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
public class Flash implements Buff {

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
    public void repetir(Algoformer algof) {
        //Que hace aca?
    }

    @Override
    public void accionSobreAlgoformer(Algoformer algof) {
        int nuevaVelocidad = (int) (algof.obtenerModoActual().obtenerVelocidad()*3);
        algof.obtenerModoActual().establecerVelocidad(nuevaVelocidad);
    }

    @Override
    public void pasarTurno(Algoformer algoformer) {
        this.turnosRestantes -= 1;
        if (this.turnosRestantes <=0) {
            int velocidad = (int) (algoformer.obtenerModoActual().obtenerVelocidad()/3);
            algoformer.obtenerModoActual().establecerVelocidad(velocidad);
            algoformer.borrarBuff(this);
        }    }
}
