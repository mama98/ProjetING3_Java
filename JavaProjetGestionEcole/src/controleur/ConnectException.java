/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

/**
 *
 * @author Sofia
 */
public class ConnectException extends Exception{
    @Override
    public String getMessage(){
        String erreur ="Erreur : Mot de passe ou identifiant invalide, veuillez réessayer ou creer un compte.";
        return erreur;
    }
}
