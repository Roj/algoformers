package algoformers;

public class Autobot extends Algoformer {	
    public Autobot(int vida, ModoAlgoformer modo1, ModoAlgoformer modo2) {
            super(vida, modo1, modo2);
    }		
    @Override
    public void atacar(Algoformer algoformer) {
            algoformer.atacar(this);
    }
    @Override
    public void atacar(Autobot algoformer) {
            throw new AtaqueInvalidoException();
    }
    @Override
    public void atacar(Decepticon algoformer) {
            vida -= algoformer.obtenerPuntosAtaque();

            //etc de cosas al atacar
    }	
}
