/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers;

import algoformers.modelo.tablero.Posicion;
import algoformers.modelo.buffs.EncadenadoException;
import algoformers.modelo.superficie.Rocosa;
import algoformers.modelo.buffs.EncadenadoEnAndromeda;
import algoformers.modelo.algoformer.FabricaAlgoformers;
import algoformers.modelo.buffs.Buff;
import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.bonus.Bonus;
import algoformers.modelo.bonus.FabricaBonus;
import algoformers.modelo.buffs.BurbujaInmaculada;
import algoformers.modelo.buffs.NoPuedeSerAtacado;
import algoformers.modelo.buffs.Psionizado;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author joaquintz
 */
public class BuffTest {
    @Test
    public void testPsionizadoDisminuyeAtaque() {
        FabricaAlgoformers fabrica = new FabricaAlgoformers();
        Algoformer optimus = fabrica.crearOptimus();
        optimus.establecerPosicion(new Posicion(1,1, new Rocosa()));
        optimus.cambiarModo();
        Buff psionizado = new Psionizado();
        int puntosAtaqueOriginal = optimus.obtenerPuntosAtaque();
        optimus.agregarBuff(psionizado);
        
        
        Assert.assertEquals((int) (puntosAtaqueOriginal*0.6),optimus.obtenerPuntosAtaque());
    }
    @Test
    public void testPsionizadoNoDisminuyeDeNuevoSiRepite() {
        FabricaAlgoformers fabrica = new FabricaAlgoformers();
        Algoformer optimus = fabrica.crearOptimus();
        optimus.establecerPosicion(new Posicion(1,1, new Rocosa()));
        optimus.cambiarModo();
        Buff psionizado = new Psionizado();
        int puntosAtaqueOriginal = optimus.obtenerPuntosAtaque();
        optimus.agregarBuff(psionizado);
        Buff psionizado2 = new Psionizado();
        optimus.agregarBuff(psionizado2);
        
        
        Assert.assertEquals((int) (puntosAtaqueOriginal*0.6),optimus.obtenerPuntosAtaque());
    }
    
    @Test(expected=EncadenadoException.class)
    public void testEncadenadoEnAndromedaNoPermiteMoverse() {
        FabricaAlgoformers fabrica = new FabricaAlgoformers();
        Algoformer optimus = fabrica.crearOptimus();
        optimus.establecerPosicion(new Posicion(1,1, new Rocosa()));
        optimus.cambiarModo();
        Buff buff = new EncadenadoEnAndromeda();
        
        Posicion pos1 = new Posicion(1,1, new Rocosa());
        Posicion pos2 = new Posicion(1,2, new Rocosa());
        optimus.agregarBuff(buff);
        optimus.establecerPosicion(pos1);
        optimus.mover(pos2);
        
    }
    @Test
    public void testEncadenadoEnAndromedaSeVaDespuesDe3Turnos() {
        FabricaAlgoformers fabrica = new FabricaAlgoformers();
        Algoformer optimus = fabrica.crearOptimus();
        optimus.establecerPosicion(new Posicion(1,1, new Rocosa()));
        optimus.cambiarModo();
        Buff buff = new EncadenadoEnAndromeda();
        
        Posicion pos1 = new Posicion(1,1, new Rocosa());
        Posicion pos2 = new Posicion(1,2, new Rocosa());
        optimus.establecerPosicion(pos1);
        optimus.agregarBuff(buff);
        
        for(int i=0; i<3; i++) {
            try {
                Assert.assertTrue(optimus.obtenerPosicion().equals(pos1));
                optimus.mover(pos2);
                
                throw new AssertionError();
            } catch(EncadenadoException e) {
                optimus.pasarTurno();
            }
        }
        optimus.mover(pos2);
        Assert.assertEquals(optimus.obtenerPosicion(),pos2);
        
    }
    
    @Test
    //⁠⁠⁠⁠public void testDosBurbujasInmaculadasNoAcumulanHumanoide() {
    public void testDosBurbujasInmaculadasNoAcumulanHumanoide() {
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
        //otraBurbuja.reemplazar(megatron);
        megatron.agregarBuff(new BurbujaInmaculada());
        megatron.mover(pos3);
        
        megatron.pasarTurno(); //restantes: 2-> 1
        
        
        Assert.assertTrue(megatron.obtenerVida()==550);
        try { optimus.atacar(megatron);
                throw new AssertionError();
        } catch(NoPuedeSerAtacado e) { }
        
        megatron.pasarTurno(); // restantes: 1->0. Deberia eliminarse
        
        
        optimus.atacar(megatron);
        Assert.assertTrue(megatron.obtenerVida()==500);
    }
}
