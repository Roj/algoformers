package algoformers.modelo.algoformer;

import algoformers.modelo.Movimiento;
import algoformers.modelo.superficie.NoSePuedeTransformarException;
import algoformers.modelo.NoSuperponibleException;
import algoformers.modelo.ObjetivoMuyLejosException;
import algoformers.modelo.Posicion;
import algoformers.modelo.superficie.SuperficieNoAtravesableException;
import algoformers.modelo.Ubicable;
import algoformers.modelo.buffs.Buff;
import java.util.HashSet;


public abstract class Algoformer implements Ubicable {
    protected ModoAlgoformer modoActual;
    protected ModoAlgoformer otroModo;
    
    protected Posicion posicion;

    protected String nombre;
    protected int vida;
    
    protected HashSet<Buff> buffs;
    
    public Algoformer(int vida, ModoAlgoformer modo1, ModoAlgoformer modo2) {
        this.vida = vida;
        this.modoActual = modo1;
        this.otroModo = modo2;
        this.buffs = new HashSet<>();
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
    public void mover(Posicion nuevaPosicion) {
        //verificacion
        this.avisarABuffsMovida();
        this.modoActual.aceptarSuperficie(nuevaPosicion.obtenerSuperficie(),this);
        //todo bien, nos cambiamos
        this.establecerPosicion(nuevaPosicion);
    }       

    public ModoAlgoformer obtenerModoActual() {
        return this.modoActual;
    }

    public void pasarTurno() {
        //en el futuro deberia tambien avisarle a los buffs
        this.avisarABuffsPasarTurno();
    }
    public void agregarBuff(Buff buff) {
        if(!this.buffs.contains(buff)) {
            this.buffs.add(buff);
            buff.accionSobreAlgoformer(this);
        }
        
        
    }
    public void borrarBuff(Buff buff) {
        this.buffs.remove(buff);
    }
    public void avisarABuffsMovida() {
        for(Buff actual: this.buffs) {
            actual.avisarMovimiento(this);
        }
    }
    public void avisarABuffsPasarTurno() {
        for(Buff actual: this.buffs) {
            actual.pasarTurno(this);
        }
    }
    public void ajustarPuntosDeMovimiento(Movimiento mov) {
        this.modoActual.ajustarPuntosDeMovimiento(mov,this.posicion.obtenerSuperficie());
    }
    public void avisarABuffsAtacado(){
        for(Buff actual: this.buffs) {
            actual.avisarAtaque(this);
        }
    }
    
}
