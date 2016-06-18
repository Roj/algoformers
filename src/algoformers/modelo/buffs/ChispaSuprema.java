package algoformers.modelo.buffs;

import algoformers.modelo.algoformer.Algoformer;
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
	
}
