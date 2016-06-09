package algoformers;

public class Pantano extends Tierra {
    @Override
    public void accionSobreAlgoformer(Algoformer alg) {
        // En modo humanoide no es posible atravesarlo
        // En modo alterno las superficie terrestren tardan el doble en avanzar
        alg.puedeAtravesarPantano();
        alg.modificarPuntosDeMovimiento(-1);
    }
}
