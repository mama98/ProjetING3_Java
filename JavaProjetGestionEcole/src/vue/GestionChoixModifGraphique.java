/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.DAO;
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
 * Interface permettant le choix de l'element (Bulletin, DetailBulletin ou Evaluation) a modifier
 * @author Marine
 */
public class GestionChoixModifGraphique extends javax.swing.JFrame {

    private int idEleve;
    private Personne enseignant;
    private Bulletin bulletin;

    private int idEnseignement;
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

    static private String[] tables = {
        "Bulletin",
        "DetailBulletin",
        "Evaluation",
    };
    static private String[][] tablesCols =
    {
        { //Bulletin
            "id",
            "appreciation",
            "nom",
            "id_Trimestre"
        },
        { //DetailBulletin
            "id",
            "appreciation",
        },
        { //Evaluation
            "id",
            "note",
            "appreciation",
        }
    };

    final private DefaultComboBoxModel modelComboBox = new DefaultComboBoxModel(tables);
    private DefaultTableModel modelResultTables = new DefaultTableModel();

    private Object[] appendValue(Object[] obj, Object newObj) {
        ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(obj));
        temp.add(newObj);
        return temp.toArray();
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
     * Crees une nouvelle JForm GestionChoixModifGraphique
     * @param enseignant
     * @param idEleve
     * @param bulletin
     */
    public GestionChoixModifGraphique(Personne enseignant, int idEleve, Bulletin bulletin) {
        this.idEleve = idEleve;
        this.enseignant = enseignant;
        this.bulletin = bulletin;
        initComponents();
        tablesComboBox.setModel(modelComboBox);
        tableResult.setModel(modelResultTables);
        getIdEnseignement();
        displayTable();
    }

    /**
     *
     */
    public void displayTable(){
        modelResultTables.setColumnCount(0);
        modelResultTables.setRowCount(0);
        tableResult.setModel(modelResultTables);

        String table = tablesComboBox.getSelectedItem().toString();
        String query = new String();
        switch(tablesComboBox.getSelectedIndex()){
            case 0:
                query = "SELECT * FROM Bulletin WHERE id_Inscription = " + idEleve;
                break;
            case 1:
                query = "SELECT * FROM DetailBulletin db WHERE db.id_Bulletin = " + bulletin.getId() +
                 " AND db.id_Enseignement = " + idEnseignement;
                break;
            case 2:
                query = "SELECT DISTINCT ev.id, note, ev.appreciation FROM Evaluation ev, DetailBulletin db, Bulletin b, Enseignement en " +
                "WHERE b.id_Inscription = " + idEleve +
                " AND b.id = " + bulletin.getId() +
                " AND ev.id_DetailBulletin = db.id" +
                " AND db.id_Bulletin = b.id" +
                " AND db.id_Enseignement = " + idEnseignement;
        }
        try {
            ResultSet result = RechercheGraphique.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery(query);

            int resultCount = 0; //Compteur d'elements du resultSet
            while(result.next()){
                if (resultCount == 0)
                // On ajoute des colonnes seulement si c'est le premier element du resultat, sinon les colonnes sont ajoutees en double, triple... etc
                    for(int index = 0; index < tablesCols[tablesComboBox.getSelectedIndex()].length; index++)
                        modelResultTables.addColumn(tablesCols[tablesComboBox.getSelectedIndex()][index]);

                Object[] rowToInsert = new Object[]{};
                String strToInsert;
                for (int indexCol = 0; indexCol < tablesCols[tablesComboBox.getSelectedIndex()].length; indexCol++) {
                    strToInsert = result.getString(tablesCols[tablesComboBox.getSelectedIndex()][indexCol]);
                    rowToInsert = appendValue(rowToInsert, strToInsert);
                }
                modelResultTables.addRow(rowToInsert);
                ++resultCount;
            }
        } catch (SQLException e){
            //JOptionPane.showMessageDialog(null, "Votre requête a échoué. Merci de réessayer");
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tablesComboBox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableResult = new javax.swing.JTable();
        retourButton = new javax.swing.JButton();
        jButtonAjouter = new javax.swing.JButton();
        jButtonSupprimer = new javax.swing.JButton();
        jButtonModifier = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(159, 90, 253));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Rechercher");

        jPanel4.setBackground(new java.awt.Color(159, 90, 253));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Rechercher");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addContainerGap(436, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addContainerGap(436, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(52, 73, 94));

        tablesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tablesComboBoxActionPerformed(evt);
            }
        });

        tableResult.setModel(new DefaultTableModel());
        jScrollPane2.setViewportView(tableResult);

        retourButton.setText("Retour");
        retourButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retourButtonActionPerformed(evt);
            }
        });

        jButtonAjouter.setText("Ajouter");
        jButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterActionPerformed(evt);
            }
        });

        jButtonSupprimer.setText("Supprimer");
        jButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerActionPerformed(evt);
            }
        });

        jButtonModifier.setText("Modifier");
        jButtonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(retourButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tablesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonModifier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(tablesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAjouter)
                    .addComponent(jButtonSupprimer)
                    .addComponent(jButtonModifier))
                .addGap(30, 30, 30)
                .addComponent(retourButton)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(159, 90, 253));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gestion des Notes");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addContainerGap(274, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 520, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tablesComboBoxActionPerformed
        displayTable();
    }//GEN-LAST:event_tablesComboBoxActionPerformed

    private void retourButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retourButtonActionPerformed
        this.setVisible(false);
        new GestionSelectionEleveGraphique(enseignant).setVisible(true);
    }//GEN-LAST:event_retourButtonActionPerformed

    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed
        this.setVisible(false);
        new AjoutBu_DB_EvGraphique(enseignant, idEleve, bulletin, tablesComboBox.getSelectedIndex()).setVisible(true);
    }//GEN-LAST:event_jButtonAjouterActionPerformed

    private void jButtonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierActionPerformed
        int row = tableResult.getSelectedRow();
        if (row == -1)
            JOptionPane.showMessageDialog(null, "Veuillez selectionner une valeur avant de continuer");
        else{
            this.setVisible(false);
            int value = Integer.parseInt(tableResult.getValueAt(row, 0).toString());
            new ModifierBu_DB_EvGraphique(enseignant, idEleve, bulletin, value, tablesComboBox.getSelectedIndex()).setVisible(true);
        }
    }//GEN-LAST:event_jButtonModifierActionPerformed

    private void jButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerActionPerformed
        if (tableResult.getSelectedRow() == -1)
            JOptionPane.showMessageDialog(null, "Veuillez selectionner une valeur avant de continuer");
        else{
            int row = tableResult.getSelectedRow();
            int value = Integer.parseInt(tableResult.getValueAt(row, 0).toString());
            switch(tablesComboBox.getSelectedIndex()){
                case 0:
                    DAO<Bulletin> daoB = DAO_Factory.getBulletinDAO();
                    Bulletin bulletin = new Bulletin(value, "", "", 0, 0);
                    if(daoB.delete(bulletin))
                        JOptionPane.showMessageDialog(null, "Suppression reussie");
                    else
                        JOptionPane.showMessageDialog(null, "La suppression a echoue");
                    break;
                case 1:
                    DAO<DetailBulletin> daoDB = DAO_Factory.getDetailBulletinDAO();
                    DetailBulletin detailBulletin = new DetailBulletin(value, "", 0, 0);
                    if(daoDB.delete(detailBulletin))
                        JOptionPane.showMessageDialog(null, "Suppression reussie");
                    else
                        JOptionPane.showMessageDialog(null, "La suppression a echoue");
                    break;
                case 2:
                    DAO<Evaluation> daoE = DAO_Factory.getEvaluationDAO();
                    Evaluation evaluation = new Evaluation(value, 0, "", 0);
                    if(daoE.delete(evaluation))
                        JOptionPane.showMessageDialog(null, "Suppression reussie");
                    else
                        JOptionPane.showMessageDialog(null, "La suppression a echoue");
                    break;
            }
            displayTable();
        }
    }//GEN-LAST:event_jButtonSupprimerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButtonSupprimer;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton retourButton;
    private javax.swing.JTable tableResult;
    private javax.swing.JComboBox<String> tablesComboBox;
    // End of variables declaration//GEN-END:variables
}
