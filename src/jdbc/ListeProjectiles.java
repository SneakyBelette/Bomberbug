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
import java.util.ArrayList;
import static jdbc.Main.Moi;
import static jdbc.Main.ProjectilesAAjouter;
import static jdbc.Main.connexion;

/**
 *
 * @author pdolle
 */
public class ListeProjectiles {
    
    private ArrayList<Projectile> Liste;
    
    public ListeProjectiles() {
        this.Liste = new ArrayList<>();
    }

    public ArrayList<Projectile> getListe() {
        return Liste;
    }

    public void setListe(ArrayList<Projectile> Liste) {
        this.Liste = Liste;
    }
    
    public void remove(Projectile proj){
        this.Liste.remove(proj);
    }
    
    public void add(Projectile proj){
        this.Liste.add(proj);
    }
    
    public void addAll(ArrayList<Projectile> Liste){
        this.Liste.addAll(Liste);
    }
    
    /*public String Afficher(){
        String LaListe = "";
        for(Projectile proj : Liste){
            LaListe = LaListe + proj.toString();
        }
        return LaListe;
    }*/
    
    
    
//    public void Pull(){
//        
//        
//        ArrayList<Projectile> ListeACharger=new ArrayList();
//        Projectile NewProj= new Projectile("erreur",0,0,0,0,0,0,0,0);
//        
//        try {
//            
//
//            PreparedStatement requete = connexion.prepareStatement("SELECT type,x,y,timer,vitesse x,vitesse y,hauteur,largeur,numero_lanceur FROM Projectiles");
//            ResultSet resultat = requete.executeQuery();
//            while (resultat.next()) {
//                NewProj.setType(resultat.getString("type"));
//                NewProj.setX(resultat.getInt("x"));
//                NewProj.setY(resultat.getInt("y"));
//                NewProj.setNaissance(resultat.getLong("timer"));
//                NewProj.setVitessex(resultat.getInt("vitesse x"));
//                NewProj.setVitessey(resultat.getInt("vitesse y"));
//                NewProj.setHauteur(resultat.getInt("hauteur"));
//                NewProj.setLargeur(resultat.getInt("largeur"));
//                NewProj.setNumero_lanceur(resultat.getInt("numero_lanceur"));
//                
//                ListeACharger.add(NewProj);
//            }
//
//            requete.close();
//            
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        
//        
//        this.Liste = ListeACharger;
//        
//        
//        
//    }
    
    
//    public void Push(){
//        
//        try {
//
//            for(Projectile proj : this.Liste){
//            PreparedStatement requete = connexion.prepareStatement("INSERT INTO projectiles VALUES (?,?,?,?,?,NOW())");
//            requete.setString(1,proj.getType() );
//            requete.setInt(2,proj.getX() );
//            requete.setInt(3,proj.getY() );
//            requete.setLong(4,proj.getNaissance() );
//            requete.setInt(5,proj.getVitessex() );
//            requete.setInt(6,proj.getVitessey());
//            requete.setInt(7,proj.getHauteur() );
//            requete.setInt(8,proj.getLargeur() );
//            requete.setInt(9,proj.getNumero_lanceur());
//
//            requete.executeUpdate();
//            requete.close();
//            }
//            
//
//            
//            
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        
//        
//        
//    }
    
    
    public void Nettoyer(){
        
        try {

           
            PreparedStatement requete = connexion.prepareStatement("DELETE FROM projectiles ");
            requete.executeUpdate();

            requete.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
    
    public void UpdateProjectiles(int ID){
        
        boolean EstPerime = false;
        
        ArrayList<Projectile> Liste2 = new ArrayList<Projectile>();
        Liste2.addAll(this.Liste);
        for(Projectile proj : Liste2){
            
            EstPerime = false;
            
            if(proj.getNumero_lanceur()==ID){
                EstPerime = proj.Avancer();

            }
            if(proj.getNumero_lanceur()!=ID){
                
                this.Liste.remove(proj);
                
            }
            
            if (EstPerime){
                this.Liste.remove(proj);
                try{
                    PreparedStatement requete4 = connexion.prepareStatement("DELETE FROM projectiles WHERE timer = ? AND numero_lanceur=? ");
                    requete4.setLong(1, proj.getNaissance());
                    requete4.setInt(2, proj.getNumero_lanceur());
                    
                    requete4.executeUpdate();

                    requete4.close();
                }catch (SQLException ex) {
                ex.printStackTrace();
            }
                
            }
        }
        
        
        try {

            
            for(int i=0; i < this.Liste.size(); i++){
                
            
                Projectile proj = this.Liste.get(i);
            
                PreparedStatement requete3 = connexion.prepareStatement("UPDATE projectiles SET x = ?, y = ? WHERE timer = ? AND numero_lanceur ="+ID+"");
                requete3.setInt(1, proj.getX());
                requete3.setInt(2, proj.getY());
                requete3.setLong(3, proj.getNaissance());
                    
                
                requete3.execute();
                requete3.close(); 
            }
            
            

        } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        
        
        
        
       /* for(Projectile proj : this.Liste){
            try {
                PreparedStatement requete3 = connexion.prepareStatement("UPDATE projectiles SET x = ?, y = ? WHERE timer = ? AND numero_lanceur ="+ID+"");
                requete3.setInt(1, proj.getX());
                requete3.setInt(2, proj.getY());
                requete3.setLong(3, proj.getNaissance());
                    
                requete3.executeUpdate();

                requete3.close();   

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }*/
        
        try {
                PreparedStatement requete = connexion.prepareStatement("SELECT * FROM projectiles WHERE numero_lanceur <>"+ID+";");
                ResultSet resultat = requete.executeQuery();
                while (resultat.next()) {
                
                    Projectile Proj = new Couteau(Moi);
                
                       

                    if (resultat.getString("type").equals("couteau")){
                        
                        Proj = new Couteau(resultat.getInt("x"),resultat.getInt("y"),resultat.getInt("vitesse x"),resultat.getInt("vitesse y"),resultat.getInt("hauteur"),resultat.getInt("largeur"),resultat.getInt("numero_lanceur"),resultat.getLong("timer"));
                    }
                    if (resultat.getString("type").equals("fleche")){
                        
                        Proj = new Fleche(resultat.getInt("x"),resultat.getInt("y"),resultat.getInt("vitesse x"),resultat.getInt("vitesse y"),resultat.getInt("hauteur"),resultat.getInt("largeur"),resultat.getInt("numero_lanceur"),resultat.getLong("timer"));
                    }
                    if (resultat.getString("type").equals("grenade")){
                        
                        Proj = new Grenade(resultat.getInt("x"),resultat.getInt("y"),resultat.getInt("vitesse x"),resultat.getInt("vitesse y"),resultat.getInt("hauteur"),resultat.getInt("largeur"),resultat.getInt("numero_lanceur"),resultat.getLong("timer"));
                    }
                    
                    
                    this.Liste.add(Proj);
                    

                     
                    
                }
                requete.close();  
                

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        
        if (ProjectilesAAjouter.Liste.size()>0){
            for(Projectile proj : ProjectilesAAjouter.Liste){

                try {
                    PreparedStatement requete2 = connexion.prepareStatement("INSERT INTO projectiles VALUES (?,?,?,?,?,?,?,?,?)");
                    requete2.setString(1, proj.getType());
                    requete2.setInt(2, proj.getX());
                    requete2.setInt(3, proj.getY());
                    requete2.setLong(4, proj.getNaissance());
                    requete2.setInt(5, proj.getVitessex());
                    requete2.setInt(6, proj.getVitessey());
                    requete2.setInt(7, proj.getHauteur());
                    requete2.setInt(8, proj.getLargeur());
                    requete2.setInt(9, proj.getNumero_lanceur());

                    requete2.executeUpdate();

                    requete2.close();   

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
                this.Liste.add(proj);
                

            }
            
            ProjectilesAAjouter.Liste = new ArrayList<Projectile>();
        }
        
        
                
               
        
//        try {
//            
//            
//            PreparedStatement requete0 = connexion.prepareStatement("SELECT * FROM projectiles ");
//            ResultSet resultat0 = requete0.executeQuery();
//            while (resultat0.next()) {
//                
//                
//                Projectile Proj =null;
//                
//                if (resultat0.getString("type")=="Couteau"){
//                    Proj = new Couteau(resultat0.getInt("x"),resultat0.getInt("y"),resultat0.getInt("vitesse x"),resultat0.getInt("vitesse y"),resultat0.getInt("hauteur"),resultat0.getInt("largeur"),resultat0.getInt("numero_lanceur"),(int) resultat0.getLong("timer"));
//                }
//                
//                
//                Liste.add(Proj);
//            }
//
//            requete0.close();
//           
//            
//            
//            
//
//            PreparedStatement requete = connexion.prepareStatement("SELECT * FROM projectiles WHERE numero_lanceur ="+ID+";");
//            ResultSet resultat = requete.executeQuery();
//            boolean AExpire=false;
//            while (resultat.next()) {
//                
//                Projectile Proj = new Couteau(Moi);
//                
//                        
//                if (resultat.getString("type")=="Couteau"){
//                    Proj = new Couteau(resultat0.getInt("x"),resultat0.getInt("y"),resultat0.getInt("vitesse x"),resultat0.getInt("vitesse y"),resultat0.getInt("hauteur"),resultat0.getInt("largeur"),resultat0.getInt("numero_lanceur"),(int) resultat0.getLong("timer"));
//                }
//                
//                
//                AExpire = Proj.Avancer();
//                
//                if (AExpire){
//                    PreparedStatement requete2 = connexion.prepareStatement("DELETE FROM projectiles WHERE timer = ? AND numero_lanceur=? ");
//                    requete2.setLong(1, Proj.getNaissance());
//                    requete2.setInt(2, Proj.getNumero_lanceur());
//                    
//                    requete2.executeUpdate();
//
//                    requete2.close();
//                }else{
//                    
//                    PreparedStatement requete3 = connexion.prepareStatement("UPDATE projectiles SET x = ?, y = ? WHERE timer = ? AND numero_lanceur =?");
//                    requete3.setInt(1, Proj.getX());
//                    requete3.setInt(2, Proj.getY());
//                    requete3.setLong(3, Proj.getNaissance());
//                    requete3.setInt(4, Proj.getNumero_lanceur());
//                    
//                    requete3.executeUpdate();
//
//                    requete3.close();   
//                    
//                }
//                
//            }
//
//            
//            requete.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
    }
}
