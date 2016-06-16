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
    public int obtenerPuntosDeMovimientoGastados(ModoHumanoide modo) {
        return 1;
    }
    @Override
    public int obtenerPuntosDeMovimientoGastados(ModoAereo modo) {
        return 1;
    }
    @Override
    public int obtenerPuntosDeMovimientoGastados(ModoTerrestre modo) {
        return 1;
    }
}
