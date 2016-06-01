package algoformers;

public class Decepticon extends Algoformer {	
	public Decepticon(TipoAlgoformer tipo, ModoAlgoformer modo) {
		super(tipo, modo);
	}		
	public void atacar(Algoformer algoformer) {
		algoformer.atacar(this);
	}
	public void atacar(Decepticon algoformer) {
		throw new AtaqueInvalidoException();
	}
	public void atacar(Autobot algoformer) {
		vida -= algoformer.obtenerPuntosAtaque();
		
		//etc de cosas al atacar
	}
}
