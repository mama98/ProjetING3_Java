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
import modele.AnneeScolaire;

import modele.Trimestre;

/**
 *
 * @author Marine <ECE>
 */
public class TrimestreDAO extends DAO<Trimestre>{

    public TrimestreDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Trimestre obj) {
        
        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO Trimestre(id,numero,debut,fin, id_AnneeScolaire) VALUES(?,?,?,?,?)"
            );
            //Changer les ? par la valeur de l'objet créé pour adapter le java a la requette SQL.
            statement.setObject(1, obj.getId(), Types.INTEGER);
            statement.setObject(2, obj.getNumero(), Types.INTEGER);
            statement.setObject(3, obj.getDebut(), Types.INTEGER);
            statement.setObject(4, obj.getFin(), Types.INTEGER);
            statement.setObject(5, obj.getId_AnneeScolaire(), Types.INTEGER);

            statement.executeUpdate(); //execute update for change in DB and executeQuery for select

    } catch (SQLException e) {
      e.printStackTrace();
    }
        return true;
    }

    @Override
    public boolean delete(Trimestre obj) {
        
    try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM Trimestre WHERE id=?"
            );
            //Changer les ? par la valeur de l'objet créé pour adapter le java a la requette SQL.
            statement.setObject(1, obj.getId(), Types.INTEGER);

            statement.executeUpdate(); //execute update for change in DB and executeQuery for select

    } catch (SQLException e) {
      e.printStackTrace();
    }
        return true;
    }

    @Override
    public boolean update(Trimestre obj) {
       
               
        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE Trimestre SET numero=?, debut=?, fin=?,id_AnneeScolaire=?, WHERE id=?"
            );
            //insert param to change the ? into data
            
            statement.setObject(2, obj.getNumero(), Types.INTEGER);
            statement.setObject(3, obj.getDebut(), Types.INTEGER);
            statement.setObject(4, obj.getFin(), Types.INTEGER);
            statement.setObject(5, obj.getId_AnneeScolaire(), Types.INTEGER);
            statement.setObject(1, obj.getId(), Types.INTEGER);
            statement.executeUpdate(); //execute update for change in DB and executeQuery for select

    } catch (SQLException e) {
      e.printStackTrace();
    }
        return true;
    }

    @Override
    public Trimestre find(int id_trimestre) {
        
                
            Trimestre trimestre = new Trimestre();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM trimestre WHERE id = " + id_trimestre );
      if(result.first())
        trimestre = new Trimestre(
          id_trimestre,
          result.getInt("numero"),
          result.getInt("debut"),
          result.getInt("fin"),
          result.getInt("id_AnneeScolaire")
          
        );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return trimestre;
    }
    
    
}
