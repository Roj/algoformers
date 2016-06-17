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
    @Test
    public void testDosBurbujasInmaculadasNoAcumulanHumanoide(){
        Posicion pos1 = new Posicion(1, 1, new Rocosa());
        Posicion pos2 = new Posicion(2, 1, new Rocosa());
        Posicion pos3 = new Posicion(3, 1, new Rocosa());
        Posicion pos4 = new Posicion(4, 1, new Rocosa());

        FabricaAlgoformers fabricaAlgoformers = new FabricaAlgoformers();
        Algoformer megatron = fabricaAlgoformers.crearMegatron();
        Algoformer optimus = fabricaAlgoformers.crearOptimus();
        megatron.establecerPosicion(pos1);
        optimus.establecerPosicion(pos4);
        
        FabricaBonus fabricaBonus = new FabricaBonus();
        Bonus burbuja = fabricaBonus.crearBurbujaInmaculada();
        Bonus otraBurbuja = fabricaBonus.crearBurbujaInmaculada();
        
        burbuja.establecerPosicion(pos2);
        otraBurbuja.establecerPosicion(pos3);
        
        burbuja.reemplazar(megatron);
        megatron.mover(pos2);
        
        
        Assert.assertTrue(megatron.obtenerVida()==550);
        try { optimus.atacar(megatron);
        } catch(NoPuedeSerAtacado e) { }
        
        // Esto me rompe todo
        otraBurbuja.reemplazar(megatron);
        megatron.mover(pos3);
        
        megatron.pasarTurno(); //restantes: 2-> 1
        
        
        Assert.assertTrue(megatron.obtenerVida()==550);
        try { optimus.atacar(megatron);
        } catch(NoPuedeSerAtacado e) { }
        megatron.pasarTurno(); // restantes: 1->0. Deberia eliminarse
        
        
        optimus.atacar(megatron);
        Assert.assertTrue(megatron.obtenerVida()==500);
    } 
    @Test
    public void testDosBurbujasInmaculadasNoAcumulanAlterno(){
        Posicion pos1 = new Posicion(1, 1, new Rocosa());
        Posicion pos2 = new Posicion(2, 1, new Rocosa());
        Posicion pos3 = new Posicion(3, 1, new Rocosa());
        Posicion pos4 = new Posicion(4, 1, new Rocosa());

        FabricaAlgoformers fabricaAlgoformers = new FabricaAlgoformers();
        Algoformer megatron = fabricaAlgoformers.crearMegatron();
        Algoformer optimus = fabricaAlgoformers.crearOptimus();
        megatron.establecerPosicion(pos1);
        optimus.establecerPosicion(pos4);
        
        FabricaBonus fabricaBonus = new FabricaBonus();
        Bonus burbuja = fabricaBonus.crearBurbujaInmaculada();
        Bonus otraBurbuja = fabricaBonus.crearBurbujaInmaculada();
        
        burbuja.establecerPosicion(pos2);
        otraBurbuja.establecerPosicion(pos3);
        
        megatron.cambiarModo();
        burbuja.reemplazar(megatron);
        megatron.mover(pos2);
        
        
        Assert.assertTrue(megatron.obtenerVida()==550);
        try { optimus.atacar(megatron);
        } catch(NoPuedeSerAtacado e) { }
        
        // Esto me rompe todo
        otraBurbuja.reemplazar(megatron);
        megatron.mover(pos3);
        
        megatron.pasarTurno(); //restantes: 2-> 1
        
        
        Assert.assertTrue(megatron.obtenerVida()==550);
        try { optimus.atacar(megatron);
        } catch(NoPuedeSerAtacado e) { }
        megatron.pasarTurno(); // restantes: 1->0. Deberia eliminarse
        
        
        optimus.atacar(megatron);
        Assert.assertTrue(megatron.obtenerVida()==500);
    }
    @Test
    public void testBurbujaInmaculadaConCañonHumanoide(){
        Posicion pos1 = new Posicion(1, 1, new Rocosa());
        Posicion pos2 = new Posicion(2, 1, new Rocosa());
        Posicion pos3 = new Posicion(3, 1, new Rocosa());
        Posicion pos4 = new Posicion(4, 1, new Rocosa());
        
        FabricaAlgoformers fabricaAlgoformers = new FabricaAlgoformers();
        Algoformer megatron = fabricaAlgoformers.crearMegatron();
        Algoformer optimus = fabricaAlgoformers.crearOptimus();
        megatron.establecerPosicion(pos1);
        optimus.establecerPosicion(pos3);
        
        FabricaBonus fabricaBonus = new FabricaBonus();
        Bonus burbuja = fabricaBonus.crearBurbujaInmaculada();
        Bonus dobleCañon = fabricaBonus.crearDobleCañon();
        
        burbuja.establecerPosicion(pos2);
        dobleCañon.establecerPosicion(pos4);
        
        dobleCañon.reemplazar(megatron);        
        burbuja.reemplazar(megatron);
        megatron.mover(pos2);
        
        
        Assert.assertTrue(megatron.obtenerPuntosAtaque()==20);  
        Assert.assertTrue(megatron.obtenerVida()==550);
        try { optimus.atacar(megatron);
        } catch(NoPuedeSerAtacado e) { }
        megatron.pasarTurno(); //restantes: 2-> 1
        
        Assert.assertTrue(megatron.obtenerPuntosAtaque()==20);
        Assert.assertTrue(megatron.obtenerVida()==550);
        try { optimus.atacar(megatron);
        } catch(NoPuedeSerAtacado e) { }
        megatron.pasarTurno(); // restantes: 1->0. Deberia eliminarse
        
        
        optimus.atacar(megatron);
        Assert.assertTrue(megatron.obtenerPuntosAtaque()==20);
        Assert.assertTrue(megatron.obtenerVida()==500);
        
        megatron.pasarTurno();
        Assert.assertTrue(megatron.obtenerPuntosAtaque()==10);
             
    }  
    @Test
    public void testBurbujaInmaculadaConFlashHumanoide(){
        Posicion pos1 = new Posicion(1, 1, new Rocosa());
        Posicion pos2 = new Posicion(2, 1, new Rocosa());
        Posicion pos3 = new Posicion(3, 1, new Rocosa());
        Posicion pos4 = new Posicion(4, 1, new Rocosa());
        
        FabricaAlgoformers fabricaAlgoformers = new FabricaAlgoformers();
        Algoformer megatron = fabricaAlgoformers.crearMegatron();
        Algoformer optimus = fabricaAlgoformers.crearOptimus();
        megatron.establecerPosicion(pos1);
        optimus.establecerPosicion(pos3);
        
        FabricaBonus fabricaBonus = new FabricaBonus();
        Bonus burbuja = fabricaBonus.crearBurbujaInmaculada();
        Bonus flash = fabricaBonus.crearFlash();
        
        burbuja.establecerPosicion(pos2);
        flash.establecerPosicion(pos4);
        
        flash.reemplazar(megatron);        
        burbuja.reemplazar(megatron);
        megatron.mover(pos2);
        
        
        Assert.assertTrue(megatron.obtenerVelocidad()==3);  
        Assert.assertTrue(megatron.obtenerVida()==550);
        try { optimus.atacar(megatron);
        } catch(NoPuedeSerAtacado e) { }
        megatron.pasarTurno(); //restantes: 2-> 1
        
        Assert.assertTrue(megatron.obtenerVelocidad()==3);
        Assert.assertTrue(megatron.obtenerVida()==550);
        try { optimus.atacar(megatron);
        } catch(NoPuedeSerAtacado e) { }
        megatron.pasarTurno(); // restantes: 1->0. Deberia eliminarse
        
        
        optimus.atacar(megatron);
        Assert.assertTrue(megatron.obtenerVelocidad()==3);
        Assert.assertTrue(megatron.obtenerVida()==500);
        
        megatron.pasarTurno();
        Assert.assertTrue(megatron.obtenerVelocidad()==1);         
    }  
    @Test
    public void testCañonConFlashHumanoide(){
        Posicion pos1 = new Posicion(1, 1, new Rocosa());
        Posicion pos2 = new Posicion(2, 1, new Rocosa());
        Posicion pos3 = new Posicion(3, 1, new Rocosa());
        Posicion pos4 = new Posicion(4, 1, new Rocosa());
        
        FabricaAlgoformers fabricaAlgoformers = new FabricaAlgoformers();
        Algoformer megatron = fabricaAlgoformers.crearMegatron();
        Algoformer optimus = fabricaAlgoformers.crearOptimus();
        megatron.establecerPosicion(pos1);
        optimus.establecerPosicion(pos3);
        
        FabricaBonus fabricaBonus = new FabricaBonus();
        Bonus dobleCañon = fabricaBonus.crearDobleCañon();
        Bonus flash = fabricaBonus.crearFlash();
        
        dobleCañon.establecerPosicion(pos2);
        flash.establecerPosicion(pos4);
        
        flash.reemplazar(megatron);        
        dobleCañon.reemplazar(megatron);
        megatron.mover(pos2);
        
        Assert.assertTrue(megatron.obtenerPuntosAtaque()==20);
        Assert.assertTrue(megatron.obtenerVelocidad()==3);  

        megatron.pasarTurno(); //restantes: 2-> 1
        
        Assert.assertTrue(megatron.obtenerPuntosAtaque()==20);
        Assert.assertTrue(megatron.obtenerVelocidad()==3);

        megatron.pasarTurno(); // restantes: 1->0. Deberia eliminarse
        
        Assert.assertTrue(megatron.obtenerPuntosAtaque()==20);
        Assert.assertTrue(megatron.obtenerVelocidad()==3); 
        
        megatron.pasarTurno();
        Assert.assertTrue(megatron.obtenerPuntosAtaque()==10);
        Assert.assertTrue(megatron.obtenerVelocidad()==1);         
    } 
    @Test
    public void testDosFlashNoAcumulanHumanoide(){
        Posicion pos1 = new Posicion(1, 1, new Rocosa());
        Posicion pos2 = new Posicion(2, 1, new Rocosa());
        Posicion pos3 = new Posicion(3, 1, new Rocosa());
        
        FabricaAlgoformers fabricaAlgoformers = new FabricaAlgoformers();
        Algoformer optimus = fabricaAlgoformers.crearOptimus();
        optimus.establecerPosicion(pos1);
        
        FabricaBonus fabricaBonus = new FabricaBonus();
        Bonus flash = fabricaBonus.crearFlash();
        Bonus otroFlash = fabricaBonus.crearFlash();
        
        flash.establecerPosicion(pos2);
        otroFlash.establecerPosicion(pos3);
        
        flash.reemplazar(optimus);
    
        optimus.mover(pos2);
        
        Assert.assertTrue(optimus.obtenerVelocidad() == 6);
        optimus.pasarTurno();
        Assert.assertTrue(optimus.obtenerVelocidad() == 6);
        otroFlash.reemplazar(optimus);
        optimus.pasarTurno();
        Assert.assertTrue(optimus.obtenerVelocidad() == 6);
        optimus.pasarTurno();       
        Assert.assertTrue(optimus.obtenerVelocidad()==2);
    }
    @Test
    public void testDosCañonesNoAcumulanHumanoide(){
        Posicion pos1 = new Posicion(1, 1, new Rocosa());
        Posicion pos2 = new Posicion(2, 1, new Rocosa());
        Posicion pos3 = new Posicion(3, 1, new Rocosa());
        Posicion pos4 = new Posicion(4, 1, new Rocosa());
        
        FabricaAlgoformers fabricaAlgoformers = new FabricaAlgoformers();
        Algoformer megatron = fabricaAlgoformers.crearMegatron();
        Algoformer optimus = fabricaAlgoformers.crearOptimus();
        megatron.establecerPosicion(pos1);
        optimus.establecerPosicion(pos3);
        
        FabricaBonus fabricaBonus = new FabricaBonus();
        Bonus dobleCañon = fabricaBonus.crearDobleCañon();
        Bonus otroDobleCañon = fabricaBonus.crearDobleCañon();
        
        dobleCañon.establecerPosicion(pos2);
        otroDobleCañon.establecerPosicion(pos4);
             
        dobleCañon.reemplazar(megatron);
        megatron.mover(pos2);
        
        Assert.assertTrue(megatron.obtenerPuntosAtaque()==20);

        megatron.pasarTurno(); //restantes: 2-> 1
        
        Assert.assertTrue(megatron.obtenerPuntosAtaque()==20);
        otroDobleCañon.reemplazar(megatron);   
        
        megatron.pasarTurno(); // restantes: 1->0. Deberia eliminarse
        
        Assert.assertTrue(megatron.obtenerPuntosAtaque()==20);
        
        megatron.pasarTurno();
        Assert.assertTrue(megatron.obtenerPuntosAtaque()==10);
    }     
}
