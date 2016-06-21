package algoformers.modelo.superficie;

import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.algoformer.ModoAereo;
import algoformers.modelo.algoformer.ModoHumanoide;
import algoformers.modelo.algoformer.ModoTerrestre;
import algoformers.vista.Casilla;

public class Rocosa extends Tierra {
    @Override
    public void accionSobreAlgoformer(ModoTerrestre modo, Algoformer algof) {

    }
    @Override
    public void accionSobreAlgoformer(ModoAereo modo, Algoformer algof) {

    }
    @Override
    public void accionSobreAlgoformer(ModoHumanoide modo, Algoformer algof) {

    }
    public void setSuperficie(Casilla casilla) {
        casilla.setSuperficie(this);
    }

}
