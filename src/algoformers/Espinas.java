package algoformers;

public class Espinas extends Tierra {
    @Override
    public void accionSobreAlgoformer(ModoTerrestre modo, Algoformer algof) {
        algof.setVida(algof.obtenerVida() * 95 / 100);
    }
    @Override
    public void accionSobreAlgoformer(ModoHumanoide modo, Algoformer algof) {
        algof.setVida(algof.obtenerVida() * 95 / 100);
    }
    @Override
    public void accionSobreAlgoformer(ModoAereo modo, Algoformer algof) {
        //no restar narinas
    }
    
}
