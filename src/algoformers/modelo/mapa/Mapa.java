/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoformers.modelo.mapa;

import algoformers.modelo.superficie.NebulosaDeAndromeda;
import algoformers.modelo.superficie.Pantano;
import algoformers.modelo.superficie.Tierra;
import algoformers.modelo.superficie.Aire;
import algoformers.modelo.superficie.Nube;
import algoformers.modelo.superficie.Espinas;
import algoformers.modelo.superficie.TormentaPsionica;
import algoformers.modelo.superficie.Rocosa;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public abstract class Mapa {
    int dimX;
    int dimY;
    Tierra[][] mapaTierra;
    Aire[][] mapaAire;
    
    public Mapa (int x, int y){
        this.dimX = x;
        this.dimY = y;
    }
    public int obtenerDimX() {
        return this.dimX;
    }
    public int obtenerDimY() {
        return this.dimY;
    }
    public void generarMapaTierra(String[][] matriz) {
        this.mapaTierra = new Tierra[this.dimX][this.dimY];
        
        for(int i=0;i<this.dimX;i++) {
            for(int j=0;j<this.dimY;j++) {
                if(matriz[i][j].equals("r")) {
                    this.mapaTierra[i][j] = new Rocosa(); 
                } else if(matriz[i][j].equals("e")) {
                    this.mapaTierra[i][j] = new Espinas(); 
                } else if(matriz[i][j].equals("p")) {
                    this.mapaTierra[i][j] = new Pantano(); 
                }
            }
        }
    }
    public void generarMapaAire(String[][] matriz) {
        this.mapaAire = new Aire[this.dimX][this.dimY];
        
        for(int i=0;i<this.dimX;i++) {
            for(int j=0;j<this.dimY;j++) {
                if(matriz[i][j].equals("nu")) {
                    this.mapaAire[i][j] = new Nube(); 
                } else if(matriz[i][j].equals("t")) {
                    this.mapaAire[i][j] = new TormentaPsionica(); 
                } else if(matriz[i][j].equals("ne")) {
                    this.mapaAire[i][j] = new NebulosaDeAndromeda(); 
                }
            }
        }
    }
    public Aire[][] obtenerMapaAire() {
        return this.mapaAire;
    }
    public Tierra[][] obtenerMapaTierra() {
        return this.mapaTierra;
    }
}
