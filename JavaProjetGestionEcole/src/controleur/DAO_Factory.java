/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

/**
 *
 * @author Marine
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Classe qui retourne les DAO du package controleur à l'aide de getters.
 * @author Marine
 */
public class DAO_Factory {

        /**
         * constante static containing the connection variable of the class
         */
        protected static final Connection conn;

        /**
         * this is a specific way to init final variable throwing exceptions
         */
        static {
            Connection tmp = null;

            try {
                // subscribe to your DriverManager as we use mysql-connector add this :
                Class.forName("com.mysql.jdbc.Driver");
                // get the connection variable
                // jdbc:mysl:// is the protocol URI (like http:// is for http)
                // localhost: wamp server
                // gestionEcole est le nom de la BDD
                // le second paramètre est l'id pour se connecter à sa BDD en passant par PHPMyAdmin
                // le troisième est vide car c'est le mot de passe pour se connecter à phpMyAdmin en root user.
                tmp = DriverManager.getConnection("jdbc:mysql://localhost/gestionEcole?allowMultipleQueries=true", "root", "");
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(DAO_Factory.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn = tmp;
        }

    /**
     * Initialise la DAO en fonction du type specifique
     * @return nouvelle instance de la classe DAO creee
     */
    public static DAO getAnneeScolaireDAO() {
            return new AnneeScolaireDAO(conn);
        }

    /**
     * Initialise la DAO en fonction du type specifique
     * @return nouvelle instance de la classe DAO creee
     */
    public static DAO getBulletinDAO() {
            return new BulletinDAO(conn);
        }

    /**
     * Initialise la DAO en fonction du type specifique
     * @return nouvelle instance de la classe DAO creee
     */
    public static DAO getClasseDAO() {
            return new ClasseDAO(conn);
        }

    /**
     * Initialise la DAO en fonction du type specifique
     * @return nouvelle instance de la classe DAO creee
     */
    public static DAO getDetailBulletinDAO() {
            return new DetailBulletinDAO(conn);
        }

    /**
     * Initialise la DAO en fonction du type specifique
     * @return nouvelle instance de la classe DAO creee
     */
    public static DAO getDisciplineDAO() {
            return new DisciplineDAO(conn);
        }

    /**
     * Initialise la DAO en fonction du type specifique
     * @return nouvelle instance de la classe DAO creee
     */
    public static DAO getEcoleDAO() {
            return new EcoleDAO(conn);
        }

    /**
     * Initialise la DAO en fonction du type specifique
     * @return nouvelle instance de la classe DAO creee
     */
    public static DAO getEnseignementDAO() {
            return new EnseignementDAO(conn);
        }

    /**
     * Initialise la DAO en fonction du type specifique
     * @return nouvelle instance de la classe DAO creee
     */
    public static DAO getEvaluationDAO() {
            return new EvaluationDAO(conn);
        }

    /**
     * Initialise la DAO en fonction du type specifique
     * @return nouvelle instance de la classe DAO creee
     */
    public static DAO getInscriptionDAO() {
            return new InscriptionDAO(conn);
        }

    /**
     * Initialise la DAO en fonction du type specifique
     * @return nouvelle instance de la classe DAO creee
     */
    public static DAO getNiveauDAO() {
            return new NiveauDAO(conn);
        }

    /**
     * Initialise la DAO en fonction du type specifique
     * @return nouvelle instance de la classe DAO creee
     */
    public static DAO getPersonneDAO() {
            return new PersonneDAO(conn);
        }

    /**
     * Initialise la DAO en fonction du type specifique
     * @return nouvelle instance de la classe DAO creee
     */
    public static DAO getTrimestreDAO() {
            return new TrimestreDAO(conn);
        }
    }
