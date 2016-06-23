package algoformers.modelo.tablero;

import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.algoformer.Autobot;
import algoformers.modelo.algoformer.Decepticon;
import algoformers.modelo.juego.AtaqueInvalidoException;
import algoformers.modelo.juego.Juego;
import algoformers.modelo.juego.Jugador;
import algoformers.modelo.tablero.Posicion;
import algoformers.modelo.tablero.Ubicable;
import algoformers.vista.Casilla;
import java.util.Iterator;

public class ChispaSuprema implements Ubicable {

    Posicion posicion;
    Juego juego;
    Jugador ganador;
    
    
    
    public void establecerJugador(Jugador jugador){
        this.ganador = jugador;
    }
    
    public void establecerJuego(Juego juego){
        //Debe conocer al juego para poder finalizarlo
        this.juego = juego;
    }
    
    @Override
    public void establecerPosicion(Posicion pos) {
        this.posicion = pos;
    }

    @Override
    public Posicion obtenerPosicion() {
        return this.posicion;
    }

    @Override
    public void reemplazar(Algoformer algoformer) {
        //Ganar Juego
        this.juego.finalizarJuego();
    }

    @Override
    public void recibirAtaque(Autobot algoformer) {
        throw new AtaqueInvalidoException();
    }

    @Override
    public void recibirAtaque(Decepticon algoformer) {
        throw new AtaqueInvalidoException();
    }

    @Override
    public void setUbicable(Casilla casilla) {
        casilla.setUbicable(this);
    }

    @Override
    public void puedeSerReemplazado() {
        //Puede ser reemplazado
    }
  

	
}
