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
 * @author joaquintz
 */
public interface Buff {
    public void avisarAtaque(Algoformer algof);
    public void avisarMovimiento(Algoformer algof);
    public void accionSobreAlgoformer(Algoformer algof);
    public void pasarTurno(Algoformer algoformer, Iterator iter);
    public void setEfecto(Casilla casilla);
}
