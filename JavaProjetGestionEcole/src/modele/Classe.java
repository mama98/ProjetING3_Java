/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe representant un des membres de la table Classe dans la base de donnees
 * @author Marine
 */
public class Classe {

    private int id;
    private String nom;
    private int id_AnneeScolaire;
    private int id_Ecole;
    private int id_Niveau;

    /**
     * Constructeur par defaut de la classe Classe
     */
    public Classe()
    {
        id=0;
        nom=null;
        id_AnneeScolaire=0;
        id_Ecole=0;
        id_Niveau=0;
    }

    /**
     * Constructeur surcharge de la classe Classe
     * @param id Id de la Classe que l'on souhaite creer
     * @param nom Nom de la Classe que l'on souhaite creer
     * @param id_AnneeScolaire Id de l'AnneeScolaire de la Classe que l'on souhaite creer
     * @param id_Ecole Id de l'Ecole de la Classe que l'on souhaite creer
     * @param id_Niveau Id du Niveau de la Classe que l'on souhaite creer
     */
    public Classe(int id, String nom, int id_AnneeScolaire, int id_Ecole, int id_Niveau) {
        this.id = id;
        this.nom = nom;
        this.id_AnneeScolaire = id_AnneeScolaire;
        this.id_Ecole = id_Ecole;
        this.id_Niveau = id_Niveau;
    }

    /**
     *
     *
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     *
     *
     * @return 
     * @return  
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     *
     * @return 
     */
    public int getId_AnneeScolaire() {
        return id_AnneeScolaire;
    }

    /**
     *
     *
     * @return 
     * @return  
     */
    public int getId_Ecole() {
        return id_Ecole;
    }

    /**
     *
     *
     * @return 
     * @return  
     */
    public int getId_Niveau() {
        return id_Niveau;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @param id_AnneeScolaire
     */
    public void setId_AnneeScolaire(int id_AnneeScolaire) {
        this.id_AnneeScolaire = id_AnneeScolaire;
    }

    /**
     *
     * @param id_Ecole
     */
    public void setId_Ecole(int id_Ecole) {
        this.id_Ecole = id_Ecole;
    }

    /**
     *
     * @param id_Niveau
     */
    public void setId_Niveau(int id_Niveau) {
        this.id_Niveau = id_Niveau;
    }


}
