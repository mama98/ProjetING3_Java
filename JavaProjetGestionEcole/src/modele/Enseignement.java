/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.logging.Logger;

/**
 * Classe representant un des membres de la table Enseignement dans la base de donnees
 * @author Marine
 */
public class Enseignement{
    private int id;
    private int id_Classe;
    private int id_Discipline;
    private int id_Personne;

    /**
     *
     */
    public Enseignement(){
        id = 0;
        id_Discipline = 0;
        id_Classe = 0;
        id_Personne = 0;
    }

    /**
     *
     * @param id
     * @param id_Classe
     * @param id_Discipline
     * @param id_Personne
     */
    public Enseignement(int id, int id_Classe, int id_Discipline, int id_Personne){
        this.id = id;
        this.id_Discipline = id_Discipline;
        this.id_Classe = id_Classe;
        this.id_Personne = id_Personne;
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
        this.id  = id;
    }

    /**
     *
     *
     */
    public int getId_Classe(){
        return this.id_Classe;
    }

    /**
     *
     * @param id_Classe
     */
    public void setId_Classe(int id_Classe){
        this.id_Classe = id_Classe;
    }

    /**
     *
     *
     */
    public int getId_Discipline(){
        return this.id_Discipline;
    }

    /**
     *
     * @param id_Discipline
     */
    public void setId_Discipline(int id_Discipline){
        this.id_Discipline = id_Discipline;
    }

    /**
     *
     *
     */
    public int getId_Personne(){
        return this.id_Personne;
    }

    /**
     *
     * @param id_Personne
     */
    public void setId_Personne(int id_Personne){
        this.id_Personne = id_Personne;
    }
}
