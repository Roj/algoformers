package algoformers.modelo;

public abstract class Tierra extends Superficie { 
    @Override
    public int hash(){
        return 1;
    }
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Tierra);
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