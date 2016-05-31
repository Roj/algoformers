package algoformers;

public abstract class Algoformer implements Ubicable {
	protected ModoAlgoformer modoAlgoformer;
	protected TipoAlgoformer tipoAlgoformer;
    protected Posicion posicion;
	
	protected String nombre;
	protected int vida;
	
	public Algoformer(TipoAlgoformer tipo, ModoAlgoformer modo) {
		modoAlgoformer = modo;
		tipoAlgoformer = tipo;
		
		vida = tipoAlgoformer.obtenerPuntosVida();
	}

    public void establecerPosicion(Posicion pos) {
    	this.posicion = pos;
    }
    public Posicion obtenerPosicion(){
    	return this.posicion;
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
	
	public abstract void atacar(Algoformer algoformer);
	public abstract void atacar(Autobot algoformer);
	public abstract void atacar(Decepticon algoformer);
	
	@Override
    public void superponer(Algoformer algoformer) {
        throw new NoSuperponibleException();
    }
}
