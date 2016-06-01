
package algoformers;

import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author joaquintz
 */
public class AlgoformerTest {
    @Test(expected=NoSuperponibleException.class)
    public void testSuperponerLanzaExcepcion() {
        FabricaAlgoformers fabrica = new FabricaAlgoformers();	
        Algoformer alf = fabrica.crearOptimus();
        
        alf.superponer(alf);
    }
    
    @Test(expected=AtaqueInvalidoException.class)
    public void testAtacarAlgoformerMismoBando() {
    	FabricaAlgoformers fabrica = new FabricaAlgoformers();
    	Algoformer optimus = fabrica.crearOptimus();
    	Algoformer otro_optimus = fabrica.crearOptimus();
        Posicion pos = new Posicion(1,1);
        optimus.establecerPosicion(pos);
        otro_optimus.establecerPosicion(pos);
    	
    	optimus.atacar(otro_optimus);
    }
    @Test
    public void testAtacarAlgoformerDiferenteBando() {
    	FabricaAlgoformers fabrica = new FabricaAlgoformers();
    	Algoformer optimus = fabrica.crearOptimus();
    	Algoformer megatron = fabrica.crearMegatron();
        Posicion pos = new Posicion(1,1);
        optimus.establecerPosicion(pos);
        megatron.establecerPosicion(pos);
    	
    	optimus.atacar(megatron);
    	
    	Assert.assertTrue(megatron.obtenerVida() == 500);	
    }  
    @Test
    public void testVerificarDistanciaObjetivoNoLanzaExcepcion(){
        FabricaAlgoformers fabrica = new FabricaAlgoformers();
    	Algoformer optimus = fabrica.crearOptimus();
        
        Posicion posOptimus = new Posicion(2,2);
        optimus.establecerPosicion(posOptimus);
        //Este es el ejemplo en la documentacion
        for(int i=0; i<=4; i++) {
            for(int j=0; j<=4; j++ ) {
                Posicion actual = new Posicion(i,j);
                Assert.assertTrue(optimus.revisarDistanciaAtaque(actual));
            }
        }
        
    }
    //@Test(expected=ObjetivoMuyLejosException.class)
    @Test(expected=AtaqueInvalidoException.class)
    public void testAtacarObjetivoLejosLanzaExcepcion() {
        FabricaAlgoformers fabrica = new FabricaAlgoformers();
    	Algoformer optimus = fabrica.crearOptimus();
    	Algoformer megatron = fabrica.crearMegatron();
        
        Posicion posOptimus = new Posicion(1,1);
        optimus.establecerPosicion(posOptimus);
        Posicion posMegatron = new Posicion(4,4);
        megatron.establecerPosicion(posMegatron);
    	
    	optimus.atacar(megatron);
    	
    	Assert.assertTrue(megatron.obtenerVida() == 500);	
    }
}
