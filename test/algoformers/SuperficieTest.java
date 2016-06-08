package algoformers;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class SuperficieTest {
	@Test
	public void testMoverAlgoformerTerrestreSobreEspinasModoHumanoide() {
	    String nombre1 = "Juan";
	    String nombre2 = "John";
	    Juego juego = new Juego(nombre1,nombre2,10,10);
	    Jugador jugador1 = juego.obtenerJugadorActual();
	    Tablero tablero = juego.obtenerTablero();
	    Algoformer optimus = jugador1.obtenerListaAlgoformers().get(0);
	    
	    Posicion pos1 = new Posicion(1, 1, new Tierra());
	    Posicion pos2 = new Posicion(2, 1, new Espinas());
	    	    
	    tablero.colocarAlgoformer(pos1, optimus);
	    
	    Assert.assertTrue(optimus.obtenerVida() == 500);
	    
	    //jugador1.moverAPosicion(optimus, pos2);
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
        
        posiciones.add(pos2);
        jugador1.moverAPosiciones(optimus, posiciones);
        
	    Assert.assertTrue(optimus.obtenerVida() == 475);
	    
	}
	@Test
	public void testMoverAlgoformerTerrestreSobreEspinasModoAlterno() {
	    String nombre1 = "Juan";
	    String nombre2 = "John";
	    Juego juego = new Juego(nombre1,nombre2,10,10);
	    Jugador jugador1 = juego.obtenerJugadorActual();
	    Jugador jugador2 = juego.obtenerJugadorEnEspera();
	    Tablero tablero = juego.obtenerTablero();
	    Algoformer optimus = jugador1.obtenerListaAlgoformers().get(0);
	    
	    Posicion pos1 = new Posicion(1, 1, new Tierra());
	    Posicion pos2 = new Posicion(2, 1, new Espinas());
	    
	    tablero.colocarAlgoformer(pos1, optimus);
	    
	    jugador1.cambiarModo(optimus);
	    
	    // Paso el turno del jugador 2
	    jugador2.cambiarModo(jugador2.obtenerListaAlgoformers().get(0));
	    
	    Assert.assertTrue(optimus.obtenerVida() == 500);
	    
	    //jugador1.moverAPosicion(optimus, pos2);
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
        
        posiciones.add(pos2);
        jugador1.moverAPosiciones(optimus, posiciones);
        
	    Assert.assertTrue(optimus.obtenerVida() == 475);
	    
	}	
	
}
