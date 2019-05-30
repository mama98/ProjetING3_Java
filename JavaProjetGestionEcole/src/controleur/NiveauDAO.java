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

import modele.Niveau;

/**
 *
 * @author val_r
 */
public class NiveauDAO extends DAO<Niveau>{

    public NiveauDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Niveau obj) {
        
        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO Niveau(id, nom) VALUES(?,?)"
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
    public boolean delete(Niveau obj) {
        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM niveau WHERE id=?"
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
    public boolean update(Niveau obj) {
        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE niveau SET nom=?, WHERE id=?"
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
    public Niveau find(int id) {
        
        Niveau niv = new Niveau();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM niveau WHERE id = " + id);
      if(result.first())
        niv = new Niveau(
            id, 
            result.getString("nom")
        );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return niv;
    }

   
    
}
