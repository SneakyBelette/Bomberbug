/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.util.ArrayList;
import static jdbc.Main.hauteurPersos;
import static jdbc.Main.largeurPersos;

/**
 *
 * @author pdolle
 */
public class Grenade extends Projectile{
    

    
    //constructeur
    public Grenade(Joueur joueur) {
        
        // /!\ cela créer un couteau FIXE pour le moment /!\

        
        super("grenade",joueur.getX(),joueur.getY(),0,0,10,10,joueur.getId(),System.currentTimeMillis());
        
        int a = 0;
        int b = 0;
        
        if(joueur.getDirection()==1){
            
            b = hauteurPersos/2;
            this.vitessey=8;
           
            
        }else if(joueur.getDirection()==2){
            
            a = largeurPersos/2;
            this.vitessex=8;
          
            
        }else if(joueur.getDirection()==3){
            
            b = -hauteurPersos/2;
            this.vitessey=-8;
            
            
        }else if(joueur.getDirection()==4){
            
            a = -largeurPersos/2;
            this.vitessex=-8;
            
            
        }
        this.x = joueur.getX()+a;
        this.y = joueur.getY()+b;
    }
    
    public Grenade(int x,int y, int dirX,int dirY,int hauteur, int largeur,int id, long timer) {
        
        super("grenade",x,y,dirX,dirY,hauteur,largeur,id,timer);
        
    }
    
    
    boolean EstPerime() {
        boolean EstPerime =false;
        

        if (System.currentTimeMillis()-1200 > this.getNaissance()){
            EstPerime = true;
        }

        
        return EstPerime;
    }
    
    void Exploser(){
        
        this.hauteur=120;
        this.largeur=120;
        
        ArrayList<Joueur> JoueursEnRange = SontEnRange();
        
        for(Joueur joueur : JoueursEnRange){
            joueur.EnleverPv();
            
            System.out.println("degat bombe à " + joueur.getPseudo() +" PV = "+ joueur.getPv());
        }
        PlaySound ihm = new PlaySound("bombeexplo.wav");
        
    }
    
    boolean Avancer(){
        boolean Aexpire=false;
        
        this.x += this.vitessex;
        this.y += this.vitessey;
        
        
        if (this.EstPerime()){
            Aexpire = true;
            this.Exploser();
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
