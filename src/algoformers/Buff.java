/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers;

/**
 *
 * @author joaquintz
 */
public interface Buff {
    public void avisarMovimiento(Algoformer algof);
    public void repetir(Algoformer algof);
    public void accionSobreAlgoformer(Algoformer algof);
    public void pasarTurno(Algoformer algoformer);
}
