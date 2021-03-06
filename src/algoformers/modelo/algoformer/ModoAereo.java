/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.modelo.algoformer;

import algoformers.modelo.juego.Movimiento;
import algoformers.modelo.superficie.Superficie;

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
    @Override
    public void ajustarPuntosDeMovimiento(Movimiento mov, Superficie sup) {
        sup.ajustarPuntosDeMovimiento(mov,this);
    }

    @Override
    public void puedeAtravesarSuperficie(Superficie superficie) {
        superficie.puedeSerAtravesada(this);
    }
}
