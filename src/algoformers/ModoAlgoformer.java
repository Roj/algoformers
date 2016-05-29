package algoformers;

public interface ModoAlgoformer { 
	public abstract ModoAlgoformer cambiarModo();
	
	public abstract int obtenerPuntosAtaque(TipoAlgoformer tipo);
	public abstract int obtenerVelocidad(TipoAlgoformer tipo);
	public abstract int obtenerDistanciaAtaque(TipoAlgoformer tipo);
}
