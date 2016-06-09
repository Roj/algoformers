package algoformers;

public class ModoHumanoide extends ModoAlgoformer { 	
    public ModoHumanoide(int puntosAtaque, int distanciaAtaque,int velocidad) {
        super(puntosAtaque,distanciaAtaque,velocidad);
    }

    @Override
    public void aceptarSuperficie(Superficie sup, Algoformer algof) {
        sup.accionSobreAlgoformer(this, algof);
    }
    public void ajustarPuntosDeMovimiento(Superficie sup, Algoformer algof) {
        sup.ajustarPuntosDeMovimiento(this,algof);
    }    
}
