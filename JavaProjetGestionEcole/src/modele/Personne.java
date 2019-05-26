/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.logging.Logger;

/**
 *
 * @author Marine
 */
public class Personne{
    private int id;
    private String nom;
    private String prenom;
    private String login;
    private String password;
    private boolean type_Enseignant;

    public Personne(){
        id = 0;
        nom = null;
        prenom = null;
        login = null;
        password = null;
        type_Enseignant=false;
    }

    public Personne(int id, String nom, String prenom, String login, String password, boolean type_Enseignant){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
    }

    public boolean isType_Enseignant() {
        return type_Enseignant;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNom(){
        return this.nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getPrenom(){
        return this.prenom;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public String getLogin(){
        return this.login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setType_Enseignant(boolean type_Enseignant) {
        this.type_Enseignant = type_Enseignant;
    }
    
}
