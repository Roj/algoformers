package algoformers.modelo.algoformer;

import algoformers.modelo.juego.Movimiento;
import algoformers.modelo.superficie.Superficie;

public class ModoHumanoide extends ModoAlgoformer { 	
    public ModoHumanoide(int puntosAtaque, int distanciaAtaque,int velocidad) {
        super(puntosAtaque,distanciaAtaque,velocidad);
    }

    @Override
    public void aceptarSuperficie(Superficie sup, Algoformer algof) {
        sup.accionSobreAlgoformer(this, algof);
    }
    @Override
    public void ajustarPuntosDeMovimiento(Movimiento mov, Superficie sup) {
        sup.ajustarPuntosDeMovimiento(mov,this);
    }
}
