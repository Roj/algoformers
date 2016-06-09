package algoformers;

public class Pantano extends Tierra {
    @Override
    public void accionSobreAlgoformer(ModoTerrestre modo, Algoformer algof) {
        //restar movimientos??
    }
    @Override
    public void accionSobreAlgoformer(ModoHumanoide modo, Algoformer algof) {
        throw new SuperficieNoAtravesableException();
    }
    @Override
    public void accionSobreAlgoformer(ModoAereo modo, Algoformer algof) {
        //no restar narinas
    }
    @Override
    public void ajustarPuntosDeMovimiento(ModoTerrestre modo, Algoformer algof) {
        algof.modificarPuntosDeMovimiento(-2);
    }
}
