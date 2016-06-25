package algoformers.controlador;

import algoformers.modelo.algoformer.Algoformer;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import algoformers.modelo.juego.Juego;
import algoformers.modelo.juego.Jugador;
import algoformers.modelo.tablero.Posicion;
import algoformers.modelo.tablero.Ubicable;
import algoformers.modelo.tablero.Vacio;
import algoformers.vista.Casilla;
import algoformers.vista.ContenedorJuego;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class AccionRealizarAtaque implements EventHandler<ActionEvent> {

	ContenedorJuego contenedorJuego;
	Juego juego;
    
    public AccionRealizarAtaque(ContenedorJuego contJuego, Juego juego) {
        this.contenedorJuego = contJuego;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent event) {

        Casilla casillaActual = this.contenedorJuego.getCasillaActual();
    	List<Casilla> casillasPosiblesAtaque = this.contenedorJuego.getCasillasPosiblesAtaque(casillaActual);
        Algoformer algoformerActual = this.contenedorJuego.getAlgoformerActual();
        if (casillasPosiblesAtaque.contains(casillaActual)){
            Algoformer algoformerEnemigo = (Algoformer) casillaActual.getUbicable();
            Posicion posicionAlgoformerEnemigo = algoformerEnemigo.obtenerPosicion();
            this.juego.obtenerJugadorActual().atacarPosicion(algoformerActual, posicionAlgoformerEnemigo);
            
//            final Rectangle rectPath = new Rectangle (0, 0, 40, 40);
//            rectPath.setArcHeight(10);
//            rectPath.setArcWidth(10);
//            rectPath.setFill(Color.ORANGE);
//
//            Path path = new Path();
//            path.getElements().add(new MoveTo(20,20));
//            path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
//            path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
//            LineTo lineTo = new LineTo();
//            lineTo.setX(casillaActual.getTranslateX());
//            lineTo.setY(casillaActual.getTranslateY());
//            path.getElements().add(lineTo);
//            PathTransition pathTransition = new PathTransition();
//            pathTransition.setDuration(Duration.millis(4000));
//            pathTransition.setPath(path);
//            pathTransition.setNode(rectPath);
//            pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
//            pathTransition.setCycleCount(1);
//            pathTransition.setAutoReverse(true);
//            this.contenedorJuego.getChildren().add(rectPath);
//            pathTransition.play();

            if(!algoformerEnemigo.esta_vivo()){
                //Efecto de explosion de algoformer                
                Image image = new Image("explosion.png");
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setPreserveRatio(true);
                imageView.setFitHeight(casillaActual.getHeight()*0.8);
                imageView.setFitWidth(casillaActual.getWidth()*0.8);
                FadeTransition ft = new FadeTransition();
                ft.setNode(imageView);
                ft.setDuration(new Duration(2000));
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                ft.setCycleCount(1);
                ft.setAutoReverse(true);                
                casillaActual.setGraphic(imageView);
                ft.play();
    		casillaActual.getStyleClass().remove(algoformerEnemigo.getStyle());                
    		Ubicable vacio = new Vacio();
    		casillaActual.setUbicable(vacio);
            }
        }
        
        this.contenedorJuego.pasarTurno();
        this.contenedorJuego.cambiarEstadoCasilla(new AccionMarcarCasilla(this.contenedorJuego, juego));
        
    	this.contenedorJuego.dejarDeMostrarCasillas(casillasPosiblesAtaque);

    }    
}

