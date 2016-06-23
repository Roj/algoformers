/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.controlador;

import algoformers.vista.Casilla;
import algoformers.vista.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Matias
 */
public class AccionCambiarSuperficie implements EventHandler<ActionEvent> {

    ContenedorJuego contenedorJuego;
    Casilla[][] casillasMaxs;
    Casilla[][] casillasMins;
    
    public AccionCambiarSuperficie(ContenedorJuego contJuego, Casilla[][] casillasMaxs, Casilla[][] casillasMins) {
        this.contenedorJuego = contJuego;
        this.casillasMaxs = casillasMaxs;
        this.casillasMins = casillasMins;
    }

    @Override
    public void handle(ActionEvent event) {
        for (Casilla[] casillas: casillasMins){
            for (Casilla casilla: casillas){
                casilla.maximizar();
            }
        }
        for (Casilla[] casillas: casillasMaxs){
            for (Casilla casilla: casillas){
                casilla.minimizar();
            }
        }        
    }
    
}
