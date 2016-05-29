package algoformers;

public class ModoAlterno implements ModoAlgoformer { 
	public ModoAlgoformer cambiarModo() {
		return new ModoHumanoide();
	}
	
	public int obtenerPuntosAtaque(TipoAlgoformer tipo) {
		return tipo.obtenerPuntosAtaque(this);
	}
	
	public int obtenerDistanciaAtaque(TipoAlgoformer tipo) {
		return tipo.obtenerDistanciaAtaque(this);
	}
	
	public int obtenerVelocidad(TipoAlgoformer tipo) {
		return tipo.obtenerVelocidad(this);
	}
}
