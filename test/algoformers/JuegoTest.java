/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author joaquintz
 */
public class JuegoTest {
    @Test
    public void testJuegoCreaConNombresCorrectos() {
        String jugador1 = "Juan";
        String jugador2 = "John";
        Juego juego = new Juego(jugador1,jugador2,3,3);
        
        Assert.assertTrue(jugador1.equals(juego.obtenerJugadorActual().obtenerNombre()));
        
        juego.avanzarTurno();
        
        Assert.assertTrue(jugador2.equals(juego.obtenerJugadorActual().obtenerNombre()));
    }
    @Test
    public void testVerificarTurnoEsElJugadorActual() {
        String jugador1 = "Juan";
        String jugador2 = "John";
        Juego juego = new Juego(jugador1,jugador2,3,3);
        
        Jugador jugadorJuan = juego.obtenerJugadorActual();
        juego.avanzarTurno();
        Jugador jugadorJohn = juego.obtenerJugadorActual();
        
        juego.avanzarTurno();
        
        
        Assert.assertTrue(juego.verificarTurno(jugadorJuan));
        
        juego.avanzarTurno();
        
        
        Assert.assertTrue(juego.verificarTurno(jugadorJohn));
    }
    @Test(expected=NoEsSuTurnoException.class)
    public void testVerificarTurnoLanzaExcepcion() {
        String jugador1 = "Juan";
        String jugador2 = "John";
        Juego juego = new Juego(jugador1,jugador2,3,3);
        
        Jugador jugadorJuan = juego.obtenerJugadorActual();
        juego.avanzarTurno();
        
        juego.verificarTurno(jugadorJuan);
    }
    
    
}
