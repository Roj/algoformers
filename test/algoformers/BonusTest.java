/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matias
 */
public class BonusTest {
    
    @Test
    public void testConBurbujaInmaculadaNoRecibeAtaquePorDosTurnos(){
        Posicion pos1 = new Posicion(1, 1, new Rocosa());
        Posicion pos2 = new Posicion(2, 1, new Rocosa());
        Posicion pos3 = new Posicion(3, 1, new Rocosa());

        FabricaAlgoformers fabricaAlgoformers = new FabricaAlgoformers();
        Algoformer megatron = fabricaAlgoformers.crearMegatron();
        Algoformer optimus = fabricaAlgoformers.crearOptimus();
        megatron.establecerPosicion(pos1);
        optimus.establecerPosicion(pos3);
        
        FabricaBonus fabricaBonus = new FabricaBonus();
        Bonus burbuja = fabricaBonus.crearBurbujaInmaculada();
        burbuja.establecerPosicion(pos2);
        
        burbuja.reemplazar(megatron);
        megatron.mover(pos2);
        
        
        for (int i=0; i<=2; i++){
            Assert.assertTrue(megatron.obtenerVida()==550);
            optimus.atacar(megatron);
            megatron.pasarTurno();
        }   
        Assert.assertTrue(megatron.obtenerVida()==500);
    }
}
