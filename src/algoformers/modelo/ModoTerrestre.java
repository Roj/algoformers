/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.modelo;

/**
 *
 * @author joaquintz
 */
public class ModoTerrestre extends ModoAlterno {
    public ModoTerrestre(int puntosAtaque, int distanciaAtaque,int velocidad) {
        super(puntosAtaque,distanciaAtaque,velocidad);
    }
    @Override
    public void aceptarSuperficie(Superficie sup, Algoformer algof) {
        sup.accionSobreAlgoformer(this, algof);
    }
    
}
