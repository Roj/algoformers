package algoformers;

<<<<<<< HEAD
public class Algoformer implements Ubicable {
	protected ModoAlgoformer modoAlgoformer;
	protected TipoAlgoformer tipoAlgoformer;
        protected Posicion posicion;
=======
public abstract class Algoformer implements Ubicable {
	protected ModoAlgoformer modoAlgoformer;
	protected TipoAlgoformer tipoAlgoformer;
    protected Posicion posicion;
>>>>>>> f0f3b25d96b573f9fe22b5c25e57d3b8c3d0256d
	
	protected String nombre;
	protected int vida;
	
	public Algoformer(TipoAlgoformer tipo, ModoAlgoformer modo) {
		modoAlgoformer = modo;
		tipoAlgoformer = tipo;
		
		vida = tipoAlgoformer.obtenerPuntosVida();
<<<<<<< HEAD
	}	
        public void establecerPosicion(Posicion pos) {
            this.posicion = pos;
        }
        public Posicion obtenerPosicion(){
            return this.posicion;
        }
=======
	}

    public void establecerPosicion(Posicion pos) {
    	this.posicion = pos;
    }
    public Posicion obtenerPosicion(){
    	return this.posicion;
    }
>>>>>>> f0f3b25d96b573f9fe22b5c25e57d3b8c3d0256d
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
<<<<<<< HEAD
	public void atacar(Algoformer algoformer) {
		
	}
	@Override
    	public void superponer(Algoformer algoformer) {
        	throw new NoSuperponibleException();
    	}
=======
	
	public abstract void atacar(Algoformer algoformer);
	public abstract void atacar(Autobot algoformer);
	public abstract void atacar(Decepticon algoformer);
	
	@Override
    public void superponer(Algoformer algoformer) {
        throw new NoSuperponibleException();
    }
>>>>>>> f0f3b25d96b573f9fe22b5c25e57d3b8c3d0256d
}
