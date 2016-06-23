package algoformers.modelo.superficie;

import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.algoformer.ModoAereo;
import algoformers.modelo.algoformer.ModoHumanoide;
import algoformers.modelo.algoformer.ModoTerrestre;
import algoformers.modelo.juego.Movimiento;
import algoformers.modelo.superficie.Tierra;
import algoformers.vista.Casilla;

public class Pantano extends Tierra {
    @Override
    public void accionSobreAlgoformer(ModoTerrestre modo, Algoformer algof) {
        //restar movimientos??
    }
    @Override
    public void accionSobreAlgoformer(ModoHumanoide modo, Algoformer algof) {
        throw new SuperficieNoAtravesableException();
    }
    @Override
    public void accionSobreAlgoformer(ModoAereo modo, Algoformer algof) {
        //no restar narinas
    }
    @Override
    public void ajustarPuntosDeMovimiento(Movimiento mov, ModoAereo modo) {
        mov.modificarPuntosDeMovimiento(-1);
    }
    @Override
    public void ajustarPuntosDeMovimiento(Movimiento mov, ModoTerrestre modo) {
        mov.modificarPuntosDeMovimiento(-2);
    }
    @Override
    public void ajustarPuntosDeMovimiento(Movimiento mov, ModoHumanoide modo) {
        mov.modificarPuntosDeMovimiento(-1);
    }
    public void setSuperficie(Casilla casilla) {
        casilla.setSuperficie(this);
    }

    @Override
    public void puedeSerAtravesada(ModoAereo modo) {
        //Puede sobrevolar pantano
    }

    @Override
    public void puedeSerAtravesada(ModoTerrestre modo) {
        //Puede atravesar pantano
    }

    @Override
    public void puedeSerAtravesada(ModoHumanoide modo) {
        throw new SuperficieNoAtravesableException();
    }

    
}
