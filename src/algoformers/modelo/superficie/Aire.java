package algoformers.modelo.superficie;

import algoformers.modelo.algoformer.ModoAereo;
import algoformers.modelo.algoformer.ModoHumanoide;
import algoformers.modelo.algoformer.ModoTerrestre;
import algoformers.modelo.Movimiento;

public abstract class Aire extends Superficie { 
    
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
