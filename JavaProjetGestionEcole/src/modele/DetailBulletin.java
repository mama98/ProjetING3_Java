/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.logging.Logger;

/**
 * Classe representant un des membres de la table DetailBulletin
 * @author Marine
 */
public class DetailBulletin{
    private int id;
    private String appreciation;
    private int id_Bulletin;
    private int id_Enseignement;

    /**
     *
     */
    public DetailBulletin(){
        id = 0;
        appreciation = null;
        id_Bulletin = 0;
        id_Enseignement = 0;
    }

    /**
     *
     * @param id
     * @param appreciation
     * @param id_Bulletin
     * @param id_Enseignement
     */
    public DetailBulletin(int id, String appreciation, int id_Bulletin, int id_Enseignement){
        this.id = id;
        this.appreciation = appreciation;
        this.id_Bulletin = id_Bulletin;
        this.id_Enseignement = id_Enseignement;
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
    public String getAppreciation(){
        return this.appreciation;
    }

    /**
     *
     * @param appreciation
     */
    public void setAppreciation(String appreciation){
        this.appreciation = appreciation;
    }

    /**
     *
     *
     */
    public int getId_Bulletin(){
        return this.id_Bulletin;
    }

    /**
     *
     * @param id_Bulletin
     */
    public void setId_Bulletin(int id_Bulletin){
        this.id_Bulletin = id_Bulletin;
    }

    /**
     *
     *
     */
    public int getId_Enseignement(){
        return this.id_Enseignement;
    }

    /**
     *
     * @param id_Enseignement
     */
    public void setId_Enseignement(int id_Enseignement){
        this.id_Enseignement = id_Enseignement;
    }
}
