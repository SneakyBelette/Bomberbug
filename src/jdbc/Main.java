/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author pdolle
 */
public class Main extends javax.swing.JFrame {
    
    public static int ID;
    public static Joueur Moi=new Joueur(0,"erreur",300,300,1,"couteau",1,1,1);
    public static BaseJoueur Adversaires = new BaseJoueur();
    private BufferedImage buffer;
    private Graphics2D contexteBuffer;
    public static ListeMur Murs=new ListeMur();
    public static ListeProjectiles Projectiles = new ListeProjectiles();
    public static ListeProjectiles ProjectilesAAjouter = new ListeProjectiles();
    private Jeu jeu;
    public static int largeurPersos=25;
    public static int hauteurPersos=35;
    private Projectile Proj;
    public static Connection connexion;
    public static int largeurbonus=30;
    
    /**
     * Creates new form Main
     */
     
    public void paint(Graphics g){
        BufferedImage fond = null;
        try {
            fond = ImageIO.read(new File("fond.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        g.drawImage(fond, 0, 0,this.getSize().width,this.getSize().height, null);
        System.out.println("image");
    }
    
    
    Runnable code = new Runnable() { 
  
        @Override 
        public void run() {
            int i = 1;
            
            while(i==1){
                
            //Début de la boucle infini
            
                //>>> Moi.Agir(); (à créer par équipe Jeu)
                Moi.Deplacer();
                Moi.Push();
                Adversaires.charger();
                
                Projectiles.UpdateProjectiles(Moi.getId());
                
                //if (Moi.getId ==2){
                //    Bonus.Generer();
                //    Bonus.Push();         (à créer par équipe SQL)
                //}
                
                jeu.Update(Moi);
                jeu.Afficher(contexteBuffer);
                jLabel1.repaint();
                
                MAJHUD();
                MAJUHDAdversaires();
                MAJVieAdv1();
                MAJVieAdv2();
                MAJVieAdv3();
                MAJVieMoi();
                MAJArmeMoi();
                MAJArmeAdv1();
                MAJArmeAdv2();
                MAJArmeAdv3();
                MAJTofAdv1();
                MAJTofAdv2();
                MAJTofAdv3();
                MAJTofAdv4();
            
            
            //fin de boucle infinie
            
            try {
            
                Thread.sleep(10);
            } catch (Exception e) {
            e.printStackTrace();
            }

            }
 
        } 
    }; 
    
    public Main(String args[]) {
        // initialisation
        System.out.println("Main lancé! Argument reçu: ID ="+args[0]);
        ID = parseInt(args[0]);
        Moi.setPseudo(args[1]);
        Moi.setId(ID);
        
        
        
        Moi.Pull(ID);
        Adversaires.InitBaseAdversaires(ID);
        
        
        
        
        initComponents();
        Thread tache = new Thread(code);
        this.jeu = new Jeu(Moi);

        // Creation du buffer pour l'affichage du jeu et recuperation du contexte graphique
        this.buffer = new BufferedImage(this.jLabel1.getWidth(), this.jLabel1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        jLabel1.setIcon(new ImageIcon(this.buffer));
        this.contexteBuffer = this.buffer.createGraphics();
        
        
        tache.start(); // lancement de la boucle infinie
        
        Murs.add(new Mur(0,0,1000,30));
        Murs.add(new Mur(0,0,30,666));
        Murs.add(new Mur(970,0,1000,666));
        Murs.add(new Mur(0,636,1000,666));
        
        
        
        
    }
        public void MAJHUD(){
        //afficher pseudo joueur Moi
       
        jTextField1.setText(Moi.getPseudo());
    }
    public void MAJUHDAdversaires(){
        jTextField2.setText(Adversaires.joueur1.getPseudo());
        jTextField3.setText(Adversaires.joueur2.getPseudo());
        jTextField4.setText(Adversaires.joueur3.getPseudo());
    }

    public void MAJVieAdv1(){

        ImageIcon Vie = new ImageIcon(Adversaires.joueur1.getPv()+"coeurs.png");
        
        jLabel2.setIcon(Vie);  
    }
    public void MAJVieAdv2(){
        ImageIcon Vie = new ImageIcon(Adversaires.joueur2.getPv()+"coeurs.png");

        jLabel3.setIcon(Vie);  
    }
    public void MAJVieAdv3(){
        ImageIcon Vie = new ImageIcon(Adversaires.joueur3.getPv()+"coeurs.png");

        jLabel4.setIcon(Vie);  
    }
    public void MAJVieMoi(){
        ImageIcon Vie = new ImageIcon(Moi.getPv()+"coeurs.png");

        jLabel5.setIcon(Vie);  
    }
    public void MAJArmeMoi(){
        ImageIcon Arme = new ImageIcon("couteaugrand.png");
        jLabel6.setIcon(Arme);
    }
    
    public void MAJArmeAdv1(){
                ImageIcon Arme = new ImageIcon("couteau.png");
                jLabel7.setIcon(Arme);
    }
     public void MAJArmeAdv2(){
                ImageIcon Arme = new ImageIcon("couteau.png");
                jLabel8.setIcon(Arme);
    }
      public void MAJArmeAdv3(){
                ImageIcon Arme = new ImageIcon("couteau.png");
                jLabel9.setIcon(Arme);
    }
      public void MAJTofAdv1(){
           ImageIcon Tof = new ImageIcon(Moi.getId()+"Zelda.png");
        
        jLabel10.setIcon(Tof);
      }
      public void MAJTofAdv2(){
           ImageIcon Tof = new ImageIcon(Adversaires.joueur1.getId()+"Zelda.png");
        
        jLabel11.setIcon(Tof);
      }
      public void MAJTofAdv3(){
           ImageIcon Tof = new ImageIcon(Adversaires.joueur2.getId()+"Zelda.png");
        
        jLabel12.setIcon(Tof);
      }
      public void MAJTofAdv4(){
           ImageIcon Tof = new ImageIcon(Adversaires.joueur3.getId()+"Zelda.png");
        
        jLabel13.setIcon(Tof);
      }
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jLabel1.setText("jLabel1");
        jLabel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel1KeyPressed(evt);
            }
        });

        jTextField1.setText("jTextField1");
        jTextField1.setEnabled(false);

        jTextField2.setText("jTextField2");
        jTextField2.setEnabled(false);

        jTextField3.setText("jTextField3");
        jTextField3.setEnabled(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setText("jTextField4");
        jTextField4.setEnabled(false);

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jLabel10.setText("jLabel10");

        jLabel11.setText("jLabel10");

        jLabel12.setText("jLabel10");

        jLabel13.setText("jLabel10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2)
                    .addComponent(jTextField3)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 113, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)))
                        .addGap(140, 140, 140))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(5, 5, 5))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(14, 14, 14)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel1KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLabel1KeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:

        if(evt.getKeyCode() == evt.VK_D){
            Moi.setDeplacerDroite(true);
        }
        if(evt.getKeyCode() == evt.VK_Q){
            Moi.setDeplacerGauche(true);
        }
        if(evt.getKeyCode() == evt.VK_Z){
            Moi.setDeplacerHaut(true);
        }
        if(evt.getKeyCode() == evt.VK_S){
            Moi.setDeplacerBas(true);
        }
        
        
        if(evt.getKeyCode() == evt.VK_RIGHT){
            Moi.setDirection(2);
            this.ProjectilesAAjouter.addAll(Moi.Attaque(Moi.getArme(), System.currentTimeMillis()));
        }


        if(evt.getKeyCode() == evt.VK_LEFT){
            Moi.setDirection(4);
            this.ProjectilesAAjouter.addAll(Moi.Attaque(Moi.getArme(), System.currentTimeMillis()));            
        }
        
        
        if(evt.getKeyCode() == evt.VK_UP){
            Moi.setDirection(3);
            this.ProjectilesAAjouter.addAll(Moi.Attaque(Moi.getArme(), System.currentTimeMillis()));
        }
        
        
        if(evt.getKeyCode() == evt.VK_DOWN){
            Moi.setDirection(1);
            this.ProjectilesAAjouter.addAll(Moi.Attaque(Moi.getArme(), System.currentTimeMillis()));
        }
        
        if(evt.getKeyCode() == evt.VK_SPACE){
           Moi.setJeRamasse(true);
            
        }
         
    }//GEN-LAST:event_formKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Moi.setEtat(-1);
    }//GEN-LAST:event_formWindowClosing

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == evt.VK_D){
            Moi.setDeplacerDroite(false);
        }
        if(evt.getKeyCode() == evt.VK_Q){
            Moi.setDeplacerGauche(false);
        }
        if(evt.getKeyCode() == evt.VK_Z){
            Moi.setDeplacerHaut(false);
        }
        if(evt.getKeyCode() == evt.VK_S){
            Moi.setDeplacerBas(false);
        }
        
        if(evt.getKeyCode() == evt.VK_SPACE){
            Moi.setJeRamasse(false);
        }
        
    }//GEN-LAST:event_formKeyReleased

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main(args).setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
