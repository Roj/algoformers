/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Matias
 */
public class Tablero {
    private Map<Posicion,Ubicable> tablero;
    int dimX;
    int dimY;
            
    public Tablero(int X,int Y){
        this.tablero = new HashMap<>();
        this.dimX = X;
        this.dimY = Y;
        this.inicializarTablero();
    }

    private void inicializarTablero(){    	    	
    	List<Superficie> superficiesTierra = new ArrayList<Superficie>();
    	List<Superficie> superficiesAereas = new ArrayList<Superficie>();
    	
    	superficiesTierra.add(new Rocosa());
    	superficiesTierra.add(new Espinas());
    	superficiesTierra.add(new Pantano());
    	
    	superficiesAereas.add(new Nube());
    	superficiesAereas.add(new NebulosaDeAndromeda());
    	superficiesAereas.add(new TormentaPsionica());
    	
        setearMapa(superficiesTierra);
        setearMapa(superficiesAereas);
    	//inicializarUnTablero(superficiesTierra);
    	//inicializarUnTablero(superficiesAereas);          
    }
    private void inicializarUnTablero(List<Superficie> superficies) {
    	Random random = new Random();    	
    	
        for (int i=0;i<this.dimX;i++){
            for (int j=0;j<this.dimY;j++){            	
            	int numAleatorio = (int)(random.nextDouble() * superficies.size());
            	
                Posicion posicion = new Posicion(i,j, superficies.get(numAleatorio));                     
                Vacio nuevoEspacio = new Vacio();
                nuevoEspacio.establecerPosicion(posicion);
                this.tablero.put(posicion,nuevoEspacio);
            }
        }     	
    }
    
    private void setearMapa(List<Superficie> superficies) {
        rellenarRocosoNube(superficies);
        rellenarPantanoTormenta(superficies);
        rellenarEspinaNebulosa(superficies);
    }
    
    private void rellenarRocosoNube(List<Superficie> superficies){
        for (int i=0;i<this.dimX/4;i++){
            for (int j=0;j<this.dimY;j++){            	
            	
                Posicion posicion = new Posicion(i,j, superficies.get(0));                     
                Vacio nuevoEspacio = new Vacio();
                nuevoEspacio.establecerPosicion(posicion);
                this.tablero.put(posicion,nuevoEspacio);
            }
        }
        
        for (int i=4;i<this.dimX;i++){
            for (int j=0;j<this.dimY/4;j++){            	
            	
                Posicion posicion = new Posicion(i,j, superficies.get(0));                     
                Vacio nuevoEspacio = new Vacio();
                nuevoEspacio.establecerPosicion(posicion);
                this.tablero.put(posicion,nuevoEspacio);
            }
        }
        
        for (int i=this.dimX - this.dimX/4;i<this.dimX;i++){
            for (int j=this.dimY/4;j<this.dimY;j++){            	
            	
                Posicion posicion = new Posicion(i,j, superficies.get(0));                     
                Vacio nuevoEspacio = new Vacio();
                nuevoEspacio.establecerPosicion(posicion);
                this.tablero.put(posicion,nuevoEspacio);
            }
        }
        
        for (int i=this.dimX/4;i<this.dimX - this.dimX/4;i++){
            for (int j=this.dimY - this.dimY/4;j<this.dimY;j++){            	
            	
                Posicion posicion = new Posicion(i,j, superficies.get(0));                     
                Vacio nuevoEspacio = new Vacio();
                nuevoEspacio.establecerPosicion(posicion);
                this.tablero.put(posicion,nuevoEspacio);
            }
        }
    }
    
    private void rellenarEspinaNebulosa(List<Superficie> superficies){
        for (int i=dimX/4;i<this.dimX/4 + this.dimX/8;i++){
            for (int j=dimY/4;j<this.dimY - this.dimY/4;j++){            	
            	
                Posicion posicion = new Posicion(i,j, superficies.get(1));                     
                Vacio nuevoEspacio = new Vacio();
                nuevoEspacio.establecerPosicion(posicion);
                this.tablero.put(posicion,nuevoEspacio);
            }
        }
        
        for (int i=this.dimX/4 + this.dimX/8;i<this.dimX-this.dimX/4;i++){
            for (int j=this.dimY/4;j<this.dimY/4 + this.dimY/8;j++){            	
            	
                Posicion posicion = new Posicion(i,j, superficies.get(1));                     
                Vacio nuevoEspacio = new Vacio();
                nuevoEspacio.establecerPosicion(posicion);
                this.tablero.put(posicion,nuevoEspacio);
            }
        }
        
        for (int i=this.dimX - this.dimX/4 - this.dimX/8;i<this.dimX-this.dimX/4;i++){
            for (int j=this.dimY/4 + this.dimY/8 ;j<this.dimY-this.dimY/4;j++){            	
            	
                Posicion posicion = new Posicion(i,j, superficies.get(1));                     
                Vacio nuevoEspacio = new Vacio();
                nuevoEspacio.establecerPosicion(posicion);
                this.tablero.put(posicion,nuevoEspacio);
            }
        }
        
        for (int i=this.dimX/4 + this.dimX/8;i<this.dimX - this.dimX/4 - this.dimX/8;i++){
            for (int j=this.dimY - this.dimY/4 - this.dimY/8 ;j<this.dimY-this.dimY/4;j++){            	
            	
                Posicion posicion = new Posicion(i,j, superficies.get(1));                     
                Vacio nuevoEspacio = new Vacio();
                nuevoEspacio.establecerPosicion(posicion);
                this.tablero.put(posicion,nuevoEspacio);
            }
        }
    }
    
    private void rellenarPantanoTormenta(List<Superficie> superficies){
        for (int i=this.dimX/4 + this.dimX/8;i<this.dimX - this.dimX/4 - this.dimX/8;i++){
            for (int j=this.dimY/4 + this.dimY/8 ;j<this.dimY-this.dimY/4 - this.dimY/8;j++){            	
            	
                Posicion posicion = new Posicion(i,j, superficies.get(2));                     
                Vacio nuevoEspacio = new Vacio();
                nuevoEspacio.establecerPosicion(posicion);
                this.tablero.put(posicion,nuevoEspacio);
            }
        }
    }
    
    public void verificarReemplazable(Posicion pos, Algoformer algof) {
        Ubicable ubicableEnPosicion = this.tablero.get(pos);
        ubicableEnPosicion.reemplazar(algof);
    }
    public void colocarAlgoformer(Posicion posicion,Algoformer algoformer){
        this.verificarReemplazable(posicion,algoformer);
        
        algoformer.establecerPosicion(posicion);
        this.agregarUbicable(posicion, algoformer);
    }
    
    
    public void moverAlgoformer(List<Posicion> posiciones,Algoformer algoformer){    	    	
    	for (Posicion siguientePos : posiciones) {

            this.verificarReemplazable(siguientePos,algoformer);
            
            Posicion viejaPos = algoformer.obtenerPosicion();
            
            algoformer.mover(siguientePos);
            
            //Si todo sale bien
            this.agregarUbicable(siguientePos, algoformer);
            this.borrarUbicable(viejaPos);	        
            
	}   	
    	               
    }    
    public void agregarUbicable(Posicion posicion,Ubicable nuevoUbicable){
        this.tablero.put(posicion, nuevoUbicable);
        nuevoUbicable.establecerPosicion(posicion);
    }
    
    public void borrarUbicable(Posicion posicion){
        Vacio nuevoEspacio = new Vacio();
        nuevoEspacio.establecerPosicion(posicion);
        this.tablero.put(posicion,nuevoEspacio);
    }

    public boolean estaVacio(Posicion posicion){
         return this.tablero.get(posicion) instanceof Vacio;
    }
    
    public Ubicable obtenerUbicable(Posicion posicion) {
        Ubicable ubicable = tablero.get(posicion);
        return ubicable;
    }
    public int obtenerDimension(){
        return dimX;
    }
    public List<Posicion> obtenerListaDePosiciones() {
    	return new ArrayList<Posicion>(this.tablero.keySet());
    }
}
