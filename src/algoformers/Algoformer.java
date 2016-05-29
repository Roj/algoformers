package algoformers;

public class Algoformer implements Ubicable {
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
	@Override
    	public void superponer(Tablero tablero, Algoformer algoformer) {
        	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	}
}
