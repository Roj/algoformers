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
        optimus.agregarBuff(buff);
        optimus.establecerPosicion(pos1);
        
        for(int i=0; i<3; i++) {
            try {
                optimus.mover(pos2);
            } catch(EncadenadoException e) {
                optimus.pasarTurno();
            }
        }
        optimus.mover(pos2);
        Assert.assertEquals(optimus.obtenerPosicion(),pos2);
        
    }
    
}
