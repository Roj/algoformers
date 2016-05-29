package algoformers;

public class Algoformer {
	protected ModoAlgoformer modoAlgoformer;
	protected TipoAlgoformer tipoAlgoformer;
	
	protected String nombre;
	protected int vida;
	
	public Algoformer(TipoAlgoformer tipo, ModoAlgoformer modo) {
		modoAlgoformer = modo;
		tipoAlgoformer = tipo;
		
		vida = tipoAlgoformer.obtenerPuntosVida();
	}	
	public void cambiarModo() {
		modoAlgoformer = modoAlgoformer.cambiarModo();
	}
	public int obtenerVida() {
		return vida;
	}
	public int obtenerPuntosAtaque() {
		return modoAlgoformer.obtenerPuntosAtaque(tipoAlgoformer);
	}
	public int obtenerVelocidad() {
		return modoAlgoformer.obtenerVelocidad(tipoAlgoformer);
	}	
	public int obtenerDistanciaAtaque() {
		return modoAlgoformer.obtenerDistanciaAtaque(tipoAlgoformer);
	}	
	public void atacar(Algoformer algoformer) {
		
	}
}
