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
    public void testTableroEstaVacioCuandoSeInicia(){
        Tablero tablero = new Tablero(3,3);
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                Posicion posicion = new Posicion(i,j, new Rocosa());
                Assert.assertTrue(tablero.estaVacio(posicion));
            }
        }
    }
    
    @Test
    public void testColocarAlgoformerNoEstaVacio(){
        Tablero tablero = new Tablero(3,3);
        Posicion posicion = new Posicion(1,2, new Rocosa());
        FabricaAlgoformers fabrica = new FabricaAlgoformers();
        Algoformer optimus = fabrica.crearOptimus();
        
        tablero.colocarAlgoformer(posicion,optimus);
        
        Assert.assertFalse(tablero.estaVacio(posicion));
    }
    
    @Test
    public void testAgregarUbicableNoEstaVacio(){
        Tablero tablero = new Tablero(3,3);
        Posicion posicion = new Posicion(1,2, new Rocosa());
        FabricaBonus fabricaBonus = new FabricaBonus();
        Bonus bonus = fabricaBonus.crearBurbujaInmaculada();
        
        tablero.agregarUbicable(posicion, bonus);
        
        Assert.assertFalse(tablero.estaVacio(posicion));
    }
        
    @Test
    public void testBorrarUbicableYEstaVacio(){
        Tablero tablero = new Tablero(3,3);
        Posicion posicion = new Posicion(1,2, new Rocosa());
        FabricaBonus fabricaBonus = new FabricaBonus();
        Bonus bonus = fabricaBonus.crearBurbujaInmaculada();
        tablero.agregarUbicable(posicion, bonus);
        
        Assert.assertFalse(tablero.estaVacio(posicion));
        
        tablero.borrarUbicable(posicion);
        
        Assert.assertTrue(tablero.estaVacio(posicion));
    }
    
    @Test
    public void testEstaVacioSiHayAgregamosVacio(){
        Tablero tablero = new Tablero(3,3);
        Posicion posicion = new Posicion(1,2, new Rocosa());
        Vacio vacio = new Vacio();
        
        tablero.agregarUbicable(posicion, vacio);
        
        Assert.assertTrue(tablero.estaVacio(posicion));
    }
    
    @Test(expected=NoSuperponibleException.class)
    public void testNoSePuedeSuperponerAlgoformers() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicion = new Posicion(1,2, new Rocosa());
        FabricaAlgoformers fabrica = new FabricaAlgoformers();
        Algoformer optimus = fabrica.crearOptimus();
        Algoformer optimus2 = fabrica.crearOptimus();
        
        tablero.colocarAlgoformer(posicion,optimus);
        tablero.colocarAlgoformer(posicion,optimus2);
        
        Assert.assertEquals(tablero.obtenerUbicable(posicion),optimus);
    }
    
    @Test
    public void testBonusAdmiteSuperposicion() {
        Tablero tablero = new Tablero(3,3);
        Posicion posicion = new Posicion(1,2, new Rocosa());
        FabricaAlgoformers fabrica = new FabricaAlgoformers();
        Algoformer optimus = fabrica.crearOptimus();
        FabricaBonus fabricaBonus = new FabricaBonus();
        Bonus bonus = fabricaBonus.crearBurbujaInmaculada();        

        tablero.agregarUbicable(posicion,bonus);
        tablero.colocarAlgoformer(posicion,optimus);
        
        
        Assert.assertEquals(tablero.obtenerUbicable(posicion),optimus);
    }   
}
