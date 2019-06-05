/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

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
import javax.swing.table.DefaultTableModel;
import modele.Personne;
import static vue.ConnexionGraphique.connect;

/**
 *
 * @author Marine <ECE>
 */
public class RechercheGraphique extends javax.swing.JFrame {

    private Personne user;

    static private String[] tables = {
        "AnneeScolaire",
        "Bulletin",
        "Classe",
        "DetailBulletin",
        "Discipline",
        "Ecole",
        "Enseignement",
        "Evaluation",
        "Inscription",
        "Niveau",
        "Personne",
        "Trimestre"};

    static private String[][] tablesCols =
    {
        { //AnneeScolaire
            "id"
        },
        { //Bulletin
            "appreciation",
            "id_Trimestre",
            "id_Inscription",
            "nom"
        },
        { //Classe
            "nom",
            "id_AnneeScolaire",
            "id_Ecole",
            "id_Niveau"
        },
        { //DetailBulletin
            "appreciation",
            "id_Bulletin",
            "id_Enseignement"
        },
        { //Discipline
            "nom"
        },
        { //Ecole
            "nom"
        },
        { //Enseignement
            "id_Classe",
            "id_Discipline",
            "id_Personne"
        },
        { //Evaluation
            "id",
            "note",
            "appreciation",
            "id_DetailBulletin"
        },
        { //Inscription
            "id_Classe",
            "id_Personne"
        },
        { //Niveau
            "nom"
        },
        { //Personne
            "nom",
            "prenom",
            "login"
        },
        { //Trimestre
            "numero",
            "debut",
            "fin",
            "id_AnneeScolaire"
        },
    };

    final private DefaultComboBoxModel modelTables = new DefaultComboBoxModel(tables);
    private DefaultComboBoxModel modelCols = new DefaultComboBoxModel(tablesCols[0]);
    private DefaultTableModel modelTable = new DefaultTableModel();

    private Object[] appendValue(Object[] obj, Object newObj) {
        ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(obj));
        temp.add(newObj);
        return temp.toArray();
    }

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
     * Creates new form RechercheGraphique
     */
    public RechercheGraphique(Personne user) {
        this.user = user;
        initComponents();
        tablesComboBox.setModel(modelTables);
        tablesColsComboBox.setModel(modelCols);
    }

    public void displayTable(){
        modelTable.setColumnCount(0);
        modelTable.setRowCount(0);
        tableResult.setModel(modelTable);

        String table = tablesComboBox.getSelectedItem().toString();
        String col = tablesColsComboBox.getSelectedItem().toString();
        try {
            String searchQuery = searchField.getText();
            ResultSet result = RechercheGraphique.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery(
                        "SELECT * FROM " + table +
                        " WHERE " + col +
                        " LIKE '%" + searchQuery + "%'"
                );

            int resultCount = 0; //Compteur d'elements du resultSet
            while(result.next()){
                if (resultCount == 0)
                // On ajoute des colonnes seulement si c'est le premier element du resultat, sinon les colonnes sont ajoutees en double, triple... etc
                    for(int index = 0; index < tablesCols[tablesComboBox.getSelectedIndex()].length; index++)
                        modelTable.addColumn(tablesCols[tablesComboBox.getSelectedIndex()][index]);

                Object[] rowToInsert = new Object[]{};
                String strToInsert;
                for (int indexCol = 0; indexCol < tablesCols[tablesComboBox.getSelectedIndex()].length; indexCol++) {
                    strToInsert = result.getString(tablesCols[tablesComboBox.getSelectedIndex()][indexCol])
                                        .replaceAll(searchQuery, "<b><font color=\"rgb(159,90,253)\">" + searchQuery + "</b></font>");
                    rowToInsert = appendValue(rowToInsert, "<html>" + strToInsert);    
                }
                modelTable.addRow(rowToInsert);
                ++resultCount;
            }

        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Votre requête a échoué. Merci de réessayer");
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        tablesComboBox = new javax.swing.JComboBox<>();
        tablesColsComboBox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableResult = new javax.swing.JTable();
        retourButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(159, 90, 253));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Rechercher");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(436, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(52, 73, 94));

        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        tablesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "\"AnneeScolaire\"", "\"Bulletin\"", "\"Classe\"", "\"DetailBulletin\"", "\"Discipline\"", "\"Ecole\"", "\"Enseignement\"", "\"Evaluation\"", "\"Inscription\"", "\"Niveau\"", "\"Personne\"", "\"TrimestreHide\"" }));
        tablesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tablesComboBoxActionPerformed(evt);
            }
        });

        tablesColsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tableResult.setModel(new DefaultTableModel());
        jScrollPane2.setViewportView(tableResult);

        retourButton.setText("Retour");
        retourButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retourButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tablesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tablesColsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchField))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(retourButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tablesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tablesColsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(retourButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 504, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        displayTable();
    }//GEN-LAST:event_searchFieldKeyReleased

    private void tablesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tablesComboBoxActionPerformed
        modelCols = new DefaultComboBoxModel(tablesCols[tablesComboBox.getSelectedIndex()]);
        tablesColsComboBox.setModel(modelCols);
    }//GEN-LAST:event_tablesComboBoxActionPerformed

    private void retourButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retourButtonActionPerformed
        this.setVisible(false);
        if(user.getType_Enseignant())
            new EnseignantGraphique(user).setVisible(true);
        else
            new EleveGraphique(user).setVisible(true);
    }//GEN-LAST:event_retourButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton retourButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JTable tableResult;
    private javax.swing.JComboBox<String> tablesColsComboBox;
    private javax.swing.JComboBox<String> tablesComboBox;
    // End of variables declaration//GEN-END:variables
}
