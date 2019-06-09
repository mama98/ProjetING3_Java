/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe representant une anee scolaire dans la base de donnees
 * @author Marine
 */
public class AnneeScolaire {

    private int id;

    /**
     * Instancie un nouvel objet de la classe AnneeScolaire
     */
    public AnneeScolaire() {
         id=0;
    }

    /**
     * Instancie un nouvel objet de la classe AnneeScolaire et assigne
     * this.id au parametre id
     * @param id Id de l'AnneeScolaire que l'on veut creer
     */
    public AnneeScolaire(int id) {
        this.id = id;
    }

    /**
     * Retourne l'id de l'AnneeScolaire
     *  attribut id de la classe
     */
    public int getId() {
        return id;
    }

    /**
     * Definis le parametre id de la classe
     * @param id Id que l'on veut attribuer a notre classe
     */
    public void setId(int id) {
        this.id = id;
    }
}
