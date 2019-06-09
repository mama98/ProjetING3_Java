/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe representant un element de la table Bulletin dans la base de donnees
 * @author Marine
 */
public class Bulletin {
    private int id;
    private String nom;
    private String appreciation;
    private int id_Trimestre;
    private int id_Inscription;

    /**
     * Constructeur par defaut de la classe, instancie simplement un nouveau
     * Bulletin et definis tous ses parametres comme nuls ou null
     */
    public Bulletin()
    {
        id=0;
        appreciation=null;
        id_Trimestre=0;
        id_Inscription=0;
    }

    /**
     * Constructeur surcharge de la classe Bulletin
     * @param id Id du bulletin que l'on cree
     * @param nom Nom du bulletin que l'on cree
     * @param appreciation Appreciations du bulletin que l'on cree
     * @param id_Trimestre Id du Trimestre du bulletin que l'on cree
     * @param id_Inscription Id de l'inscris du bulletin que l'on cree
     */
    public Bulletin(int id, String nom, String appreciation, int id_Trimestre, int id_Inscription) {
        this.id = id;
        this.appreciation = appreciation;
        this.id_Trimestre = id_Trimestre;
        this.id_Inscription = id_Inscription;
        this.nom = nom;
    }

    /**
     *
     *
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     *
     */
    public int getId() {
        return id;
    }

    /**
     *
     *
     */
    public String getAppreciation() {
        return appreciation;
    }

    /**
     *
     *
     */
    public int getId_Trimestre() {
        return id_Trimestre;
    }

    /**
     *
     *
     */
    public int getId_Inscription() {
        return id_Inscription;
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
     * @param appreciation
     */
    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    /**
     *
     * @param id_Trimestre
     */
    public void setId_Trimestre(int id_Trimestre) {
        this.id_Trimestre = id_Trimestre;
    }

    /**
     *
     * @param id_Inscription
     */
    public void setId_Inscription(int id_Inscription) {
        this.id_Inscription = id_Inscription;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
}
