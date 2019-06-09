/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe representant un des membres de la table Niveau dans la base de donnees
 * @author Marine
 */
public class Niveau {

    private int id;
    private String nom;

    /**
     *
     */
    public Niveau()
    {
        id=0;
        nom=null;
    }

    /**
     *
     * @param id
     * @param nom
     */
    public Niveau(int id, String nom) {
        this.id = id;
        this.nom=nom;
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
    public String getNom() {
        return nom;
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




}
