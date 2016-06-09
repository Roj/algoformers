package algoformers;

public class ModoHumanoide extends ModoAlgoformer { 	
    public ModoHumanoide(int puntosAtaque, int distanciaAtaque,int velocidad) {
        super(puntosAtaque,distanciaAtaque,velocidad);
    }

    @Override
    public void aceptaPantano() {
        throw new ModoHumanoideNoPasaPorPantano();
    }
}
