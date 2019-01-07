/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import static jdbc.Main.connexion;
import static jdbc.Main.hauteurPersos;
import static jdbc.Main.largeurPersos;
import static jdbc.Main.largeurbonus;

/**
 *
 * @author pdolle
 */
public abstract class Bonus {
    
    
    protected String type;
    protected int x;
    protected int y;
    
    public Bonus(String type, int x, int y){
        this.type = type;
        this.x = x;
        this.y = y;
    }
    
    protected String getType() {
        return type;
    }

    protected int getX() {
        return x;
    }

    protected int getY() {
        return y;
    }
    
    protected void setType(String type) {
        this.type = type;
    }

    protected void setX(int x) {
        this.x = x;
    }

    protected void setY(int y) {
        this.y = y;
    }
    
    
    protected void Ajouter(){
        try {

            PreparedStatement requete = connexion.prepareStatement("INSERT INTO bonus VALUES ('"+this.getType()+"','"+this.x+"','"+this.y+"')");
            
            
            requete.executeUpdate();

            requete.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    protected boolean TestChoc(Joueur joueur){
        boolean Choc = false;
        
        
        //Génération des 4 points délimitant le rectangle du joueur, en commencant 
        //par en haut à gauche et en tournant dans le sens horaire
        
            
        
            int x1=joueur.getX()-largeurPersos/2;
            int y1=joueur.getY()-hauteurPersos/2;
            int x2=joueur.getX()+largeurPersos/2;
            int y2=y1;
            int x3=x2;
            int y3=joueur.getY()+hauteurPersos/2;
            int x4=x1;
            int y4=y3;

            if ((this.x-largeurbonus/2)<x1 & (this.x+largeurbonus/2)>x1 & (this.y-largeurbonus/2)<y1 & (this.y+largeurbonus/2)>y1){
                Choc = true;
            }
            if ((this.x-largeurbonus/2)<x2 & (this.x+largeurbonus/2)>x2 & (this.y-largeurbonus/2)<y2 & (this.y+largeurbonus/2)>y2){
                Choc = true;
            }
            if ((this.x-largeurbonus/2)<x3 & (this.x+largeurbonus/2)>x3 & (this.y-largeurbonus/2)<y3 & (this.y+largeurbonus/2)>y3){
                Choc = true;
            }
            if ((this.x-largeurbonus/2)<x4 & (this.x+largeurbonus/2)>x4 & (this.y-largeurbonus/2)<y4 & (this.y+largeurbonus/2)>y4){
                Choc = true;
            }

        return Choc;
    }
    
    abstract void Afficher();
    
    abstract void Utiliser();
    
}
