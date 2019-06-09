/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

/**
 * Exception soulevee lorsque la connection avec la base de donnees n'est pas possible
 * @author Sofia
 */
public class ConnectException extends Exception{

    /**
     * Override la methode getMessage de Exception afin de creer un message personnel
     * @return String du message d'erreur
     */
    @Override
    public String getMessage(){
        String erreur ="Erreur : Mot de passe ou identifiant invalide, veuillez réessayer ou creer un compte.";
        return erreur;
    }
}
