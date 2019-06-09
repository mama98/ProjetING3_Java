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

import modele.Discipline;

/**
 * Classe permettant l'interface entre les disciplines de la base de donnees et
 * la classe Discipline en Java
 * @author val_r
 */
public class DisciplineDAO extends DAO<Discipline>{

    /**
     * Cree une nouvelle instance de la classe et connecte a la base de donnees
     * @param conn Connexion etablie avec la base de donnees MySQL
     */
    public DisciplineDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Discipline obj) {

        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO Discipline(id, nom) VALUES(?,?)"
            );
            //insert param to change the ? into data
            statement.setObject(1, obj.getId(), Types.INTEGER);
            statement.setObject(2, obj.getNom(), Types.VARCHAR);
            statement.executeUpdate(); //execute update for change in DB and executeQuery for select

    } catch (SQLException e) {
      e.printStackTrace();
    }
        return true;

    }

    @Override
    public boolean delete(Discipline obj) {

        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM Discipline WHERE id=?"
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
    public boolean update(Discipline obj) {

        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE Discipline SET nom=?, WHERE id=?"
            );
            //insert param to change the ? into data
            statement.setObject(2, obj.getNom(), Types.VARCHAR);
            statement.setObject(1, obj.getId(), Types.INTEGER);
            statement.executeUpdate(); //execute update for change in DB and executeQuery for select

        } catch (SQLException e) {
          e.printStackTrace();
        }
        return true;

    }

    @Override
    public Discipline find(int id) {

        Discipline discip = new Discipline();

    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Discipline WHERE id = " + id);
      if(result.first())
        discip = new Discipline(
            id,
            result.getString("nom")
        );
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return discip;

    }

}
