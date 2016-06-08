package algoformers;

public class Espinas extends Tierra {
	@Override
	public void accionSobreAlgoformer(Algoformer alg) {		
		alg.setVida(alg.obtenerVida() * 95 / 100);
	}
}
