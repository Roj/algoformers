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