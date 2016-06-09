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
public class ModoAereo extends ModoAlterno {
    public ModoAereo(int puntosAtaque, int distanciaAtaque,int velocidad) {
        super(puntosAtaque,distanciaAtaque,velocidad);
    }
    @Override
    public void aceptarSuperficie(Superficie sup, Algoformer algof) {
        sup.accionSobreAlgoformer(this, algof);
    }
    public void ajustarPuntosDeMovimiento(Superficie sup, Algoformer algof) {
        sup.ajustarPuntosDeMovimiento(this,algof);
    }   
}
