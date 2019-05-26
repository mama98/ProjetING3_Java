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
public class Bulletin {
    private int id;
    private String appreciation;
    private int id_Trimestre;
    private int id_Inscription;
    
    public Bulletin()
    {
        id=0;
        appreciation=null;
        id_Trimestre=0;
        id_Inscription=0;
    }

    public Bulletin(int id, String appreciation, int id_Trimestre, int id_Inscription) {
        this.id = id;
        this.appreciation = appreciation;
        this.id_Trimestre = id_Trimestre;
        this.id_Inscription = id_Inscription;
    }

    public int getId() {
        return id;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public int getId_Trimestre() {
        return id_Trimestre;
    }

    public int getId_Inscription() {
        return id_Inscription;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public void setId_Trimestre(int id_Trimestre) {
        this.id_Trimestre = id_Trimestre;
    }

    public void setId_Inscription(int id_Inscription) {
        this.id_Inscription = id_Inscription;
    }
    
    
    
}
