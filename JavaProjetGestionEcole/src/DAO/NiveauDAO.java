/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
                    "INSERT INTO niveau(id) VALUES(?)"
            );
            //insert param to change the ? into data
            statement.setObject(1, obj.getId(), Types.INTEGER);
            statement.executeUpdate(); //execute update for change in DB and executeQuery for select

    } catch (SQLException e) {
      e.printStackTrace();
    }
        return true;    }

    @Override
    public boolean delete(Niveau obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Niveau obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Niveau find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
