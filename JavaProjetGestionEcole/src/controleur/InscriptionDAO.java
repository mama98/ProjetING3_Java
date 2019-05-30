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

import modele.Inscription;


/**
 *
 * @author val_r
 */
public class InscriptionDAO extends DAO<Inscription> {

    public InscriptionDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Inscription obj) {
        
        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO Inscription (id, id_Classe, id_Personne) VALUES(?,?,?)"
            );
            //insert param to change the ? into data
            statement.setObject(1, obj.getId(), Types.INTEGER);
            statement.setObject(2, obj.getId_Classe(), Types.INTEGER);
            statement.setObject(3, obj.getId_Personne(), Types.INTEGER);

            statement.executeUpdate(); //execute update for change in DB and executeQuery for select

        } catch (SQLException e) {
          e.printStackTrace();
        }
        return true;
        
    }

    @Override
    public boolean delete(Inscription obj) {
        
        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM Inscription WHERE id=?"
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
    public boolean update(Inscription obj) {
        
        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE Inscription SET id_Classe=?, id_Personne=?, WHERE id=?"
            );
            //insert param to change the ? into data
            statement.setObject(2, obj.getId_Classe(), Types.INTEGER);
            statement.setObject(3, obj.getId_Personne(), Types.INTEGER);
            statement.setObject(1, obj.getId(), Types.INTEGER);
            statement.executeUpdate(); //execute update for change in DB and executeQuery for select

        } catch (SQLException e) {
          e.printStackTrace();
        }
        return true;
        
    }

    @Override
    public Inscription find(int id) {
        
        Inscription ins = new Inscription();      
      
        try {
          ResultSet result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Inscription WHERE id = " + id);
          if(result.first())
            ins = new Inscription(
                id, 
                result.getInt("id_Classe"),
                result.getInt("id_Personne")

            );         
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return ins;
        
    }
    
}
