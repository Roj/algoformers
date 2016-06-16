/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.modelo.superficie;

import algoformers.modelo.SuperficieNoAtravesableException;
import algoformers.modelo.algoformer.ModoAereo;
import algoformers.modelo.algoformer.ModoTerrestre;
import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.algoformer.ModoHumanoide;
import algoformers.modelo.superficie.Aire;
import algoformers.modelo.buffs.EncadenadoEnAndromeda;

/**
 *
 * @author Matias
 */
public class NebulosaDeAndromeda extends Aire {
    @Override
    public void accionSobreAlgoformer(ModoTerrestre modo, Algoformer algof) {
        throw new SuperficieNoAtravesableException();
    }
    @Override
    public void accionSobreAlgoformer(ModoAereo modo, Algoformer algof) {
        algof.agregarBuff(new EncadenadoEnAndromeda());
        
    }
    @Override
    public void accionSobreAlgoformer(ModoHumanoide modo, Algoformer algof) {
        throw new SuperficieNoAtravesableException();
    }
}
