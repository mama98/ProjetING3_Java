/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.logging.Logger;

/**
 *
 * @author Marine <ECE>
 */
public class Ecole {
    //Déclaration des attributs
    
    private int id;
    private String nom;
    
    //Constructeurs
    public Ecole()
    {
        id=0;
        nom=null;  
    }
    
    public Ecole(int id, String nom)
    {
        this.id = id;
        this.nom = nom;   
    }

    //Getters

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
    
    //Setters
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    

    
}
