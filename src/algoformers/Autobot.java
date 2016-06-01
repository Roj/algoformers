package algoformers;

public class Autobot extends Algoformer {	
    public Autobot(int vida, ModoAlgoformer modo1, ModoAlgoformer modo2) {
            super(vida, modo1, modo2);
    }		
    @Override
    public void atacar(Ubicable ubicable) {
        this.revisarDistanciaAtaque(ubicable.obtenerPosicion());
        ubicable.recibirAtaque(this);
    }
    @Override
    public void recibirAtaque(Autobot algoformer) {
            throw new AtaqueInvalidoException();
    }
    @Override
    public void recibirAtaque(Decepticon algoformer) {
            vida -= algoformer.obtenerPuntosAtaque();

            //etc de cosas al atacar
    }	
}
