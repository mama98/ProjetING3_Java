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
public class Inscription {
    private int id;
    private int id_Classe;
    private int id_Personne;
    
    public Inscription()
    {
        id=0;
        id_Classe=0;
        id_Personne=0;
    }

    public Inscription(int id, int id_Classe, int id_Personne) {
        this.id = id;
        this.id_Classe = id_Classe;
        this.id_Personne = id_Personne;
    }

    public int getId() {
        return id;
    }

    public int getId_Classe() {
        return id_Classe;
    }

    public int getId_Personne() {
        return id_Personne;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_Classe(int id_Classe) {
        this.id_Classe = id_Classe;
    }

    public void setId_Personne(int id_Personne) {
        this.id_Personne = id_Personne;
    }
    
    
}
