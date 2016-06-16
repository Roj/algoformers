package algoformers.modelo;

public abstract class Superficie {
    public abstract void accionSobreAlgoformer(ModoAereo modo, Algoformer algof);
    public abstract void accionSobreAlgoformer(ModoTerrestre modo, Algoformer algof);
    public abstract void accionSobreAlgoformer(ModoHumanoide modo, Algoformer algof);
    
    public abstract void ajustarPuntosDeMovimiento(Movimiento mov, ModoAereo modo);
    public abstract void ajustarPuntosDeMovimiento(Movimiento mov, ModoTerrestre modo);
    public abstract void ajustarPuntosDeMovimiento(Movimiento mov, ModoHumanoide modo);
    
    public abstract int hash();
}
