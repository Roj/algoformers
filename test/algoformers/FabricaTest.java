package algoformers;

import org.junit.Assert;
import org.junit.Test;

import algoformers.Algoformer;
import algoformers.FabricaAlgoformers;

public class FabricaTest {

	@Test
<<<<<<< HEAD
	public void test01ObtenerEstadisticasAlgoformer() {
=======
	public void testObtenerEstadisticasAlgoformer() {
>>>>>>> f0f3b25d96b573f9fe22b5c25e57d3b8c3d0256d
		FabricaAlgoformers fabrica = new FabricaAlgoformers();
		
		Algoformer optimus = fabrica.crearOptimus();
		
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

}
