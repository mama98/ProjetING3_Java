/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Point d'entree dans l'application, ouvrant une fenetre de connexion
 * @author Marine
 */
public class TestConnexion extends javax.swing.JFrame {

    /**
     * Point d'entree du .jar
     * @param args Arguments de la ligne de commande, inutiles
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnexionGraphique().setVisible(true);
            }
        });

    }
}
