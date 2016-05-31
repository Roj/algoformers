package algoformers;

public class FabricaAlgoformers {
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
}
