package algoformers;

public class Optimus implements TipoAlgoformer {
	
	private int puntosVida = 500;
	private int puntosAtaqueHumanoide = 50;
	private int distanciaAtaqueHumanoide = 2;
	private int velocidadHumanoide = 2;
	
	private int puntosAtaqueAlterno = 15;
	private int distanciaAtaqueAlterno = 4;
	private int velocidadAlterno = 5;
	
	public int obtenerPuntosVida() {
		return puntosVida;
	}
	public int obtenerPuntosAtaque(ModoHumanoide modoAlgoformer) {
		return puntosAtaqueHumanoide;
	}
	public int obtenerPuntosAtaque(ModoAlterno modoAlgoformer) {
		return puntosAtaqueAlterno;
	}	
	public int obtenerDistanciaAtaque(ModoHumanoide modoAlgoformer) {
		return distanciaAtaqueHumanoide;
	}
	public int obtenerDistanciaAtaque(ModoAlterno modoAlgoformer) {
		return distanciaAtaqueAlterno;
	}
	public int obtenerVelocidad(ModoHumanoide modoAlgoformer) {
		return velocidadHumanoide;
	}
	public int obtenerVelocidad(ModoAlterno modoAlgoformer) {
		return velocidadAlterno;
	}	
}
