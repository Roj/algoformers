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
public class BurbujaInmaculada implements Buff {
    protected int turnosRestantes;
    protected int vidaAlgoformer;
    public BurbujaInmaculada() {
        this.turnosRestantes = 2;
    }
    
    @Override
    public void avisarMovimiento(Algoformer algof) {
        //no es afectado por movimientos
    }


    @Override
    public void accionSobreAlgoformer(Algoformer algof) {
        this.vidaAlgoformer = algof.obtenerVida();
    }

    @Override
    public void pasarTurno(Algoformer algoformer) {
        this.turnosRestantes -= 1;
        if (this.turnosRestantes <=0) {
            algoformer.borrarBuff(this);
        }
    }

    @Override
    public void avisarAtaque(Algoformer algof) {
        throw new NoPuedeSerAtacado();
    }

    
    
}
