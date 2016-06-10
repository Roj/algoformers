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
//
public class EncadenadoEnAndromeda implements Buff {
    protected int turnosRestantes;
    public EncadenadoEnAndromeda() {
        this.turnosRestantes = 3;
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
    public void repetir(Algoformer algof) {
        //es imposible que se repita
    }

    @Override
    public void accionSobreAlgoformer(Algoformer algof) {
        //no hace nada en especial
    }

    @Override
    public void pasarTurno(Algoformer algoformer) {
        this.turnosRestantes -= 1;
        if (this.turnosRestantes <=0) {
            algoformer.borrarBuff(this);
        }
    }
    
}
