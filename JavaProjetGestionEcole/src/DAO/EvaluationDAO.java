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
import modele.Ecole;
import modele.Evaluation;

/**
 *
 * @author Marine <ECE>
 */
public class EvaluationDAO extends DAO<Evaluation> {

    public EvaluationDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Evaluation obj) {
        
     try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO Evaluation(id, note, appreciation, id_DetailBulletin) VALUES(?,?,?,?)"
            );
            //Changer les ? par la valeur de l'objet créé pour adapter le java a la requette SQL.
            statement.setObject(1, obj.getId(), Types.INTEGER);
            statement.setObject(2, obj.getNote(), Types.INTEGER);
            statement.setObject(3, obj.getAppreciation(), Types.VARCHAR);
            statement.setObject(4, obj.getId_DetailBulletin(), Types.INTEGER);

            statement.executeUpdate(); //execute update for change in DB and executeQuery for select

    } catch (SQLException e) {
      e.printStackTrace();
    }
        return true;
    }

    @Override
    public boolean delete(Evaluation obj) {
        
     try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM Evaluation WHERE id=?"
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
    public boolean update(Evaluation obj) {
        
    try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE Evaluation SET note=?, appreciation=?, WHERE id=?"
            );
            //insert param to change the ? into data
            statement.setObject(2, obj.getNote(), Types.VARCHAR);
            statement.setObject(3, obj.getAppreciation(), Types.VARCHAR);
            statement.setObject(1, obj.getId(), Types.INTEGER);
            
            statement.executeUpdate(); //execute update for change in DB and executeQuery for select

    } catch (SQLException e) {
      e.printStackTrace();
    }
        return true;
    }

    @Override
    public Evaluation find(int id_evaluation) {
        
        Evaluation evaluation = new Evaluation();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Evaluation WHERE id = " + id_evaluation);
      if(result.first())
        evaluation = new Evaluation(
          id_evaluation,
          result.getInt("note"),
          result.getString("appreciation"),
          result.getInt("id_DetailBulletin")    
        );         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return evaluation;
    }
    
}
