/*
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
import static jdbc.Main.connexion;

/**
 *
 * @author pdolle
 */
public class BaseJoueur {
    
    public Joueur joueur1;
    public Joueur joueur2;
    public Joueur joueur3;
    
    public static void nettoyer(){
        
        try {
                

                PreparedStatement requete = connexion.prepareStatement("UPDATE Joueur SET x = ?, y = ?, pv = ?, arme = ?, direction = ?, etat = ?, munitions =?,pseudo=? WHERE id =?");
                requete.setInt(1,50);
                requete.setInt(2,50);
                requete.setInt(3,3);
                requete.setString(4, "couteau");
                requete.setInt(5,1);
                requete.setInt(6,-1);
                requete.setInt(7,1);
                requete.setString(8,"Libre");
                requete.setInt(9,1);
                
                
                requete.executeUpdate();
                
                PreparedStatement requete2 = connexion.prepareStatement("UPDATE Joueur SET x = ?, y = ?, pv = ?, arme = ?, direction = ?, etat = ?, munitions =?,pseudo=? WHERE id =?");
                requete2.setInt(1,200);
                requete2.setInt(2,50);
                requete2.setInt(3,3);
                requete2.setString(4, "couteau");
                requete2.setInt(5,1);
                requete2.setInt(6,-1);
                requete2.setInt(7,1);
                requete2.setString(8,"Libre");
                requete2.setInt(9,2);
                
                
                requete2.executeUpdate();
                
                PreparedStatement requete3 = connexion.prepareStatement("UPDATE Joueur SET x = ?, y = ?, pv = ?, arme = ?, direction = ?, etat = ?, munitions =?,pseudo=? WHERE id =?");
                requete3.setInt(1,50);
                requete3.setInt(2,200);
                requete3.setInt(3,3);
                requete3.setString(4, "couteau");
                requete3.setInt(5,1);
                requete3.setInt(6,-1);
                requete3.setInt(7,1);
                requete3.setString(8,"Libre");
                requete3.setInt(9,3);
                
                
                requete3.executeUpdate();
                
                PreparedStatement requete4 = connexion.prepareStatement("UPDATE Joueur SET x = ?, y = ?, pv = ?, arme = ?, direction = ?, etat = ?, munitions =?,pseudo=? WHERE id =?");
                requete4.setInt(1,200);
                requete4.setInt(2,200);
                requete4.setInt(3,3);
                requete4.setString(4, "couteau");
                requete4.setInt(5,1);
                requete4.setInt(6,-1);
                requete4.setInt(7,1);
                requete4.setString(8,"Libre");
                requete4.setInt(9,4);
                
                
                requete4.executeUpdate();
                
                
                
                

                requete.close();
                

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        
    }
    
    public void charger(){
        
        
        try {

            

            PreparedStatement requete = connexion.prepareStatement("SELECT pseudo, x, y, pv, arme, direction, etat, munitions FROM Joueur WHERE id ="+this.joueur1.getId());
            ResultSet resultat = requete.executeQuery();
            while (resultat.next()) {
                this.joueur1.setPseudo(resultat.getString("pseudo"));
                this.joueur1.setX(resultat.getInt("x"));
                this.joueur1.setY(resultat.getInt("y"));
                this.joueur1.setPv(resultat.getInt("pv"));
                this.joueur1.setArme(resultat.getString("arme"));
                this.joueur1.setDirection(resultat.getInt("direction"));
                this.joueur1.setEtat(resultat.getInt("etat"));
                this.joueur1.setMunition(resultat.getInt("munitions"));
                
                
            }

            requete.close();
            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        try {

            

            PreparedStatement requete = connexion.prepareStatement("SELECT pseudo, x, y, pv, arme, direction, etat, munitions FROM Joueur WHERE id ="+this.joueur2.getId());
            ResultSet resultat = requete.executeQuery();
            while (resultat.next()) {
                this.joueur2.setPseudo(resultat.getString("pseudo"));
                this.joueur2.setX(resultat.getInt("x"));
                this.joueur2.setY(resultat.getInt("y"));
                this.joueur2.setPv(resultat.getInt("pv"));
                this.joueur2.setArme(resultat.getString("arme"));
                this.joueur2.setDirection(resultat.getInt("direction"));
                this.joueur2.setEtat(resultat.getInt("etat"));
                this.joueur2.setMunition(resultat.getInt("munitions"));
                
            }

            requete.close();
           

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        try {

           

            PreparedStatement requete = connexion.prepareStatement("SELECT pseudo, x, y, pv, arme, direction, etat, munitions FROM Joueur WHERE id ="+this.joueur3.getId());
            ResultSet resultat = requete.executeQuery();
            while (resultat.next()) {
                this.joueur3.setPseudo(resultat.getString("pseudo"));
                this.joueur3.setX(resultat.getInt("x"));
                this.joueur3.setY(resultat.getInt("y"));
                this.joueur3.setPv(resultat.getInt("pv"));
                this.joueur3.setArme(resultat.getString("arme"));
                this.joueur3.setDirection(resultat.getInt("direction"));
                this.joueur3.setEtat(resultat.getInt("etat"));
                this.joueur3.setMunition(resultat.getInt("munitions"));
                
            }

            requete.close();
            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
    
    public int AjouterJoueur(String Pseudo){
        int ID = -1;
        //Récupération du premier ID libre dans la basejoueur 
        try {

            PreparedStatement requete = connexion.prepareStatement("SELECT id FROM Joueur WHERE etat=-1");
            ResultSet resultat = requete.executeQuery();
            if (resultat.next()) {
                ID = resultat.getInt("id");
                System.out.println("connexion1 ok, id captée =  "+ID);
            }

            requete.close();
            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
            
            //On définit l'ID comme étant le nôtre, plus accessible pour les autres joueurs
        if (ID !=-1){
            
            try {
                System.out.println("connexion2 ok");

            

            PreparedStatement requete = connexion.prepareStatement("UPDATE joueur SET pseudo = ?, etat = ? WHERE id =?");
            
            requete.setString(1, Pseudo);
            requete.setInt(2, 1);
            requete.setInt(3, ID);
            System.out.println(requete);
            requete.executeUpdate();

            requete.close();
            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            
        }
        
        
        return ID;
    }

    public BaseJoueur() {
        
        this.joueur1 = new Joueur(-10,"Libre",50,50,5,"cut",1,1,1);
        this.joueur2 = new Joueur(-11,"Libre",100,50,5,"cut",1,1,1);
        this.joueur3 = new Joueur(-12,"Libre",50,100,5,"cut",1,1,1);
        
        
    }
    
    public void InitBaseAdversaires(int IdJoueur){
        
        
        
        
        if (IdJoueur==1){
            this.joueur1.setId(2);
            this.joueur2.setId(3);
            this.joueur3.setId(4);
            System.out.println("marche");
        }else{
            if (IdJoueur==2){
                this.joueur1.setId(1);
                this.joueur2.setId(3);
                this.joueur3.setId(4);
                System.out.println("marche pas");
        }else{
                if (IdJoueur==3){
                    this.joueur1.setId(1);
                    this.joueur2.setId(2);
                    this.joueur3.setId(4);
                    System.out.println("marche pas");
        }else{
                    if (IdJoueur==4){
                        this.joueur1.setId(1);
                        this.joueur2.setId(2);
                        this.joueur3.setId(3);
                        System.out.println("marche pas");
        }
                }
            }
        }
        
        System.out.println("adv1 id ="+this.joueur1.getId());
        System.out.println("adv2 id ="+this.joueur2.getId());
        System.out.println("adv3 id ="+this.joueur3.getId());
        
        
        
    }
    
    
    
    
            
            

}
