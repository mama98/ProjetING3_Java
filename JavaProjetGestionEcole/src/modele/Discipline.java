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
public class Discipline {
    private int id;
    private String nom;

    public Discipline(){
        id = 0;
        nom = null;
    }

    public Discipline(int id, String nom){
        this.id = id;
        this.nom = nom;
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
}
