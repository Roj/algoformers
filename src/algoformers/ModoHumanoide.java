package algoformers;

public class ModoHumanoide implements ModoAlgoformer { 	
	public ModoAlgoformer cambiarModo() {
		return new ModoAlterno();
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
