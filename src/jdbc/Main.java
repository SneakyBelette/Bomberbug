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
    public static int largeurPersos=20;
    public static int hauteurPersos=30;
    private Projectile Proj;
    public static Connection connexion;
    public static ListeBonus ListeDesBonus = new ListeBonus();
    
    /**
     * Creates new form Main
     */
     
    public void paint(Graphics g){
        BufferedImage fond = null;
        try {
            fond = ImageIO.read(new File("fond3.jpg"));
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
            
                
                Moi.Deplacer();
                Moi.Push();
                Adversaires.charger();
                
               
                Projectiles.UpdateProjectiles(Moi.getId());
                
                ListeDesBonus.ResoudreBonus(Moi);
                ListeDesBonus.UpdateBonus();
                
                jeu.Update(Moi);
                jeu.Afficher(contexteBuffer);
                jLabel1.repaint();
                
               /* jTextField1.requestFocus();
                jTextField2.requestFocus();
                jTextField3.requestFocus();
                jTextField4.requestFocus();
        */
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
                MAJMunitionMoi();
                MAJMunitionAdv1();
                MAJMunitionAdv2();
                MAJMunitionAdv3();
            
            
            //fin de boucle infinie
            
            try {
            
                Thread.sleep(40);
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
        
        
         // lancement de la boucle infinie
        
        Murs.add(new Mur(0,0,975,25));
        Murs.add(new Mur(975,0,1000,666));
        Murs.add(new Mur(0,636,975,666));
        Murs.add(new Mur(0,25,25,641));
        Murs.add(new Mur(87,77,139,127));
        Murs.add(new Mur(244,90,415,108));
        Murs.add(new Mur(244,90,264,140));
        Murs.add(new Mur(212,123,264,140));
        Murs.add(new Mur(212,123,231,172));
        Murs.add(new Mur(179,155,231,172));
        Murs.add(new Mur(179,155,199,205));
        Murs.add(new Mur(146,189,199,205));
        Murs.add(new Mur(146,189,166,238));
        Murs.add(new Mur(114,220,166,238));
        Murs.add(new Mur(114,220,134,289));
        Murs.add(new Mur(83,271,134,289));
        Murs.add(new Mur(83,271,102,339));
        Murs.add(new Mur(164,370,195,389));
        Murs.add(new Mur(164,390,216,406));
        Murs.add(new Mur(83,465,206,484));
        Murs.add(new Mur(187,485,205,591));
        Murs.add(new Mur(84,536,135,590));
        Murs.add(new Mur(274,458,293,591));
        Murs.add(new Mur(274,458,524,476));
        Murs.add(new Mur(433,539,689,557));
        Murs.add(new Mur(610,460,888,475));
        Murs.add(new Mur(764,539,887,556));
        Murs.add(new Mur(870,539,887,640));
        Murs.add(new Mur(869,385,888,475));
        Murs.add(new Mur(869,237,888,320));
        Murs.add(new Mur(869,237,975,256));
        Murs.add(new Mur(753,237,772,389));
        Murs.add(new Mur(650,344,670,395));
        Murs.add(new Mur(310,376,670,395));
        Murs.add(new Mur(230,267,375,283));
        Murs.add(new Mur(230,267,250,317));
        Murs.add(new Mur(320,180,670,198));
        Murs.add(new Mur(507,85,527,180));
        Murs.add(new Mur(603,25,623,118));
        Murs.add(new Mur(693,78,797,95));
        Murs.add(new Mur(778,78,797,180));
        Murs.add(new Mur(778,153,904,180));
        Murs.add(new Mur(898,91,976,110));
        
        
       
        for(Mur mur : Murs.getListeMur()){
            mur.setX1(mur.getX1()-10);
            mur.setX2(mur.getX2()-10);
            mur.setY1(mur.getY1()-5);
            mur.setY2(mur.getY2()-5);
        }
        
        PlaySound fond = new PlaySound("truc.wav");

        
        tache.start();
        
        
    }
        public void MAJHUD(){
        //afficher pseudo joueur Moi
        
        jTextField2.setText(Moi.getPseudo());
    }
    public void MAJUHDAdversaires(){
        
        jTextField3.setText(Adversaires.joueur2.getPseudo());
        jTextField4.setText(Adversaires.joueur3.getPseudo());
        jTextField1.setText(Adversaires.joueur1.getPseudo());
        
    }

    public void MAJVieAdv1(){

        ImageIcon Vie = new ImageIcon(Adversaires.joueur1.getPv()+"coeurs.png");
        
        jLabel3.setIcon(Vie);  
    }
    public void MAJVieAdv2(){
        ImageIcon Vie = new ImageIcon(Adversaires.joueur2.getPv()+"coeurs.png");

        jLabel5.setIcon(Vie);  
    }
    public void MAJVieAdv3(){
        ImageIcon Vie = new ImageIcon(Adversaires.joueur3.getPv()+"coeurs.png");

        jLabel4.setIcon(Vie);  
    }
    public void MAJVieMoi(){
        ImageIcon Vie = new ImageIcon(Moi.getPv()+"coeurs.png");

        jLabel2.setIcon(Vie);  
    }
    public void MAJArmeMoi(){
        if(Moi.getArme().equals("grenade")){
        ImageIcon Arme = new ImageIcon("bombenoire.png");
        jLabel6.setIcon(Arme);
        }
        if(Moi.getArme().equals("couteau")){
        ImageIcon Arme = new ImageIcon("couteaugrand.png");
        jLabel6.setIcon(Arme);
        }
        if(Moi.getArme().equals("fleche")){
        ImageIcon Arme = new ImageIcon("arrowgrand.png");
        jLabel6.setIcon(Arme);
        }
        
    }
        
    
    public void MAJArmeAdv1(){
        if(Adversaires.joueur1.getArme().equals("couteau")){
        ImageIcon Arme = new ImageIcon("couteau.png");
        jLabel7.setIcon(Arme);
        }
        if(Adversaires.joueur1.getArme().equals("fleche")){
        ImageIcon Arme = new ImageIcon("arrowgrand.png");
        jLabel7.setIcon(Arme);
        }
        if(Adversaires.joueur1.getArme().equals("grenade")){
        ImageIcon Arme = new ImageIcon("bombeAdv.png");
        jLabel7.setIcon(Arme);
        }
    }
    public void MAJArmeAdv2(){
        if(Adversaires.joueur2.getArme().equals("couteau")){
        ImageIcon Arme = new ImageIcon("couteau.png");
        jLabel8.setIcon(Arme);
        }
        if(Adversaires.joueur2.getArme().equals("fleche")){
        ImageIcon Arme = new ImageIcon("arrowgrand.png");
        jLabel8.setIcon(Arme);
        }
        if(Adversaires.joueur2.getArme().equals("grenade")){
        ImageIcon Arme = new ImageIcon("bombeAdv.png");
        jLabel8.setIcon(Arme);
        }
    }
    public void MAJArmeAdv3(){
        if(Adversaires.joueur3.getArme().equals("couteau")){
        ImageIcon Arme = new ImageIcon("couteau.png");
        jLabel9.setIcon(Arme);
        }
        if(Adversaires.joueur3.getArme().equals("fleche")){
        ImageIcon Arme = new ImageIcon("arrowgrand.png");
        jLabel9.setIcon(Arme);
        }
        if(Adversaires.joueur3.getArme().equals("grenade")){
        ImageIcon Arme = new ImageIcon("bombeAdv.png");
        jLabel9.setIcon(Arme);
        }
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
      public void MAJMunitionMoi(){
          
          jLabel14.setText(""+Moi.getMunition());
      }
      public void MAJMunitionAdv1(){
           
          jLabel15.setText(""+Adversaires.joueur1.getMunition());
      }
      public void MAJMunitionAdv2(){
           
          jLabel16.setText(""+Adversaires.joueur2.getMunition());
      }
      public void MAJMunitionAdv3(){
          
          jLabel17.setText(""+Adversaires.joueur3.getMunition());
          
      }
      
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
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
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        jLabel18.setText("jLabel18");

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

        jLabel10.setText("jLabel10");

        jLabel11.setText("jLabel10");

        jLabel12.setText("jLabel10");

        jLabel13.setText("jLabel10");

        jLabel14.setText("jLabel14");

        jLabel15.setText("jLabel15");

        jLabel16.setText("jLabel16");

        jLabel17.setText("jLabel17");

        jTextField1.setText("jTextField1");
        jTextField1.setEnabled(false);

        jTextField2.setText("jTextField2");
        jTextField2.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(jLabel15)))
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGap(20, 20, 20)))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(25, 25, 25)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGap(193, 193, 193))
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
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
