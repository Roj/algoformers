package algoformers;

public class Rocosa extends Tierra {
    @Override
    public void accionSobreAlgoformer(ModoTerrestre modo, Algoformer algof) {

    }
    @Override
    public void accionSobreAlgoformer(ModoAereo modo, Algoformer algof) {

    }
    @Override
    public void accionSobreAlgoformer(ModoHumanoide modo, Algoformer algof) {

    }

    @Override
    public void ajustarPuntosDeMovimiento(ModoAlgoformer modo, Algoformer algof) {
        algof.modificarPuntosDeMovimiento(-1);
    }
}
