/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import modele.AnneeScolaire;

import modele.Enseignement;

/**
 * Classe permettant l'interface entre les enseignements de la base de donnees et
 * la classe Enseignement en Java
 * @author val_r
 */
public class EnseignementDAO extends DAO<Enseignement> {

    /**
     * Cree une nouvelle instance de la classe et connecte a la base de donnees
     * @param conn Connexion etablie avec la base de donnees MySQL
     */
    public EnseignementDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Enseignement obj) {

        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO Enseignement (id, id_Classe, id_Discipline, id_Personne) VALUES(?,?,?,?)"
            );
            //insert param to change the ? into data
            statement.setObject(1, obj.getId(), Types.INTEGER);
            statement.setObject(2, obj.getId_Classe(), Types.INTEGER);
            statement.setObject(3, obj.getId_Discipline(), Types.INTEGER);
            statement.setObject(4, obj.getId_Personne(), Types.INTEGER);

            statement.executeUpdate(); //execute update for change in DB and executeQuery for select

        } catch (SQLException e) {
          e.printStackTrace();
        }
        return true;

    }

    @Override
    public boolean delete(Enseignement obj) {

        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM Enseignement WHERE id=?"
            );
            //insert param to change the ? into data
            statement.setObject(1, obj.getId(), Types.INTEGER);
            statement.executeUpdate(); //execute update for change in DB and executeQuery for select

        } catch (SQLException e) {
          e.printStackTrace();
        }
        return true;

    }

    @Override
    public boolean update(Enseignement obj) {

        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE Enseignement SET id_Classe=?, id_Discipline=?, id_Personne=?, WHERE id=?"
            );
            //insert param to change the ? into data
            statement.setObject(2, obj.getId_Classe(), Types.INTEGER);
            statement.setObject(3, obj.getId_Discipline(), Types.INTEGER);
            statement.setObject(4, obj.getId_Personne(), Types.INTEGER);
            statement.setObject(1, obj.getId(), Types.INTEGER);
            statement.executeUpdate(); //execute update for change in DB and executeQuery for select

        } catch (SQLException e) {
          e.printStackTrace();
        }
        return true;

    }

    @Override
    public Enseignement find(int id) {

        Enseignement ens = new Enseignement();

        try {
          ResultSet result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Enseignement WHERE id = " + id);
          if(result.first())
            ens = new Enseignement(
                id,
                result.getInt("id_Classe"),
                result.getInt("id_Discipline"),
                result.getInt("id_Personne")

            );
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return ens;

    }

}
