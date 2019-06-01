/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Marine <ECE>
 */
public class TestConnexion extends javax.swing.JFrame {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConnexionGraphique().setVisible(true);
  
            }
        });

    }
}