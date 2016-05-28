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
 * @author Matias
 */
public class TableroTest {
    
    @Test
    public void testTableroVacio(){
        Tablero tablero = new Tablero(3,3);
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                Posicion posicion = new Posicion(i,j);
                Assert.assertTrue(tablero.estaVacio(posicion));
            }
        }
    }
    
}
