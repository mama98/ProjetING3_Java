/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.logging.Logger;

/**
 * Classe representant un des membres de la table Ecole dans la base de donnees
 * @author Marine
 */
public class Ecole {
    //Déclaration des attributs

    private int id;
    private String nom;

    //Constructeurs

    /**
     *
     */
    public Ecole()
    {
        id=0;
        nom=null;
    }

    /**
     *
     * @param id
     * @param nom
     */
    public Ecole(int id, String nom)
    {
        this.id = id;
        this.nom = nom;
    }

    //Getters

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

    //Setters

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
