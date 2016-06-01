package algoformers;

import org.junit.Assert;
import org.junit.Test;

import algoformers.Algoformer;
import algoformers.FabricaAlgoformers;

public class FabricaTest {

	@Test
	public void testObtenerEstadisticasAlgoformer() {
		FabricaAlgoformers fabrica = new FabricaAlgoformers();
		
		Algoformer optimus = fabrica.crearOptimus();
		
                Assert.assertTrue(optimus.obtenerVida() == 500);
		Assert.assertTrue(optimus.obtenerPuntosAtaque() == 15);
		Assert.assertTrue(optimus.obtenerDistanciaAtaque() == 4);
		Assert.assertTrue(optimus.obtenerVelocidad() == 5);		
		
		optimus.cambiarModo();
		
                Assert.assertTrue(optimus.obtenerVida() == 500);
		Assert.assertTrue(optimus.obtenerPuntosAtaque() == 50);
		Assert.assertTrue(optimus.obtenerDistanciaAtaque() == 2);
		Assert.assertTrue(optimus.obtenerVelocidad() == 2);
		
		
		optimus.cambiarModo();
		
		Assert.assertTrue(optimus.obtenerVida() == 500);
		Assert.assertTrue(optimus.obtenerPuntosAtaque() == 15);
		Assert.assertTrue(optimus.obtenerDistanciaAtaque() == 4);
		Assert.assertTrue(optimus.obtenerVelocidad() == 5);		
	}

}
