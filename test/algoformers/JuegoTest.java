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
    public void testVerificarTurnoLanzaExcepcionDebeLanzarExcepcion() {
        String jugador1 = "Juan";
        String jugador2 = "John";
        Juego juego = new Juego(jugador1,jugador2,3,3);
        
        Jugador jugadorJuan = juego.obtenerJugadorActual();
        juego.avanzarTurno();
        
        juego.verificarTurno(jugadorJuan);
    }
    @Test
    public void testAtacarExitosamenteCambiaTurno() {
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,3,3);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Jugador jugador2 = juego.obtenerJugadorEnEspera();
        Tablero tablero = juego.obtenerTablero();
        tablero.colocarAlgoformer(new Posicion(1,1),jugador1.obtenerAlgoformer(0));
        tablero.colocarAlgoformer(new Posicion(2,1),jugador2.obtenerAlgoformer(0));
        
        Assert.assertTrue(juego.verificarTurno(jugador1));
        jugador1.atacarPosicion(0,new Posicion(2,1));
        
        Assert.assertTrue(juego.verificarTurno(jugador2));
    }
    @Test
    public void testAtacarMuyLejosNoCambiaTurno() {
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,30,30);
        Jugador jugador1 = juego.obtenerJugadorActual();
        
        Tablero tablero = juego.obtenerTablero();
        tablero.colocarAlgoformer(new Posicion(1,1),jugador1.obtenerAlgoformer(0));
        
        
        Assert.assertTrue(juego.verificarTurno(jugador1));

        try {
            jugador1.atacarPosicion(0,new Posicion(20,1));
            
            //Si esto sigue ejecutando caimos en un error
            throw new AssertionError();
        } catch(ObjetivoMuyLejosException e) {
            Assert.assertTrue(juego.verificarTurno(jugador1));
        }
    }
    @Test
    public void testAtacarMismoBandoNoCambiaTurno() {
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,30,30);
        Jugador jugador1 = juego.obtenerJugadorActual();
        
        Tablero tablero = juego.obtenerTablero();
        tablero.colocarAlgoformer(new Posicion(1,1),jugador1.obtenerAlgoformer(0));
        tablero.colocarAlgoformer(new Posicion(2,1),jugador1.obtenerAlgoformer(1));
        
        Assert.assertTrue(juego.verificarTurno(jugador1));
        try {
            jugador1.atacarPosicion(0,new Posicion(2,1));
            //Si esto sigue ejecutando caimos en un error
            throw new AssertionError();
        } catch(AtaqueInvalidoException e) {
            Assert.assertTrue(juego.verificarTurno(jugador1));
        }        
    }
    @Test 
    public void testAtacarAlgoformerEnemigoLeBajaVida() {
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,3,3);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Jugador jugador2 = juego.obtenerJugadorEnEspera();
        Tablero tablero = juego.obtenerTablero();
        tablero.colocarAlgoformer(new Posicion(1,1),jugador1.obtenerAlgoformer(0));
        tablero.colocarAlgoformer(new Posicion(2,1),jugador2.obtenerAlgoformer(0));
        
        int vidaEnemigoOriginal = jugador2.obtenerAlgoformer(0).obtenerVida();
        
        Assert.assertTrue(juego.verificarTurno(jugador1));
        jugador1.atacarPosicion(0,new Posicion(2,1));
        
        Assert.assertTrue(vidaEnemigoOriginal > jugador2.obtenerAlgoformer(0).obtenerVida());
    }
    @Test
    public void testAtacarAlVacioNoCambiaTurno() {
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,30,30);
        Jugador jugador1 = juego.obtenerJugadorActual();
        
        Tablero tablero = juego.obtenerTablero();
        tablero.colocarAlgoformer(new Posicion(1,1),jugador1.obtenerAlgoformer(0));
        
        Assert.assertTrue(juego.verificarTurno(jugador1));

        try {
            jugador1.atacarPosicion(0,new Posicion(2,1));
            
            //Si esto sigue ejecutando caimos en un error
            throw new AssertionError();
        } catch(AtaqueInvalidoException e) {
            Assert.assertTrue(juego.verificarTurno(jugador1));
        }    
    }
    @Test (expected=FueraDeRangoDeTableroException.class)
    public void testAtacarFueraDeTableroException(){
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,3,3);
        Jugador jugador1 = juego.obtenerJugadorActual();
        
        Tablero tablero = juego.obtenerTablero();
        tablero.colocarAlgoformer(new Posicion(1,1),jugador1.obtenerAlgoformer(0));
        
        jugador1.atacarPosicion(0,new Posicion(4,4));    
    }
    
    @Test
    public void testAtacarFueraDeTableroNoCambiaJugador(){
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,3,3);
        Jugador jugador1 = juego.obtenerJugadorActual();
        
        Tablero tablero = juego.obtenerTablero();
        tablero.colocarAlgoformer(new Posicion(1,1),jugador1.obtenerAlgoformer(0));
        
        Assert.assertTrue(juego.verificarTurno(jugador1));

        try {
            jugador1.atacarPosicion(0,new Posicion(4,4));
            
            throw new AssertionError();
        } catch(FueraDeRangoDeTableroException e) {
            Assert.assertTrue(juego.verificarTurno(jugador1));
        }    
    }
    @Test
    public void testMoverExitosamente(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        Juego juego = new Juego(nombre1,nombre2,3,3);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Tablero tablero = juego.obtenerTablero();
        Posicion posicionInicial = new Posicion(1,1);
        tablero.colocarAlgoformer(posicionInicial,jugador1.obtenerAlgoformer(0));
        
        Algoformer algo1 = jugador1.obtenerAlgoformer(0);
        Assert.assertTrue(algo1.obtenerPosicion()==posicionInicial);
        
        Posicion posicionFinal = new Posicion(2,1);
        jugador1.moverAPosicion(0,posicionFinal);
        Assert.assertTrue(algo1.obtenerPosicion()==posicionFinal);
    }
    @Test
    public void testMoverExitosamenteCambiaJugador(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        Juego juego = new Juego(nombre1,nombre2,3,3);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Jugador jugador2 = juego.obtenerJugadorEnEspera();
        Tablero tablero = juego.obtenerTablero();
        Posicion posicionInicial = new Posicion(1,1);
        tablero.colocarAlgoformer(posicionInicial,jugador1.obtenerAlgoformer(0));
        
        Assert.assertTrue(juego.verificarTurno(jugador1));
        Posicion posicionFinal = new Posicion(2,1);
        jugador1.moverAPosicion(0,posicionFinal);
        
        Assert.assertTrue(juego.verificarTurno(jugador2));        
    }
    @Test
    public void testMoverMuyLejosNoCambiaJugador(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        Juego juego = new Juego(nombre1,nombre2,30,30);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Tablero tablero = juego.obtenerTablero();
        Posicion posicionInicial = new Posicion(1,1);
        tablero.colocarAlgoformer(posicionInicial,jugador1.obtenerAlgoformer(0));
        
        Assert.assertTrue(juego.verificarTurno(jugador1));
        
        try{
            Posicion posicionFinal = new Posicion(15,1);
            jugador1.moverAPosicion(0,posicionFinal);
            throw new AssertionError();
        } catch(ObjetivoMuyLejosException e) {
            Assert.assertTrue(juego.verificarTurno(jugador1));
        }        
    }
    @Test
    public void testMoverAPosicionConAlgoformerNoCambiaJugador(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        Juego juego = new Juego(nombre1,nombre2,30,30);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Jugador jugador2 = juego.obtenerJugadorEnEspera();
        Tablero tablero = juego.obtenerTablero();
        tablero.colocarAlgoformer(new Posicion(1,1),jugador1.obtenerAlgoformer(0));
        tablero.colocarAlgoformer(new Posicion(1,2),jugador2.obtenerAlgoformer(0));

        Assert.assertTrue(juego.verificarTurno(jugador1));
        
        try{
            Posicion posicionFinal = new Posicion(1,2);
            jugador1.moverAPosicion(0,posicionFinal);
            throw new AssertionError();
        } catch(NoSuperponibleException e) {
            Assert.assertTrue(juego.verificarTurno(jugador1));
        }        
    }
    @Test(expected=ObjetivoMuyLejosException.class)
    public void testMoverAPosicionMuyLejosObjetoMuyLejosException(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        Juego juego = new Juego(nombre1,nombre2,30,30);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Tablero tablero = juego.obtenerTablero();
        Posicion posicionInicial = new Posicion(1,1);
        tablero.colocarAlgoformer(posicionInicial,jugador1.obtenerAlgoformer(0));
        
        Posicion posicionFinal = new Posicion(15,1);
        jugador1.moverAPosicion(0,posicionFinal);        
    }
    @Test(expected=NoSuperponibleException.class)
    public void testMoverAPosicionConAlgoformerNoSuperponibleException(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        Juego juego = new Juego(nombre1,nombre2,30,30);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Jugador jugador2 = juego.obtenerJugadorEnEspera();
        Tablero tablero = juego.obtenerTablero();
        tablero.colocarAlgoformer(new Posicion(1,1),jugador1.obtenerAlgoformer(0));
        tablero.colocarAlgoformer(new Posicion(1,2),jugador2.obtenerAlgoformer(0));
        
        Posicion posicionFinal = new Posicion(1,2);
        jugador1.moverAPosicion(0,posicionFinal);        
    }
    @Test(expected=FueraDeRangoDeTableroException.class)
    public void testMoverFueraDeTableroException(){
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,3,3);
        Jugador jugador1 = juego.obtenerJugadorActual();
        
        Tablero tablero = juego.obtenerTablero();
        tablero.colocarAlgoformer(new Posicion(1,1),jugador1.obtenerAlgoformer(0));
        
        jugador1.moverAPosicion(0,new Posicion(4,4));
    }
    @Test
    public void testMoverFueraDeTableroNoCambiaJugador(){
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,3,3);
        Jugador jugador1 = juego.obtenerJugadorActual();
        
        Tablero tablero = juego.obtenerTablero();
        tablero.colocarAlgoformer(new Posicion(1,1),jugador1.obtenerAlgoformer(0));
     
        
        Assert.assertTrue(juego.verificarTurno(jugador1));
        
        try{
            jugador1.moverAPosicion(0,new Posicion(4,4));
            throw new AssertionError();
        } catch(FueraDeRangoDeTableroException e) {
            Assert.assertTrue(juego.verificarTurno(jugador1));
        }        

    }
    @Test
    public void testUbicarChispaEnCentroDelTablero(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        Juego juego = new Juego(nombre1,nombre2,30,30);

        Tablero tablero = juego.obtenerTablero();
        Ubicable chispa = tablero.obtenerUbicable(new Posicion(15, 15));
        
        Assert.assertTrue(chispa instanceof ChispaSuprema);     
    }
    
}
