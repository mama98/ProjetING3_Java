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
public class Evaluation {
    private int id;
    private int note;
    private String appreciation;
    private int id_DetailBulletin;
    
    public Evaluation()
    {
        id=0;
        note=0;
        appreciation=null;
        id_DetailBulletin=0;
    }

    public Evaluation(int id, int note, String appreciation, int id_DetailBulletin) {
        this.id = id;
        this.note = note;
        this.appreciation = appreciation;
        this.id_DetailBulletin = id_DetailBulletin;
    }

    public int getId() {
        return id;
    }

    public int getNote() {
        return note;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public int getId_DetailBulletin() {
        return id_DetailBulletin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public void setId_DetailBulletin(int id_DetailBulletin) {
        this.id_DetailBulletin = id_DetailBulletin;
    }
    
}
