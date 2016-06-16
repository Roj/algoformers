package algoformers;

import algoformers.modelo.Posicion;
import algoformers.modelo.superficie.Rocosa;
import org.junit.Assert;
import org.junit.Test;

import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.algoformer.FabricaAlgoformers;

public class FabricaTest {
    @Test
    public void testObtenerEstadisticasAlgoformer() {
        FabricaAlgoformers fabrica = new FabricaAlgoformers();

        Algoformer optimus = fabrica.crearOptimus();
        optimus.establecerPosicion(new Posicion(1,1, new Rocosa()));

        //por defecto esta en modo humanoide

        Assert.assertTrue(optimus.obtenerVida() == 500);
        Assert.assertTrue(optimus.obtenerPuntosAtaque() == 50);
        Assert.assertTrue(optimus.obtenerDistanciaAtaque() == 2);
        Assert.assertTrue(optimus.obtenerVelocidad() == 2);


        optimus.cambiarModo();

        Assert.assertTrue(optimus.obtenerVida() == 500);
        Assert.assertTrue(optimus.obtenerPuntosAtaque() == 15);
        Assert.assertTrue(optimus.obtenerDistanciaAtaque() == 4);
        Assert.assertTrue(optimus.obtenerVelocidad() == 5);		

        optimus.cambiarModo();

        Assert.assertTrue(optimus.obtenerVida() == 500);
        Assert.assertTrue(optimus.obtenerPuntosAtaque() == 50);
        Assert.assertTrue(optimus.obtenerDistanciaAtaque() == 2);
        Assert.assertTrue(optimus.obtenerVelocidad() == 2);

    }
    @Test
    public void testObtenerEstadisticasBumblebee() {
        FabricaAlgoformers fabrica = new FabricaAlgoformers();

        Algoformer bumblebee = fabrica.crearBumblebee();
        bumblebee.establecerPosicion(new Posicion(1,1, new Rocosa()));

        //por defecto esta en modo humanoide

        Assert.assertTrue(bumblebee.obtenerVida() == 350);
        Assert.assertTrue(bumblebee.obtenerPuntosAtaque() == 40);
        Assert.assertTrue(bumblebee.obtenerDistanciaAtaque() == 1);
        Assert.assertTrue(bumblebee.obtenerVelocidad() == 2);


        bumblebee.cambiarModo();

        Assert.assertTrue(bumblebee.obtenerVida() == 350);
        Assert.assertTrue(bumblebee.obtenerPuntosAtaque() == 20);
        Assert.assertTrue(bumblebee.obtenerDistanciaAtaque() == 3);
        Assert.assertTrue(bumblebee.obtenerVelocidad() == 5);		

    }
    @Test
    public void testObtenerEstadisticasRatchet() {
        FabricaAlgoformers fabrica = new FabricaAlgoformers();

        Algoformer ratchet = fabrica.crearRatchet();
        ratchet.establecerPosicion(new Posicion(1,1, new Rocosa()));

        //por defecto esta en modo humanoide

        Assert.assertTrue(ratchet.obtenerVida() == 150);
        Assert.assertTrue(ratchet.obtenerPuntosAtaque() == 5);
        Assert.assertTrue(ratchet.obtenerDistanciaAtaque() == 5);
        Assert.assertTrue(ratchet.obtenerVelocidad() == 1);


        ratchet.cambiarModo();

        Assert.assertTrue(ratchet.obtenerVida() == 150);
        Assert.assertTrue(ratchet.obtenerPuntosAtaque() == 35);
        Assert.assertTrue(ratchet.obtenerDistanciaAtaque() == 2);
        Assert.assertTrue(ratchet.obtenerVelocidad() == 8);		

    }
    @Test
    public void testObtenerEstadisticasMegatron() {
        FabricaAlgoformers fabrica = new FabricaAlgoformers();

        Algoformer megatron = fabrica.crearMegatron();
        megatron.establecerPosicion(new Posicion(1,1, new Rocosa()));

        //por defecto esta en modo humanoide

        Assert.assertTrue(megatron.obtenerVida() == 550);
        Assert.assertTrue(megatron.obtenerPuntosAtaque() == 10);
        Assert.assertTrue(megatron.obtenerDistanciaAtaque() == 3);
        Assert.assertTrue(megatron.obtenerVelocidad() == 1);


        megatron.cambiarModo();

        Assert.assertTrue(megatron.obtenerVida() == 550);
        Assert.assertTrue(megatron.obtenerPuntosAtaque() == 55);
        Assert.assertTrue(megatron.obtenerDistanciaAtaque() == 2);
        Assert.assertTrue(megatron.obtenerVelocidad() == 8);		

    }
    @Test
    public void testObtenerEstadisticasBonecrusher() {
        FabricaAlgoformers fabrica = new FabricaAlgoformers();

        Algoformer bonecrusher = fabrica.crearBonecrusher();
        bonecrusher.establecerPosicion(new Posicion(1,1, new Rocosa()));

        //por defecto esta en modo humanoide

        Assert.assertTrue(bonecrusher.obtenerVida() == 200);
        Assert.assertTrue(bonecrusher.obtenerPuntosAtaque() == 30);
        Assert.assertTrue(bonecrusher.obtenerDistanciaAtaque() == 3);
        Assert.assertTrue(bonecrusher.obtenerVelocidad() == 1);


        bonecrusher.cambiarModo();

        Assert.assertTrue(bonecrusher.obtenerVida() == 200);
        Assert.assertTrue(bonecrusher.obtenerPuntosAtaque() == 30);
        Assert.assertTrue(bonecrusher.obtenerDistanciaAtaque() == 3);
        Assert.assertTrue(bonecrusher.obtenerVelocidad() == 8);		

    }
    
    @Test
    public void testObtenerEstadisticasFrenzy() {
        FabricaAlgoformers fabrica = new FabricaAlgoformers();

        Algoformer frenzy = fabrica.crearFrenzy();
        frenzy.establecerPosicion(new Posicion(1,1, new Rocosa()));

        //por defecto esta en modo humanoide

        Assert.assertTrue(frenzy.obtenerVida() == 400);
        Assert.assertTrue(frenzy.obtenerPuntosAtaque() == 10);
        Assert.assertTrue(frenzy.obtenerDistanciaAtaque() == 5);
        Assert.assertTrue(frenzy.obtenerVelocidad() == 2);


        frenzy.cambiarModo();

        Assert.assertTrue(frenzy.obtenerVida() == 400);
        Assert.assertTrue(frenzy.obtenerPuntosAtaque() == 25);
        Assert.assertTrue(frenzy.obtenerDistanciaAtaque() == 2);
        Assert.assertTrue(frenzy.obtenerVelocidad() == 6);		

    }
}
