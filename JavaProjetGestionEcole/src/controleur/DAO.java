/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;
import java.sql.Connection;

/**
 * Classe abstraite permettant la connection entra Java et MySQL
 * @author Marine
 * @param <T> Type de la DAO que l'on cherche a creer
 */
public abstract class DAO<T> {

    /**
     * Parametre de la connexion a la base de donnees.
     */
    protected Connection connect = null;

  // Code OpenClassroom pour implementer DAO.

    /**
     * Constructeur assignant la connexion passee en parametre
     * @param conn Connexion etablie avec la base de donnees MySQL Connection etablie avec la base de donnees.
     */
  public DAO(Connection conn){
    this.connect = conn;
  }

  /**
  * Méthode de création
  * @param obj Objet passe en parametre que l'on cherche a ajouter a la base de donnees
  * @return boolean true si l'operation a reussi, false sinon
  */
  public abstract boolean create(T obj);

  /**
  * Méthode pour effacer
  * @param obj Objet passe en parametre que l'on cherche a supprimer de la base de donnees
  * @return boolean true si l'operation a reussi, false sinon
  */
  public abstract boolean delete(T obj);

  /**
  * Méthode de mise à jour
  * @param obj Objet que l'on veut mettre a jour dans la base de donnees
  * @return boolean true si l'operation a reussi, false sinon
  */
  public abstract boolean update(T obj);

  /**
  * Méthode de recherche des informations
  * @param id id de l'objet que l'on cherche dans la base de donnees
  * @return T Objet retourne par la recherche dans la base de donnees, null si il n'existe pas
  */
  public abstract T find(int id);
}
