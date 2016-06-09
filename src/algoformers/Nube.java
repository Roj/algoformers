package algoformers;

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
    @Override
    public void ajustarPuntosDeMovimiento(ModoAlgoformer modo, Algoformer algof) {
        algof.modificarPuntosDeMovimiento(-1);
    }
}
