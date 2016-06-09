/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
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
        
        Algoformer algoformerj1 = jugador1.obtenerListaAlgoformers().get(0);
        Algoformer algoformerj2 = jugador2.obtenerListaAlgoformers().get(0);
        
        tablero.colocarAlgoformer(new Posicion(1,1, new Rocosa()),algoformerj1);
        tablero.colocarAlgoformer(new Posicion(2,1, new Rocosa()),algoformerj2);
        
        
        
        Assert.assertTrue(juego.verificarTurno(jugador1));
        jugador1.atacarPosicion(algoformerj1,new Posicion(2,1, new Rocosa()));
        
        Assert.assertTrue(juego.verificarTurno(jugador2));
        
        
    }
    @Test
    public void testAtacarMuyLejosNoCambiaTurno() {
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,30,30);
        Jugador jugador1 = juego.obtenerJugadorActual();
        
        Tablero tablero = juego.obtenerTablero();
        
        Algoformer algoformer = jugador1.obtenerListaAlgoformers().get(0);
        
        tablero.colocarAlgoformer(new Posicion(1,1, new Rocosa()),algoformer);
        
        Assert.assertTrue(juego.verificarTurno(jugador1));

        try {
            jugador1.atacarPosicion(algoformer,new Posicion(20,1, new Rocosa()));
            
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
        Algoformer algoformer1 = jugador1.obtenerListaAlgoformers().get(0);
        Algoformer algoformer2 = jugador1.obtenerListaAlgoformers().get(1);
        tablero.colocarAlgoformer(new Posicion(1,1, new Rocosa()),algoformer1);
        tablero.colocarAlgoformer(new Posicion(2,1, new Rocosa()),algoformer2);
        
        Assert.assertTrue(juego.verificarTurno(jugador1));
        try {
            jugador1.atacarPosicion(algoformer1,new Posicion(2,1, new Rocosa()));
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
        
        Algoformer algoformerj1 = jugador1.obtenerListaAlgoformers().get(0);
        Algoformer algoformerj2 = jugador2.obtenerListaAlgoformers().get(0);
        tablero.colocarAlgoformer(new Posicion(1,1, new Rocosa()),algoformerj1);
        tablero.colocarAlgoformer(new Posicion(2,1, new Rocosa()),algoformerj2);
        
        int vidaEnemigoOriginal = algoformerj2.obtenerVida();
        
        Assert.assertTrue(juego.verificarTurno(jugador1));
        jugador1.atacarPosicion(algoformerj1,new Posicion(2,1, new Rocosa()));
        
        Assert.assertTrue(vidaEnemigoOriginal > algoformerj2.obtenerVida());
    }
    @Test
    public void testAtacarAlVacioNoCambiaTurno() {
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,30,30);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Tablero tablero = juego.obtenerTablero();
        
        Algoformer algoformer1 = jugador1.obtenerListaAlgoformers().get(0);
        
        tablero.colocarAlgoformer(new Posicion(1,1, new Rocosa()),algoformer1);
        
        
        Assert.assertTrue(juego.verificarTurno(jugador1));

        try {
            jugador1.atacarPosicion(algoformer1,new Posicion(2,1, new Rocosa()));
            
            //Si esto sigue ejecutando caimos en un error
            throw new AssertionError();
        } catch(AtaqueInvalidoException e) {
            Assert.assertTrue(juego.verificarTurno(jugador1));
        }    
    }
    @Test
    public void testMoverExitosamenteCambiaLaPosicion(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        Juego juego = new Juego(nombre1,nombre2,3,3);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Tablero tablero = juego.obtenerTablero();
        Posicion posicionInicial = new Posicion(1,1, new Rocosa());
        
        Algoformer algo1 = jugador1.obtenerListaAlgoformers().get(0);
        tablero.colocarAlgoformer(posicionInicial,algo1);
        
        Assert.assertTrue(algo1.obtenerPosicion()==posicionInicial);
        
        Posicion posicionFinal = new Posicion(2,1, new Rocosa());
        //jugador1.moverAPosicion(algo1,posicionFinal);
        
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
        
        posiciones.add(posicionFinal);
        jugador1.moverAPosiciones(algo1, posiciones);
        
        Assert.assertTrue(algo1.obtenerPosicion()==posicionFinal);
    }
    @Test
    public void testMoverExitosamentePoneVacioEnSuViejoLugar(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        Juego juego = new Juego(nombre1,nombre2,3,3);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Tablero tablero = juego.obtenerTablero();
        Posicion posicionInicial = new Posicion(1,1, new Rocosa());
        Algoformer algo1 = jugador1.obtenerListaAlgoformers().get(0);
        
        tablero.colocarAlgoformer(posicionInicial,algo1);
        
        Assert.assertEquals(algo1.obtenerPosicion(), posicionInicial);
        
        Posicion posicionFinal = new Posicion(2,1, new Rocosa());
        //jugador1.moverAPosicion(algo1,posicionFinal);
        
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
        
        posiciones.add(posicionFinal);
        jugador1.moverAPosiciones(algo1, posiciones);
        
        //comparamos punteros
        Assert.assertTrue(tablero.obtenerUbicable(posicionInicial) != algo1);
    }
    @Test
    public void testMoverExitosamenteCambiaJugador(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        Juego juego = new Juego(nombre1,nombre2,3,3);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Jugador jugador2 = juego.obtenerJugadorEnEspera();
        Tablero tablero = juego.obtenerTablero();
        Posicion posicionInicial = new Posicion(1,1, new Rocosa());
        Algoformer algoformer1 = jugador1.obtenerListaAlgoformers().get(0);
        tablero.colocarAlgoformer(posicionInicial,algoformer1);
        
        Assert.assertTrue(juego.verificarTurno(jugador1));
        Posicion posicionFinal = new Posicion(2,1, new Rocosa());
        //jugador1.moverAPosicion(algoformer1,posicionFinal);
        
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
        
        posiciones.add(posicionFinal);
        jugador1.moverAPosiciones(algoformer1, posiciones);
        
        Assert.assertTrue(juego.verificarTurno(jugador2));        
    }
    /*@Test
    public void testMoverMuyLejosNoCambiaJugador(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        Juego juego = new Juego(nombre1,nombre2,30,30);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Tablero tablero = juego.obtenerTablero();
        Posicion posicionInicial = new Posicion(1,1, new Rocosa());
        Algoformer algoformer1 = jugador1.obtenerListaAlgoformers().get(0);
        tablero.colocarAlgoformer(posicionInicial,algoformer1);
        
        Assert.assertTrue(juego.verificarTurno(jugador1));
        
        try{
            Posicion posicionFinal = new Posicion(15,1, new Rocosa());
            jugador1.moverAPosicion(algoformer1,posicionFinal);
            
            throw new AssertionError();
        } catch(ObjetivoMuyLejosException e) {
            Assert.assertTrue(juego.verificarTurno(jugador1));
        }        
    }*/
    @Test
    public void testMoverAPosicionConAlgoformerNoCambiaJugador(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        Juego juego = new Juego(nombre1,nombre2,30,30);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Jugador jugador2 = juego.obtenerJugadorEnEspera();
        Tablero tablero = juego.obtenerTablero();
        Algoformer algoformerj1 = jugador1.obtenerListaAlgoformers().get(0);
        Algoformer algoformerj2 = jugador2.obtenerListaAlgoformers().get(0);
        tablero.colocarAlgoformer(new Posicion(1,1, new Rocosa()),algoformerj1);
        tablero.colocarAlgoformer(new Posicion(1,2, new Rocosa()),algoformerj2);

        Assert.assertTrue(juego.verificarTurno(jugador1));
        
        try{
            Posicion posicionFinal = new Posicion(1,2, new Rocosa());
            //jugador1.moverAPosicion(algoformerj1,posicionFinal);
            ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
            
            posiciones.add(posicionFinal);
            jugador1.moverAPosiciones(algoformerj1, posiciones); 
            
            throw new AssertionError();
        } catch(NoSuperponibleException e) {
            Assert.assertTrue(juego.verificarTurno(jugador1));
        }        
    }
    /*@Test(expected=ObjetivoMuyLejosException.class)
    public void testMoverAPosicionMuyLejosObjetoMuyLejosException(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        
        Juego juego = new Juego(nombre1,nombre2,30,30);
        Jugador jugador1 = juego.obtenerJugadorActual();
        
        Tablero tablero = juego.obtenerTablero();
        
        Algoformer algoformer = jugador1.obtenerListaAlgoformers().get(0);
        Posicion posicionInicial = new Posicion(1,1, new Rocosa());
        
        tablero.colocarAlgoformer(posicionInicial,algoformer);
        
        Posicion posicionFinal = new Posicion(15,1, new Rocosa());
        jugador1.moverAPosicion(algoformer,posicionFinal);        
    }*/
    @Test(expected=NoSuperponibleException.class)
    public void testMoverAPosicionConAlgoformerNoSuperponibleException(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        Juego juego = new Juego(nombre1,nombre2,30,30);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Jugador jugador2 = juego.obtenerJugadorEnEspera();
        Tablero tablero = juego.obtenerTablero();
        Algoformer algoformerj1 = jugador1.obtenerListaAlgoformers().get(0);
        Algoformer algoformerj2 = jugador2.obtenerListaAlgoformers().get(0);
        tablero.colocarAlgoformer(new Posicion(1,1, new Rocosa()),algoformerj1);
        tablero.colocarAlgoformer(new Posicion(1,2, new Rocosa()),algoformerj2);
        
        Posicion posicionFinal = new Posicion(1,2, new Rocosa());
        //jugador1.moverAPosicion(algoformerj1,posicionFinal);      
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
        
        posiciones.add(posicionFinal);
        jugador1.moverAPosiciones(algoformerj1, posiciones);        
        
    }
    @Test
    public void testUbicarChispaEnCentroDelTablero(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        Juego juego = new Juego(nombre1,nombre2,30,30);

        Tablero tablero = juego.obtenerTablero();
        Ubicable chispa = tablero.obtenerUbicable(new Posicion(14, 14, new Rocosa()));
        
        Assert.assertTrue(chispa instanceof ChispaSuprema);     
    }
    @Test
    public void testCambiarModoCambiaJugador(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        Juego juego = new Juego(nombre1,nombre2,3,3);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Jugador jugador2 = juego.obtenerJugadorEnEspera();
        Tablero tablero = juego.obtenerTablero();
        Posicion posicionInicial = new Posicion(1,1, new Rocosa());
        Algoformer algoformer1 = jugador1.obtenerListaAlgoformers().get(0);
        tablero.colocarAlgoformer(posicionInicial,algoformer1);
        
        Assert.assertTrue(juego.verificarTurno(jugador1));

        jugador1.cambiarModo(algoformer1);
        
        Assert.assertTrue(juego.verificarTurno(jugador2));        
    }    
}
