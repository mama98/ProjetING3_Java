/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.DAO;
import controleur.DAO_Factory;
import controleur.DAO_Factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modele.Personne;
import modele.Bulletin;
import modele.DetailBulletin;
import modele.Evaluation;
import static vue.ConnexionGraphique.connect;

/**
 * Permet l'ajout d'un Bulletin, DetailBulletin ou Evaluation a la base de donnees
 * @author Marine
 */
public class AjoutBu_DB_EvGraphique extends javax.swing.JFrame {

    private int idEleve;

    private Personne enseignant;
    private Bulletin bulletin;
    private Bulletin bulletinChoix = null;
    private DetailBulletin detailBulletinChoix = null;
    private Evaluation evaluationChoix = null;

    private int idChoix = 0;
    private int idEnseignement;

    private int choice;

    private void getIdEnseignement(){
        try {
            ResultSet result = RechercheGraphique.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery(
            "SELECT id FROM Enseignement WHERE id_Personne = " + enseignant.getId()
            );
            if(result.first())
            idEnseignement = result.getInt("id");
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Connecte le programme a la base de donnees
     */
    protected static Connection connect = null;
        static {
            Connection tmp = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                tmp = DriverManager.getConnection("jdbc:mysql://localhost/gestionEcole", "root", "");
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DAO_Factory.class.getName()).log(Level.SEVERE, null, ex);
            }
            connect = tmp;
        }

    /**
     * Crees une nouvelle JForm AjoutBu_DB_EvGraphique
     * @param enseignant Enseignant connecte
     * @param choice Choix de l'enseignant : 0 - Bulletin, 1 - DetailBulletin, 2 - Evaluation
     * @param bulletin Bulletin de l'eleve selectionne
     * @param idEleve Id d'inscription de l'eleve selectionne
     */
    public AjoutBu_DB_EvGraphique(Personne enseignant,
                                  int idEleve,
                                  Bulletin bulletin,
                                  int choice) {
        initComponents();
        this.enseignant = enseignant;
        this.idEleve = idEleve;
        this.bulletin = bulletin;
        this.choice = choice;
        switch(choice) {
            case 0:
                jLabel1.setText("Nom");
                jLabel2.setText("Appréciation");
                jLabelCat.setText("Trimestre");
                break;
            case 1:
                jLabel1.setText("Appréciation");
                jLabelCat.setText("Bulletin");
                jLabel2.setVisible(false);
                jTextField2.setVisible(false);
                break;
            case 2:
                jLabel1.setText("Note");
                jLabel2.setText("Appréciation");
                jLabelCat.setText("Détail Bulletin");
                break;
        }
        populateComboBox();
    }

    private void populateComboBox(){
        getIdEnseignement();
        String query = new String();
        switch(choice){
            case 0:
            query = "SELECT * FROM Trimestre";
            break;
            case 1:
            query = "SELECT * FROM Bulletin, Inscription i WHERE " +
            "id_Inscription = i.id AND i.id = " + idEleve;
            break;
            case 2:
            query = "SELECT * FROM DetailBulletin WHERE " +
            "id_Bulletin = " + bulletin.getId() +
            " AND id_Enseignement = " + idEnseignement;
            break;
        }

        try {
            ResultSet result = RechercheGraphique.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery(query);

            while(result.next())
                switch(choice) {
                    case 0:
                        jComboBoxID.addItem(result.getString("id") + "_Trimestre_" + result.getString("numero"));
                        break;
                    case 1:
                        jComboBoxID.addItem(result.getString("id") + "_" + result.getString("nom"));
                        break;
                    case 2:
                        jComboBoxID.addItem(result.getString("id") + "_DetailBulletin_" + result.getString("id_Enseignement"));
                        break;
                }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxID = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabelCat = new javax.swing.JLabel();
        jButtonValider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(52, 73, 94));

        jPanel5.setBackground(new java.awt.Color(159, 90, 253));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ajout ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jComboBoxID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxIDActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("jLabel1");

        jButton1.setText("Retour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelCat.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCat.setText("jLabel3");

        jButtonValider.setText("Valider");
        jButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabelCat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jComboBoxID, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCat))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButtonValider))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        new GestionChoixModifGraphique(enseignant, idEleve, bulletin).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxIDActionPerformed
        String query = new String();
        String parts[] = jComboBoxID.getSelectedItem().toString().split("_");
        String idComboBox = parts[0];
        switch(choice) {
            case 0:
            query = "SELECT id FROM Trimestre WHERE " +
            "id = " + idComboBox;
            break;
            case 1:
            query = "SELECT b.id FROM Bulletin b, Inscription i WHERE " +
            "b.id = '" + idComboBox + "' AND " +
            "i.id = " + idEleve + " AND " +
            "id_Inscription = i.id";
            break;
            case 2:
            query = "SELECT id FROM DetailBulletin WHERE " +
            "id = " + idComboBox;
            break;
        }
        try {
            ResultSet result = RechercheGraphique.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery(query);

            if(result.first()) {
                if(choice == 1){
                    idChoix = result.getInt("b.id");
                } else
                    idChoix = result.getInt("id");
            } else {
                JOptionPane.showMessageDialog(null, "Une erreur s'est produite.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jComboBoxIDActionPerformed

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
        if(jTextField1.getText().isEmpty() ||
        (jTextField2.isVisible() &&
        jTextField2.getText().isEmpty()))
        JOptionPane.showMessageDialog(null, "Merci de remplir tous les champs");

        switch(choice){
        case 0:
            DAO<Bulletin> dao_b = DAO_Factory.getBulletinDAO();
            Bulletin newBulletin = new Bulletin(0,
            jTextField1.getText(),
            jTextField2.getText(),
            idChoix,
            idEleve);
            if(dao_b.create(newBulletin))
            JOptionPane.showMessageDialog(null, "Bulletin ajouté avec succès");
            else
            JOptionPane.showMessageDialog(null, "Une erreur s'est produite");
            break;
        case 1:
            DAO<DetailBulletin> dao_db = DAO_Factory.getDetailBulletinDAO();
            DetailBulletin newDB = new DetailBulletin(0,
            jTextField1.getText(),
            idChoix,
            idEnseignement);
            if(dao_db.create(newDB))
            JOptionPane.showMessageDialog(null, "Détail Bulletin ajouté avec succès");
            else
            JOptionPane.showMessageDialog(null, "Une erreur s'est produite");
            break;
        case 2:
            DAO<Evaluation> dao_ev = DAO_Factory.getEvaluationDAO();
            float note;
            try {
                note = Float.parseFloat(jTextField1.getText());
                if(note > 20 || note < 0) {
                    JOptionPane.showMessageDialog(null, "Veuillez entrer une note comprise entre 0 et 20");
                } else {
                    Evaluation newEvaluation = new Evaluation(0,
                    note,
                    jTextField2.getText(),
                    idChoix);
                    if(dao_ev.create(newEvaluation))
                    JOptionPane.showMessageDialog(null, "Evaluation ajoutée avec succès");
                    else
                    JOptionPane.showMessageDialog(null, "Une erreur s'est produite");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer la note correctement");
            }
            break;
        }
    }//GEN-LAST:event_jButtonValiderActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JComboBox<String> jComboBoxID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCat;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
