package algoformers.modelo.superficie;

import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.algoformer.ModoAereo;
import algoformers.modelo.algoformer.ModoHumanoide;
import algoformers.modelo.algoformer.ModoTerrestre;
import algoformers.modelo.SuperficieNoAtravesableException;

public class Nube extends Aire {
    @Override
    public void accionSobreAlgoformer(ModoTerrestre modo, Algoformer algof) {
        throw new SuperficieNoAtravesableException();
    }
    @Override
    public void accionSobreAlgoformer(ModoAereo modo, Algoformer algof) {
        //narinas
    }
    @Override
    public void accionSobreAlgoformer(ModoHumanoide modo, Algoformer algof) {
        throw new SuperficieNoAtravesableException();
    }

}
