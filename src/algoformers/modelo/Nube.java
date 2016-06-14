package algoformers.modelo;

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
    public void ajustarPuntosDeMovimiento(ModoHumanoide modo, Algoformer algof) {
        algof.modificarPuntosDeMovimiento(-1);
    }
    @Override
    public void ajustarPuntosDeMovimiento(ModoAereo modo, Algoformer algof) {
        algof.modificarPuntosDeMovimiento(-1);
    }
    @Override
    public void ajustarPuntosDeMovimiento(ModoTerrestre modo, Algoformer algof) {
        algof.modificarPuntosDeMovimiento(-1);
    }
}
