package algoformers;

public class Decepticon extends Algoformer {	
    public Decepticon(int vida, ModoAlgoformer modo1, ModoAlgoformer modo2) {
            super(vida, modo1, modo2);
    }	
    @Override
    public void atacar(Algoformer algoformer) {
            algoformer.atacar(this);
    }
    @Override
    public void atacar(Decepticon algoformer) {
            throw new AtaqueInvalidoException();
    }
    @Override
    public void atacar(Autobot algoformer) {
            vida -= algoformer.obtenerPuntosAtaque();

            //etc de cosas al atacar
    }
}
