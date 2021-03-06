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

/**
* Classe permettant l'interface entre les annees de la base de donnees et
* la classe AnneeScolaire en Java
* @author Marine
*/
public class AnneeScolaireDAO extends DAO<AnneeScolaire> {

    /**
    * Cree une nouvelle instance de la classe et connecte a la base de donnees
    *
    * @param conn Connexion etablie avec la base de donnees MySQL
    */
    public AnneeScolaireDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(AnneeScolaire obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
            "INSERT INTO AnneeScolaire(id) VALUES(?)"
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
    public boolean delete(AnneeScolaire obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
            "DELETE FROM AnneeScolaire WHERE id=?"
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
    public boolean update(AnneeScolaire obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AnneeScolaire find(int id_annee_scolaire) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        AnneeScolaire annee = new AnneeScolaire();
        try {
            ResultSet result = this.connect.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM AnneeScolaire WHERE id = " + id_annee_scolaire);
            if(result.first())
            annee = new AnneeScolaire(
            id_annee_scolaire
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return annee;
    }
}
