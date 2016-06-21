package algoformers.modelo.buffs;

import algoformers.modelo.algoformer.Algoformer;
import algoformers.vista.Casilla;
import java.util.Iterator;

public class ChispaSuprema implements Buff {
  
    @Override
    public void avisarAtaque(Algoformer algof) {
        //no se utiliza en la chispa suprema
    }

    @Override
    public void avisarMovimiento(Algoformer algof) {
        //no se utiliza en la chispa suprema
    }


    @Override
    public void accionSobreAlgoformer(Algoformer algof) {
        //Falta implementar
    }

    @Override
    public void pasarTurno(Algoformer algoformer, Iterator iter) {
        //no se utiliza en la chispa suprema
    }

    @Override
    public void setEfecto(Casilla casilla) {
        //No se implementa porque no es un bonus, no se visualiza
    }
	
}
