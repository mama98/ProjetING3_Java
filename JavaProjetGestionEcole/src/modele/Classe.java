/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Marine <ECE>
 */
public class Classe {
    
    private int id;
    private String nom;
    private int id_AnneeScolaire;
    private int id_Ecole;
    private int id_Niveau;
    
    public Classe()
    {
        id=0;
        nom=null;
        id_AnneeScolaire=0;
        id_Ecole=0;
        id_Niveau=0;
    }

    public Classe(int id, String nom, int id_AnneeScolaire, int id_Ecole, int id_Niveau) {
        this.id = id;
        this.nom = nom;
        this.id_AnneeScolaire = id_AnneeScolaire;
        this.id_Ecole = id_Ecole;
        this.id_Niveau = id_Niveau;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getId_AnneeScolaire() {
        return id_AnneeScolaire;
    }

    public int getId_Ecole() {
        return id_Ecole;
    }

    public int getId_Niveau() {
        return id_Niveau;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId_AnneeScolaire(int id_AnneeScolaire) {
        this.id_AnneeScolaire = id_AnneeScolaire;
    }

    public void setId_Ecole(int id_Ecole) {
        this.id_Ecole = id_Ecole;
    }

    public void setId_Niveau(int id_Niveau) {
        this.id_Niveau = id_Niveau;
    }
    
    
}
