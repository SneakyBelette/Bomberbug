/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import static jdbc.Main.Adversaires;
import static jdbc.Main.Moi;
import static jdbc.Main.connexion;
import static jdbc.Main.hauteurPersos;
import static jdbc.Main.largeurPersos;
import outils.OutilsJDBC;

/**
 *
 * @author pdolle
 */
public abstract class Projectile {
    
    protected String type;
    protected int x;
    protected int y;
    protected int vitessex;
    protected int vitessey;
    protected int hauteur;
    protected int largeur;
    protected int numero_lanceur;
    protected long naissance;
    
    /*constructeur*/
    public Projectile(String type, int x, int y, int vitessex, int vitessey, int hauteur, int largeur, int numero_lanceur, long naissance) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.vitessex = vitessex;
        this.vitessey = vitessey;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.numero_lanceur = numero_lanceur;
        this.naissance = naissance;
    }

    
    /*getters*/

    protected String getType() {
        return type;
    }

    protected int getX() {
        return x;
    }

    protected int getY() {
        return y;
    }

    protected int getVitessex() {
        return vitessex;
    }

    protected int getVitessey() {
        return vitessey;
    }

    protected int getHauteur() {
        return hauteur;
    }

    protected int getLargeur() {
        return largeur;
    }

    protected int getNumero_lanceur() {
        return numero_lanceur;
    }

    protected long getNaissance() {
        return naissance;
    }
    
    
    /*setter*/

    protected void setType(String type) {
        this.type = type;
    }

    protected void setX(int x) {
        this.x = x;
    }

    protected void setY(int y) {
        this.y = y;
    }

    protected void setVitessex(int vitessex) {
        this.vitessex = vitessex;
    }

    protected void setVitessey(int vitessey) {
        this.vitessey = vitessey;
    }

    protected void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    protected void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    protected void setNumero_lanceur(int numero_lanceur) {
        this.numero_lanceur = numero_lanceur;
    }

    protected void setNaissance(long naissance) {
        this.naissance = naissance;
    }

    
    
    
    protected ArrayList<Joueur> SontEnRange(){
        ArrayList<Joueur> JoueursEnRange = new ArrayList<Joueur>();
        
     //   if (TestChoc(Moi)){
     //       JoueursEnRange.add(Moi);
     //   }
        if (TestChoc(Adversaires.joueur1)){
            JoueursEnRange.add(Adversaires.joueur1);
            System.out.println("en range ! ");
        }
        if (TestChoc(Adversaires.joueur2)){
            JoueursEnRange.add(Adversaires.joueur2);
        }
        if (TestChoc(Adversaires.joueur3)){
            JoueursEnRange.add(Adversaires.joueur3);
        }
        
        return JoueursEnRange;
    } 
    
    
    
    protected boolean TestChoc(){
        boolean Choc = false;
        ArrayList<Joueur> listeJoueur=new ArrayList<>();
        listeJoueur.add(Adversaires.joueur1);
        listeJoueur.add(Adversaires.joueur2);
        listeJoueur.add(Adversaires.joueur3);
        
        //Génération des 4 points délimitant le rectangle du joueur, en commencant 
        //par en haut à gauche et en tournant dans le sens horaire
        for(Joueur joueur : listeJoueur){
            
        
            int x1=joueur.getX()-largeurPersos/2;
            int y1=joueur.getY()-hauteurPersos/2;
            int x2=joueur.getX()+largeurPersos/2;
            int y2=y1;
            int x3=x2;
            int y3=joueur.getY()+hauteurPersos/2;
            int x4=x1;
            int y4=y3;

            if ((this.x-this.largeur/2)<x1 & (this.x+this.largeur/2)>x1 & (this.y-this.hauteur/2)<y1 & (this.y+this.largeur/2)>y1){
                Choc = true;
            }
            if ((this.x-this.largeur/2)<x2 & (this.x+this.largeur/2)>x2 & (this.y-this.hauteur/2)<y2 & (this.y+this.largeur/2)>y2){
                Choc = true;
            }
            if ((this.x-this.largeur/2)<x3 & (this.x+this.largeur/2)>x3 & (this.y-this.hauteur/2)<y3 & (this.y+this.largeur/2)>y3){
                Choc = true;
            }
            if ((this.x-this.largeur/2)<x4 & (this.x+this.largeur/2)>x4 & (this.y-this.hauteur/2)<y4 & (this.y+this.largeur/2)>y4){
                Choc = true;
            }
        }
        
        return Choc;
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

            if ((this.x-this.largeur/2)<x1 & (this.x+this.largeur/2)>x1 & (this.y-this.hauteur/2)<y1 & (this.y+this.hauteur/2)>y1){
                Choc = true;
            }
            if ((this.x-this.largeur/2)<x2 & (this.x+this.largeur/2)>x2 & (this.y-this.hauteur/2)<y2 & (this.y+this.hauteur/2)>y2){
                Choc = true;
            }
            if ((this.x-this.largeur/2)<x3 & (this.x+this.largeur/2)>x3 & (this.y-this.hauteur/2)<y3 & (this.y+this.hauteur/2)>y3){
                Choc = true;
            }
            if ((this.x-this.largeur/2)<x4 & (this.x+this.largeur/2)>x4 & (this.y-this.hauteur/2)<y4 & (this.y+this.hauteur/2)>y4){
                Choc = true;
            }
        
        
        return Choc;
    }
    
    
    protected void Ajouter(){
        try {

            PreparedStatement requete = connexion.prepareStatement("INSERT INTO projectiles VALUES ('"+this.getType()+"','"+this.x+"','"+this.y+"','"+this.naissance+"','"+this.vitessex+"','"+this.vitessey+"','"+this.hauteur+"','"+this.largeur+"','"+this.numero_lanceur+"')");
            
            
            requete.executeUpdate();

            requete.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    abstract boolean EstPerime();

    abstract void Exploser();
    
    abstract boolean Avancer();
    
    abstract void Afficher();
    
  

   

}



