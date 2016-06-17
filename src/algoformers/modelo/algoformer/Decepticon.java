package algoformers.modelo.algoformer;

import algoformers.modelo.juego.AtaqueInvalidoException;
import algoformers.modelo.tablero.Ubicable;

public class Decepticon extends Algoformer {	
    public Decepticon(int vida, ModoAlgoformer modo1, ModoAlgoformer modo2) {
            super(vida, modo1, modo2);
    }	
    @Override
    public void atacar(Ubicable ubicable) {
        this.revisarDistanciaAtaque(ubicable.obtenerPosicion());
        ubicable.recibirAtaque(this);
    }
    @Override
    public void recibirAtaque(Decepticon algoformer) {
            throw new AtaqueInvalidoException();
    }
    @Override
    public void recibirAtaque(Autobot algoformer) {        
        this.avisarABuffsAtacado();
        vida -= algoformer.obtenerPuntosAtaque();
        //TODO: revisar muerte	
    }
}
