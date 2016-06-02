/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers;

/**
 *
 * @author joaquintz
 */
public class Juego {
    private Jugador jugadorActual;
    private Jugador otroJugador;
    private Tablero tablero;
    public Juego(String nombreJugadorA, String nombreJugadorB, int dim1, int dim2) {
        this.tablero = new Tablero(dim1,dim2);
        
        this.jugadorActual = new Jugador(nombreJugadorA,tablero, this);
        this.otroJugador = new Jugador(nombreJugadorB,tablero, this);
     
        //Agregar chispa en el centro del tablero
        this.tablero.agregarUbicable(new Posicion(dim1/2, dim2/2), new ChispaSuprema());
        
        //Creacion de algoformers
        this.agregarAlgoformers();
        //Los algoformers seran ubicados por el jugador
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
