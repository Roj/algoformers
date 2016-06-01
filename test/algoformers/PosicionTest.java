package algoformers;
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
        Posicion pos1 = new Posicion(1,1);
        Posicion pos2 = new Posicion(2,2);
        Posicion pos3 = new Posicion(1,3);
        Posicion pos4 = new Posicion(4,1);
        
        //diagonal
        Assert.assertEquals(pos1.calcularDistancia(pos2), 1);
        //vertical
        Assert.assertEquals(pos1.calcularDistancia(pos3), 2);
        //horizontal
        Assert.assertEquals(pos1.calcularDistancia(pos4), 3);
        
    }
}
