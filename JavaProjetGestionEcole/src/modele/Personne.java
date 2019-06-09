/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.logging.Logger;

/**
 * Classe representant un des membres de la table Personne dans la base de donnees
 * @author Marine
 */
public class Personne{
    private int id;
    private String nom;
    private String prenom;
    private String login;
    private String password;
    private int type_Enseignant;

    /**
     *
     */
    public Personne(){
        id = 0;
        nom = null;
        prenom = null;
        login = null;
        password = null;
        type_Enseignant=0;
    }

    /**
     *
     * @param id
     * @param nom
     * @param prenom
     * @param login
     * @param password
     * @param type_Enseignant
     */
    public Personne(int id, String nom, String prenom, String login, String password, int type_Enseignant){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.type_Enseignant = type_Enseignant;
    }

    /**
     *
     *
     */
    public int getId(){
        return this.id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     *
     *
     */
    public String getNom(){
        return this.nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom){
        this.nom = nom;
    }

    /**
     *
     *
     */
    public String getPrenom(){
        return this.prenom;
    }

    /**
     *
     * @param prenom
     */
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    /**
     *
     *
     */
    public String getLogin(){
        return this.login;
    }

    /**
     *
     * @param login
     */
    public void setLogin(String login){
        this.login = login;
    }

    /**
     *
     *
     */
    public String getPassword(){
        return this.password;
    }

    /**
     *
     *
     */
    public boolean getType_Enseignant(){
        return (this.type_Enseignant == 1);
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     *
     * @param type_Enseignant
     */
    public void setType_Enseignant(boolean type_Enseignant) {
        if(type_Enseignant)
            this.type_Enseignant = 1;
        else
            this.type_Enseignant = 0;
    }

}
