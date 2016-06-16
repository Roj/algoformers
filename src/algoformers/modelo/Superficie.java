package algoformers.modelo;

public abstract class Superficie {
    public abstract void accionSobreAlgoformer(ModoAereo modo, Algoformer algof);
    public abstract void accionSobreAlgoformer(ModoTerrestre modo, Algoformer algof);
    public abstract void accionSobreAlgoformer(ModoHumanoide modo, Algoformer algof);
    
    public abstract int obtenerPuntosDeMovimientoGastados(ModoHumanoide modo);
    public abstract int obtenerPuntosDeMovimientoGastados(ModoTerrestre modo);
    public abstract int obtenerPuntosDeMovimientoGastados(ModoAereo modo);
    
    
    public abstract int hash();
}
