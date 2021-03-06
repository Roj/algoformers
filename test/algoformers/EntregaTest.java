/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoformers;

import algoformers.modelo.tablero.Posicion;
import algoformers.modelo.tablero.Tablero;
import algoformers.modelo.tablero.ChispaSuprema;
import algoformers.modelo.tablero.Ubicable;
import algoformers.modelo.juego.Juego;
import algoformers.modelo.superficie.Rocosa;
import algoformers.modelo.juego.Jugador;
import algoformers.modelo.bonus.Bonus;
import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.mapa.MapaChico;
import java.util.List;

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
        Juego juego = new Juego(nombre1,nombre2,new MapaChico());
        Jugador jugador1 = juego.obtenerJugadorActual();
        Tablero tablero = juego.obtenerTablero();
        Algoformer optimus = jugador1.obtenerListaAlgoformers().get(0);
        tablero.colocarAlgoformer(new Posicion(1,1, new Rocosa()),optimus);
        
        Posicion nuevaPosicion = new Posicion(2,1, new Rocosa());
        // muevo a la nuevo posicion
        optimus.mover(nuevaPosicion);
        
        Assert.assertTrue(optimus.obtenerPosicion() == nuevaPosicion);
    }
    
    @Test
    public void test02AlgoformerHumanoideSeTransformaEnAmbasDirecciones() {
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,new MapaChico());
        Jugador jugador1 = juego.obtenerJugadorActual();
        Tablero tablero = juego.obtenerTablero();
        
        Algoformer optimus = jugador1.obtenerListaAlgoformers().get(0);
        tablero.colocarAlgoformer(new Posicion(1,1, new Rocosa()),optimus);
        
        
        
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
        Juego juego = new Juego(nombre1,nombre2,new MapaChico());
        Jugador jugador1 = juego.obtenerJugadorActual();
        Tablero tablero = juego.obtenerTablero();
        
        Algoformer optimus = jugador1.obtenerListaAlgoformers().get(0);
        tablero.colocarAlgoformer(new Posicion(1,1, new Rocosa()),optimus);
     
        // el algoformer[0] es Optimus   
        optimus.cambiarModo();
        
        Posicion nuevaPosicion = new Posicion(2,1, new Rocosa());
        // muevo a la nuevo posicion
        optimus.mover(nuevaPosicion);
        
        Assert.assertTrue(optimus.obtenerPosicion() == nuevaPosicion);
    }
    @Test
    public void test04CrearJuegoConAlgoformersEnEsquivasOpuestasYChispaEnCentro(){
        String nombre1 = "Juan";
        String nombre2 = "John";
        
        Juego juego = new Juego(nombre1,nombre2,new MapaChico());
        
        Jugador jugador1 = juego.obtenerJugadorActual();
        Jugador jugador2 = juego.obtenerJugadorEnEspera();
        
        Tablero tablero = juego.obtenerTablero();
        List<Algoformer> algoformersj1 = jugador1.obtenerListaAlgoformers();
        List<Algoformer> algoformersj2 = jugador2.obtenerListaAlgoformers();
        
        Algoformer optimus = algoformersj1.get(0);
        Algoformer bumblebee = algoformersj1.get(1);
        Algoformer ratchet = algoformersj1.get(2);
        
        Algoformer megatron = algoformersj2.get(0);
        Algoformer bonecrusher = algoformersj2.get(1);
        Algoformer frenzy = algoformersj2.get(2);
        
        Ubicable chispa = tablero.obtenerUbicable(new Posicion(7,7, new Rocosa()));
               
        Posicion esquinaInferiorIzqBorde = new Posicion(0,0, new Rocosa());
        Posicion esquinaInferiorIzqSuperior = new Posicion(1,0,new Rocosa());
        Posicion esquinaInferiorIzqFrontal = new Posicion(2,0,new Rocosa());
        
        Posicion esquinaSuperiorDerBorde = new Posicion(15,15,new Rocosa());
        Posicion esquinaSuperiorDerInferior = new Posicion(14,15,new Rocosa());
        Posicion esquinaSuperioDerTrasera = new Posicion(13,15,new Rocosa());
        
        Assert.assertEquals(optimus.obtenerPosicion(),esquinaInferiorIzqBorde);
        Assert.assertEquals(bumblebee.obtenerPosicion(),esquinaInferiorIzqSuperior);
        Assert.assertEquals(ratchet.obtenerPosicion(),esquinaInferiorIzqFrontal);
        
        Assert.assertEquals(megatron.obtenerPosicion(),esquinaSuperiorDerBorde);
        Assert.assertEquals(bonecrusher.obtenerPosicion(),esquinaSuperiorDerInferior);
        Assert.assertEquals(frenzy.obtenerPosicion(),esquinaSuperioDerTrasera);     
        
        Assert.assertTrue(chispa instanceof ChispaSuprema);
    }
    
}