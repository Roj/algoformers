/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.controlador;

import algoformers.vista.ContenedorCargaDeDatos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Matias
 */
public class AccionSetearTablero implements EventHandler<ActionEvent> {

    ContenedorCargaDeDatos contenedorDeCarga;
    int dimension;
    
    public AccionSetearTablero(int dimension, ContenedorCargaDeDatos contenedorDeCarga) {
        this.dimension = dimension;
        this.contenedorDeCarga = contenedorDeCarga;
    }

    @Override
    public void handle(ActionEvent event) {
        this.contenedorDeCarga.setearDimensionTablero(dimension);
    }
    
}
