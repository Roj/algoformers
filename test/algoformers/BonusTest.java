/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers;

import algoformers.modelo.Posicion;
import algoformers.modelo.Rocosa;
import algoformers.modelo.FabricaAlgoformers;
import algoformers.modelo.Bonus;
import algoformers.modelo.Algoformer;
import algoformers.modelo.FabricaBonus;
import algoformers.modelo.NoPuedeSerAtacado;
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
        
        
        Assert.assertTrue(megatron.obtenerVida()==550);
        try { optimus.atacar(megatron);
        } catch(NoPuedeSerAtacado e) { }
        megatron.pasarTurno(); //restantes: 2-> 1
        
        
        Assert.assertTrue(megatron.obtenerVida()==550);
        try { optimus.atacar(megatron);
        } catch(NoPuedeSerAtacado e) { }
        megatron.pasarTurno(); // restantes: 1->0. Deberia eliminarse
        
        
        optimus.atacar(megatron);
        Assert.assertTrue(megatron.obtenerVida()==500);
    }
    @Test
    public void testDobleCañonDuplicaAtaquePorTresTurnos(){
        Posicion pos1 = new Posicion(1, 1, new Rocosa());
        Posicion pos2 = new Posicion(2, 1, new Rocosa());
        
        FabricaAlgoformers fabricaAlgoformers = new FabricaAlgoformers();
        Algoformer optimus = fabricaAlgoformers.crearOptimus();
        optimus.establecerPosicion(pos1);
        
        FabricaBonus fabricaBonus = new FabricaBonus();
        Bonus dobleCañon = fabricaBonus.crearDobleCañon();
        dobleCañon.establecerPosicion(pos2);
        
        dobleCañon.reemplazar(optimus);
        optimus.mover(pos2);
        
        
        for (int i=0; i<3; i++){
            Assert.assertTrue(optimus.obtenerPuntosAtaque() == 100);
            optimus.pasarTurno();
        }
        Assert.assertTrue(optimus.obtenerPuntosAtaque()==50);
    }
    @Test
    public void testFlashTriplicaVelocidadPorTresTurnos(){
        Posicion pos1 = new Posicion(1, 1, new Rocosa());
        Posicion pos2 = new Posicion(2, 1, new Rocosa());
        
        FabricaAlgoformers fabricaAlgoformers = new FabricaAlgoformers();
        Algoformer optimus = fabricaAlgoformers.crearOptimus();
        optimus.establecerPosicion(pos1);
        
        FabricaBonus fabricaBonus = new FabricaBonus();
        Bonus flash = fabricaBonus.crearFlash();
        flash.establecerPosicion(pos2);
        
        flash.reemplazar(optimus);
        optimus.mover(pos2);
        
        
        for (int i=0; i<3; i++){
            Assert.assertTrue(optimus.obtenerVelocidad() == 6);
            optimus.pasarTurno();
        }
        Assert.assertTrue(optimus.obtenerVelocidad()==2);
    }
}
