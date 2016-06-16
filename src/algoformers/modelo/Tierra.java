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