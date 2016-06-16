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
    public void ajustarPuntosDeMovimiento(Movimiento mov, ModoAereo modo) {
        mov.modificarPuntosDeMovimiento(-1);
    }
    @Override
    public void ajustarPuntosDeMovimiento(Movimiento mov, ModoTerrestre modo) {
        mov.modificarPuntosDeMovimiento(-1);
    }
    @Override
    public void ajustarPuntosDeMovimiento(Movimiento mov, ModoHumanoide modo) {
        mov.modificarPuntosDeMovimiento(-1);
    }
    
}
