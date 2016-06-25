package algoformers;

import algoformers.modelo.tablero.Tablero;
import algoformers.modelo.tablero.Ubicable;
import algoformers.modelo.juego.ObjetivoMuyLejosException;
import algoformers.modelo.superficie.Nube;
import algoformers.modelo.superficie.Rocosa;
import algoformers.modelo.juego.Jugador;
import algoformers.modelo.juego.NoSePuedeCombinarException;
import algoformers.modelo.juego.NoSuperponibleException;
import algoformers.modelo.bonus.Bonus;
import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.tablero.Posicion;
import algoformers.modelo.tablero.ChispaSuprema;
import algoformers.modelo.juego.Juego;
import algoformers.modelo.juego.AtaqueInvalidoException;
import algoformers.modelo.mapa.MapaChico;
import algoformers.modelo.juego.NoEsSuTurnoException;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author joaquintz
 */
public class JuegoTest {
    @Test
    public void testJuegoCreaConNombresCorrectos() {
        String jugador1 = "Juan";
        String jugador2 = "John";
        Juego juego = new Juego(jugador1,jugador2,new MapaChico());
        
        Assert.assertTrue(jugador1.equals(juego.obtenerJugadorActual().obtenerNombre()));
        
        juego.avanzarTurno();
        
        Assert.assertTrue(jugador2.equals(juego.obtenerJugadorActual().obtenerNombre()));
    }
    @Test
    public void testVerificarTurnoEsElJugadorActual() {
        String jugador1 = "Juan";
        String jugador2 = "John";
        Juego juego = new Juego(jugador1,jugador2,new MapaChico());
        
        Jugador jugadorJuan = juego.obtenerJugadorActual();
        juego.avanzarTurno();
        Jugador jugadorJohn = juego.obtenerJugadorActual();
        
        juego.avanzarTurno();
        
        
        Assert.assertTrue(juego.verificarTurno(jugadorJuan));
        
        juego.avanzarTurno();
        
        
        Assert.assertTrue(juego.verificarTurno(jugadorJohn));
    }
    @Test(expected=NoEsSuTurnoException.class)
    public void testVerificarTurnoLanzaExcepcionDebeLanzarExcepcion() {
        String jugador1 = "Juan";
        String jugador2 = "John";
        Juego juego = new Juego(jugador1,jugador2,new MapaChico());
        
        Jugador jugadorJuan = juego.obtenerJugadorActual();
        juego.avanzarTurno();
        
        juego.verificarTurno(jugadorJuan);
    }
    @Test
    public void testAtacarExitosamenteCambiaTurno() {
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,new MapaChico());
        Jugador jugador1 = juego.obtenerJugadorActual();
        Jugador jugador2 = juego.obtenerJugadorEnEspera();
        Tablero tablero = juego.obtenerTablero();
        
        Algoformer algoformerj1 = jugador1.obtenerListaAlgoformers().get(0);
        Algoformer algoformerj2 = jugador2.obtenerListaAlgoformers().get(0);
        
        tablero.colocarAlgoformer(new Posicion(1,1, new Rocosa()),algoformerj1);
        tablero.colocarAlgoformer(new Posicion(2,1, new Rocosa()),algoformerj2);
        
        
        
        Assert.assertTrue(juego.verificarTurno(jugador1));
        jugador1.atacarPosicion(algoformerj1,new Posicion(2,1, new Rocosa()));
        
        Assert.assertTrue(juego.verificarTurno(jugador2));
        
        
    }
    @Test
    public void testAtacarMuyLejosNoCambiaTurno() {
//        En versiones anteriores se verificaba por el modelo
//        En la version actual la vista no permite atacar a algoformers fuera del rango de ataque


//        String nombre1 = "Juan";
//        String nombre2 = "John";
//        Juego juego = new Juego(nombre1,nombre2,new MapaChico());
//        Jugador jugador1 = juego.obtenerJugadorActual();
//        
//        Tablero tablero = juego.obtenerTablero();
//        
//        Algoformer algoformer = jugador1.obtenerListaAlgoformers().get(0);
//        
//        tablero.colocarAlgoformer(new Posicion(1,1, new Rocosa()),algoformer);
//        
//        Assert.assertTrue(juego.verificarTurno(jugador1));
//
//        try {
//            jugador1.atacarPosicion(algoformer,new Posicion(15,1, new Rocosa()));
//            
//            //Si esto sigue ejecutando caimos en un error
//            throw new AssertionError();
//        } catch(ObjetivoMuyLejosException e) {
//            Assert.assertTrue(juego.verificarTurno(jugador1));
//        }

    }
    @Test
    public void testAtacarMismoBandoNoCambiaTurno() {
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,new MapaChico());
        Jugador jugador1 = juego.obtenerJugadorActual();
        
        Tablero tablero = juego.obtenerTablero();
        Algoformer algoformer1 = jugador1.obtenerListaAlgoformers().get(0);
        Algoformer algoformer2 = jugador1.obtenerListaAlgoformers().get(1);
        tablero.colocarAlgoformer(new Posicion(1,1, new Rocosa()),algoformer1);
        tablero.colocarAlgoformer(new Posicion(2,1, new Rocosa()),algoformer2);
        
        Assert.assertTrue(juego.verificarTurno(jugador1));
        try {
            jugador1.atacarPosicion(algoformer1,new Posicion(2,1, new Rocosa()));
            //Si esto sigue ejecutando caimos en un error
            throw new AssertionError();
        } catch(AtaqueInvalidoException e) {
            Assert.assertTrue(juego.verificarTurno(jugador1));
        }        
    }
    @Test 
    public void testAtacarAlgoformerEnemigoLeBajaVida() {
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2, new MapaChico());
        Jugador jugador1 = juego.obtenerJugadorActual();
        Jugador jugador2 = juego.obtenerJugadorEnEspera();
        Tablero tablero = juego.obtenerTablero();
        
        Algoformer algoformerj1 = jugador1.obtenerListaAlgoformers().get(0);
        Algoformer algoformerj2 = jugador2.obtenerListaAlgoformers().get(0);
        tablero.colocarAlgoformer(new Posicion(1,1, new Rocosa()),algoformerj1);
        tablero.colocarAlgoformer(new Posicion(2,1, new Rocosa()),algoformerj2);
        
        int vidaEnemigoOriginal = algoformerj2.obtenerVida();
        
        Assert.assertTrue(juego.verificarTurno(jugador1));
        jugador1.atacarPosicion(algoformerj1,new Posicion(2,1, new Rocosa()));
        
        Assert.assertTrue(vidaEnemigoOriginal > algoformerj2.obtenerVida());
    }
    @Test
    public void testAtacarAlVacioNoCambiaTurno() {
//        En versiones anteriores se verificaba por el modelo
//        En la version actual la vista no permite atacar a posiciones vacias

        
        
//        String nombre1 = "Juan";
//        String nombre2 = "John";
//        Juego juego = new Juego(nombre1,nombre2, new MapaChico());
//        Jugador jugador1 = juego.obtenerJugadorActual();
//        Tablero tablero = juego.obtenerTablero();
//        
//        Algoformer algoformer1 = jugador1.obtenerListaAlgoformers().get(0);
//        
//        tablero.colocarAlgoformer(new Posicion(1,1, new Rocosa()),algoformer1);
//        
//        
//        Assert.assertTrue(juego.verificarTurno(jugador1));
//
//        try {
//            jugador1.atacarPosicion(algoformer1,new Posicion(2,1, new Rocosa()));
//            
//            //Si esto sigue ejecutando caimos en un error
//            throw new AssertionError();
//        } catch(AtaqueInvalidoException e) {
//            Assert.assertTrue(juego.verificarTurno(jugador1));
//        }    
    }
    @Test
    public void testMoverExitosamenteCambiaLaPosicion(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        Juego juego = new Juego(nombre1,nombre2,new MapaChico());
        Jugador jugador1 = juego.obtenerJugadorActual();
        Tablero tablero = juego.obtenerTablero();
        Posicion posicionInicial = new Posicion(1,1, new Rocosa());
        
        Algoformer algo1 = jugador1.obtenerListaAlgoformers().get(0);
        tablero.colocarAlgoformer(posicionInicial,algo1);
        
        Assert.assertTrue(algo1.obtenerPosicion()==posicionInicial);
        
        Posicion posicionFinal = new Posicion(2,1, new Rocosa());
        
        
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
        
        posiciones.add(posicionFinal);
        jugador1.moverAPosiciones(algo1, posiciones);
        
        Assert.assertTrue(algo1.obtenerPosicion()==posicionFinal);
    }
    @Test
    public void testMoverExitosamentePoneVacioEnSuViejoLugar(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        Juego juego = new Juego(nombre1,nombre2,new MapaChico());
        Jugador jugador1 = juego.obtenerJugadorActual();
        Tablero tablero = juego.obtenerTablero();
        Posicion posicionInicial = new Posicion(1,1, new Rocosa());
        Algoformer algo1 = jugador1.obtenerListaAlgoformers().get(0);
        
        tablero.colocarAlgoformer(posicionInicial,algo1);
        
        Assert.assertEquals(algo1.obtenerPosicion(), posicionInicial);
        
        Posicion posicionFinal = new Posicion(2,1, new Rocosa());
        
        
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
        
        posiciones.add(posicionFinal);
        jugador1.moverAPosiciones(algo1, posiciones);
        
        //comparamos punteros
        Assert.assertTrue(tablero.obtenerUbicable(posicionInicial) != algo1);
    }
    @Test
    public void testMoverExitosamenteCambiaJugador(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        Juego juego = new Juego(nombre1,nombre2,new MapaChico());
        Jugador jugador1 = juego.obtenerJugadorActual();
        Jugador jugador2 = juego.obtenerJugadorEnEspera();
        Tablero tablero = juego.obtenerTablero();
        Posicion posicionInicial = new Posicion(1,1, new Rocosa());
        Algoformer algoformer1 = jugador1.obtenerListaAlgoformers().get(0);
        tablero.colocarAlgoformer(posicionInicial,algoformer1);
        
        Assert.assertTrue(juego.verificarTurno(jugador1));
        Posicion posicionFinal = new Posicion(2,1, new Rocosa());
        //jugador1.moverAPosicion(algoformer1,posicionFinal);
        
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
        
        posiciones.add(posicionFinal);
        jugador1.moverAPosiciones(algoformer1, posiciones);
        
        Assert.assertTrue(juego.verificarTurno(jugador2));        
    }
    @Test
    public void testMoverMuyLejosNoCambiaJugador(){
//        En versiones anteriores se verificaba por el modelo
//        En la version actual la vista no permite realizar movimientos hasta donde la velocidad le permite
        
//        String nombre1 = "Juan";
//        String nombre2 = "Jhon";
//        Juego juego = new Juego(nombre1,nombre2, new MapaChico());
//        Jugador jugador1 = juego.obtenerJugadorActual();
//        Tablero tablero = juego.obtenerTablero();
//        Posicion posicionInicial = new Posicion(0,0, new Rocosa());
//        Algoformer algoformer1 = jugador1.obtenerListaAlgoformers().get(0);
//        
//        Assert.assertTrue(juego.verificarTurno(jugador1));
//        
//        try{
//            ArrayList<Posicion> pasos = new ArrayList<>();
//        
//            pasos.add(new Posicion(0,1, new Rocosa()));
//            pasos.add(new Posicion(0,2, new Rocosa()));
//            pasos.add(new Posicion(0,3, new Rocosa()));
//            pasos.add(new Posicion(0,4, new Rocosa()));
//            pasos.add(new Posicion(0,5, new Rocosa()));
//            pasos.add(new Posicion(0,6, new Rocosa()));
//            pasos.add(new Posicion(0,7, new Rocosa()));
//            pasos.add(new Posicion(0,8, new Rocosa()));
//
//            jugador1.moverAPosiciones(algoformer1, pasos);
//            
//            //Si llegamos aca, fallo el test.
//            throw new AssertionError();
//        } catch(ObjetivoMuyLejosException e) {
//            Assert.assertTrue(juego.verificarTurno(jugador1));
//        }        
    }
    
    @Test
    public void testMoverAPosicionConAlgoformerNoCambiaJugador(){
//        En versiones anteriores se verificaba por el modelo
//        En la version actual la vista no permite realizar movimientos donde hay otro algoformer
        
        
//        String nombre1 = "Juan";
//        String nombre2 = "Jhon";
//        Juego juego = new Juego(nombre1,nombre2, new MapaChico());
//        Jugador jugador1 = juego.obtenerJugadorActual();
//        Jugador jugador2 = juego.obtenerJugadorEnEspera();
//        Tablero tablero = juego.obtenerTablero();
//        Algoformer algoformerj1 = jugador1.obtenerListaAlgoformers().get(0);
//        Algoformer algoformerj2 = jugador2.obtenerListaAlgoformers().get(0);
//        tablero.colocarAlgoformer(new Posicion(1,1, new Rocosa()),algoformerj1);
//        tablero.colocarAlgoformer(new Posicion(1,2, new Rocosa()),algoformerj2);
//
//        Assert.assertTrue(juego.verificarTurno(jugador1));
//        
//        try{
//            Posicion posicionFinal = new Posicion(1,2, new Rocosa());
//            
//            ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
//            
//            posiciones.add(posicionFinal);
//            jugador1.moverAPosiciones(algoformerj1, posiciones); 
//            
//            throw new AssertionError();
//        } catch(NoSuperponibleException e) {
//            Assert.assertTrue(juego.verificarTurno(jugador1));
//        }        
    }
    @Test(expected=ObjetivoMuyLejosException.class)
    public void testMoverAPosicionMuyLejosLanzaObjetoMuyLejosException(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        
        Juego juego = new Juego(nombre1,nombre2,new MapaChico());
        Jugador jugador1 = juego.obtenerJugadorActual();
        
        Tablero tablero = juego.obtenerTablero();
        
        Algoformer algoformer = jugador1.obtenerListaAlgoformers().get(0);
        Posicion posicionInicial = new Posicion(0,0, new Rocosa());
        
        
        ArrayList<Posicion> pasos = new ArrayList<>();
        
        pasos.add(new Posicion(0,1, new Rocosa()));
        pasos.add(new Posicion(0,2, new Rocosa()));
        pasos.add(new Posicion(0,3, new Rocosa()));
        pasos.add(new Posicion(0,4, new Rocosa()));
        pasos.add(new Posicion(0,5, new Rocosa()));
        pasos.add(new Posicion(0,6, new Rocosa()));
        pasos.add(new Posicion(0,7, new Rocosa()));
        pasos.add(new Posicion(0,8, new Rocosa()));
        
        jugador1.moverAPosiciones(algoformer, pasos);
    }
    @Test(expected=NoSuperponibleException.class)
    public void testMoverAPosicionConAlgoformerNoSuperponibleException(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        Juego juego = new Juego(nombre1,nombre2, new MapaChico());
        Jugador jugador1 = juego.obtenerJugadorActual();
        Jugador jugador2 = juego.obtenerJugadorEnEspera();
        Tablero tablero = juego.obtenerTablero();
        Algoformer algoformerj1 = jugador1.obtenerListaAlgoformers().get(0);
        Algoformer algoformerj2 = jugador2.obtenerListaAlgoformers().get(0);
        tablero.colocarAlgoformer(new Posicion(1,1, new Rocosa()),algoformerj1);
        tablero.colocarAlgoformer(new Posicion(1,2, new Rocosa()),algoformerj2);
        
        Posicion posicionFinal = new Posicion(1,2, new Rocosa());
        //jugador1.moverAPosicion(algoformerj1,posicionFinal);      
        ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
        
        posiciones.add(posicionFinal);
        jugador1.moverAPosiciones(algoformerj1, posiciones);        
        
    }
    @Test
    public void testUbicarChispaEnCentroDelTablero(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        Juego juego = new Juego(nombre1,nombre2, new MapaChico());

        Tablero tablero = juego.obtenerTablero();
        Ubicable chispa = tablero.obtenerUbicable(new Posicion(7, 7, new Rocosa()));
        
        Assert.assertTrue(chispa instanceof ChispaSuprema); 
    }
    @Test
    public void testCambiarModoCambiaJugador(){
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        Juego juego = new Juego(nombre1,nombre2, new MapaChico());
        Jugador jugador1 = juego.obtenerJugadorActual();
        Jugador jugador2 = juego.obtenerJugadorEnEspera();
        Tablero tablero = juego.obtenerTablero();
        Posicion posicionInicial = new Posicion(1,1, new Rocosa());
        Algoformer algoformer1 = jugador1.obtenerListaAlgoformers().get(0);
        tablero.colocarAlgoformer(posicionInicial,algoformer1);
        
        Assert.assertTrue(juego.verificarTurno(jugador1));

        jugador1.cambiarModo(algoformer1);
        
        Assert.assertTrue(juego.verificarTurno(jugador2));        
    }    
    @Test
    public void testLosPuntosDeMovimientoSeReinicianAlCambiarTurno() {
        String nombre1 = "Juan";
        String nombre2 = "Jhon";
        
        Juego juego = new Juego(nombre1,nombre2,new MapaChico());
        Jugador jugador1 = juego.obtenerJugadorActual();
        Jugador jugador2 = juego.obtenerJugadorEnEspera();
        
        Tablero tablero = juego.obtenerTablero();
        
        Algoformer algoformer = jugador1.obtenerListaAlgoformers().get(0);
        Algoformer algoformerEnemigo = jugador2.obtenerListaAlgoformers().get(0);
        Posicion posicionInicial = new Posicion(0,0, new Rocosa());
        
        
        ArrayList<Posicion> pasos = new ArrayList<>();
        
        //optimus en humanoide tiene velocidad =2
        pasos.add(new Posicion(0,1, new Rocosa()));
        pasos.add(new Posicion(0,2, new Rocosa()));
        jugador1.moverAPosiciones(algoformer, pasos);
        
        //mandamos una acción que pase el turno
                
        tablero.colocarAlgoformer(posicionInicial,algoformerEnemigo);
        jugador2.cambiarModo(jugador2.obtenerListaAlgoformers().get(0));
        
        
        pasos = new ArrayList<>();
        //ahora es turno de jugador1
        pasos.add(new Posicion(0,3, new Rocosa()));
        pasos.add(new Posicion(0,4, new Rocosa()));
        jugador1.moverAPosiciones(algoformer, pasos);
        
        Assert.assertEquals(algoformer.obtenerPosicion().obtenerX(),0);
        Assert.assertEquals(algoformer.obtenerPosicion().obtenerY(),4);
    }
    
    @Test
    public void testCombinarAlgoformersSeteaSupremoEnPosicionDeseada() {
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,new MapaChico());
        Jugador jugador1 = juego.obtenerJugadorActual();
        
        Tablero tablero = juego.obtenerTablero();
        
        List<Algoformer> algoformers = jugador1.obtenerListaAlgoformers();
        List<Algoformer> algoformersACombinar = algoformers;
        Algoformer supremo = (Algoformer) jugador1.obtenerSupremo();
        
        List<Posicion> posiciones = new ArrayList<Posicion>();
        
        for (Algoformer alg : algoformersACombinar) {
        	Posicion pos = alg.obtenerPosicion();
        	
        	posiciones.add(pos);        	
        }
        
        jugador1.combinarAlgoformers(posiciones.get(1), algoformersACombinar);
        
        Assert.assertTrue(tablero.estaVacio(posiciones.get(0)));
        Assert.assertFalse(tablero.estaVacio(posiciones.get(1)));
        Assert.assertTrue(tablero.estaVacio(posiciones.get(2)));     
        
        Assert.assertEquals(supremo.obtenerPosicion().equals(posiciones.get(1)), true);        
        //Assert.assertEquals(supremo.obtenerPosicion().equals(pos2), true);
    } 
    @Test
    public void testCombinarAlgoformersCreaSupremoConVidaSumaDeTodos() {
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,new MapaChico());
        Jugador jugador1 = juego.obtenerJugadorActual();
        
        Tablero tablero = juego.obtenerTablero();
        
        List<Algoformer> algoformers = jugador1.obtenerListaAlgoformers();
        List<Algoformer> algoformersACombinar = algoformers;
        Algoformer supremo = (Algoformer) jugador1.obtenerSupremo();
        
        List<Posicion> posiciones = new ArrayList<Posicion>();
        
        for (Algoformer alg : algoformersACombinar) {
        	Posicion pos = alg.obtenerPosicion();
        	
        	posiciones.add(pos);        	
        }
        
        jugador1.combinarAlgoformers(posiciones.get(1), algoformersACombinar);
        
        Assert.assertTrue(supremo.obtenerVida() == 1000);
      
    }     
    @Test(expected=NoSePuedeCombinarException.class)
    public void testCombinarAlgoformersSobrePosicionInvalida() {
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,new MapaChico());
        Jugador jugador1 = juego.obtenerJugadorActual();
        
        Tablero tablero = juego.obtenerTablero();
        
        List<Algoformer> algoformers = jugador1.obtenerListaAlgoformers();
        List<Algoformer> algoformersACombinar = algoformers;
        Algoformer supremo = (Algoformer) jugador1.obtenerSupremo();
        
        Posicion posAire = new Posicion(1, 1, new Nube());
        
        List<Posicion> posiciones = new ArrayList<Posicion>();
        
        for (Algoformer alg : algoformersACombinar) {
        	Posicion pos = alg.obtenerPosicion();
        	
        	posiciones.add(pos);        	
        }
        
        jugador1.combinarAlgoformers(posAire, algoformersACombinar);
    } 
    @Test
    public void testCombinarAlgoformersSobrePosicionInvalidaNoSacaAlgoformers() {
        String nombre1 = "Juan";
        String nombre2 = "John";
        Juego juego = new Juego(nombre1,nombre2,new MapaChico());
        Jugador jugador1 = juego.obtenerJugadorActual();
        
        Tablero tablero = juego.obtenerTablero();
        
        List<Algoformer> algoformers = jugador1.obtenerListaAlgoformers();
        List<Algoformer> algoformersACombinar = algoformers;
        Algoformer supremo = (Algoformer) jugador1.obtenerSupremo();
        
        Posicion posAire = new Posicion(1, 1, new Nube());
        
        List<Posicion> posiciones = new ArrayList<Posicion>();
        
        for (Algoformer alg : algoformersACombinar) {
        	Posicion pos = alg.obtenerPosicion();
        	
        	posiciones.add(pos);        	
        }
        
        try {
        	jugador1.combinarAlgoformers(posAire, algoformersACombinar);
        } catch(NoSePuedeCombinarException e){
        	Assert.assertFalse(tablero.estaVacio(posiciones.get(0)));
        	Assert.assertFalse(tablero.estaVacio(posiciones.get(1)));
        	Assert.assertFalse(tablero.estaVacio(posiciones.get(2)));            	
        } 
        
    }    
}
