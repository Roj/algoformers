package algoformers.modelo.algoformer;

import algoformers.modelo.juego.AtaqueInvalidoException;
import algoformers.modelo.tablero.Ubicable;
import algoformers.vista.Casilla;
import algoformers.vista.VistaAlgoformer;

public class Autobot extends Algoformer {	
    public Autobot(int vida, ModoAlgoformer modo1, ModoAlgoformer modo2,VistaAlgoformer vista) {
            super(vida, modo1, modo2,vista);
    }		
    @Override
    public void atacar(Ubicable ubicable) {
        super.atacar(ubicable);
        ubicable.recibirAtaque(this);
    }
    @Override
    public void recibirAtaque(Autobot algoformer) {
            throw new AtaqueInvalidoException();
    }
    @Override
    public void recibirAtaque(Decepticon algoformer) {        
        this.avisarABuffsAtacado();
        vida -= algoformer.obtenerPuntosAtaque();
        //TODO: revisar muerte	
    }
   
}
