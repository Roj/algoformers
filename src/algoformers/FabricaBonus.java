/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoformers;

/**
 *
 * @author Matias
 */
public class FabricaBonus {
    public Bonus crearBurbujaInmaculada(){
        return new Bonus(new BurbujaInmaculada());
    }
    public Bonus crearDobleCañon(){
        return new Bonus(new DobleCañon());
    }
    public Bonus crearFlash(){
        return new Bonus(new Flash());
    }
    public Bonus crearChispaSuprema(){
        return new Bonus(new ChispaSuprema());
    }
}
