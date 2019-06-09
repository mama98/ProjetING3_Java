/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 * Classe representant un des membres de la table Evaluation dans la base de donnees
 * @author Marine
 */
public class Evaluation {
    private int id;
    private float note;
    private String appreciation;
    private int id_DetailBulletin;

    /**
     *
     */
    public Evaluation()
    {
        id=0;
        note=0;
        appreciation=null;
        id_DetailBulletin=0;
    }

    /**
     *
     * @param id
     * @param note
     * @param appreciation
     * @param id_DetailBulletin
     */
    public Evaluation(int id, float note, String appreciation, int id_DetailBulletin) {
        this.id = id;
        this.note = note;
        this.appreciation = appreciation;
        this.id_DetailBulletin = id_DetailBulletin;
    }

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
    public float getNote() {
        return note;
    }

    /**
     *
     *
     */
    public String getAppreciation() {
        return appreciation;
    }

    /**
     *
     *
     */
    public int getId_DetailBulletin() {
        return id_DetailBulletin;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param note
     */
    public void setNote(int note) {
        this.note = note;
    }

    /**
     *
     * @param appreciation
     */
    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    /**
     *
     * @param id_DetailBulletin
     */
    public void setId_DetailBulletin(int id_DetailBulletin) {
        this.id_DetailBulletin = id_DetailBulletin;
    }

}
