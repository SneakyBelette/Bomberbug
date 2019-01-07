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
        
        
    public void UpdateBonus(){
        
        
        ArrayList<Bonus> Liste2 = new ArrayList<Bonus>();

        try {
                PreparedStatement requete = connexion.prepareStatement("SELECT * FROM projectiles;");
                ResultSet resultat = requete.executeQuery();
                while (resultat.next()) {
                
                    //Bonus bonus = new Couteau(Moi);
                
                       

                    if (resultat.getString("type").equals("couteau")){
                        
                        //bonus = new Couteau(resultat.getInt("x"),resultat.getInt("y"),resultat.getInt("vitesse x"),resultat.getInt("vitesse y"),resultat.getInt("hauteur"),resultat.getInt("largeur"),resultat.getInt("numero_lanceur"),resultat.getLong("timer"));
                    }
                    
                    
                    //Liste2.add(bonus);
                    

                     
                    
                }
                requete.close();  
                

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        
        this.setListe(Liste2);
        
        
        }
    
}
