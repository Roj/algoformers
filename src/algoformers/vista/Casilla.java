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
import algoformers.modelo.tablero.ChispaSuprema;
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
	
        Posicion posicion;
	Ubicable ubicable;
        
	public Casilla(int X, int Y,Posicion pos) {
            this.getStylesheets().add("casilla.css");            
            this.posicion = pos;
            this.setSuperficie();
	    	    
	}
	public int getX() {
		return this.posicion.obtenerX();
	}
	public int getY() {
		return this.posicion.obtenerY();
	}
	public void setCoordenadas(int posX, int posY) {
	    this.setTranslateX(posX);
	    this.setTranslateY(posY);			
	}
	
	public void setTamanio(int tamX, int tamY) {
		this.setPrefSize(tamX, tamY);
	}

	public void setUbicable(Ubicable ubi) {
                this.getStyleClass().removeAll("ChispaSuprema","DobleCanon","Flash","BurbujaInmaculada");
		ubi.setUbicable(this);
	}
        
        public void setUbicable(Algoformer algoformer){
            this.ubicable = algoformer;
            this.getStyleClass().add(algoformer.getStyle());
            
        }
	
        public void setUbicable(Vacio vacio){
            this.ubicable = vacio;
        }

        public void setUbicable(Bonus bonus){
            this.ubicable = bonus;
            bonus.obtenerEfecto().setEfecto(this);
        }
        
        public void setUbicable(ChispaSuprema chispaSuprema){
            this.ubicable = chispaSuprema;
            this.getStyleClass().add("ChispaSuprema");
        }
        
        //Double Dispatch para identificar efecto
        public void setEfecto(BurbujaInmaculada burbuja){
            this.getStyleClass().add("BurbujaInmaculada");
        }
        
        public void setEfecto(Flash flash){
            this.getStyleClass().add("Flash");
        }
        
        public void setEfecto(DobleCañon dobleCañon){
            this.getStyleClass().add("DobleCanon");
        }
        
	public Ubicable getUbicable() {
		return this.ubicable;
	}
        
        public Superficie getSuperficie() {
            return this.posicion.obtenerSuperficie();
        }

        //Double Dispatch para setear superficie
        public void setSuperficie(){            
            this.posicion.obtenerSuperficie().setSuperficie(this);
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
        public void minimizar(){
                this.getStyleClass().remove("Maximizado");
                this.setTamanio(60, 50);
                this.setTranslateY(-25);
                this.getStyleClass().add("Minimizado");
                this.toFront();
        }
        public void maximizar(){
                this.getStyleClass().remove("Minimizado");
                this.getStyleClass().add("Maximizado");
                this.toBack();
        }
        
        public Posicion getPosicion() {
            return this.posicion;
        }

        public Posicion obtenerPosicion() {
            return this.posicion;
        }
    }
