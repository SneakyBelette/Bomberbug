/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.util.ArrayList;
import static jdbc.Main.Moi;
import static jdbc.Main.hauteurPersos;
import static jdbc.Main.largeurPersos;

/**
 *
 * @author pdolle
 */
public class Couteau extends Projectile{
    
    
    //constructeur
    public Couteau(Joueur joueur) {
        

        super("couteau",joueur.getX(),joueur.getY(),0,0,0,0,joueur.getId(),System.currentTimeMillis());
        
        int a = 0;
        int b = 0;
        
        if(joueur.getDirection()==1){
            
            b = hauteurPersos/2;
            this.vitessey=20;
            this.hauteur=20;
            this.largeur=5;
            
        }else if(joueur.getDirection()==2){
            
            a = largeurPersos/2;
            this.vitessex=20;
            this.hauteur=5;
            this.largeur=20;
            
        }else if(joueur.getDirection()==3){
            
            b = -hauteurPersos/2;
            this.vitessey=-20;
            this.hauteur=20;
            this.largeur=5;
            
        }else if(joueur.getDirection()==4){
            
            a = -largeurPersos/2;
            this.vitessex=-20;
            this.hauteur=5;
            this.largeur=20;
            
            
        }
        this.x = joueur.getX()+a;
        this.y = joueur.getY()+b;
    }
    
    public Couteau(int x,int y, int dirX,int dirY,int hauteur, int largeur,int id, long timer) {
        
        super("couteau",x,y,dirX,dirY,hauteur,largeur,id,timer);
        
    }
    
    
    boolean EstPerime() {
        boolean EstPerime =false;
        

        if (System.currentTimeMillis()-400 > this.getNaissance()){
            EstPerime = true;
        }

        return EstPerime;
    }
    
    void Exploser(){
        
        ArrayList<Joueur> JoueursEnRange = SontEnRange();
        
        for(Joueur joueur : JoueursEnRange){
            joueur.EnleverPv();
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
