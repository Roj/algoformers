package algoformers;

public class Espinas extends Tierra {
    @Override
    public void accionSobreAlgoformer(Algoformer alg) {
        // Resta un 5% de vida
        alg.setVida(alg.obtenerVida() * 95 / 100);
    }
}
