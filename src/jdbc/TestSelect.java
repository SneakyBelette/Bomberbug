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

/**
 *
 * @author guillaume.laurent
 */
public class TestSelect {

    public static void main(String[] args) {

        try {

            Connection connexion = DriverManager.getConnection("jdbc:mysql://nemrod.ens2m.fr:3306/20182019_s1_vs2_tp1_bomberman?serverTimezone=UTC", "tutur", "bomberman");

            PreparedStatement requete = connexion.prepareStatement("SELECT pseudo, x, y FROM Joueur;");
            ResultSet resultat = requete.executeQuery();
            while (resultat.next()) {
                String pseudo = resultat.getString("pseudo");
                int x = resultat.getInt("x");
                int y = resultat.getInt("y");
                System.out.println(pseudo + " = (" + x + "; " + y + ")");
            }

            requete.close();
            connexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
