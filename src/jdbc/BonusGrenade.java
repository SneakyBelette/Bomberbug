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
public class BonusGrenade extends Bonus {
    
     public BonusGrenade(int x, int y) {
        
        super("lancegrenade",x,y);
        
     }
    
    void Utiliser() {
        System.out.println("utiliser called!");
        Moi.setArme("grenade");
        Moi.setMunition(5);
        this.Enlever();
    }
    
    
    void Afficher() {
        
    }
}


