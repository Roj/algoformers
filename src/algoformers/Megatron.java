package algoformers;

public class Megatron implements TipoAlgoformer {
	
	private int puntosVida = 550;
	private int puntosAtaqueHumanoide = 10;
	private int distanciaAtaqueHumanoide = 3;
	private int velocidadHumanoide = 1;
	
	private int puntosAtaqueAlterno = 55;
	private int distanciaAtaqueAlterno = 2;
	private int velocidadAlterno = 8;
	
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
