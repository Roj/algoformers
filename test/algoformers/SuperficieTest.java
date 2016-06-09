package algoformers;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class SuperficieTest {
    @Test
    public void testMoverAlgoformerTerrestreSobreEspinasModoHumanoideQuitaVida() {
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,10,10);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Tablero tablero = juego.obtenerTablero();
        Algoformer optimus = jugador1.obtenerListaAlgoformers().get(0);

        Posicion pos1 = new Posicion(1, 1, new Rocosa());
        Posicion pos2 = new Posicion(2, 1, new Espinas());

        tablero.colocarAlgoformer(pos1, optimus);

        Assert.assertTrue(optimus.obtenerVida() == 500);

        
        //jugador1.moverAPosicion(optimus, pos2);
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();

        posiciones.add(pos2);
        jugador1.moverAPosiciones(optimus, posiciones);

        Assert.assertTrue(optimus.obtenerVida() == 475);

    }
    @Test
    public void testMoverAlgoformerTerrestreSobreEspinasModoAlternoQuitaVida() {
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,10,10);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Jugador jugador2 = juego.obtenerJugadorEnEspera();
        Tablero tablero = juego.obtenerTablero();
        Algoformer optimus = jugador1.obtenerListaAlgoformers().get(0);

        Posicion pos1 = new Posicion(1, 1, new Rocosa());
        Posicion pos2 = new Posicion(2, 1, new Espinas());

        tablero.colocarAlgoformer(pos1, optimus);

        jugador1.cambiarModo(optimus);

        // Paso el turno del jugador 2
        jugador2.cambiarModo(jugador2.obtenerListaAlgoformers().get(0));

        Assert.assertTrue(optimus.obtenerVida() == 500);

        //jugador1.moverAPosicion(optimus, pos2);
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();

        posiciones.add(pos2);
        jugador1.moverAPosiciones(optimus, posiciones);

        Assert.assertTrue(optimus.obtenerVida() == 475);

    }	
    @Test(expected=SuperficieNoAtravesableException.class)
    public void testMoverAlgoformerTerrestreSobrePantanoModoHumanoide(){
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,10,10);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Tablero tablero = juego.obtenerTablero();
        Algoformer optimus = jugador1.obtenerListaAlgoformers().get(0);

        Posicion pos1 = new Posicion(1, 1, new Rocosa());
        Posicion pos2 = new Posicion(2, 1, new Pantano());

        tablero.colocarAlgoformer(pos1, optimus);

        Assert.assertTrue(optimus.obtenerPosicion() == pos1);

        //jugador1.moverAPosicion(optimus, pos2);
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();

        posiciones.add(pos2);

        jugador1.moverAPosiciones(optimus, posiciones);

        Assert.assertTrue(optimus.obtenerPosicion() == pos1);
    }
    @Test
    public void testMoverAlgoformerTerrestreSobrePantanoModoAlgoformer(){
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,10,10);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Tablero tablero = juego.obtenerTablero();
        Algoformer optimus = jugador1.obtenerListaAlgoformers().get(0);

        Posicion pos1 = new Posicion(1, 1, new Rocosa());

        tablero.colocarAlgoformer(pos1, optimus);

        optimus.cambiarModo(); //No se lo pido a jugador así no pasa de turno

        Assert.assertTrue(optimus.obtenerPosicion() == pos1);

        //jugador1.moverAPosicion(optimus, pos2);
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
        //comando - movimientos restantes
        posiciones.add(new Posicion(2,1,new Pantano())); //5->4
        posiciones.add(new Posicion(3,1,new Rocosa()));  //4->2
        posiciones.add(new Posicion(4,1,new Rocosa()));  //2->1
        posiciones.add(new Posicion(5,1,new Rocosa()));  //1->0, aqui se cumplen 5 movs.
        posiciones.add(new Posicion(6,1,new Rocosa()));  //0->-1
        posiciones.add(new Posicion(7,1,new Rocosa())); //No deberia llegar a esta posicion
        
        
        try {
            jugador1.moverAPosiciones(optimus, posiciones);
            
            //no deberiamos llegar aca
            throw new AssertionError();
        } catch (ObjetivoMuyLejosException e){
             Assert.assertEquals(optimus.obtenerPosicion(),new Posicion(5,1,new Rocosa()));
        }
    }
    @Test
    public void testMoverAlgoformerTerrestreSobreRocosoPosicionFinalEsCorrecta(){
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,10,10);
        Jugador jugador1 = juego.obtenerJugadorActual();
        Tablero tablero = juego.obtenerTablero();
        Algoformer optimus = jugador1.obtenerListaAlgoformers().get(0);

        Posicion pos1 = new Posicion(1, 1, new Rocosa());

        tablero.colocarAlgoformer(pos1, optimus);

        optimus.cambiarModo(); //No se lo pido a jugador así no pasa de turno

        Assert.assertTrue(optimus.obtenerPosicion() == pos1);

        //jugador1.moverAPosicion(optimus, pos2);
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
        //comando - movimientos restantes
        posiciones.add(new Posicion(2,1,new Rocosa())); //5->4
        posiciones.add(new Posicion(3,1,new Rocosa())); //4->3
        posiciones.add(new Posicion(4,1,new Rocosa())); //3->2
        posiciones.add(new Posicion(5,1,new Rocosa())); //2->1
        posiciones.add(new Posicion(6,1,new Rocosa())); //1->0, aqui se cumplen 5 movs.
        posiciones.add(new Posicion(7,1,new Rocosa())); //No deberia llegar a esta posicion
        
        
        try {
            jugador1.moverAPosiciones(optimus, posiciones);
            
            //no deberiamos llegar aca
            throw new AssertionError();
        } catch (ObjetivoMuyLejosException e){
             Assert.assertEquals(optimus.obtenerPosicion(),new Posicion(6,1,new Rocosa()));
        }
    }
    @Test
    public void testMoverAlgoformerAereoSobreTormentaBajaAtaque() {
        FabricaAlgoformers fabrica = new FabricaAlgoformers();
        Algoformer ratchet = fabrica.crearRatchet();
        ratchet.cambiarModo(); //F22 raptor
        Posicion pos1 = new Posicion(1, 1, new Rocosa());
        Posicion pos2 = new Posicion(1, 1, new TormentaPsionica());

        ratchet.establecerPosicion(pos1);

        int ataqueOriginal = ratchet.obtenerPuntosAtaque();
        ratchet.mover(pos2);
               
        Assert.assertEquals((int)(ataqueOriginal*0.6), ratchet.obtenerPuntosAtaque());

    }
    public void testMoverAlgoformerAereoSobreTormentaDosVecesBajaAtaqueUnaVez() {
        FabricaAlgoformers fabrica = new FabricaAlgoformers();
        Algoformer ratchet = fabrica.crearRatchet();
        ratchet.cambiarModo(); //F22 raptor
        Posicion pos1 = new Posicion(1, 1, new Rocosa());
        Posicion pos2 = new Posicion(1, 1, new TormentaPsionica());
        Posicion pos3 = new Posicion(1, 2, new TormentaPsionica());

        ratchet.establecerPosicion(pos1);

        int ataqueOriginal = ratchet.obtenerPuntosAtaque();
        ratchet.mover(pos2);
        ratchet.mover(pos3);
               
        Assert.assertEquals((int)(ataqueOriginal*0.6), ratchet.obtenerPuntosAtaque());

    }
    @Test(expected=EncadenadoException.class)
    public void testMoverAlgoformerAereoSobreAndromedaLuegoNoPermiteMover() {
        FabricaAlgoformers fabrica = new FabricaAlgoformers();
        Algoformer ratchet = fabrica.crearRatchet();
        ratchet.cambiarModo(); //F22 raptor
        Posicion pos1 = new Posicion(1, 1, new Rocosa());
        Posicion pos2 = new Posicion(1, 1, new NebulosaDeAndromeda());
        Posicion pos3 = new Posicion(1, 2, new TormentaPsionica());

        ratchet.establecerPosicion(pos1);

        int ataqueOriginal = ratchet.obtenerPuntosAtaque();
        ratchet.mover(pos2);
        ratchet.mover(pos3);

    }
    @Test
    public void testMoverAlgoformerAereoSobreAndromedaDesapareceEn3Turnos() {
        FabricaAlgoformers fabrica = new FabricaAlgoformers();
        Algoformer ratchet = fabrica.crearRatchet();
        ratchet.cambiarModo(); //F22 raptor
        Posicion pos1 = new Posicion(1, 1, new Rocosa());
        Posicion pos2 = new Posicion(1, 1, new NebulosaDeAndromeda());
        Posicion pos3 = new Posicion(1, 2, new TormentaPsionica());

        ratchet.establecerPosicion(pos1);

        int ataqueOriginal = ratchet.obtenerPuntosAtaque();
        ratchet.mover(pos2);
        
        for(int i=0; i<3; i++) {
            try {
                ratchet.mover(pos3);
            } catch(EncadenadoException e) {
                ratchet.pasarTurno();
            }
        }
        //Ahora esta libre
        ratchet.mover(pos3);
        Assert.assertEquals(ratchet.obtenerPosicion(),pos3);

    }
}
