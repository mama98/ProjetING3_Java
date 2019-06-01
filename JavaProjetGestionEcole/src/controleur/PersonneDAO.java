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

import modele.Personne;


/**
 *
 * @author val_r
 */
public class PersonneDAO extends DAO<Personne>{

    public PersonneDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Personne obj) {
        
        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO Personne(nom, prenom, login, password, type_Enseignant) VALUES(?,?,?,?,?)"
            );
            //insert param to change the ? into data
            //statement.setObject(1, obj.getId(), Types.INTEGER);
            statement.setObject(1, obj.getNom(), Types.VARCHAR);
            statement.setObject(2, obj.getPrenom(), Types.VARCHAR);
            statement.setObject(3, obj.getLogin(), Types.VARCHAR);
            statement.setObject(4, obj.getPassword(), Types.VARCHAR);
            statement.setObject(5, obj.getType_Enseignant(), Types.BOOLEAN);
            statement.executeUpdate(); //execute update for change in DB and executeQuery for select

    } catch (SQLException e) {
      e.printStackTrace();
    }
        return true;
        
    }

    @Override
    public boolean delete(Personne obj) {
        
        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM Personne WHERE id=?"
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
    public boolean update(Personne obj) {
        
        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE Personne SET nom=?, prenom=?, login=?, password=?, type_Enseignant=false, WHERE id=?"
            );
            //insert param to change the ? into data
            statement.setObject(2, obj.getNom(), Types.VARCHAR);
            statement.setObject(3, obj.getPrenom(), Types.VARCHAR);
            statement.setObject(4, obj.getLogin(), Types.VARCHAR);
            statement.setObject(5, obj.getPassword(), Types.VARCHAR);
            statement.setObject(6, obj.getType_Enseignant(), Types.INTEGER);
            statement.setObject(1, obj.getId(), Types.INTEGER);
            statement.executeUpdate(); //execute update for change in DB and executeQuery for select

        } catch (SQLException e) {
          e.printStackTrace();
        }
        return true;
        
    }

    @Override
    public Personne find(int id) {
        
        Personne personne = new Personne();      
      
        try {
          ResultSet result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Personne WHERE id = " + id);
          if(result.first())
            personne = new Personne(
                id, 
                result.getString("nom"),
                result.getString("prenom"),
                result.getString("login"),
                result.getString("password"),
                result.getInt("type_Enseignant")
            );         
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return personne;
        
    }
    
    
    
}
