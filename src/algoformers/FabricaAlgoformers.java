package algoformers;

public class FabricaAlgoformers {
<<<<<<< HEAD
	public Algoformer crearOptimus() {
		TipoAlgoformer optimus = new Optimus();
		ModoAlgoformer humanoide = new ModoHumanoide();
		
		return new Algoformer(optimus, humanoide);
	}
=======
	public Algoformer crearOptimus() {	
		
		/*ModoAlgoformer humanoide = new ModoHumanoide();
		Algoformer optimus = new Algoformer(humanoide);
		
		optimus.setVida(500);
		
		optimus.setEstadisticasHumanoide(50, 2, 2);
		optimus.setEstadisticasAlterno(15, 4, 5);
		
		return optimus;*/
		TipoAlgoformer optimus = new Optimus();
		ModoAlgoformer humanoide = new ModoHumanoide();
		
		return new Autobot(optimus, humanoide);
	}
	public Algoformer crearMegatron() {
		TipoAlgoformer megatron = new Megatron();
		ModoAlgoformer humanoide = new ModoHumanoide();
		
		return new Decepticon(megatron, humanoide);
	}	
>>>>>>> f0f3b25d96b573f9fe22b5c25e57d3b8c3d0256d
}
