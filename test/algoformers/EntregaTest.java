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
 * @author John
 */
public class EntregaTest {
    
    
     @Test
    public void test01ColocarAlgoformerHumanoideYMoverSobreElTablero(){
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,10,10);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Jugador jugador2 = juego.obtenerJugadorEnEspera();
        Tablero tablero = juego.obtenerTablero();
        tablero.colocarAlgoformer(new Posicion(1,1),jugador1.obtenerAlgoformer(0));
      
        // el algoformer[0] es Optimus
        Algoformer optimus = jugador1.obtenerAlgoformer(0);
        
        Posicion nuevaPosicion = new Posicion(2,1);
        // muevo a la nuevo posicion
        optimus.mover(nuevaPosicion);
        
        Assert.assertTrue(optimus.obtenerPosicion() == nuevaPosicion);
    }
    
    @Test
    public void test02AlgoformerHumanoideSeTransformaEnAmbasDirecciones() {
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,3,3);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Jugador jugador2 = juego.obtenerJugadorEnEspera();
        Tablero tablero = juego.obtenerTablero();
        tablero.colocarAlgoformer(new Posicion(1,1),jugador1.obtenerAlgoformer(0));
        
        // el algoformer[0] es Optimus
        Algoformer optimus = jugador1.obtenerAlgoformer(0);
        
        //por defecto esta en modo humanoide
        Assert.assertTrue(optimus.obtenerVida() == 500);
        Assert.assertTrue(optimus.obtenerPuntosAtaque() == 50);
        Assert.assertTrue(optimus.obtenerDistanciaAtaque() == 2);
        Assert.assertTrue(optimus.obtenerVelocidad() == 2);

        optimus.cambiarModo();
        //verifico que este en modo alterno
        Assert.assertTrue(optimus.obtenerVida() == 500);
        Assert.assertTrue(optimus.obtenerPuntosAtaque() == 15);
        Assert.assertTrue(optimus.obtenerDistanciaAtaque() == 4);
        Assert.assertTrue(optimus.obtenerVelocidad() == 5);		

        optimus.cambiarModo();
        //verifico que este en modo humanoide
        Assert.assertTrue(optimus.obtenerVida() == 500);
        Assert.assertTrue(optimus.obtenerPuntosAtaque() == 50);
        Assert.assertTrue(optimus.obtenerDistanciaAtaque() == 2);
        Assert.assertTrue(optimus.obtenerVelocidad() == 2);
        
    }
    
    @Test
    public void test03ColocarAlgoformerAlternoYMoverSobreElTablero(){
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,10,10);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Jugador jugador2 = juego.obtenerJugadorEnEspera();
        Tablero tablero = juego.obtenerTablero();
        tablero.colocarAlgoformer(new Posicion(1,1),jugador1.obtenerAlgoformer(0));
      
        // el algoformer[0] es Optimus
        Algoformer optimus = jugador1.obtenerAlgoformer(0);
        optimus.cambiarModo();
        
        Posicion nuevaPosicion = new Posicion(2,1);
        // muevo a la nuevo posicion
        optimus.mover(nuevaPosicion);
        
        Assert.assertTrue(optimus.obtenerPosicion() == nuevaPosicion);
    }

    
}
