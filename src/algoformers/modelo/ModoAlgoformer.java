package algoformers.modelo;

public abstract class ModoAlgoformer { 
	
    protected int puntosAtaque;
    protected int velocidad;
    protected int distanciaAtaque;

    public ModoAlgoformer(int puntosAtaque, int distanciaAtaque,int velocidad) {
        this.puntosAtaque = puntosAtaque;
        this.velocidad = velocidad;
        this.distanciaAtaque = distanciaAtaque;
    }

    public int obtenerPuntosAtaque() {
        return this.puntosAtaque;
    }
    public int obtenerVelocidad() {
        return this.velocidad;
    }
    public int obtenerDistanciaAtaque() {
        return this.distanciaAtaque;
    }
    public void establecerPuntosAtaque(int puntosAtaqueNuevos) {
        this.puntosAtaque = puntosAtaqueNuevos;
    }
    public void establecerVelocidad(int nuevaVelocidad) {
        this.velocidad = nuevaVelocidad;
    }
    public abstract void aceptarSuperficie(Superficie sup, Algoformer algof);
    public abstract void ajustarPuntosDeMovimiento(Movimiento mov, Superficie sup);
}
