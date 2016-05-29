package algoformers;

public interface TipoAlgoformer {
	public abstract int obtenerPuntosVida();
	public abstract int obtenerPuntosAtaque(ModoHumanoide modoAlgoformer);
	public abstract int obtenerPuntosAtaque(ModoAlterno modoAlgoformer);
	public abstract int obtenerDistanciaAtaque(ModoHumanoide modoAlgoformer);
	public abstract int obtenerDistanciaAtaque(ModoAlterno modoAlgoformer);
	public abstract int obtenerVelocidad(ModoHumanoide modoAlgoformer);
	public abstract int obtenerVelocidad(ModoAlterno modoAlgoformer);
}
