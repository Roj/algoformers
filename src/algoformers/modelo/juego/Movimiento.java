/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.modelo.juego;

import algoformers.modelo.tablero.Tablero;
import algoformers.modelo.tablero.Posicion;
import algoformers.modelo.algoformer.Algoformer;
import java.util.List;

/**
 *
 * @author Joaquin
 */
public class Movimiento {
    Algoformer algoformer;
    List<Posicion> pasos;
    int movimientosDisponibles;
    Tablero tablero;
    
    public Movimiento(Algoformer algoformer, List<Posicion> destino, Tablero table) {
        this.algoformer = algoformer;
        this.pasos = destino;
        this.movimientosDisponibles = algoformer.obtenerVelocidad();
        this.tablero = table;
    }
    
    public void modificarPuntosDeMovimiento(int i) {
        this.movimientosDisponibles+=i;
    }
    
    public void mover() {
        for(int i=0; i < pasos.size(); i++ ) {
            if(this.movimientosDisponibles <= 0)
                throw new ObjetivoMuyLejosException();

            this.algoformer.ajustarPuntosDeMovimiento(this);
            this.tablero.moverAlgoformer(pasos.get(i),algoformer);
        }
    }
    
}
