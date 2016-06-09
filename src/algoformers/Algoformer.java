package algoformers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public abstract class Algoformer implements Ubicable {
    protected ModoAlgoformer modoActual;
    protected ModoAlgoformer otroModo;
    
    protected Posicion posicion;

    protected String nombre;
    protected int vida;
    protected int puntosMovimiento;
    
    protected HashMap<Integer,Buff> buffs;
    
    public Algoformer(int vida, ModoAlgoformer modo1, ModoAlgoformer modo2) {
        this.vida = vida;
        this.modoActual = modo1;
        this.otroModo = modo2;
        this.buffs = new HashMap<>();
        
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
        //verificamos que la nueva superficie acepte la superficie
        try {
            this.otroModo.aceptarSuperficie(this.posicion.obtenerSuperficie(), this);
            this.modoActual = this.otroModo;
            this.otroModo = aux;
        } catch (SuperficieNoAtravesableException e) {
            throw new NoSePuedeTransformarException();
        }
        
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
        throw new NoSuperponibleException();
    }
    
    public boolean revisarVelocidad(Posicion destino) {
        if(this.posicion.calcularDistancia(destino) > this.obtenerVelocidad()) {
            throw new ObjetivoMuyLejosException();
        }
        return true;
    }
    public boolean verificarMovida() {
        //Obtenemos el valor en el que quedaria el algoformer
        int puntosIniciales = this.puntosMovimiento;
        this.modoActual.ajustarPuntosDeMovimiento(this.posicion.obtenerSuperficie(),this);
        int puntosModificados = this.puntosMovimiento;
        this.puntosMovimiento = puntosIniciales;
        
    	if (puntosModificados < 0)
    		throw new ObjetivoMuyLejosException(); // Por ahora está esta excepcion
    	
    	return true;
    }        
    public void mover(Posicion nuevaPosicion) {
        //verificacion
        this.avisarABuffsMovida();
        this.verificarMovida();
        this.modoActual.aceptarSuperficie(nuevaPosicion.obtenerSuperficie(),this);
        //todo bien, nos cambiamos
        this.modoActual.ajustarPuntosDeMovimiento(this.posicion.obtenerSuperficie(),this);
        this.establecerPosicion(nuevaPosicion);
    }       

    ModoAlgoformer obtenerModoActual() {
        return this.modoActual;
    }

    public int obtenerPuntosDeMovimiento() {
        return this.puntosMovimiento;
    }
    
    public void modificarPuntosDeMovimiento(int i) {
        this.puntosMovimiento = this.puntosMovimiento+i;
    }
    public void restablecerPuntosDeMovimiento() {
        this.puntosMovimiento = this.modoActual.obtenerVelocidad();
    }
    public void pasarTurno() {
        //en el futuro deberia tambien avisarle a los buffs
        this.avisarABuffsPasarTurno();
        this.restablecerPuntosDeMovimiento();
    }
    public void agregarBuff(Buff buff) {
        Buff existente = this.buffs.get(buff.hashCode());
        try {
            existente.repetir(this);
        } catch(NullPointerException e) {
            this.buffs.put(buff.hashCode(), buff);
            buff.accionSobreAlgoformer(this);
        }
        
    }
    public void borrarBuff(Buff buff) {
        this.buffs.remove(buff.hashCode());
    }
    public void avisarABuffsMovida() {

        for(Entry<Integer, Buff> entry : this.buffs.entrySet()) {
            Buff actual = entry.getValue();
            actual.avisarMovimiento(this);
        
        }
    }
    public void avisarABuffsPasarTurno() {

        for(Entry<Integer, Buff> entry : this.buffs.entrySet()) {
            Buff actual = entry.getValue();
            actual.pasarTurno(this);
        
        }
    }
        
    
}
