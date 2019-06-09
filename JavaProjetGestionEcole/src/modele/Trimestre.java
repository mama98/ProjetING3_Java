/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe representant un des membres de la classe Trimestre dans la base de donnees
 * @author Marine 
 */
public class Trimestre {

    //Déclaration des attributs

    private int id;
    private int numero;
    private int debut;
    private int fin;
    private int id_AnneeScolaire;
    //Constructeurs:

    /**
     *
     */
    public Trimestre() {
        id = 0;
        numero = 0;
        debut = 0;
        fin = 0;
        id_AnneeScolaire =0;
    }

    /**
     *
     * @param id
     * @param numero
     * @param debut
     * @param fin
     * @param id_AnneeScolaire
     */
    public Trimestre(int id, int numero, int debut, int fin, int id_AnneeScolaire) {
        this.id = id;
        this.numero = numero;
        this.debut = debut;
        this.fin = fin;
        this.id_AnneeScolaire = id_AnneeScolaire;
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
    public int getNumero() {
        return numero;
    }

    /**
     *
     *
     */
    public int getDebut() {
        return debut;
    }

    /**
     *
     *
     */
    public int getFin() {
        return fin;
    }

    /**
     *
     *
     */
    public int getId_AnneeScolaire() {
        return id_AnneeScolaire;
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
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     *
     * @param debut
     */
    public void setDebut(int debut) {
        this.debut = debut;
    }

    /**
     *
     * @param fin
     */
    public void setFin(int fin) {
        this.fin = fin;
    }

    /**
     *
     * @param id_AnneeScolaire
     */
    public void setId_AnneeScolaire(int id_AnneeScolaire) {
        this.id_AnneeScolaire = id_AnneeScolaire;
    }

}
