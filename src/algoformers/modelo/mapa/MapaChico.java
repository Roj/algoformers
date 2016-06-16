/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers.modelo.mapa;

/**
 *
 * @author Joaquin
 */
public class MapaChico extends Mapa {
    public MapaChico() {
        super(16,16);
        
        String[][] tierra = {{"r","r","r","r","r","r","r","r","r","r","r","r","r","r","r","r"},
                             {"r","r","r","r","r","r","r","r","r","r","r","r","r","r","r","r"},
                             {"r","r","r","r","r","r","r","r","r","r","r","r","r","r","r","r"},
                             {"r","r","p","p","p","p","p","p","p","p","p","p","p","p","r","r"},
                             {"r","r","r","r","r","r","r","r","r","r","r","r","r","r","r","r"},
                             {"r","r","r","r","r","r","r","r","r","r","r","r","r","r","r","r"},
                             {"r","r","r","r","e","e","e","e","e","e","e","r","r","r","r","r"},
                             {"r","r","r","r","e","r","r","r","r","r","e","r","r","r","r","r"},
                             {"r","r","r","r","e","r","r","r","r","r","e","r","r","r","r","r"},
                             {"r","r","r","r","e","e","e","e","e","e","e","r","r","r","r","r"},
                             {"r","r","r","r","r","r","r","r","r","r","r","r","r","r","r","r"},
                             {"r","r","r","r","r","r","r","r","r","r","r","r","r","r","r","r"},
                             {"r","r","p","p","p","p","p","p","p","p","p","p","p","p","r","r"},
                             {"r","r","r","r","r","r","r","r","r","r","r","r","r","r","r","r"},
                             {"r","r","r","r","r","r","r","r","r","r","r","r","r","r","r","r"},
                             {"r","r","r","r","r","r","r","r","r","r","r","r","r","r","r","r"},
        };
        String[][] aire   = {{"nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu"},
                             {"nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu"},
                             {"nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu"},
                             {"ne","ne","ne","ne","ne","ne","ne","ne","ne","ne","ne","ne","ne","ne","ne","ne"},
                             {"nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu"},
                             {"nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu"},
                             {"nu","nu","nu","nu","t", "nu","nu","nu","nu","nu","t", "nu","nu","nu","nu","nu"},
                             {"nu","nu","nu","nu","t", "nu","nu","nu","nu","nu","t", "nu","nu","nu","nu","nu"},
                             {"nu","nu","nu","nu","t", "nu","nu","nu","nu","nu","t", "nu","nu","nu","nu","nu"},
                             {"nu","nu","nu","nu","t", "nu","nu","nu","nu","nu","t", "nu","nu","nu","nu","nu"},
                             {"nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu"},
                             {"nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu"},
                             {"ne","ne","ne","ne","ne","ne","ne","ne","ne","ne","ne","ne","ne","ne","ne","ne"},
                             {"nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu"},
                             {"nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu"},
                             {"nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu","nu"},
                             
        };
        
        this.generarMapaAire(aire);
        this.generarMapaTierra(tierra);
    }

    
}
