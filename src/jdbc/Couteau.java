/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.util.ArrayList;
import static jdbc.Main.Moi;
import static jdbc.Main.largeurPersos;

/**
 *
 * @author pdolle
 */
public class Couteau extends Projectile{
    
    
    //constructeur
    public Couteau(Joueur joueur) {
        
        // /!\ cela créer un couteau FIXE pour le moment /!\
        
        super("couteau",joueur.getX()+largeurPersos/2,joueur.getY(),0,0,20,20,joueur.getId(),System.currentTimeMillis());
        
        
    }
    
    public Couteau(int x,int y, int dirX,int dirY,int hauteur, int largeur,int id, int timer) {
        
        super("couteau",x,y,dirX,dirY,hauteur,largeur,id,timer);
        
    }
    
    
    boolean EstPerime() {
        boolean EstPerime =false;
        

        if (System.currentTimeMillis()-20000 > this.getNaissance()){
            EstPerime = true;
        }

        return EstPerime;
    }
    
    void Exploser(){
        
        ArrayList<Joueur> JoueursEnRange = SontEnRange();
        
        for(Joueur joueur : JoueursEnRange){
            joueur.setPv(joueur.getPv()-1);
            System.out.println("degat couteau à " + joueur.getPseudo() +" PV = "+ joueur.getPv());
        }
        
    }
    
    boolean Avancer(){
        boolean Aexpire=false;
        
        this.x += this.vitessex;
        this.y += this.vitessey;
        
        
        if (this.EstPerime()){
            Aexpire = true;
        }
        
        if (this.TestChoc()){
            Aexpire =true;
            this.Exploser();
        }
        
        
        return Aexpire;
    }
    
    void Afficher(){
        
    }
    
    
}
