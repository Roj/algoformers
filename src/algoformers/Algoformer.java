package algoformers;

public abstract class Algoformer implements Ubicable {
    protected ModoAlgoformer modoActual;
    protected ModoAlgoformer otroModo;
    
    protected Posicion posicion;

    protected String nombre;
    protected int vida;
    protected int puntosMovimiento;
    
    public Algoformer(int vida, ModoAlgoformer modo1, ModoAlgoformer modo2) {
        this.vida = vida;
        this.modoActual = modo1;
        this.otroModo = modo2;
        
        this.restablecerPuntosMovimiento();
    }	
    @Override
    public void establecerPosicion(Posicion pos) {
       this.posicion = pos;
    }
    @Override
    public Posicion obtenerPosicion(){
       return this.posicion;
    }
    public void cambiarModo() {
        ModoAlgoformer aux = this.modoActual;
        this.modoActual = this.otroModo;
        this.otroModo = aux;
        
        this.restablecerPuntosMovimiento();
    }
    public void setPuntosMovimiento(int num) {
    	puntosMovimiento = num;
    }
    public void restablecerPuntosMovimiento() {
    	puntosMovimiento = this.obtenerVelocidad();
    }
    public void setVida(int num) {
    	vida = num;
    }
    public int obtenerVida() {
        return vida;
    }
    public int obtenerPuntosAtaque() {
        return modoActual.obtenerPuntosAtaque();
    }
    public int obtenerVelocidad() {
            return modoActual.obtenerVelocidad();
    }	
    public int obtenerDistanciaAtaque() {
        return modoActual.obtenerDistanciaAtaque();
    }	
    public boolean revisarDistanciaAtaque(Posicion destino) {
        if(this.posicion.calcularDistancia(destino) > this.obtenerDistanciaAtaque()) {
        	throw new ObjetivoMuyLejosException();
        }
        return true;
    }
    public void atacar(Ubicable ubicable) {
        this.revisarDistanciaAtaque(ubicable.obtenerPosicion());
    }
    
    @Override
    public void reemplazar(Algoformer algoformer) {
    	algoformer.restablecerPuntosMovimiento();
        throw new NoSuperponibleException();
    }
    
    public boolean revisarVelocidad(Posicion destino) {
        if(this.posicion.calcularDistancia(destino) > this.obtenerVelocidad()) {
            throw new ObjetivoMuyLejosException();
        }
        return true;
    }
    public boolean verificarMovida(Posicion destino) {
    	if (this.puntosMovimiento <= 0)
    		throw new ObjetivoMuyLejosException(); // Por ahora está esta excepcion
    	
    	return true;
       //return this.revisarVelocidad(destino);
    }        
    public void mover(Posicion nuevaPosicion) {
        this.revisarVelocidad(nuevaPosicion);
        this.establecerPosicion(nuevaPosicion);
    }       

    ModoAlgoformer obtenerModoActual() {
        return this.modoActual;
    }

    void puedeAtravesarPantano() {
        this.modoActual.aceptaPantano();
    }

    void modificarPuntosDeMovimiento(int i) {
        this.puntosMovimiento = this.puntosMovimiento+i;
    }
}
