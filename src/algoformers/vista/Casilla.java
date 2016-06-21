package algoformers.vista;

import algoformers.controlador.AccionMarcarCasilla;
import algoformers.modelo.algoformer.Algoformer;
import algoformers.modelo.bonus.Bonus;
import algoformers.modelo.buffs.BurbujaInmaculada;
import algoformers.modelo.superficie.Espinas;
import algoformers.modelo.superficie.Pantano;
import algoformers.modelo.tablero.Posicion;
import algoformers.modelo.superficie.Rocosa;
import algoformers.modelo.superficie.Superficie;
import algoformers.modelo.tablero.Tablero;
import algoformers.modelo.tablero.Ubicable;
import algoformers.modelo.tablero.Vacio;
import algoformers.modelo.buffs.ChispaSuprema;
import algoformers.modelo.buffs.DobleCañon;
import algoformers.modelo.buffs.Flash;
import algoformers.modelo.superficie.NebulosaDeAndromeda;
import algoformers.modelo.superficie.Nube;
import algoformers.modelo.superficie.TormentaPsionica;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Casilla extends Button {
	
	int x;
	int y;
        Superficie superficie;
	String txt;
	Posicion posicion;
	Ubicable ubicable;
	
	public Casilla(int X, int Y) {
            this.getStylesheets().add("casilla.css");
		txt = String.valueOf(X) + " - " +String.valueOf(Y);
            
	    this.x = X;
	    this.y = Y;
	    	    
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public void setCoordenadas(int posX, int posY) {
	    this.setTranslateX(posX);
	    this.setTranslateY(posY);			
	}
	
	public void setTamanio(int tamX, int tamY) {
		this.setPrefSize(tamX, tamY);
	}
	
	public void setSuperficie(Superficie sup) {

                this.superficie = sup;
                this.setSuperficie();
        }

	public void setUbicable(Ubicable ubi) {
		this.ubicable = ubi;
		ubi.setUbicable(this);
	}
        
        public void setUbicable(Algoformer algoformer){
            this.getStyleClass().add(algoformer.getStyle());
            txt += "- A";
            this.setText(txt);
        }
	
        public void setUbicable(Vacio vacio){
            txt += "- V";
            this.setText(txt);
        }

        public void setUbicable(Bonus bonus){
            bonus.obtenerEfecto().setEfecto(this);
            txt += "- B";
            this.setText(txt);
        }
        
        
        //Double Dispatch para identificar efecto
        public void setEfecto(BurbujaInmaculada burbuja){
            this.getStyleClass().add("Burbuja");
        }
        
        public void setEfecto(Flash flash){
            this.getStyleClass().add("Flash");
        }
        
        public void setEfecto(DobleCañon dobleCañon){
            this.getStyleClass().add("DobleCañon");
        }
        
        //Como implementamos chispa suprema? Actualmente esta como un buff
        public void setUbicable(ChispaSuprema chispa){
            txt += "- C";
            this.setText(txt);
        }
        
	public Ubicable getUbicable() {
		return this.ubicable;
	}


        //Double Dispatch para setear superficie
        public void setSuperficie(){            
            this.superficie.setSuperficie(this);
        }
        public void setSuperficie(Rocosa rocosa){
            this.getStyleClass().add("Rocosa");
        }
        public void setSuperficie(Pantano pantano){
            this.getStyleClass().add("Pantano");
        }
        public void setSuperficie(Espinas espina){
            this.getStyleClass().add("Espina");
        }
        public void setSuperficie(Nube nube){
            this.getStyleClass().add("Nube");
        }
        public void setSuperficie(TormentaPsionica tormentaPsionica){
            this.getStyleClass().add("TormentaPsionica");
        }
        public void setSuperficie(NebulosaDeAndromeda nebulosaDeAndromeda){
            this.getStyleClass().add("NebulosaDeAndromeda");
        }


    }
