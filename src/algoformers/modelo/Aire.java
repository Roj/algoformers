package algoformers.modelo;

public abstract class Aire extends Superficie { 
    public int hash(){
        return 0;
    }
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Aire);
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
