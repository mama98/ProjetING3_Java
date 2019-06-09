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
import modele.DetailBulletin;

/**
 * Classe permettant l'interface entre les details des bulletins de la base de donnees et
 * la classe DetailBulletin en Java
 * @author Marine
 */
public class DetailBulletinDAO extends DAO<DetailBulletin> {

    /**
     * Cree une nouvelle instance de la classe et connecte a la base de donnees
     * @param conn Connexion etablie avec la base de donnees MySQL
     */
    public DetailBulletinDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(DetailBulletin obj) {

        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
            "INSERT INTO DetailBulletin(id, appreciation, id_Bulletin, id_Enseignement) VALUES(?,?,?,?)"
            );
            //Changer les ? par la valeur de l'objet créé pour adapter le java a la requette SQL.
            statement.setObject(1, obj.getId(), Types.INTEGER);
            statement.setObject(2, obj.getAppreciation(), Types.VARCHAR);
            statement.setObject(3, obj.getId_Bulletin(), Types.INTEGER);
            statement.setObject(4, obj.getId_Enseignement(), Types.INTEGER);

            statement.executeUpdate(); //execute update for change in DB and executeQuery for select

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(DetailBulletin obj) {

        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "DELETE FROM Evaluation WHERE id_detailBulletin=?; DELETE FROM Detailbulletin WHERE id=?"
            );
            //insert param to change the ? into data
            statement.setObject(1, obj.getId(), Types.INTEGER);
            statement.setObject(2, obj.getId(), Types.INTEGER);
            statement.executeUpdate(); //execute update for change in DB and executeQuery for select

    } catch (SQLException e) {
      e.printStackTrace();
    }
        return true;
    }

    @Override
    public boolean update(DetailBulletin obj) {

        try {
            // prefer prepareStatement as statement to avoid SQL injection
            PreparedStatement statement = this.connect.prepareStatement(
                    "UPDATE DetailBulletin SET appreciation=? WHERE id=?"
            );
            //insert param to change the ? into data
            statement.setObject(1, obj.getAppreciation(), Types.VARCHAR);
            statement.setObject(2, obj.getId(), Types.INTEGER);
            statement.executeUpdate(); //execute update for change in DB and executeQuery for select

    } catch (SQLException e) {
      e.printStackTrace();
    }
        return true;
    }

    @Override
    public DetailBulletin find(int id_detailbulletin) {

                    DetailBulletin detailbulletin = new DetailBulletin();

    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM DetailBulletin WHERE id = " + id_detailbulletin);
      if(result.first())
        detailbulletin = new DetailBulletin(
          id_detailbulletin,
          result.getString("appreciation"),
          result.getInt("id_Bulletin"),
          result.getInt("id_Enseignement")
        );
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return detailbulletin;
    }

}
