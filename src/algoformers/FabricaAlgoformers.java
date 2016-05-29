package algoformers;

public class FabricaAlgoformers {
	public Algoformer crearOptimus() {
		TipoAlgoformer optimus = new Optimus();
		ModoAlgoformer humanoide = new ModoHumanoide();
		
		return new Algoformer(optimus, humanoide);
	}
}
