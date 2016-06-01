package algoformers;

public class Autobot extends Algoformer {	
	public Autobot(TipoAlgoformer tipo, ModoAlgoformer modo) {
		super(tipo, modo);
	}		
	public void atacar(Algoformer algoformer) {
		algoformer.atacar(this);
	}
	public void atacar(Autobot algoformer) {
		throw new AtaqueInvalidoException();
	}
	public void atacar(Decepticon algoformer) {
		vida -= algoformer.obtenerPuntosAtaque();
		
		//etc de cosas al atacar
	}	
}
