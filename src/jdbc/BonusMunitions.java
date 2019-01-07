/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import static jdbc.Main.Moi;

/**
 *
 * @author pdolle
 */
public class BonusMunitions extends Bonus{
    
    
     public BonusMunitions(int x, int y) {
        
        super("BonusMunitions",x,y);
        
     }
    
    void Utiliser() {
        
        Moi.setMunition(Moi.getMunition()+5);
        this.Enlever();
        
    }
    
    
    void Afficher() {
        
    }

}
