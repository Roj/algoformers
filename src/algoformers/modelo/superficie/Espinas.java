package algoformers.modelo.superficie;

import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.algoformer.ModoAereo;
import algoformers.modelo.algoformer.ModoAlgoformer;
import algoformers.modelo.algoformer.ModoHumanoide;
import algoformers.modelo.algoformer.ModoTerrestre;
import algoformers.vista.Casilla;

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

    public void setSuperficie(Casilla casilla) {
        casilla.setSuperficie(this);
    }

    @Override
    public void puedeSerAtravesada(ModoAereo modo) {
        //Puede sobrevolar espinas
    }

    @Override
    public void puedeSerAtravesada(ModoTerrestre modo) {
        //Puede atravesar espinas
    }

    @Override
    public void puedeSerAtravesada(ModoHumanoide modo) {
        //Puede atravesar espinas
    }
    
}
