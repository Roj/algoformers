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
    
    @Test
    public void testColocarAlgoformer(){
        Tablero tablero = new Tablero(3,3);
        Posicion posicion = new Posicion(1,2);
        FabricaAlgoformers fabrica = new FabricaAlgoformers();
        Algoformer optimus = fabrica.crearOptimus();
        tablero.colocarAlgoformer(posicion,optimus);
        Assert.assertFalse(tablero.estaVacio(posicion));
    }
    
    @Test
    public void testAgregarUbicable(){
        Tablero tablero = new Tablero(3,3);
        Posicion posicion = new Posicion(1,2);
        Bonus bonus = new BurbujaInmaculada(posicion);
        tablero.agregarUbicable(posicion, bonus);
        Assert.assertFalse(tablero.estaVacio(posicion));
    }
    
    @Test
    public void testBorrarUbicable(){
        Tablero tablero = new Tablero(3,3);
        Posicion posicion = new Posicion(1,2);
        Bonus bonus = new BurbujaInmaculada(posicion);
        tablero.agregarUbicable(posicion, bonus);
        Assert.assertFalse(tablero.estaVacio(posicion));
        tablero.borrarUbicable(posicion);
        Assert.assertTrue(tablero.estaVacio(posicion));
    }
    
    @Test
    public void testEstaVacio(){
        Tablero tablero = new Tablero(3,3);
        Posicion posicion = new Posicion(1,2);
        Vacio vacio = new Vacio(posicion);
        tablero.agregarUbicable(posicion, vacio);
        Assert.assertTrue(tablero.estaVacio(posicion));
    }
}
