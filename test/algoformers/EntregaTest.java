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
    @Test
    public void test04CrearJuegoConAlgoformersEnEsquivasOpuestasYChispaEnCentro(){
        String nombre1 = "Juan";
        String nombre2 = "John";
        
        Juego juego = new Juego(nombre1,nombre2,20,20);
        
        Jugador jugador1 = juego.obtenerJugadorActual();
        Jugador jugador2 = juego.obtenerJugadorEnEspera();
        
        Tablero tablero = juego.obtenerTablero();
        
        Algoformer optimus = jugador1.obtenerAlgoformer(0);
        Algoformer bumblebee = jugador1.obtenerAlgoformer(1);
        Algoformer ratchet = jugador1.obtenerAlgoformer(2);
        
        Algoformer megatron = jugador2.obtenerAlgoformer(0);
        Algoformer bonecrusher = jugador2.obtenerAlgoformer(1);
        Algoformer frenzy = jugador2.obtenerAlgoformer(2);
        
        Ubicable chispa = tablero.obtenerUbicable(new Posicion(10, 10));
               
        Posicion esquinaInferiorIzqBorde = new Posicion(0,0);
        Posicion esquinaInferiorIzqSuperior = new Posicion(0,1);
        Posicion esquinaInferiorIzqFrontal = new Posicion(1,0);
        
        Posicion esquinaSuperiorDerBorde = new Posicion(19,19);
        Posicion esquinaSuperiorDerInferior = new Posicion(19,18);
        Posicion esquinaSuperioDerTrasera = new Posicion(18,19);
        
        tablero.colocarAlgoformer(esquinaInferiorIzqBorde, optimus);
        tablero.colocarAlgoformer(esquinaInferiorIzqSuperior, bumblebee);
        tablero.colocarAlgoformer(esquinaInferiorIzqFrontal, ratchet);
        
        tablero.colocarAlgoformer(esquinaSuperiorDerBorde, megatron);
        tablero.colocarAlgoformer(esquinaSuperiorDerInferior, bonecrusher);
        tablero.colocarAlgoformer(esquinaSuperioDerTrasera, frenzy);
        
        Assert.assertTrue(optimus.obtenerPosicion() == esquinaInferiorIzqBorde);
        Assert.assertTrue(bumblebee.obtenerPosicion() == esquinaInferiorIzqSuperior);
        Assert.assertTrue(ratchet.obtenerPosicion() == esquinaInferiorIzqFrontal);
        
        Assert.assertTrue(megatron.obtenerPosicion() == esquinaSuperiorDerBorde);
        Assert.assertTrue(bonecrusher.obtenerPosicion() == esquinaSuperiorDerInferior);
        Assert.assertTrue(frenzy.obtenerPosicion() == esquinaSuperioDerTrasera);     
        Assert.assertTrue(chispa instanceof ChispaSuprema); 
    }
    
}