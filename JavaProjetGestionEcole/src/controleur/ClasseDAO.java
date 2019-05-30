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

import modele.Classe;


/**
 *
 * @author val_r
 */
public class ClasseDAO extends DAO<Classe> {

    public ClasseDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Classe obj) {
        
        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO Classe(id, nom, id_AnneeScolaire, id_Ecole, id_Niveau) VALUES(?,?,?,?,?)"
            );
            //insert param to change the ? into data
            statement.setObject(1, obj.getId(), Types.INTEGER);
            statement.setObject(2, obj.getNom(), Types.VARCHAR);
            statement.setObject(3, obj.getId_AnneeScolaire(), Types.INTEGER);
            statement.setObject(4, obj.getId_Ecole(), Types.INTEGER);
            statement.setObject(5, obj.getId_Niveau(), Types.INTEGER);

            statement.executeUpdate(); //execute update for change in DB and executeQuery for select

        } catch (SQLException e) {
          e.printStackTrace();
        }
        return true;
        
    }

    @Override
    public boolean delete(Classe obj) {
        
        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM Classe WHERE id=?"
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
    public boolean update(Classe obj) {
        
        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE Classe SET nom=?, id_AnneeScolaire=?, id_Ecole=?, id_Niveau=?, WHERE id=?"
            );
            //insert param to change the ? into data
            statement.setObject(2, obj.getNom(), Types.VARCHAR);
            statement.setObject(3, obj.getId_AnneeScolaire(), Types.INTEGER);
            statement.setObject(4, obj.getId_Ecole(), Types.INTEGER);
            statement.setObject(5, obj.getId_Niveau(), Types.INTEGER);
            statement.setObject(1, obj.getId(), Types.INTEGER);
            statement.executeUpdate(); //execute update for change in DB and executeQuery for select

        } catch (SQLException e) {
          e.printStackTrace();
        }
        return true;
        
    }

    @Override
    public Classe find(int id) {
        
        Classe classe = new Classe();      
      
        try {
          ResultSet result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Classe WHERE id = " + id);
          if(result.first())
            classe = new Classe(
                id, 
                result.getString("nom"),
                result.getInt("id_AnneeScolaire"),
                result.getInt("id_Ecole"),
                result.getInt("id_Niveau")

            );         
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return classe;
        
    }
    
}
