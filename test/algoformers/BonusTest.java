/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers;

import algoformers.modelo.tablero.Posicion;
import algoformers.modelo.superficie.Rocosa;
import algoformers.modelo.algoformer.FabricaAlgoformers;
import algoformers.modelo.bonus.Bonus;
import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.bonus.FabricaBonus;
import algoformers.modelo.buffs.NoPuedeSerAtacado;
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
    public void testConBurbujaInmaculadaNoRecibeAtaquePorDosTurnosHumanoide(){
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
    public void testConBurbujaInmaculadaNoRecibeAtaquePorDosTurnosAlterno(){
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
        
        megatron.cambiarModo();
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
    public void testDobleCañonDuplicaAtaquePorTresTurnosHumanoide(){
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
    public void testDobleCañonDuplicaAtaquePorTresTurnosAlterno(){
        Posicion pos1 = new Posicion(1, 1, new Rocosa());
        Posicion pos2 = new Posicion(2, 1, new Rocosa());
        
        FabricaAlgoformers fabricaAlgoformers = new FabricaAlgoformers();
        Algoformer optimus = fabricaAlgoformers.crearOptimus();
        optimus.establecerPosicion(pos1);
        
        FabricaBonus fabricaBonus = new FabricaBonus();
        Bonus dobleCañon = fabricaBonus.crearDobleCañon();
        dobleCañon.establecerPosicion(pos2);
        
        optimus.cambiarModo();
        dobleCañon.reemplazar(optimus);
        optimus.mover(pos2);
        
        
        for (int i=0; i<3; i++){
            Assert.assertTrue(optimus.obtenerPuntosAtaque() == 30);
            optimus.pasarTurno();
        }
        Assert.assertTrue(optimus.obtenerPuntosAtaque()==15);
    }
    
    @Test
    public void testFlashTriplicaVelocidadPorTresTurnosHumanoide(){
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
    @Test
    public void testFlashTriplicaVelocidadPorTresTurnosAlterno(){
        Posicion pos1 = new Posicion(1, 1, new Rocosa());
        Posicion pos2 = new Posicion(2, 1, new Rocosa());
        
        FabricaAlgoformers fabricaAlgoformers = new FabricaAlgoformers();
        Algoformer optimus = fabricaAlgoformers.crearOptimus();
        optimus.establecerPosicion(pos1);
        
        FabricaBonus fabricaBonus = new FabricaBonus();
        Bonus flash = fabricaBonus.crearFlash();
        flash.establecerPosicion(pos2);
        
        optimus.cambiarModo();
        flash.reemplazar(optimus);
        optimus.mover(pos2);
        
        for (int i=0; i<3; i++){
            Assert.assertTrue(optimus.obtenerVelocidad() == 15);
            optimus.pasarTurno();
        }
        Assert.assertTrue(optimus.obtenerVelocidad()==5);
    }

    @Test
    public void testFlashTriplicaVelocidadPorTresTurnosEnHumanoideNoAlterno(){
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
        
        //Humanoide
        Assert.assertTrue(optimus.obtenerVelocidad() == 6);
        optimus.pasarTurno();
        //Alterno
        optimus.cambiarModo();
        Assert.assertTrue(optimus.obtenerVelocidad() == 5);
        optimus.pasarTurno();
        //Humanoide
        optimus.cambiarModo();
        Assert.assertTrue(optimus.obtenerVelocidad() == 6);
        optimus.pasarTurno();
        
        Assert.assertTrue(optimus.obtenerVelocidad()==2);
    }
    
}
