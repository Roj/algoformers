package algoformers;

public abstract class Superficie {
    public abstract void accionSobreAlgoformer(ModoAereo modo, Algoformer algof);
    public abstract void accionSobreAlgoformer(ModoTerrestre modo, Algoformer algof);
    public abstract void accionSobreAlgoformer(ModoHumanoide modo, Algoformer algof);
    
    public abstract void ajustarPuntosDeMovimiento(ModoHumanoide modo, Algoformer algof);
    public abstract void ajustarPuntosDeMovimiento(ModoTerrestre modo, Algoformer algof);
    public abstract void ajustarPuntosDeMovimiento(ModoAereo modo, Algoformer algof);
    
    
    public abstract int hash();
}
