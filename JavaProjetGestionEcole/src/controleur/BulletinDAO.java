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
import modele.Bulletin;
import modele.DetailBulletin;

/**
 * Classe permettant l'interface entre les bulletins de la base de donnees et
 * la classe Bulletin en Java
 * @author Marine
 */
public class BulletinDAO extends DAO<Bulletin> {

    /**
    * Cree une nouvelle instance de la classe et connecte a la base de donnees
    *
    * @param conn Connexion etablie avec la base de donnees MySQL
    */
    public BulletinDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Bulletin obj) {
        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
            "INSERT INTO Bulletin(nom, appreciation, id_Trimestre, id_Inscription) VALUES(?,?,?,?)"
            );
            //Changer les ? par la valeur de l'objet créé pour adapter le java a la requette SQL.
            statement.setObject(1, obj.getNom(), Types.VARCHAR);
            statement.setObject(2, obj.getAppreciation(), Types.VARCHAR);
            statement.setObject(3, obj.getId_Trimestre(), Types.INTEGER);
            statement.setObject(4, obj.getId_Inscription(), Types.INTEGER);

            statement.executeUpdate(); //execute update for change in DB and executeQuery for select

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Bulletin obj) {
                try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM Bulletin WHERE id=?"
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
    public boolean update(Bulletin obj) {

                try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE Bulletin SET appreciation=?, nom=? WHERE id=?"
            );
            //insert param to change the ? into data
            statement.setObject(1, obj.getAppreciation(), Types.VARCHAR);
            statement.setObject(2, obj.getNom(), Types.VARCHAR);
            statement.setObject(3, obj.getId(), Types.INTEGER);
            statement.executeUpdate(); //execute update for change in DB and executeQuery for select

    } catch (SQLException e) {
      e.printStackTrace();
    }
        return true;
    }

    @Override
    public Bulletin find(int id_bulletin) {

                            Bulletin bulletin = new Bulletin();

    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Bulletin WHERE id = " + id_bulletin);
      if(result.first())
        bulletin = new Bulletin(
          id_bulletin,
          result.getString("nom"),
          result.getString("appreciation"),
          result.getInt("id_Trimestre"),
          result.getInt("id_Inscription")
        );
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return bulletin;
    }

}
