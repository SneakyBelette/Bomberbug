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
    
    protected void Enlever(){
        
        try {

            PreparedStatement requete = connexion.prepareStatement("DELETE FROM bonus WHERE type =? AND x=? AND y=? ");
            System.out.println(this.getType()+" x="+this.getX()+" y= "+this.getY());
            requete.setString(1, this.getType());
            requete.setInt(2, this.getX());
            requete.setInt(3, this.getY());

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
        
            
        int x1=joueur.getX();
            int y1=joueur.getY();
            int x2=joueur.getX()+largeurPersos;
            int y2=joueur.getY()+hauteurPersos;
            

            if ((this.x)>x1 & (this.x)<x2 & (this.y)>y1 & (this.y)<y2){
                Choc = true;
            }if ((this.x+10)>x1 & (this.x+10)<x2 & (this.y)>y1 & (this.y)<y2){
                Choc = true;
            }if ((this.x)>x1 & (this.x)<x2 & (this.y+10)>y1 & (this.y+10)<y2){
                Choc = true;
            }if ((this.x+10)>x1 & (this.x+10)<x2 & (this.y+10)>y1 & (this.y+10)<y2){
                Choc = true;
            }

        return Choc;
    }
    
    abstract void Afficher();
    
    abstract void Utiliser();
    
}
