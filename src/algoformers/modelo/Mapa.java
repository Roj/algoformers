/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoformers.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Mapa {
    int dimX;
    int dimY;
    Superficie[][] modeloTierra;
    Superficie[][] modeloAire;
    
    public Mapa (int x,int y){
        this.dimX = x;
        this.dimY = y;
        this.modeloTierra = new Superficie[x][y];
        this.modeloAire = new Superficie[x][y];
    }
    
    public void setearMapa1 (){
        setearModelos();
    }
    
    public Superficie[][] getModeloTierra (){
        return modeloTierra;
    }
    
    public Superficie[][] getModeloAire (){
        return modeloAire;
    }
    
    
    private void setearModelos() {
            	    	
    	List<Superficie> superficiesTierra = new ArrayList<Superficie>();
    	List<Superficie> superficiesAereas = new ArrayList<Superficie>();
    	
    	superficiesTierra.add(new Rocosa());
    	superficiesTierra.add(new Espinas());
    	superficiesTierra.add(new Pantano());
    	
    	superficiesAereas.add(new Nube());
    	superficiesAereas.add(new NebulosaDeAndromeda());
    	superficiesAereas.add(new TormentaPsionica());
        
        rellenarRocosoNube(superficiesTierra,modeloTierra);
        rellenarPantanoTormenta(superficiesTierra,modeloTierra);
        rellenarEspinaNebulosa(superficiesTierra,modeloTierra);
        
        rellenarRocosoNube(superficiesAereas,modeloAire);
        rellenarPantanoTormenta(superficiesAereas,modeloAire);
        rellenarEspinaNebulosa(superficiesAereas,modeloAire);
    }
    
    private void rellenarRocosoNube(List<Superficie> superficies,Superficie[][] modelo){
        for (int i=0;i<this.dimX/4;i++){
            for (int j=0;j<this.dimY;j++){            	
            	modelo[i][j] = superficies.get(0);
            }
        }
        
        for (int i=4;i<this.dimX;i++){
            for (int j=0;j<this.dimY/4;j++){            	
            	modelo[i][j] = superficies.get(0);
            }
        }
        
        for (int i=this.dimX - this.dimX/4;i<this.dimX;i++){
            for (int j=this.dimY/4;j<this.dimY;j++){            	
            	modelo[i][j] = superficies.get(0);
            }
        }
        
        for (int i=this.dimX/4;i<this.dimX - this.dimX/4;i++){
            for (int j=this.dimY - this.dimY/4;j<this.dimY;j++){            	
            	modelo[i][j] = superficies.get(0);
            }
        }
    }
    
    private void rellenarEspinaNebulosa(List<Superficie> superficies,Superficie[][] modelo){
        for (int i=dimX/4;i<this.dimX/4 + this.dimX/8;i++){
            for (int j=dimY/4;j<this.dimY - this.dimY/4;j++){            	
            	modelo[i][j] = superficies.get(1);
            }
        }
        
        for (int i=this.dimX/4 + this.dimX/8;i<this.dimX-this.dimX/4;i++){
            for (int j=this.dimY/4;j<this.dimY/4 + this.dimY/8;j++){
            	modelo[i][j] = superficies.get(1);
            }
        }
        
        for (int i=this.dimX - this.dimX/4 - this.dimX/8;i<this.dimX-this.dimX/4;i++){
            for (int j=this.dimY/4 + this.dimY/8 ;j<this.dimY-this.dimY/4;j++){            	
            	modelo[i][j] = superficies.get(1);
            }
        }
        
        for (int i=this.dimX/4 + this.dimX/8;i<this.dimX - this.dimX/4 - this.dimX/8;i++){
            for (int j=this.dimY - this.dimY/4 - this.dimY/8 ;j<this.dimY-this.dimY/4;j++){            	
            	modelo[i][j] = superficies.get(1);
            }
        }
    }
    
    private void rellenarPantanoTormenta(List<Superficie> superficies, Superficie[][] modelo){
        for (int i=this.dimX/4 + this.dimX/8;i<this.dimX - this.dimX/4 - this.dimX/8;i++){
            for (int j=this.dimY/4 + this.dimY/8 ;j<this.dimY-this.dimY/4 - this.dimY/8;j++){            	
            	modelo[i][j] = superficies.get(2);
            }
        }
    }

}
