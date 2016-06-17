/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.modelo.juego;

import algoformers.modelo.Posicion;
import algoformers.modelo.algoformer.FabricaAlgoformers;
import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.mapa.Mapa;
import algoformers.modelo.superficie.Rocosa;
import java.util.List;

/**
 *
 * @author joaquintz
 */
public class Juego {
    private Jugador jugadorActual;
    private Jugador otroJugador;
    private Tablero tablero;
    public Juego(String nombreJugadorA, String nombreJugadorB, Mapa mapa) {
        this.tablero = new Tablero(mapa);
        
        this.jugadorActual = new Jugador(nombreJugadorA,tablero, this);
        this.otroJugador = new Jugador(nombreJugadorB,tablero, this);
     
        tablero.ubicarChispaEnElCentro();
        
        //Agregar chispa en el centro del tablero
        
        
        //Creacion de algoformers
        this.agregarAlgoformers();
        //Los algoformers seran ubicados por el tablero
        //this.posicionarAlgoformers();
    }
    private void agregarAlgoformers() {
        FabricaAlgoformers fabrica = new FabricaAlgoformers();
        
        this.jugadorActual.agregarAlgoformer(fabrica.crearOptimus());
        this.jugadorActual.agregarAlgoformer(fabrica.crearBumblebee());
        this.jugadorActual.agregarAlgoformer(fabrica.crearRatchet());
        
        this.otroJugador.agregarAlgoformer(fabrica.crearMegatron());
        this.otroJugador.agregarAlgoformer(fabrica.crearBonecrusher());
        this.otroJugador.agregarAlgoformer(fabrica.crearFrenzy());
    }
    
    private void posicionarAlgoformers(){
        List<Algoformer> algoformersJugador1 = this.jugadorActual.obtenerListaAlgoformers();
        List<Algoformer> algoformersJugador2 = this.otroJugador.obtenerListaAlgoformers();
        int dimension = this.tablero.obtenerDimension() - 1;
        for(int i = 0; i<3; i ++){
            this.tablero.colocarAlgoformer(new Posicion(i,1,new Rocosa()), algoformersJugador1.get(i));
            this.tablero.colocarAlgoformer(new Posicion(dimension - i, dimension, new Rocosa()), algoformersJugador2.get(i));
        }
        
    }
    
    public boolean verificarTurno(Jugador jugador) {
        if(!jugador.equals(jugadorActual)) {
            throw new NoEsSuTurnoException();
        }
        return true;
    }
    
    public Jugador obtenerJugadorActual() {
        return this.jugadorActual;
    }
    public Jugador obtenerJugadorEnEspera() {
        return this.otroJugador;
    }
    public Tablero obtenerTablero() {
        return this.tablero;
    }
    public void avanzarTurno() {
        Jugador aux = this.jugadorActual;
        this.jugadorActual = this.otroJugador;
        this.otroJugador = aux;
    }
}
