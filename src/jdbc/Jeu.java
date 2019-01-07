/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import static jdbc.Main.Adversaires;
import static jdbc.Main.ListeDesBonus;
import static jdbc.Main.Projectiles;

/**
 *
 * @author pdolle
 */

/**
 * Exemple de jeu
 *
 * @author guillaume.laurent
 */
public class Jeu {

    private BufferedImage nyancat,map, fond, spritegauche1, spritegauche2, spritegauche3,
            spritegauche4, spritegauche5, spritegauche6, spritegauche7, spritegauche8,
            spritegauche9, spritegauche10, spritedroite1, spritedroite2, spritedroite3,
            spritedroite4, spritedroite5, spritedroite6, spritedroite7, spritedroite8,
            spritedroite9, spritedroite10, spritebas1, spritebas2, spritebas3, spritebas4,
            spritebas5, spritebas6, spritebas7, spritebas8, spritebas9, spritebas10, mur,
            spritehaut1, spritehaut2, spritehaut3, spritehaut4, spritehaut5, spritehaut6,
            spritehaut7, spritehaut8, spritehaut9, spritehaut10, spriteBgauche1, spriteBgauche2, spriteBgauche3,
            spriteBgauche4, spriteBgauche5, spriteBgauche6, spriteBgauche7, spriteBgauche8,
            spriteBgauche9, spriteBgauche10, spriteBdroite1, spriteBdroite2, spriteBdroite3,
            spriteBdroite4, spriteBdroite5, spriteBdroite6, spriteBdroite7, spriteBdroite8,
            spriteBdroite9, spriteBdroite10, spriteBbas1, spriteBbas2, spriteBbas3, spriteBbas4,
            spriteBbas5, spriteBbas6, spriteBbas7, spriteBbas8, spriteBbas9, spriteBbas10,
            spriteBhaut1, spriteBhaut2, spriteBhaut3, spriteBhaut4, spriteBhaut5, spriteBhaut6,
            spriteBhaut7, spriteBhaut8, spriteBhaut9, spriteBhaut10, spriteRgauche1, spriteRgauche2, spriteRgauche3,
            spriteRgauche4, spriteRgauche5, spriteRgauche6, spriteRgauche7, spriteRgauche8,
            spriteRgauche9, spriteRgauche10, spriteRdroite1, spriteRdroite2, spriteRdroite3,
            spriteRdroite4, spriteRdroite5, spriteRdroite6, spriteRdroite7, spriteRdroite8,
            spriteRdroite9, spriteRdroite10, spriteRbas1, spriteRbas2, spriteRbas3, spriteRbas4,
            spriteRbas5, spriteRbas6, spriteRbas7, spriteRbas8, spriteRbas9, spriteRbas10,
            spriteRhaut1, spriteRhaut2, spriteRhaut3, spriteRhaut4, spriteRhaut5, spriteRhaut6,
            spriteRhaut7, spriteRhaut8, spriteRhaut9, spriteRhaut10, spriteVgauche1, spriteVgauche2, spriteVgauche3,
            spriteVgauche4, spriteVgauche5, spriteVgauche6, spriteVgauche7, spriteVgauche8,
            spriteVgauche9, spriteVgauche10, spriteVdroite1, spriteVdroite2, spriteVdroite3,
            spriteVdroite4, spriteVdroite5, spriteVdroite6, spriteVdroite7, spriteVdroite8,
            spriteVdroite9, spriteVdroite10, spriteVbas1, spriteVbas2, spriteVbas3, spriteVbas4,
            spriteVbas5, spriteVbas6, spriteVbas7, spriteVbas8, spriteVbas9, spriteVbas10,
            spriteVhaut1, spriteVhaut2, spriteVhaut3, spriteVhaut4, spriteVhaut5, spriteVhaut6,
            spriteVhaut7, spriteVhaut8, spriteVhaut9, spriteVhaut10, couteauPti,grenade;
    private Joueur Moi;

    public Jeu(Joueur moi) {
        try {
            this.fond = ImageIO.read(new File("fond.jpg"));
            this.nyancat = ImageIO.read(new File("nyancat.png"));
            this.spritegauche1 = ImageIO.read(new File("ZeldaGaucheStep1PetitTr.png"));
            this.spritedroite1 = ImageIO.read(new File("ZeldaDroiteStep1PetitTr.png"));
            this.spritehaut1 = ImageIO.read(new File("ZeldaHautStep1PetitTr.png"));
            this.spritebas1 = ImageIO.read(new File("ZeldaBasStep1PetitTr.png")); 
            this.spritegauche2 = ImageIO.read(new File("ZeldaGaucheStep2PetitTr.png"));
            this.spritedroite2 = ImageIO.read(new File("ZeldaDroiteStep2PetitTr.png"));
            this.spritehaut2 = ImageIO.read(new File("ZeldaHautStep2PetitTr.png"));
            this.spritebas2 = ImageIO.read(new File("ZeldaBasStep2PetitTr.png"));
            this.spritegauche3 = ImageIO.read(new File("ZeldaGaucheStep3PetitTr.png"));
            this.spritedroite3 = ImageIO.read(new File("ZeldaDroiteStep3PetitTr.png"));
            this.spritehaut3 = ImageIO.read(new File("ZeldaHautStep3PetitTr.png"));
            this.spritebas3 = ImageIO.read(new File("ZeldaBasStep3PetitTr.png"));
            this.spritegauche4 = ImageIO.read(new File("ZeldaGaucheStep4PetitTr.png"));
            this.spritedroite4 = ImageIO.read(new File("ZeldaDroiteStep4PetitTr.png"));
            this.spritehaut4 = ImageIO.read(new File("ZeldaHautStep4PetitTr.png"));
            this.spritebas4 = ImageIO.read(new File("ZeldaBasStep4PetitTr.png")); 
            this.spritegauche5 = ImageIO.read(new File("ZeldaGaucheStep5PetitTr.png"));
            this.spritedroite5 = ImageIO.read(new File("ZeldaDroiteStep5PetitTr.png"));
            this.spritehaut5 = ImageIO.read(new File("ZeldaHautStep5PetitTr.png"));
            this.spritebas5 = ImageIO.read(new File("ZeldaBasStep5PetitTr.png"));
            this.spritegauche6 = ImageIO.read(new File("ZeldaGaucheStep6PetitTr.png"));
            this.spritedroite6 = ImageIO.read(new File("ZeldaDroiteStep6PetitTr.png"));
            this.spritehaut6 = ImageIO.read(new File("ZeldaHautStep6PetitTr.png"));
            this.spritebas6 = ImageIO.read(new File("ZeldaBasStep6PetitTr.png"));
            this.spritegauche7 = ImageIO.read(new File("ZeldaGaucheStep7PetitTr.png"));
            this.spritedroite7 = ImageIO.read(new File("ZeldaDroiteStep7PetitTr.png"));
            this.spritehaut7 = ImageIO.read(new File("ZeldaHautStep7PetitTr.png"));
            this.spritebas7 = ImageIO.read(new File("ZeldaBasStep7PetitTr.png")); 
            this.spritegauche8 = ImageIO.read(new File("ZeldaGaucheStep8PetitTr.png"));
            this.spritedroite8 = ImageIO.read(new File("ZeldaDroiteStep8PetitTr.png"));
            this.spritehaut8 = ImageIO.read(new File("ZeldaHautStep8PetitTr.png"));
            this.spritebas8 = ImageIO.read(new File("ZeldaBasStep8PetitTr.png"));
            this.spritegauche9 = ImageIO.read(new File("ZeldaGaucheStep9PetitTr.png"));
            this.spritedroite9 = ImageIO.read(new File("ZeldaDroiteStep9PetitTr.png"));
            this.spritehaut9 = ImageIO.read(new File("ZeldaHautStep9PetitTr.png"));
            this.spritebas9 = ImageIO.read(new File("ZeldaBasStep9PetitTr.png"));
            this.spritegauche10 = ImageIO.read(new File("ZeldaGaucheStep10PetitTr.png"));
            this.spritedroite10 = ImageIO.read(new File("ZeldaDroiteStep10PetitTr.png"));
            this.spritehaut10 = ImageIO.read(new File("ZeldaHautStep10PetitTr.png"));
            this.spritebas10 = ImageIO.read(new File("ZeldaBasStep10PetitTr.png"));
            this.spriteBgauche1 = ImageIO.read(new File("ZeldaGaucheStep1PetitTrB.png"));
            this.spriteBdroite1 = ImageIO.read(new File("ZeldaDroiteStep1PetitTrB.png"));
            this.spriteBhaut1 = ImageIO.read(new File("ZeldaHautStep1PetitTrB.png"));
            this.spriteBbas1 = ImageIO.read(new File("ZeldaBasStep1PetitTrB.png")); 
            this.spriteBgauche2 = ImageIO.read(new File("ZeldaGaucheStep2PetitTrB.png"));
            this.spriteBdroite2 = ImageIO.read(new File("ZeldaDroiteStep2PetitTrB.png"));
            this.spriteBhaut2 = ImageIO.read(new File("ZeldaHautStep2PetitTrB.png"));
            this.spriteBbas2 = ImageIO.read(new File("ZeldaBasStep2PetitTrB.png"));
            this.spriteBgauche3 = ImageIO.read(new File("ZeldaGaucheStep3PetitTrB.png"));
            this.spriteBdroite3 = ImageIO.read(new File("ZeldaDroiteStep3PetitTrB.png"));
            this.spriteBhaut3 = ImageIO.read(new File("ZeldaHautStep3PetitTrB.png"));
            this.spriteBbas3 = ImageIO.read(new File("ZeldaBasStep3PetitTrB.png"));
            this.spriteBgauche4 = ImageIO.read(new File("ZeldaGaucheStep4PetitTrB.png"));
            this.spriteBdroite4 = ImageIO.read(new File("ZeldaDroiteStep4PetitTrB.png"));
            this.spriteBhaut4 = ImageIO.read(new File("ZeldaHautStep4PetitTrB.png"));
            this.spriteBbas4 = ImageIO.read(new File("ZeldaBasStep4PetitTrB.png")); 
            this.spriteBgauche5 = ImageIO.read(new File("ZeldaGaucheStep5PetitTrB.png"));
            this.spriteBdroite5 = ImageIO.read(new File("ZeldaDroiteStep5PetitTrB.png"));
            this.spriteBhaut5 = ImageIO.read(new File("ZeldaHautStep5PetitTrB.png"));
            this.spriteBbas5 = ImageIO.read(new File("ZeldaBasStep5PetitTrB.png"));
            this.spriteBgauche6 = ImageIO.read(new File("ZeldaGaucheStep6PetitTrB.png"));
            this.spriteBdroite6 = ImageIO.read(new File("ZeldaDroiteStep6PetitTrB.png"));
            this.spriteBhaut6 = ImageIO.read(new File("ZeldaHautStep6PetitTrB.png"));
            this.spriteBbas6 = ImageIO.read(new File("ZeldaBasStep6PetitTrB.png"));
            this.spriteBgauche7 = ImageIO.read(new File("ZeldaGaucheStep7PetitTrB.png"));
            this.spriteBdroite7 = ImageIO.read(new File("ZeldaDroiteStep7PetitTrB.png"));
            this.spriteBhaut7 = ImageIO.read(new File("ZeldaHautStep7PetitTrB.png"));
            this.spriteBbas7 = ImageIO.read(new File("ZeldaBasStep7PetitTrB.png")); 
            this.spriteBgauche8 = ImageIO.read(new File("ZeldaGaucheStep8PetitTrB.png"));
            this.spriteBdroite8 = ImageIO.read(new File("ZeldaDroiteStep8PetitTrB.png"));
            this.spriteBhaut8 = ImageIO.read(new File("ZeldaHautStep8PetitTrB.png"));
            this.spriteBbas8 = ImageIO.read(new File("ZeldaBasStep8PetitTrB.png"));
            this.spriteBgauche9 = ImageIO.read(new File("ZeldaGaucheStep9PetitTrB.png"));
            this.spriteBdroite9 = ImageIO.read(new File("ZeldaDroiteStep9PetitTrB.png"));
            this.spriteBhaut9 = ImageIO.read(new File("ZeldaHautStep9PetitTrB.png"));
            this.spriteBbas9 = ImageIO.read(new File("ZeldaBasStep9PetitTrB.png"));
            this.spriteBgauche10 = ImageIO.read(new File("ZeldaGaucheStep10PetitTrB.png"));
            this.spriteBdroite10 = ImageIO.read(new File("ZeldaDroiteStep10PetitTrB.png"));
            this.spriteBhaut10 = ImageIO.read(new File("ZeldaHautStep10PetitTrB.png"));
            this.spriteBbas10 = ImageIO.read(new File("ZeldaBasStep10PetitTrB.png"));
            this.spriteRgauche1 = ImageIO.read(new File("ZeldaGaucheStep1PetitTrR.png"));
            this.spriteRdroite1 = ImageIO.read(new File("ZeldaDroiteStep1PetitTrR.png"));
            this.spriteRhaut1 = ImageIO.read(new File("ZeldaHautStep1PetitTrR.png"));
            this.spriteRbas1 = ImageIO.read(new File("ZeldaBasStep1PetitTrR.png")); 
            this.spriteRgauche2 = ImageIO.read(new File("ZeldaGaucheStep2PetitTrR.png"));
            this.spriteRdroite2 = ImageIO.read(new File("ZeldaDroiteStep2PetitTrR.png"));
            this.spriteRhaut2 = ImageIO.read(new File("ZeldaHautStep2PetitTrR.png"));
            this.spriteRbas2 = ImageIO.read(new File("ZeldaBasStep2PetitTrR.png"));
            this.spriteRgauche3 = ImageIO.read(new File("ZeldaGaucheStep3PetitTrR.png"));
            this.spriteRdroite3 = ImageIO.read(new File("ZeldaDroiteStep3PetitTrR.png"));
            this.spriteRhaut3 = ImageIO.read(new File("ZeldaHautStep3PetitTrR.png"));
            this.spriteRbas3 = ImageIO.read(new File("ZeldaBasStep3PetitTrR.png"));
            this.spriteRgauche4 = ImageIO.read(new File("ZeldaGaucheStep4PetitTrR.png"));
            this.spriteRdroite4 = ImageIO.read(new File("ZeldaDroiteStep4PetitTrR.png"));
            this.spriteRhaut4 = ImageIO.read(new File("ZeldaHautStep4PetitTrR.png"));
            this.spriteRbas4 = ImageIO.read(new File("ZeldaBasStep4PetitTrR.png")); 
            this.spriteRgauche5 = ImageIO.read(new File("ZeldaGaucheStep5PetitTrR.png"));
            this.spriteRdroite5 = ImageIO.read(new File("ZeldaDroiteStep5PetitTrR.png"));
            this.spriteRhaut5 = ImageIO.read(new File("ZeldaHautStep5PetitTrR.png"));
            this.spriteRbas5 = ImageIO.read(new File("ZeldaBasStep5PetitTrR.png"));
            this.spriteRgauche6 = ImageIO.read(new File("ZeldaGaucheStep6PetitTrR.png"));
            this.spriteRdroite6 = ImageIO.read(new File("ZeldaDroiteStep6PetitTrR.png"));
            this.spriteRhaut6 = ImageIO.read(new File("ZeldaHautStep6PetitTrR.png"));
            this.spriteRbas6 = ImageIO.read(new File("ZeldaBasStep6PetitTrR.png"));
            this.spriteRgauche7 = ImageIO.read(new File("ZeldaGaucheStep7PetitTrR.png"));
            this.spriteRdroite7 = ImageIO.read(new File("ZeldaDroiteStep7PetitTrR.png"));
            this.spriteRhaut7 = ImageIO.read(new File("ZeldaHautStep7PetitTrR.png"));
            this.spriteRbas7 = ImageIO.read(new File("ZeldaBasStep7PetitTrR.png")); 
            this.spriteRgauche8 = ImageIO.read(new File("ZeldaGaucheStep8PetitTrR.png"));
            this.spriteRdroite8 = ImageIO.read(new File("ZeldaDroiteStep8PetitTrR.png"));
            this.spriteRhaut8 = ImageIO.read(new File("ZeldaHautStep8PetitTrR.png"));
            this.spriteRbas8 = ImageIO.read(new File("ZeldaBasStep8PetitTrR.png"));
            this.spriteRgauche9 = ImageIO.read(new File("ZeldaGaucheStep9PetitTrR.png"));
            this.spriteRdroite9 = ImageIO.read(new File("ZeldaDroiteStep9PetitTrR.png"));
            this.spriteRhaut9 = ImageIO.read(new File("ZeldaHautStep9PetitTrR.png"));
            this.spriteRbas9 = ImageIO.read(new File("ZeldaBasStep9PetitTrR.png"));
            this.spriteRgauche10 = ImageIO.read(new File("ZeldaGaucheStep10PetitTrR.png"));
            this.spriteRdroite10 = ImageIO.read(new File("ZeldaDroiteStep10PetitTrR.png"));
            this.spriteRhaut10 = ImageIO.read(new File("ZeldaHautStep10PetitTrR.png"));
            this.spriteRbas10 = ImageIO.read(new File("ZeldaBasStep10PetitTrR.png"));
            this.spriteVgauche1 = ImageIO.read(new File("ZeldaGaucheStep1PetitTrV.png"));
            this.spriteVdroite1 = ImageIO.read(new File("ZeldaDroiteStep1PetitTrV.png"));
            this.spriteVhaut1 = ImageIO.read(new File("ZeldaHautStep1PetitTrV.png"));
            this.spriteVbas1 = ImageIO.read(new File("ZeldaBasStep1PetitTrV.png")); 
            this.spriteVgauche2 = ImageIO.read(new File("ZeldaGaucheStep2PetitTrV.png"));
            this.spriteVdroite2 = ImageIO.read(new File("ZeldaDroiteStep2PetitTrV.png"));
            this.spriteVhaut2 = ImageIO.read(new File("ZeldaHautStep2PetitTrV.png"));
            this.spriteVbas2 = ImageIO.read(new File("ZeldaBasStep2PetitTrV.png"));
            this.spriteVgauche3 = ImageIO.read(new File("ZeldaGaucheStep3PetitTrV.png"));
            this.spriteVdroite3 = ImageIO.read(new File("ZeldaDroiteStep3PetitTrV.png"));
            this.spriteVhaut3 = ImageIO.read(new File("ZeldaHautStep3PetitTrV.png"));
            this.spriteVbas3 = ImageIO.read(new File("ZeldaBasStep3PetitTrV.png"));
            this.spriteVgauche4 = ImageIO.read(new File("ZeldaGaucheStep4PetitTrV.png"));
            this.spriteVdroite4 = ImageIO.read(new File("ZeldaDroiteStep4PetitTrV.png"));
            this.spriteVhaut4 = ImageIO.read(new File("ZeldaHautStep4PetitTrV.png"));
            this.spriteVbas4 = ImageIO.read(new File("ZeldaBasStep4PetitTrV.png")); 
            this.spriteVgauche5 = ImageIO.read(new File("ZeldaGaucheStep5PetitTrV.png"));
            this.spriteVdroite5 = ImageIO.read(new File("ZeldaDroiteStep5PetitTrV.png"));
            this.spriteVhaut5 = ImageIO.read(new File("ZeldaHautStep5PetitTrV.png"));
            this.spriteVbas5 = ImageIO.read(new File("ZeldaBasStep5PetitTrV.png"));
            this.spriteVgauche6 = ImageIO.read(new File("ZeldaGaucheStep6PetitTrV.png"));
            this.spriteVdroite6 = ImageIO.read(new File("ZeldaDroiteStep6PetitTrV.png"));
            this.spriteVhaut6 = ImageIO.read(new File("ZeldaHautStep6PetitTrV.png"));
            this.spriteVbas6 = ImageIO.read(new File("ZeldaBasStep6PetitTrV.png"));
            this.spriteVgauche7 = ImageIO.read(new File("ZeldaGaucheStep7PetitTrV.png"));
            this.spriteVdroite7 = ImageIO.read(new File("ZeldaDroiteStep7PetitTrV.png"));
            this.spriteVhaut7 = ImageIO.read(new File("ZeldaHautStep7PetitTrV.png"));
            this.spriteVbas7 = ImageIO.read(new File("ZeldaBasStep7PetitTrV.png")); 
            this.spriteVgauche8 = ImageIO.read(new File("ZeldaGaucheStep8PetitTrV.png"));
            this.spriteVdroite8 = ImageIO.read(new File("ZeldaDroiteStep8PetitTrV.png"));
            this.spriteVhaut8 = ImageIO.read(new File("ZeldaHautStep8PetitTrV.png"));
            this.spriteVbas8 = ImageIO.read(new File("ZeldaBasStep8PetitTrV.png"));
            this.spriteVgauche9 = ImageIO.read(new File("ZeldaGaucheStep9PetitTrV.png"));
            this.spriteVdroite9 = ImageIO.read(new File("ZeldaDroiteStep9PetitTrV.png"));
            this.spriteVhaut9 = ImageIO.read(new File("ZeldaHautStep9PetitTrV.png"));
            this.spriteVbas9 = ImageIO.read(new File("ZeldaBasStep9PetitTrV.png"));
            this.spriteVgauche10 = ImageIO.read(new File("ZeldaGaucheStep10PetitTrV.png"));
            this.spriteVdroite10 = ImageIO.read(new File("ZeldaDroiteStep10PetitTrV.png"));
            this.spriteVhaut10 = ImageIO.read(new File("ZeldaHautStep10PetitTrV.png"));
            this.spriteVbas10 = ImageIO.read(new File("ZeldaBasStep10PetitTrV.png"));
            this.mur = ImageIO.read(new File("mur.jpg"));
            this.map = ImageIO.read(new File("map.png"));
            this.couteauPti = ImageIO.read(new File("couteauPti.png"));
            this.grenade = ImageIO.read(new File("bombe.png"));

            this.Moi= moi;
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Update(Joueur Moi){
        this.Moi = Moi;
    }


    public void Afficher(Graphics2D contexte) {
        int x = this.Moi.getX();
        int y = this.Moi.getY();
        //dessiner fond
      /*  for (int i=0; i<=20; i++){
            for (int j=0; j<=20; j++){
                contexte.drawImage(this.fond, 0+30*i, 0+30*j, null);
            }
        }*/
        contexte.drawImage(this.map, 0, 0, null);

        // dessiner un joueur
        this.AfficherJoueur(contexte,Moi);
        this.AfficherJoueur(contexte,Adversaires.joueur1);
        this.AfficherJoueur(contexte,Adversaires.joueur2);
        this.AfficherJoueur(contexte,Adversaires.joueur3);

        // dessiner projectile
        
        for(Projectile proj : Projectiles.getListe()){
            
            this.AfficherProjectile(proj, contexte);
            
        }
        
        for (Bonus bonus : ListeDesBonus.getListe()){
            
            this.AfficherBonus(bonus,contexte);
        }
        
        //dessiner mur
        /* for (int i=0; i<=20; i++){
        
                contexte.drawImage(this.mur, 0+30*i, 0, null);
            
        }
         for (int i=0; i<=20; i++){
        
                contexte.drawImage(this.mur, 0+30*i, 350, null);
            
        }
         for (int i=0; i<=20; i++){
        
                contexte.drawImage(this.mur, 0, 0+30*i, null);
            
        }
         for (int i=0; i<=20; i++){
        
                contexte.drawImage(this.mur, 577, 0+30*i, null);
            
        }*/
         

        
        
    }
        public void AfficherProjectile(Projectile Proj, Graphics2D contexte){
            int x = Proj.getX();
            int y = Proj.getY();

            if (Proj.getType()=="couteau" && Proj.getVitessex()>0){
                contexte.drawImage(this.couteauPti, x, y, null);
            }
            if (Proj.getType()=="grenade"){
                contexte.drawImage(this.grenade, x, y, null);
            }
        } 
        
        public void AfficherBonus(Bonus bonus, Graphics2D contexte){
            int x = bonus.getX();
            int y = bonus.getY();

            if (bonus.getType()=="BonusArc" ){
                //contexte.drawImage(, x, y, null);
            }
            if (bonus.getType()=="lancegrenade"){
                //contexte.drawImage(, x, y, null);
            }
            if (bonus.getType()=="BonusMunitions"){
                //contexte.drawImage(, x, y, null);
            }
        }
    
    
     public void AfficherJoueur(Graphics2D contexte, Joueur j1) {
        int x = j1.getX();
        int y = j1.getY();
        int id = j1.getId();
        
        //contexte.drawImage(this.spritebas1, x, y, null);
        if (id==1){
        if (j1.getDirection()==4){    
                if (((x<15)&&(x>0))|((x>150)&&(x<165))|((x<315)&&(x>300))|((x>450)&&(x<465))|((x<615)&&(x>600))|((x>750)&&(x<765))|((x<915)&&(x>900))|((x>1050)&&(x<1065))){
                    contexte.drawImage(this.spritegauche1, x, y, null);
                }
                if (((x<30)&&(x>15))|((x>165)&&(x<180))|((x<330)&&(x>315))|((x>465)&&(x<480))|((x<630)&&(x>615))|((x>765)&&(x<780))|((x<930)&&(x>915))|((x>1065)&&(x<1080))){
                    contexte.drawImage(this.spritegauche2, x, y, null);
                }
                if (((x<45)&&(x>30))|((x>180)&&(x<195))|((x<345)&&(x>330))|((x>480)&&(x<495))|((x<645)&&(x>630))|((x>780)&&(x<795))|((x<945)&&(x>930))|((x>1080)&&(x<1095))){
                    contexte.drawImage(this.spritegauche3, x, y, null);
                }
                if (((x<60)&&(x>45))|((x>195)&&(x<210))|((x<360)&&(x>345))|((x>495)&&(x<510))|((x<660)&&(x>645))|((x>795)&&(x<810))|((x<960)&&(x>945))|((x>1095)&&(x<1110))){
                    contexte.drawImage(this.spritegauche4, x, y, null);
                }
                if (((x<75)&&(x>60))|((x>210)&&(x<225))|((x<375)&&(x>360))|((x>510)&&(x<525))|((x<675)&&(x>660))|((x>810)&&(x<825))|((x<975)&&(x>960))|((x>1110)&&(x<1125))){
                    contexte.drawImage(this.spritegauche5, x, y, null);
                }
                if (((x<90)&&(x>75))|((x>225)&&(x<240))|((x<390)&&(x>375))|((x>525)&&(x<540))|((x<690)&&(x>675))|((x>825)&&(x<840))|((x<990)&&(x>975))|((x>1125)&&(x<1140))){
                    contexte.drawImage(this.spritegauche6, x, y, null);
                }
                if (((x<105)&&(x>90))|((x>240)&&(x<255))|((x<405)&&(x>390))|((x>540)&&(x<555))|((x<705)&&(x>690))|((x>840)&&(x<855))|((x<1005)&&(x>990))|((x>1140)&&(x<1155))){
                    contexte.drawImage(this.spritegauche7, x, y, null);
                }
                if (((x<120)&&(x>105))|((x>255)&&(x<270))|((x<420)&&(x>405))|((x>555)&&(x<570))|((x<720)&&(x>705))|((x>855)&&(x<870))|((x<1020)&&(x>1005))|((x>1155)&&(x<1170))){
                    contexte.drawImage(this.spritegauche8, x, y, null);
                }
                if (((x<135)&&(x>120))|((x>270)&&(x<285))|((x<435)&&(x>420))|((x>570)&&(x<585))|((x<735)&&(x>720))|((x>870)&&(x<885))|((x<1035)&&(x>1020))|((x>1170)&&(x<1185))){
                    contexte.drawImage(this.spritegauche9, x, y, null);
                }
                if (((x<150)&&(x>135))|((x>285)&&(x<300))|((x<450)&&(x>435))|((x>585)&&(x<600))|((x<750)&&(x>735))|((x>885)&&(x<900))|((x<1050)&&(x>1035))|((x>1185)&&(x<1200))){
                    contexte.drawImage(this.spritegauche10, x, y, null);
                }
        
        }
        
        if (j1.getDirection()==2){    
                if (((x<15)&&(x>0))|((x>150)&&(x<165))|((x<315)&&(x>300))|((x>450)&&(x<465))|((x<615)&&(x>600))|((x>750)&&(x<765))|((x<915)&&(x>900))|((x>1050)&&(x<1065))){
                    contexte.drawImage(this.spritedroite1, x, y, null);
                }
                if (((x<30)&&(x>15))|((x>165)&&(x<180))|((x<330)&&(x>315))|((x>465)&&(x<480))|((x<630)&&(x>615))|((x>765)&&(x<780))|((x<930)&&(x>915))|((x>1065)&&(x<1080))){
                    contexte.drawImage(this.spritedroite2, x, y, null);
                }
                if (((x<45)&&(x>30))|((x>180)&&(x<195))|((x<345)&&(x>330))|((x>480)&&(x<495))|((x<645)&&(x>630))|((x>780)&&(x<795))|((x<945)&&(x>930))|((x>1080)&&(x<1095))){
                    contexte.drawImage(this.spritedroite3, x, y, null);
                }
                if (((x<60)&&(x>45))|((x>195)&&(x<210))|((x<360)&&(x>345))|((x>495)&&(x<510))|((x<660)&&(x>645))|((x>795)&&(x<810))|((x<960)&&(x>945))|((x>1095)&&(x<1110))){
                    contexte.drawImage(this.spritedroite4, x, y, null);
                }
                if (((x<75)&&(x>60))|((x>210)&&(x<225))|((x<375)&&(x>360))|((x>510)&&(x<525))|((x<675)&&(x>660))|((x>810)&&(x<825))|((x<975)&&(x>960))|((x>1110)&&(x<1125))){
                    contexte.drawImage(this.spritedroite5, x, y, null);
                }
                if (((x<90)&&(x>75))|((x>225)&&(x<240))|((x<390)&&(x>375))|((x>525)&&(x<540))|((x<690)&&(x>675))|((x>825)&&(x<840))|((x<990)&&(x>975))|((x>1125)&&(x<1140))){
                    contexte.drawImage(this.spritedroite6, x, y, null);
                }
                if (((x<105)&&(x>90))|((x>240)&&(x<255))|((x<405)&&(x>390))|((x>540)&&(x<555))|((x<705)&&(x>690))|((x>840)&&(x<855))|((x<1005)&&(x>990))|((x>1140)&&(x<1155))){
                    contexte.drawImage(this.spritedroite7, x, y, null);
                }
                if (((x<120)&&(x>105))|((x>255)&&(x<270))|((x<420)&&(x>405))|((x>555)&&(x<570))|((x<720)&&(x>705))|((x>855)&&(x<870))|((x<1020)&&(x>1005))|((x>1155)&&(x<1170))){
                    contexte.drawImage(this.spritedroite8, x, y, null);
                }
                if (((x<135)&&(x>120))|((x>270)&&(x<285))|((x<435)&&(x>420))|((x>570)&&(x<585))|((x<735)&&(x>720))|((x>870)&&(x<885))|((x<1035)&&(x>1020))|((x>1170)&&(x<1185))){
                    contexte.drawImage(this.spritedroite9, x, y, null);
                }
                if (((x<150)&&(x>135))|((x>285)&&(x<300))|((x<450)&&(x>435))|((x>585)&&(x<600))|((x<750)&&(x>735))|((x>885)&&(x<900))|((x<1050)&&(x>1035))|((x>1185)&&(x<1200))){
                    contexte.drawImage(this.spritedroite10, x, y, null);
                }
        }
        if (j1.getDirection()==1){    
                if (((y<15)&&(y>0))|((y>150)&&(y<165))|((y<315)&&(y>300))|((y>450)&&(y<465))|((y>600)&&(y<615))){
                    contexte.drawImage(this.spritebas1, x, y, null);
                }
                if (((y<30)&&(y>15))|((y>165)&&(y<180))|((y<330)&&(y>315))|((y>465)&&(y<480))|((y>615)&&(y<630))){
                    contexte.drawImage(this.spritebas2, x, y, null);
                }
                if (((y<45)&&(y>30))|((y>180)&&(y<195))|((y<345)&&(y>330))|((y>480)&&(y<495))|((y>630)&&(y<645))){
                    contexte.drawImage(this.spritebas3, x, y, null);
                }
                if (((y<60)&&(y>45))|((y>195)&&(y<210))|((y<360)&&(y>345))|((y>495)&&(y<510))|((y>645)&&(y<660))){
                    contexte.drawImage(this.spritebas4, x, y, null);
                }
                if (((y<75)&&(y>60))|((y>210)&&(y<225))|((y<375)&&(y>360))|((y>510)&&(y<525))|((y>660)&&(y<675))){
                    contexte.drawImage(this.spritebas5, x, y, null);
                }
                if (((y<90)&&(y>75))|((y>225)&&(y<240))|((y<390)&&(y>375))|((y>525)&&(y<540))|((y>675)&&(y<690))){
                    contexte.drawImage(this.spritebas6, x, y, null);
                }
                if (((y<105)&&(y>90))|((y>240)&&(y<255))|((y<405)&&(y>390))|((y>540)&&(y<555))|((y>690)&&(y<705))){
                    contexte.drawImage(this.spritebas7, x, y, null);
                }
                if (((y<120)&&(y>105))|((y>255)&&(y<270))|((y<420)&&(y>405))|((y>555)&&(y<570))|((y>705)&&(y<720))){
                    contexte.drawImage(this.spritebas8, x, y, null);
                }
                if (((y<135)&&(y>120))|((y>270)&&(y<285))|((y<435)&&(y>420))|((y>570)&&(y<585))|((y>720)&&(y<735))){
                    contexte.drawImage(this.spritebas9, x, y, null);
                }
                if (((y<150)&&(y>135))|((y>285)&&(y<300))|((y<450)&&(y>435))|((y>585)&&(y<600))|((y>735)&&(y<750))){
                    contexte.drawImage(this.spritebas10, x, y, null);
                }
        }
        if (j1.getDirection()==3){    
                if (((y<15)&&(y>0))|((y>150)&&(y<165))|((y<315)&&(y>300))|((y>450)&&(y<465))|((y>600)&&(y<615))){
                    contexte.drawImage(this.spritehaut1, x, y, null);
                }
                if (((y<30)&&(y>15))|((y>165)&&(y<180))|((y<330)&&(y>315))|((y>465)&&(y<480))|((y>615)&&(y<630))){
                    contexte.drawImage(this.spritehaut2, x, y, null);
                }
                if (((y<45)&&(y>30))|((y>180)&&(y<195))|((y<345)&&(y>330))|((y>480)&&(y<495))|((y>630)&&(y<645))){
                    contexte.drawImage(this.spritehaut3, x, y, null);
                }
                if (((y<60)&&(y>45))|((y>195)&&(y<210))|((y<360)&&(y>345))|((y>495)&&(y<510))|((y>645)&&(y<660))){
                    contexte.drawImage(this.spritehaut4, x, y, null);
                }
                if (((y<75)&&(y>60))|((y>210)&&(y<225))|((y<375)&&(y>360))|((y>510)&&(y<525))|((y>660)&&(y<675))){
                    contexte.drawImage(this.spritehaut5, x, y, null);
                }
                if (((y<90)&&(y>75))|((y>225)&&(y<240))|((y<390)&&(y>375))|((y>525)&&(y<540))|((y>675)&&(y<690))){
                    contexte.drawImage(this.spritehaut6, x, y, null);
                }
                if (((y<105)&&(y>90))|((y>240)&&(y<255))|((y<405)&&(y>390))|((y>540)&&(y<555))|((y>690)&&(y<705))){
                    contexte.drawImage(this.spritehaut7, x, y, null);
                }
                if (((y<120)&&(y>105))|((y>255)&&(y<270))|((y<420)&&(y>405))|((y>555)&&(y<570))|((y>705)&&(y<720))){
                    contexte.drawImage(this.spritehaut8, x, y, null);
                }
                if (((y<135)&&(y>120))|((y>270)&&(y<285))|((y<435)&&(y>420))|((y>570)&&(y<585))|((y>720)&&(y<735))){
                    contexte.drawImage(this.spritehaut9, x, y, null);
                }
                if (((y<150)&&(y>135))|((y>285)&&(y<300))|((y<450)&&(y>435))|((y>585)&&(y<600))|((y>735)&&(y<750))){
                    contexte.drawImage(this.spritehaut10, x, y, null);
                }
        }
        }
        if (id==2){
            if (j1.getDirection()==4){    
                if (((x<15)&&(x>0))|((x>150)&&(x<165))|((x<315)&&(x>300))|((x>450)&&(x<465))|((x<615)&&(x>600))|((x>750)&&(x<765))|((x<915)&&(x>900))|((x>1050)&&(x<1065))){
                    contexte.drawImage(this.spriteBgauche1, x, y, null);
                }
                if (((x<30)&&(x>15))|((x>165)&&(x<180))|((x<330)&&(x>315))|((x>465)&&(x<480))|((x<630)&&(x>615))|((x>765)&&(x<780))|((x<930)&&(x>915))|((x>1065)&&(x<1080))){
                    contexte.drawImage(this.spriteBgauche2, x, y, null);
                }
                if (((x<45)&&(x>30))|((x>180)&&(x<195))|((x<345)&&(x>330))|((x>480)&&(x<495))|((x<645)&&(x>630))|((x>780)&&(x<795))|((x<945)&&(x>930))|((x>1080)&&(x<1095))){
                    contexte.drawImage(this.spriteBgauche3, x, y, null);
                }
                if (((x<60)&&(x>45))|((x>195)&&(x<210))|((x<360)&&(x>345))|((x>495)&&(x<510))|((x<660)&&(x>645))|((x>795)&&(x<810))|((x<960)&&(x>945))|((x>1095)&&(x<1110))){
                    contexte.drawImage(this.spriteBgauche4, x, y, null);
                }
                if (((x<75)&&(x>60))|((x>210)&&(x<225))|((x<375)&&(x>360))|((x>510)&&(x<525))|((x<675)&&(x>660))|((x>810)&&(x<825))|((x<975)&&(x>960))|((x>1110)&&(x<1125))){
                    contexte.drawImage(this.spriteBgauche5, x, y, null);
                }
                if (((x<90)&&(x>75))|((x>225)&&(x<240))|((x<390)&&(x>375))|((x>525)&&(x<540))|((x<690)&&(x>675))|((x>825)&&(x<840))|((x<990)&&(x>975))|((x>1125)&&(x<1140))){
                    contexte.drawImage(this.spriteBgauche6, x, y, null);
                }
                if (((x<105)&&(x>90))|((x>240)&&(x<255))|((x<405)&&(x>390))|((x>540)&&(x<555))|((x<705)&&(x>690))|((x>840)&&(x<855))|((x<1005)&&(x>990))|((x>1140)&&(x<1155))){
                    contexte.drawImage(this.spriteBgauche7, x, y, null);
                }
                if (((x<120)&&(x>105))|((x>255)&&(x<270))|((x<420)&&(x>405))|((x>555)&&(x<570))|((x<720)&&(x>705))|((x>855)&&(x<870))|((x<1020)&&(x>1005))|((x>1155)&&(x<1170))){
                    contexte.drawImage(this.spriteBgauche8, x, y, null);
                }
                if (((x<135)&&(x>120))|((x>270)&&(x<285))|((x<435)&&(x>420))|((x>570)&&(x<585))|((x<735)&&(x>720))|((x>870)&&(x<885))|((x<1035)&&(x>1020))|((x>1170)&&(x<1185))){
                    contexte.drawImage(this.spriteBgauche9, x, y, null);
                }
                if (((x<150)&&(x>135))|((x>285)&&(x<300))|((x<450)&&(x>435))|((x>585)&&(x<600))|((x<750)&&(x>735))|((x>885)&&(x<900))|((x<1050)&&(x>1035))|((x>1185)&&(x<1200))){
                    contexte.drawImage(this.spriteBgauche10, x, y, null);
                }
        
        }
        
        if (j1.getDirection()==2){    
                if (((x<15)&&(x>0))|((x>150)&&(x<165))|((x<315)&&(x>300))|((x>450)&&(x<465))|((x<615)&&(x>600))|((x>750)&&(x<765))|((x<915)&&(x>900))|((x>1050)&&(x<1065))){
                    contexte.drawImage(this.spriteBdroite1, x, y, null);
                }
                if (((x<30)&&(x>15))|((x>165)&&(x<180))|((x<330)&&(x>315))|((x>465)&&(x<480))|((x<630)&&(x>615))|((x>765)&&(x<780))|((x<930)&&(x>915))|((x>1065)&&(x<1080))){
                    contexte.drawImage(this.spriteBdroite2, x, y, null);
                }
                if (((x<45)&&(x>30))|((x>180)&&(x<195))|((x<345)&&(x>330))|((x>480)&&(x<495))|((x<645)&&(x>630))|((x>780)&&(x<795))|((x<945)&&(x>930))|((x>1080)&&(x<1095))){
                    contexte.drawImage(this.spriteBdroite3, x, y, null);
                }
                if (((x<60)&&(x>45))|((x>195)&&(x<210))|((x<360)&&(x>345))|((x>495)&&(x<510))|((x<660)&&(x>645))|((x>795)&&(x<810))|((x<960)&&(x>945))|((x>1095)&&(x<1110))){
                    contexte.drawImage(this.spriteBdroite4, x, y, null);
                }
                if (((x<75)&&(x>60))|((x>210)&&(x<225))|((x<375)&&(x>360))|((x>510)&&(x<525))|((x<675)&&(x>660))|((x>810)&&(x<825))|((x<975)&&(x>960))|((x>1110)&&(x<1125))){
                    contexte.drawImage(this.spriteBdroite5, x, y, null);
                }
                if (((x<90)&&(x>75))|((x>225)&&(x<240))|((x<390)&&(x>375))|((x>525)&&(x<540))|((x<690)&&(x>675))|((x>825)&&(x<840))|((x<990)&&(x>975))|((x>1125)&&(x<1140))){
                    contexte.drawImage(this.spriteBdroite6, x, y, null);
                }
                if (((x<105)&&(x>90))|((x>240)&&(x<255))|((x<405)&&(x>390))|((x>540)&&(x<555))|((x<705)&&(x>690))|((x>840)&&(x<855))|((x<1005)&&(x>990))|((x>1140)&&(x<1155))){
                    contexte.drawImage(this.spriteBdroite7, x, y, null);
                }
                if (((x<120)&&(x>105))|((x>255)&&(x<270))|((x<420)&&(x>405))|((x>555)&&(x<570))|((x<720)&&(x>705))|((x>855)&&(x<870))|((x<1020)&&(x>1005))|((x>1155)&&(x<1170))){
                    contexte.drawImage(this.spriteBdroite8, x, y, null);
                }
                if (((x<135)&&(x>120))|((x>270)&&(x<285))|((x<435)&&(x>420))|((x>570)&&(x<585))|((x<735)&&(x>720))|((x>870)&&(x<885))|((x<1035)&&(x>1020))|((x>1170)&&(x<1185))){
                    contexte.drawImage(this.spriteBdroite9, x, y, null);
                }
                if (((x<150)&&(x>135))|((x>285)&&(x<300))|((x<450)&&(x>435))|((x>585)&&(x<600))|((x<750)&&(x>735))|((x>885)&&(x<900))|((x<1050)&&(x>1035))|((x>1185)&&(x<1200))){
                    contexte.drawImage(this.spriteBdroite10, x, y, null);
                }
        }
        if (j1.getDirection()==1){    
                if (((y<15)&&(y>0))|((y>150)&&(y<165))|((y<315)&&(y>300))|((y>450)&&(y<465))|((y>600)&&(y<615))){
                    contexte.drawImage(this.spriteBbas1, x, y, null);
                }
                if (((y<30)&&(y>15))|((y>165)&&(y<180))|((y<330)&&(y>315))|((y>465)&&(y<480))|((y>615)&&(y<630))){
                    contexte.drawImage(this.spriteBbas2, x, y, null);
                }
                if (((y<45)&&(y>30))|((y>180)&&(y<195))|((y<345)&&(y>330))|((y>480)&&(y<495))|((y>630)&&(y<645))){
                    contexte.drawImage(this.spriteBbas3, x, y, null);
                }
                if (((y<60)&&(y>45))|((y>195)&&(y<210))|((y<360)&&(y>345))|((y>495)&&(y<510))|((y>645)&&(y<660))){
                    contexte.drawImage(this.spriteBbas4, x, y, null);
                }
                if (((y<75)&&(y>60))|((y>210)&&(y<225))|((y<375)&&(y>360))|((y>510)&&(y<525))|((y>660)&&(y<675))){
                    contexte.drawImage(this.spriteBbas5, x, y, null);
                }
                if (((y<90)&&(y>75))|((y>225)&&(y<240))|((y<390)&&(y>375))|((y>525)&&(y<540))|((y>675)&&(y<690))){
                    contexte.drawImage(this.spriteBbas6, x, y, null);
                }
                if (((y<105)&&(y>90))|((y>240)&&(y<255))|((y<405)&&(y>390))|((y>540)&&(y<555))|((y>690)&&(y<705))){
                    contexte.drawImage(this.spriteBbas7, x, y, null);
                }
                if (((y<120)&&(y>105))|((y>255)&&(y<270))|((y<420)&&(y>405))|((y>555)&&(y<570))|((y>705)&&(y<720))){
                    contexte.drawImage(this.spriteBbas8, x, y, null);
                }
                if (((y<135)&&(y>120))|((y>270)&&(y<285))|((y<435)&&(y>420))|((y>570)&&(y<585))|((y>720)&&(y<735))){
                    contexte.drawImage(this.spriteBbas9, x, y, null);
                }
                if (((y<150)&&(y>135))|((y>285)&&(y<300))|((y<450)&&(y>435))|((y>585)&&(y<600))|((y>735)&&(y<750))){
                    contexte.drawImage(this.spriteBbas10, x, y, null);
                }
        }
        if (j1.getDirection()==3){    
                if (((y<15)&&(y>0))|((y>150)&&(y<165))|((y<315)&&(y>300))|((y>450)&&(y<465))|((y>600)&&(y<615))){
                    contexte.drawImage(this.spriteBhaut1, x, y, null);
                }
                if (((y<30)&&(y>15))|((y>165)&&(y<180))|((y<330)&&(y>315))|((y>465)&&(y<480))|((y>615)&&(y<630))){
                    contexte.drawImage(this.spriteBhaut2, x, y, null);
                }
                if (((y<45)&&(y>30))|((y>180)&&(y<195))|((y<345)&&(y>330))|((y>480)&&(y<495))|((y>630)&&(y<645))){
                    contexte.drawImage(this.spriteBhaut3, x, y, null);
                }
                if (((y<60)&&(y>45))|((y>195)&&(y<210))|((y<360)&&(y>345))|((y>495)&&(y<510))|((y>645)&&(y<660))){
                    contexte.drawImage(this.spriteBhaut4, x, y, null);
                }
                if (((y<75)&&(y>60))|((y>210)&&(y<225))|((y<375)&&(y>360))|((y>510)&&(y<525))|((y>660)&&(y<675))){
                    contexte.drawImage(this.spriteBhaut5, x, y, null);
                }
                if (((y<90)&&(y>75))|((y>225)&&(y<240))|((y<390)&&(y>375))|((y>525)&&(y<540))|((y>675)&&(y<690))){
                    contexte.drawImage(this.spriteBhaut6, x, y, null);
                }
                if (((y<105)&&(y>90))|((y>240)&&(y<255))|((y<405)&&(y>390))|((y>540)&&(y<555))|((y>690)&&(y<705))){
                    contexte.drawImage(this.spriteBhaut7, x, y, null);
                }
                if (((y<120)&&(y>105))|((y>255)&&(y<270))|((y<420)&&(y>405))|((y>555)&&(y<570))|((y>705)&&(y<720))){
                    contexte.drawImage(this.spriteBhaut8, x, y, null);
                }
                if (((y<135)&&(y>120))|((y>270)&&(y<285))|((y<435)&&(y>420))|((y>570)&&(y<585))|((y>720)&&(y<735))){
                    contexte.drawImage(this.spriteBhaut9, x, y, null);
                }
                if (((y<150)&&(y>135))|((y>285)&&(y<300))|((y<450)&&(y>435))|((y>585)&&(y<600))|((y>735)&&(y<750))){
                    contexte.drawImage(this.spriteBhaut10, x, y, null);
                }
        }
        }
        if (id==3){
            if (j1.getDirection()==4){    
                if (((x<15)&&(x>0))|((x>150)&&(x<165))|((x<315)&&(x>300))|((x>450)&&(x<465))|((x<615)&&(x>600))|((x>750)&&(x<765))|((x<915)&&(x>900))|((x>1050)&&(x<1065))){
                    contexte.drawImage(this.spriteRgauche1, x, y, null);
                }
                if (((x<30)&&(x>15))|((x>165)&&(x<180))|((x<330)&&(x>315))|((x>465)&&(x<480))|((x<630)&&(x>615))|((x>765)&&(x<780))|((x<930)&&(x>915))|((x>1065)&&(x<1080))){
                    contexte.drawImage(this.spriteRgauche2, x, y, null);
                }
                if (((x<45)&&(x>30))|((x>180)&&(x<195))|((x<345)&&(x>330))|((x>480)&&(x<495))|((x<645)&&(x>630))|((x>780)&&(x<795))|((x<945)&&(x>930))|((x>1080)&&(x<1095))){
                    contexte.drawImage(this.spriteRgauche3, x, y, null);
                }
                if (((x<60)&&(x>45))|((x>195)&&(x<210))|((x<360)&&(x>345))|((x>495)&&(x<510))|((x<660)&&(x>645))|((x>795)&&(x<810))|((x<960)&&(x>945))|((x>1095)&&(x<1110))){
                    contexte.drawImage(this.spriteRgauche4, x, y, null);
                }
                if (((x<75)&&(x>60))|((x>210)&&(x<225))|((x<375)&&(x>360))|((x>510)&&(x<525))|((x<675)&&(x>660))|((x>810)&&(x<825))|((x<975)&&(x>960))|((x>1110)&&(x<1125))){
                    contexte.drawImage(this.spriteRgauche5, x, y, null);
                }
                if (((x<90)&&(x>75))|((x>225)&&(x<240))|((x<390)&&(x>375))|((x>525)&&(x<540))|((x<690)&&(x>675))|((x>825)&&(x<840))|((x<990)&&(x>975))|((x>1125)&&(x<1140))){
                    contexte.drawImage(this.spriteRgauche6, x, y, null);
                }
                if (((x<105)&&(x>90))|((x>240)&&(x<255))|((x<405)&&(x>390))|((x>540)&&(x<555))|((x<705)&&(x>690))|((x>840)&&(x<855))|((x<1005)&&(x>990))|((x>1140)&&(x<1155))){
                    contexte.drawImage(this.spriteRgauche7, x, y, null);
                }
                if (((x<120)&&(x>105))|((x>255)&&(x<270))|((x<420)&&(x>405))|((x>555)&&(x<570))|((x<720)&&(x>705))|((x>855)&&(x<870))|((x<1020)&&(x>1005))|((x>1155)&&(x<1170))){
                    contexte.drawImage(this.spriteRgauche8, x, y, null);
                }
                if (((x<135)&&(x>120))|((x>270)&&(x<285))|((x<435)&&(x>420))|((x>570)&&(x<585))|((x<735)&&(x>720))|((x>870)&&(x<885))|((x<1035)&&(x>1020))|((x>1170)&&(x<1185))){
                    contexte.drawImage(this.spriteRgauche9, x, y, null);
                }
                if (((x<150)&&(x>135))|((x>285)&&(x<300))|((x<450)&&(x>435))|((x>585)&&(x<600))|((x<750)&&(x>735))|((x>885)&&(x<900))|((x<1050)&&(x>1035))|((x>1185)&&(x<1200))){
                    contexte.drawImage(this.spriteRgauche10, x, y, null);
                }
        
        }
        
        if (j1.getDirection()==2){    
                if (((x<15)&&(x>0))|((x>150)&&(x<165))|((x<315)&&(x>300))|((x>450)&&(x<465))|((x<615)&&(x>600))|((x>750)&&(x<765))|((x<915)&&(x>900))|((x>1050)&&(x<1065))){
                    contexte.drawImage(this.spriteRdroite1, x, y, null);
                }
                if (((x<30)&&(x>15))|((x>165)&&(x<180))|((x<330)&&(x>315))|((x>465)&&(x<480))|((x<630)&&(x>615))|((x>765)&&(x<780))|((x<930)&&(x>915))|((x>1065)&&(x<1080))){
                    contexte.drawImage(this.spriteRdroite2, x, y, null);
                }
                if (((x<45)&&(x>30))|((x>180)&&(x<195))|((x<345)&&(x>330))|((x>480)&&(x<495))|((x<645)&&(x>630))|((x>780)&&(x<795))|((x<945)&&(x>930))|((x>1080)&&(x<1095))){
                    contexte.drawImage(this.spriteRdroite3, x, y, null);
                }
                if (((x<60)&&(x>45))|((x>195)&&(x<210))|((x<360)&&(x>345))|((x>495)&&(x<510))|((x<660)&&(x>645))|((x>795)&&(x<810))|((x<960)&&(x>945))|((x>1095)&&(x<1110))){
                    contexte.drawImage(this.spriteRdroite4, x, y, null);
                }
                if (((x<75)&&(x>60))|((x>210)&&(x<225))|((x<375)&&(x>360))|((x>510)&&(x<525))|((x<675)&&(x>660))|((x>810)&&(x<825))|((x<975)&&(x>960))|((x>1110)&&(x<1125))){
                    contexte.drawImage(this.spriteRdroite5, x, y, null);
                }
                if (((x<90)&&(x>75))|((x>225)&&(x<240))|((x<390)&&(x>375))|((x>525)&&(x<540))|((x<690)&&(x>675))|((x>825)&&(x<840))|((x<990)&&(x>975))|((x>1125)&&(x<1140))){
                    contexte.drawImage(this.spriteRdroite6, x, y, null);
                }
                if (((x<105)&&(x>90))|((x>240)&&(x<255))|((x<405)&&(x>390))|((x>540)&&(x<555))|((x<705)&&(x>690))|((x>840)&&(x<855))|((x<1005)&&(x>990))|((x>1140)&&(x<1155))){
                    contexte.drawImage(this.spriteRdroite7, x, y, null);
                }
                if (((x<120)&&(x>105))|((x>255)&&(x<270))|((x<420)&&(x>405))|((x>555)&&(x<570))|((x<720)&&(x>705))|((x>855)&&(x<870))|((x<1020)&&(x>1005))|((x>1155)&&(x<1170))){
                    contexte.drawImage(this.spriteRdroite8, x, y, null);
                }
                if (((x<135)&&(x>120))|((x>270)&&(x<285))|((x<435)&&(x>420))|((x>570)&&(x<585))|((x<735)&&(x>720))|((x>870)&&(x<885))|((x<1035)&&(x>1020))|((x>1170)&&(x<1185))){
                    contexte.drawImage(this.spriteRdroite9, x, y, null);
                }
                if (((x<150)&&(x>135))|((x>285)&&(x<300))|((x<450)&&(x>435))|((x>585)&&(x<600))|((x<750)&&(x>735))|((x>885)&&(x<900))|((x<1050)&&(x>1035))|((x>1185)&&(x<1200))){
                    contexte.drawImage(this.spriteRdroite10, x, y, null);
                }
        }
        if (j1.getDirection()==1){    
                if (((y<15)&&(y>0))|((y>150)&&(y<165))|((y<315)&&(y>300))|((y>450)&&(y<465))|((y>600)&&(y<615))){
                    contexte.drawImage(this.spriteRbas1, x, y, null);
                }
                if (((y<30)&&(y>15))|((y>165)&&(y<180))|((y<330)&&(y>315))|((y>465)&&(y<480))|((y>615)&&(y<630))){
                    contexte.drawImage(this.spriteRbas2, x, y, null);
                }
                if (((y<45)&&(y>30))|((y>180)&&(y<195))|((y<345)&&(y>330))|((y>480)&&(y<495))|((y>630)&&(y<645))){
                    contexte.drawImage(this.spriteRbas3, x, y, null);
                }
                if (((y<60)&&(y>45))|((y>195)&&(y<210))|((y<360)&&(y>345))|((y>495)&&(y<510))|((y>645)&&(y<660))){
                    contexte.drawImage(this.spriteRbas4, x, y, null);
                }
                if (((y<75)&&(y>60))|((y>210)&&(y<225))|((y<375)&&(y>360))|((y>510)&&(y<525))|((y>660)&&(y<675))){
                    contexte.drawImage(this.spriteRbas5, x, y, null);
                }
                if (((y<90)&&(y>75))|((y>225)&&(y<240))|((y<390)&&(y>375))|((y>525)&&(y<540))|((y>675)&&(y<690))){
                    contexte.drawImage(this.spriteRbas6, x, y, null);
                }
                if (((y<105)&&(y>90))|((y>240)&&(y<255))|((y<405)&&(y>390))|((y>540)&&(y<555))|((y>690)&&(y<705))){
                    contexte.drawImage(this.spriteRbas7, x, y, null);
                }
                if (((y<120)&&(y>105))|((y>255)&&(y<270))|((y<420)&&(y>405))|((y>555)&&(y<570))|((y>705)&&(y<720))){
                    contexte.drawImage(this.spriteRbas8, x, y, null);
                }
                if (((y<135)&&(y>120))|((y>270)&&(y<285))|((y<435)&&(y>420))|((y>570)&&(y<585))|((y>720)&&(y<735))){
                    contexte.drawImage(this.spriteRbas9, x, y, null);
                }
                if (((y<150)&&(y>135))|((y>285)&&(y<300))|((y<450)&&(y>435))|((y>585)&&(y<600))|((y>735)&&(y<750))){
                    contexte.drawImage(this.spriteRbas10, x, y, null);
                }
        }
        if (j1.getDirection()==3){    
                if (((y<15)&&(y>0))|((y>150)&&(y<165))|((y<315)&&(y>300))|((y>450)&&(y<465))|((y>600)&&(y<615))){
                    contexte.drawImage(this.spriteRhaut1, x, y, null);
                }
                if (((y<30)&&(y>15))|((y>165)&&(y<180))|((y<330)&&(y>315))|((y>465)&&(y<480))|((y>615)&&(y<630))){
                    contexte.drawImage(this.spriteRhaut2, x, y, null);
                }
                if (((y<45)&&(y>30))|((y>180)&&(y<195))|((y<345)&&(y>330))|((y>480)&&(y<495))|((y>630)&&(y<645))){
                    contexte.drawImage(this.spriteRhaut3, x, y, null);
                }
                if (((y<60)&&(y>45))|((y>195)&&(y<210))|((y<360)&&(y>345))|((y>495)&&(y<510))|((y>645)&&(y<660))){
                    contexte.drawImage(this.spriteRhaut4, x, y, null);
                }
                if (((y<75)&&(y>60))|((y>210)&&(y<225))|((y<375)&&(y>360))|((y>510)&&(y<525))|((y>660)&&(y<675))){
                    contexte.drawImage(this.spriteRhaut5, x, y, null);
                }
                if (((y<90)&&(y>75))|((y>225)&&(y<240))|((y<390)&&(y>375))|((y>525)&&(y<540))|((y>675)&&(y<690))){
                    contexte.drawImage(this.spriteRhaut6, x, y, null);
                }
                if (((y<105)&&(y>90))|((y>240)&&(y<255))|((y<405)&&(y>390))|((y>540)&&(y<555))|((y>690)&&(y<705))){
                    contexte.drawImage(this.spriteRhaut7, x, y, null);
                }
                if (((y<120)&&(y>105))|((y>255)&&(y<270))|((y<420)&&(y>405))|((y>555)&&(y<570))|((y>705)&&(y<720))){
                    contexte.drawImage(this.spriteRhaut8, x, y, null);
                }
                if (((y<135)&&(y>120))|((y>270)&&(y<285))|((y<435)&&(y>420))|((y>570)&&(y<585))|((y>720)&&(y<735))){
                    contexte.drawImage(this.spriteRhaut9, x, y, null);
                }
                if (((y<150)&&(y>135))|((y>285)&&(y<300))|((y<450)&&(y>435))|((y>585)&&(y<600))|((y>735)&&(y<750))){
                    contexte.drawImage(this.spriteRhaut10, x, y, null);
                }
        }
        }
        if (id==4){
            if (j1.getDirection()==4){    
                if (((x<15)&&(x>0))|((x>150)&&(x<165))|((x<315)&&(x>300))|((x>450)&&(x<465))|((x<615)&&(x>600))|((x>750)&&(x<765))|((x<915)&&(x>900))|((x>1050)&&(x<1065))){
                    contexte.drawImage(this.spriteVgauche1, x, y, null);
                }
                if (((x<30)&&(x>15))|((x>165)&&(x<180))|((x<330)&&(x>315))|((x>465)&&(x<480))|((x<630)&&(x>615))|((x>765)&&(x<780))|((x<930)&&(x>915))|((x>1065)&&(x<1080))){
                    contexte.drawImage(this.spriteVgauche2, x, y, null);
                }
                if (((x<45)&&(x>30))|((x>180)&&(x<195))|((x<345)&&(x>330))|((x>480)&&(x<495))|((x<645)&&(x>630))|((x>780)&&(x<795))|((x<945)&&(x>930))|((x>1080)&&(x<1095))){
                    contexte.drawImage(this.spriteVgauche3, x, y, null);
                }
                if (((x<60)&&(x>45))|((x>195)&&(x<210))|((x<360)&&(x>345))|((x>495)&&(x<510))|((x<660)&&(x>645))|((x>795)&&(x<810))|((x<960)&&(x>945))|((x>1095)&&(x<1110))){
                    contexte.drawImage(this.spriteVgauche4, x, y, null);
                }
                if (((x<75)&&(x>60))|((x>210)&&(x<225))|((x<375)&&(x>360))|((x>510)&&(x<525))|((x<675)&&(x>660))|((x>810)&&(x<825))|((x<975)&&(x>960))|((x>1110)&&(x<1125))){
                    contexte.drawImage(this.spriteVgauche5, x, y, null);
                }
                if (((x<90)&&(x>75))|((x>225)&&(x<240))|((x<390)&&(x>375))|((x>525)&&(x<540))|((x<690)&&(x>675))|((x>825)&&(x<840))|((x<990)&&(x>975))|((x>1125)&&(x<1140))){
                    contexte.drawImage(this.spriteVgauche6, x, y, null);
                }
                if (((x<105)&&(x>90))|((x>240)&&(x<255))|((x<405)&&(x>390))|((x>540)&&(x<555))|((x<705)&&(x>690))|((x>840)&&(x<855))|((x<1005)&&(x>990))|((x>1140)&&(x<1155))){
                    contexte.drawImage(this.spriteVgauche7, x, y, null);
                }
                if (((x<120)&&(x>105))|((x>255)&&(x<270))|((x<420)&&(x>405))|((x>555)&&(x<570))|((x<720)&&(x>705))|((x>855)&&(x<870))|((x<1020)&&(x>1005))|((x>1155)&&(x<1170))){
                    contexte.drawImage(this.spriteVgauche8, x, y, null);
                }
                if (((x<135)&&(x>120))|((x>270)&&(x<285))|((x<435)&&(x>420))|((x>570)&&(x<585))|((x<735)&&(x>720))|((x>870)&&(x<885))|((x<1035)&&(x>1020))|((x>1170)&&(x<1185))){
                    contexte.drawImage(this.spriteVgauche9, x, y, null);
                }
                if (((x<150)&&(x>135))|((x>285)&&(x<300))|((x<450)&&(x>435))|((x>585)&&(x<600))|((x<750)&&(x>735))|((x>885)&&(x<900))|((x<1050)&&(x>1035))|((x>1185)&&(x<1200))){
                    contexte.drawImage(this.spriteVgauche10, x, y, null);
                }
        
        }
        
        if (j1.getDirection()==2){    
                if (((x<15)&&(x>0))|((x>150)&&(x<165))|((x<315)&&(x>300))|((x>450)&&(x<465))|((x<615)&&(x>600))|((x>750)&&(x<765))|((x<915)&&(x>900))|((x>1050)&&(x<1065))){
                    contexte.drawImage(this.spriteVdroite1, x, y, null);
                }
                if (((x<30)&&(x>15))|((x>165)&&(x<180))|((x<330)&&(x>315))|((x>465)&&(x<480))|((x<630)&&(x>615))|((x>765)&&(x<780))|((x<930)&&(x>915))|((x>1065)&&(x<1080))){
                    contexte.drawImage(this.spriteVdroite2, x, y, null);
                }
                if (((x<45)&&(x>30))|((x>180)&&(x<195))|((x<345)&&(x>330))|((x>480)&&(x<495))|((x<645)&&(x>630))|((x>780)&&(x<795))|((x<945)&&(x>930))|((x>1080)&&(x<1095))){
                    contexte.drawImage(this.spriteVdroite3, x, y, null);
                }
                if (((x<60)&&(x>45))|((x>195)&&(x<210))|((x<360)&&(x>345))|((x>495)&&(x<510))|((x<660)&&(x>645))|((x>795)&&(x<810))|((x<960)&&(x>945))|((x>1095)&&(x<1110))){
                    contexte.drawImage(this.spriteVdroite4, x, y, null);
                }
                if (((x<75)&&(x>60))|((x>210)&&(x<225))|((x<375)&&(x>360))|((x>510)&&(x<525))|((x<675)&&(x>660))|((x>810)&&(x<825))|((x<975)&&(x>960))|((x>1110)&&(x<1125))){
                    contexte.drawImage(this.spriteVdroite5, x, y, null);
                }
                if (((x<90)&&(x>75))|((x>225)&&(x<240))|((x<390)&&(x>375))|((x>525)&&(x<540))|((x<690)&&(x>675))|((x>825)&&(x<840))|((x<990)&&(x>975))|((x>1125)&&(x<1140))){
                    contexte.drawImage(this.spriteVdroite6, x, y, null);
                }
                if (((x<105)&&(x>90))|((x>240)&&(x<255))|((x<405)&&(x>390))|((x>540)&&(x<555))|((x<705)&&(x>690))|((x>840)&&(x<855))|((x<1005)&&(x>990))|((x>1140)&&(x<1155))){
                    contexte.drawImage(this.spriteVdroite7, x, y, null);
                }
                if (((x<120)&&(x>105))|((x>255)&&(x<270))|((x<420)&&(x>405))|((x>555)&&(x<570))|((x<720)&&(x>705))|((x>855)&&(x<870))|((x<1020)&&(x>1005))|((x>1155)&&(x<1170))){
                    contexte.drawImage(this.spriteVdroite8, x, y, null);
                }
                if (((x<135)&&(x>120))|((x>270)&&(x<285))|((x<435)&&(x>420))|((x>570)&&(x<585))|((x<735)&&(x>720))|((x>870)&&(x<885))|((x<1035)&&(x>1020))|((x>1170)&&(x<1185))){
                    contexte.drawImage(this.spriteVdroite9, x, y, null);
                }
                if (((x<150)&&(x>135))|((x>285)&&(x<300))|((x<450)&&(x>435))|((x>585)&&(x<600))|((x<750)&&(x>735))|((x>885)&&(x<900))|((x<1050)&&(x>1035))|((x>1185)&&(x<1200))){
                    contexte.drawImage(this.spriteVdroite10, x, y, null);
                }
        }
        if (j1.getDirection()==1){    
                if (((y<15)&&(y>0))|((y>150)&&(y<165))|((y<315)&&(y>300))|((y>450)&&(y<465))|((y>600)&&(y<615))){
                    contexte.drawImage(this.spriteVbas1, x, y, null);
                }
                if (((y<30)&&(y>15))|((y>165)&&(y<180))|((y<330)&&(y>315))|((y>465)&&(y<480))|((y>615)&&(y<630))){
                    contexte.drawImage(this.spriteVbas2, x, y, null);
                }
                if (((y<45)&&(y>30))|((y>180)&&(y<195))|((y<345)&&(y>330))|((y>480)&&(y<495))|((y>630)&&(y<645))){
                    contexte.drawImage(this.spriteVbas3, x, y, null);
                }
                if (((y<60)&&(y>45))|((y>195)&&(y<210))|((y<360)&&(y>345))|((y>495)&&(y<510))|((y>645)&&(y<660))){
                    contexte.drawImage(this.spriteVbas4, x, y, null);
                }
                if (((y<75)&&(y>60))|((y>210)&&(y<225))|((y<375)&&(y>360))|((y>510)&&(y<525))|((y>660)&&(y<675))){
                    contexte.drawImage(this.spriteVbas5, x, y, null);
                }
                if (((y<90)&&(y>75))|((y>225)&&(y<240))|((y<390)&&(y>375))|((y>525)&&(y<540))|((y>675)&&(y<690))){
                    contexte.drawImage(this.spriteVbas6, x, y, null);
                }
                if (((y<105)&&(y>90))|((y>240)&&(y<255))|((y<405)&&(y>390))|((y>540)&&(y<555))|((y>690)&&(y<705))){
                    contexte.drawImage(this.spriteVbas7, x, y, null);
                }
                if (((y<120)&&(y>105))|((y>255)&&(y<270))|((y<420)&&(y>405))|((y>555)&&(y<570))|((y>705)&&(y<720))){
                    contexte.drawImage(this.spriteVbas8, x, y, null);
                }
                if (((y<135)&&(y>120))|((y>270)&&(y<285))|((y<435)&&(y>420))|((y>570)&&(y<585))|((y>720)&&(y<735))){
                    contexte.drawImage(this.spriteVbas9, x, y, null);
                }
                if (((y<150)&&(y>135))|((y>285)&&(y<300))|((y<450)&&(y>435))|((y>585)&&(y<600))|((y>735)&&(y<750))){
                    contexte.drawImage(this.spriteVbas10, x, y, null);
                }
        }
        if (j1.getDirection()==3){    
                if (((y<15)&&(y>0))|((y>150)&&(y<165))|((y<315)&&(y>300))|((y>450)&&(y<465))|((y>600)&&(y<615))){
                    contexte.drawImage(this.spriteVhaut1, x, y, null);
                }
                if (((y<30)&&(y>15))|((y>165)&&(y<180))|((y<330)&&(y>315))|((y>465)&&(y<480))|((y>615)&&(y<630))){
                    contexte.drawImage(this.spriteVhaut2, x, y, null);
                }
                if (((y<45)&&(y>30))|((y>180)&&(y<195))|((y<345)&&(y>330))|((y>480)&&(y<495))|((y>630)&&(y<645))){
                    contexte.drawImage(this.spriteVhaut3, x, y, null);
                }
                if (((y<60)&&(y>45))|((y>195)&&(y<210))|((y<360)&&(y>345))|((y>495)&&(y<510))|((y>645)&&(y<660))){
                    contexte.drawImage(this.spriteVhaut4, x, y, null);
                }
                if (((y<75)&&(y>60))|((y>210)&&(y<225))|((y<375)&&(y>360))|((y>510)&&(y<525))|((y>660)&&(y<675))){
                    contexte.drawImage(this.spriteVhaut5, x, y, null);
                }
                if (((y<90)&&(y>75))|((y>225)&&(y<240))|((y<390)&&(y>375))|((y>525)&&(y<540))|((y>675)&&(y<690))){
                    contexte.drawImage(this.spriteVhaut6, x, y, null);
                }
                if (((y<105)&&(y>90))|((y>240)&&(y<255))|((y<405)&&(y>390))|((y>540)&&(y<555))|((y>690)&&(y<705))){
                    contexte.drawImage(this.spriteVhaut7, x, y, null);
                }
                if (((y<120)&&(y>105))|((y>255)&&(y<270))|((y<420)&&(y>405))|((y>555)&&(y<570))|((y>705)&&(y<720))){
                    contexte.drawImage(this.spriteVhaut8, x, y, null);
                }
                if (((y<135)&&(y>120))|((y>270)&&(y<285))|((y<435)&&(y>420))|((y>570)&&(y<585))|((y>720)&&(y<735))){
                    contexte.drawImage(this.spriteVhaut9, x, y, null);
                }
                if (((y<150)&&(y>135))|((y>285)&&(y<300))|((y<450)&&(y>435))|((y>585)&&(y<600))|((y>735)&&(y<750))){
                    contexte.drawImage(this.spriteVhaut10, x, y, null);
                }
        }
        }
     }


}

    

