/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static jdbc.Main.Moi;
import static jdbc.Main.Murs;
import static jdbc.Main.ProjectilesAAjouter;
import static jdbc.Main.connexion;

/**
 *
 * @author pdolle
 */
public class ListeBonus {
    
        private ArrayList<Bonus> Liste;
    
    public ListeBonus() {
        this.Liste = new ArrayList<>();
    }

    public ArrayList<Bonus> getListe() {
        return Liste;
    }

    public void setListe(ArrayList<Bonus> Liste) {
        this.Liste = Liste;
    }
    
    public void remove(Bonus bonus){
        this.Liste.remove(bonus);
    }
    
    public void add(Bonus bonus){
        this.Liste.add(bonus);
    }
    
    public void addAll(ArrayList<Bonus> Liste){
        this.Liste.addAll(Liste);
    }
    
    
    public void Nettoyer(){
        
        try {

           
            PreparedStatement requete = connexion.prepareStatement("DELETE FROM bonus ");
            requete.executeUpdate();

            requete.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
    public void ResoudreBonus(Joueur joueur){
        for (Bonus bonus : this.Liste){
            if (bonus.TestChoc(joueur)){
                bonus.Utiliser();
            }
        }
    }
        
    public void NettoyerBonus(){
         try {

           
            PreparedStatement requete = connexion.prepareStatement("DELETE FROM bonus ");
            requete.executeUpdate();

            requete.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        
    public void UpdateBonus(){
        
        
        ArrayList<Bonus> Liste2 = new ArrayList<Bonus>();

        try {
                PreparedStatement requete = connexion.prepareStatement("SELECT * FROM bonus;");
                ResultSet resultat = requete.executeQuery();
                while (resultat.next()) {
                
                    Bonus bonus = new Arc(0,0);

                    if (resultat.getString("type").equals("BonusArc")){
                        bonus = new Arc(resultat.getInt("x"),resultat.getInt("y"));
                    }
                    if (resultat.getString("type").equals("lancegrenade")){
                        bonus = new BonusGrenade(resultat.getInt("x"),resultat.getInt("y"));
                        
                    }if (resultat.getString("type").equals("BonusMunitions")){
                        bonus = new BonusMunitions(resultat.getInt("x"),resultat.getInt("y"));
                    }
                    
                    
                    
                    Liste2.add(bonus);
                    

                    
                    
                }
                requete.close();  
                

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        
        int i =(int)(Math.random() * (60*1000/40));
                    
                    if (i == 1){
                        int x = (int)(Math.random() * (1200));
                        int y = (int)(Math.random() * (800));
                        
                        if (Murs.estDansMur(x, y)==false){
                            Bonus Nouveaubonus = new BonusGrenade(x,y);
                            Nouveaubonus.Ajouter();
                        }
                    }
                    if (i == 2){
                        int x = (int)(Math.random() * (1200));
                        int y = (int)(Math.random() * (800));
                        
                        if (Murs.estDansMur(x, y)==false){
                            Bonus Nouveaubonus = new Arc(x,y);
                            Nouveaubonus.Ajouter();
                        }
                    }
                    if (i >10 && i < 30 ){
                        int x = (int)(Math.random() * (1200));
                        int y = (int)(Math.random() * (800));
                        
                        if (Murs.estDansMur(x, y)==false){
                            Bonus Nouveaubonus = new BonusMunitions(x,y);
                            Nouveaubonus.Ajouter();
                        }
                    }
        
        this.setListe(Liste2);
        
        
        }
    
}
