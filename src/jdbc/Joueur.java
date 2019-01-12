/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static jdbc.Main.Adversaires;
import static jdbc.Main.Moi;
import static jdbc.Main.Murs;
import static jdbc.Main.connexion;
import static jdbc.Main.hauteurPersos;
import static jdbc.Main.largeurPersos;

/**
 *
 * @author Arthur
 */
public class Joueur {
    private int id;
    private String pseudo;
    private int x;
    private int y;
    private int pv;
    private String arme;
    private int direction;
    private int etat;
    private int munition;
    private boolean deplacerDroite = false;
    private boolean deplacerGauche = false;
    private boolean deplacerHaut = false;
    private boolean deplacerBas = false;
    private long derniereAttaque;
    private long tempsEntreAttaque;
    private boolean jeRamasse = false;

    /*constructeur*/
    public Joueur(int id, String pseudo, int x, int y, int pv, String Arme, int direction, int etat, int munition) {
        this.id = id;
        this.pseudo = pseudo;
        this.x = x;
        this.y = y;
        this.pv = pv;
        this.arme = Arme;
        this.direction = direction;
        this.etat = etat;
        this.munition = munition;
        this.tempsEntreAttaque = 500; /* a changer à chaque changement d'armes*/
    }
    
    

    /*setter*/
    public void setId(int id) {
        this.id = id;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setArme(String arme) {
        this.arme = arme;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setMunition(int munition) {
        this.munition = munition;
    }

    public void setDeplacerDroite(boolean deplacerDroite) {
        this.deplacerDroite = deplacerDroite;
    }

    public void setDeplacerGauche(boolean deplacerGauche) {
        this.deplacerGauche = deplacerGauche;
    }

    public void setDeplacerHaut(boolean deplacerHaut) {
        this.deplacerHaut = deplacerHaut;
    }

    public void setDeplacerBas(boolean deplacerBas) {
        this.deplacerBas = deplacerBas;
    }

    public void setDerniereAttaque(long derniereAttaque) {
        this.derniereAttaque = derniereAttaque;
    }
    
    public void setJeRamasse(boolean jeRamasse){
        this.jeRamasse = jeRamasse;
    }
    
    public void settempsattaque(long truc){
        this.tempsEntreAttaque = truc;
    }
    
    
    
    /* getters */

    public int getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPv() {
        return pv;
    }

    public String getArme() {
        return arme;
    }

    public int getDirection() {
        return direction;
    }

    public int getEtat() {
        return etat;
    }

    public int getMunition() {
        return munition;
    }

    public boolean isDeplacerDroite() {
        return deplacerDroite;
    }

    public boolean isDeplacerGauche() {
        return deplacerGauche;
    }

    public boolean isDeplacerHaut() {
        return deplacerHaut;
    }

    public boolean isDeplacerBas() {
        return deplacerBas;
    }

    public long getDerniereAttaque() {
        return derniereAttaque;
    }
    public boolean getJeRamasse(){
        return jeRamasse;
    }
    
    
    
    
    //constructeur pour chaque joueur     
    
    public void JoueurDefault(int id) {
        this.id = id;
        this.pseudo = "Libre";
        this.x = 0;
        this.y = 0;
        this.pv = 5;
    }
    
    
    public void Joueur1() {
        this.pseudo = pseudo;
        this.x = 0;
        this.y = 0;
        this.pv = 5;
    }
    
    public void Joueur2() {
        this.pseudo = pseudo;
        this.x = 50;
        this.y = 0;
        this.pv = 5;
    }
    
    public void Joueur3() {
        this.pseudo = pseudo;
        this.x = 0;
        this.y = 50;
        this.pv = 5;
    }
    
    public void Joueur4() {
        this.pseudo = pseudo;
        this.x = 50;
        this.y = 50;
        this.pv = 5;
    }
    
     public void deplacerDroite(){
         
        if (this.EstOccupee(this.x+8, this.y)==false && deplacerDroite == true){
            this.x = this.x+8;
        }
        
        this.direction = 2;
    }
     
    public void deplacerGauche(){
        
        if (this.EstOccupee(this.x-8, this.y)==false && deplacerGauche == true){
            this.x=this.x-8;       
        }
        this.direction = 4;

    }
    
    public void deplacerHaut(){
        
        if (this.EstOccupee(this.x, this.y-8)==false && deplacerHaut == true){
            this.y= this.y-8;
        }
        
        this.direction = 3;
    }      
    
    public void deplacerBas(){
        
        if (this.EstOccupee(this.x, this.y+8)==false && deplacerBas == true){
            this.y= this.y+8;
        }
        this.direction = 1;
        
    }
    
    public void Deplacer(){
        if(deplacerDroite){
            deplacerDroite();
        }
        if(deplacerGauche){
            deplacerGauche();
        }
        if(deplacerHaut){
            deplacerHaut();
        }
        if(deplacerBas){
            deplacerBas();
        }
    }
    
    public boolean EstOccupee(int x, int y){
        boolean estoccupee;
        x=x-3;
        
        estoccupee = Adversaires.joueur1.getX()+largeurPersos>x && Adversaires.joueur1.getX()-largeurPersos<x && Adversaires.joueur1.getY()+hauteurPersos>y && Adversaires.joueur1.getY()-hauteurPersos<y;

        if (Adversaires.joueur2.getX()+largeurPersos>x && Adversaires.joueur2.getX()-largeurPersos<x && Adversaires.joueur2.getY()+hauteurPersos>y && Adversaires.joueur2.getY()-hauteurPersos<y){
            estoccupee = true;
        }
        
        if (Adversaires.joueur3.getX()+largeurPersos>x && Adversaires.joueur3.getX()-largeurPersos<x && Adversaires.joueur3.getY()+hauteurPersos>y && Adversaires.joueur3.getY()-hauteurPersos<y){
            estoccupee = true;
        }
        
        if (Murs.estDansMur(x+largeurPersos,y+hauteurPersos) || Murs.estDansMur(x,y+hauteurPersos) || Murs.estDansMur(x+largeurPersos,y) || Murs.estDansMur(x,y) || Murs.estDansMur(x,y+hauteurPersos/2) || Murs.estDansMur(x+largeurPersos,y+hauteurPersos/2) ){
            estoccupee = true;
            
        }
        
        return estoccupee;
    }
    
    public ArrayList<Projectile> Attaque(String Arme, long temps){
        ArrayList<Projectile> Liste = new ArrayList<>();
        if(temps - this.derniereAttaque > this.tempsEntreAttaque){
            this.derniereAttaque = System.currentTimeMillis();
            
            if (this.arme.equals("fleche") && this.munition>0){
                Projectile proj = new Fleche(Moi);
                Liste.add(proj);
                PlaySound ihm = new PlaySound("fleche.wav");
                this.munition = this.munition -1;
            }else if (this.arme.equals("grenade") && this.munition>0){
                Projectile proj = new Grenade(Moi);
                Liste.add(proj);
                PlaySound ihm = new PlaySound("grenage.wav");
                this.munition = this.munition -1;
            }else{
                Projectile proj = new Couteau(Moi);
                PlaySound ihm = new PlaySound("couteau.wav");
                Liste.add(proj);
            }
        }
        return Liste;
    }
    
    public void RamasserObjet(int x, int y, String pseudo){
        this.x = x;
        this.y = y;
        this.pseudo = pseudo;
        if (this.getJeRamasse()){
            // A COMPLETER AVEC TEST DE BONUS A PROXIMITE
        }
    }
    
    public void EnleverPv(){
        
         try {


            PreparedStatement requete = connexion.prepareStatement("UPDATE joueur SET pv = ? WHERE id = ?");

            requete.setInt(1,this.pv-1);
            requete.setInt(2,this.id);

            //System.out.println(requete);
            requete.executeUpdate();

            requete.close();
            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        PlaySound ihm = new PlaySound("quelquuntouche.wav");
        
    }
    
    
    public void Push(){
        
        
        try {


            PreparedStatement requete = connexion.prepareStatement("SELECT pv FROM joueur WHERE id = ?");
            requete.setInt(1,this.id );
            


            //System.out.println(requete);
            ResultSet resultat = requete.executeQuery();

            
            if(resultat.next()){
                this.setPv(resultat.getInt("pv"));
            }

            requete.close();
            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        if (Moi.getPv()<1){
            Moi.setPseudo("MORT");
            Moi.setX(-200);
            Moi.setArme("aucune");
            //PlaySound ihm = new PlaySound("quelquunestmort.wav");
        }
        
        try {


            PreparedStatement requete = connexion.prepareStatement("UPDATE joueur SET pseudo = ?, x = ?, y = ?, arme = ?, etat = ?, direction = ?, munitions = ? WHERE id = ?");
            requete.setString(1,this.pseudo );
            requete.setInt(2,this.x );
            requete.setInt(3,this.y );
            requete.setString(4,this.arme );
            requete.setInt(5,this.etat );
            requete.setInt(6,this.direction );
            requete.setInt(7,this.munition );
            requete.setInt(8,this.id);

            //System.out.println(requete);
            requete.executeUpdate();

            requete.close();
            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void Pull(int id){
        
        
        try {

            

            PreparedStatement requete = connexion.prepareStatement("SELECT pseudo, x, y, pv, arme, direction, etat, munitions FROM Joueur WHERE id ="+id);
            ResultSet resultat = requete.executeQuery();
            while (resultat.next()) {
                this.setX(resultat.getInt("x"));
                this.setY(resultat.getInt("y"));
                this.setPv(resultat.getInt("pv"));
                this.setArme(resultat.getString("arme"));
                this.setDirection(resultat.getInt("direction"));
                this.setEtat(resultat.getInt("etat"));
                this.setMunition(resultat.getInt("munitions"));
                
                
            }

            requete.close();
            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
