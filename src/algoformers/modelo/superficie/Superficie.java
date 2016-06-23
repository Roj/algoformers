package algoformers.modelo.superficie;

import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.algoformer.ModoAereo;
import algoformers.modelo.algoformer.ModoAlgoformer;
import algoformers.modelo.algoformer.ModoHumanoide;
import algoformers.modelo.algoformer.ModoTerrestre;
import algoformers.modelo.juego.Movimiento;
import algoformers.vista.Casilla;

public abstract class Superficie {
    public abstract void accionSobreAlgoformer(ModoAereo modo, Algoformer algof);
    public abstract void accionSobreAlgoformer(ModoTerrestre modo, Algoformer algof);
    public abstract void accionSobreAlgoformer(ModoHumanoide modo, Algoformer algof);
    
    public abstract void ajustarPuntosDeMovimiento(Movimiento mov, ModoAereo modo);
    public abstract void ajustarPuntosDeMovimiento(Movimiento mov, ModoTerrestre modo);
    public abstract void ajustarPuntosDeMovimiento(Movimiento mov, ModoHumanoide modo);

    public abstract void setSuperficie(Casilla casilla);

    public abstract void puedeSerAtravesada(ModoAereo modo);
    public abstract void puedeSerAtravesada(ModoTerrestre modo);
    public abstract void puedeSerAtravesada(ModoHumanoide modo);    
    
}
