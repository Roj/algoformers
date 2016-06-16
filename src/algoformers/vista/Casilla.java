package algoformers.vista;

import algoformers.controlador.AccionMarcarCasilla;
import algoformers.modelo.Algoformer;
import algoformers.modelo.Bonus;
import algoformers.modelo.Espinas;
import algoformers.modelo.Pantano;
import algoformers.modelo.Posicion;
import algoformers.modelo.Rocosa;
import algoformers.modelo.Superficie;
import algoformers.modelo.Tablero;
import algoformers.modelo.Ubicable;
import algoformers.modelo.Vacio;
import algoformers.modelo.buffs.ChispaSuprema;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Casilla extends Button {
	
	int x;
	int y;
	String txt;
	Ubicable ubicable;
	
	public Casilla(int X, int Y) {
		
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
	public void setPosicion(int posX, int posY) {
	    this.setTranslateX(posX);
	    this.setTranslateY(posY);			
	}
	
	public void setTamanio(int tamX, int tamY) {
		this.setPrefSize(tamX, tamY);
	}
	
	public void setSuperficie(Superficie sup) {
		// Todo esto es para testeo
		if (sup instanceof Rocosa) {
			txt += "\nR";
		}
		if (sup instanceof Pantano) {
			txt += "\nP";		
		}		
		if (sup instanceof Espinas) {
			txt += "\nE";
		}
	}

	public void setUbicable(Ubicable ubi) {
		this.ubicable = ubi;
		// Todo esto es para testeo
		if (ubi instanceof Vacio) {
			txt += " - V";
		}
		if (ubi instanceof Bonus) {
			txt += " - B";
		}	
		if (ubi instanceof Algoformer) {
			txt += " - A";
		}				
		if (ubi instanceof ChispaSuprema) {
			txt += " - C";
		}			
		
		this.setText(txt);
	}	
	
	public Ubicable getUbicable() {
		return this.ubicable;
	}
}
