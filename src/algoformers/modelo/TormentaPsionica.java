/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.modelo;

/**
 *
 * @author Matias
 */
public class TormentaPsionica extends Aire {
    public void accionSobreAlgoformer(Algoformer alg) {
        // Disminuye poder de ataque para siempre en 40% solo la primera vez que pasa
    }

    @Override
    public void accionSobreAlgoformer(ModoAereo modo, Algoformer algof) {
        //bajar capacidad de ataque por unica vez, es un buff
        algof.agregarBuff(new Psionizado());
    }

    @Override
    public void accionSobreAlgoformer(ModoTerrestre modo, Algoformer algof) {
        throw new SuperficieNoAtravesableException();
    }

    @Override
    public void accionSobreAlgoformer(ModoHumanoide modo, Algoformer algof) {
        throw new SuperficieNoAtravesableException();
    }
}
