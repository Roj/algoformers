package algoformers;
import algoformers.modelo.tablero.Posicion;
import algoformers.modelo.superficie.Nube;
import algoformers.modelo.superficie.Rocosa;
import algoformers.modelo.superficie.Superficie;
import org.junit.Assert;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joaquintz
 */
public class PosicionTest {
    @Test
    public void testCalcularDistancia() {
    	Superficie tierra = new Rocosa();
    	
        Posicion pos1 = new Posicion(1,1, tierra);
        Posicion pos2 = new Posicion(2,2, tierra);
        Posicion pos3 = new Posicion(1,3, tierra);
        Posicion pos4 = new Posicion(4,1, tierra);
        
        //diagonal
        Assert.assertEquals(pos1.calcularDistancia(pos2), 1);
        //vertical
        Assert.assertEquals(pos1.calcularDistancia(pos3), 2);
        //horizontal
        Assert.assertEquals(pos1.calcularDistancia(pos4), 3);
        
    } 
    @Test
    public void testPosicionesDiferenteTerreno() {    	
        Posicion pos1 = new Posicion(1,1, new Rocosa());
        Posicion pos2 = new Posicion(1,1, new Nube());
        Posicion pos3 = new Posicion(1,1, new Rocosa());
        
        Assert.assertEquals(pos1.equals(pos2), false);
        Assert.assertEquals(pos1.equals(pos3), true);
        
    }     
}
