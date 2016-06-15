/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.vista;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Matias
 */
public class Contenedor extends StackPane {
    
    public void colocarImagen(Image imagen,String nombreArchivo,int X, int Y){
        imagen = new Image(nombreArchivo);
        ImageView viewImagen = new ImageView();
        viewImagen.setImage(imagen);
        viewImagen.setFitWidth(100);
        viewImagen.setPreserveRatio(true);
        viewImagen.setSmooth(true);
        viewImagen.setCache(true);
        this.getChildren().add(viewImagen);
        viewImagen.setTranslateX(X);
        viewImagen.setTranslateY(Y);
    }

    public void colocarBoton(Button boton,String titulo,int size, int X, int Y){
        boton.setId("boton-juego");;
        boton.setText(titulo);
        boton.getStylesheets().add("botones.css");
        boton.setStyle("-fx-font-size:"+String.valueOf(size)+"px");
        this.getChildren().add(boton);
        boton.setTranslateX(X);
        boton.setTranslateY(Y);
    }
    
    public void colocarCasillero(TextField casillero,int ancho, int X, int Y){
        casillero.setId("text-field");
        casillero.getStylesheets().add("text-field.css");
        casillero.setMaxWidth(ancho);
        this.getChildren().add(casillero);
        casillero.setTranslateX(X);
        casillero.setTranslateY(Y);   
    }
}
