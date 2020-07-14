/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

/**
 *
 * @author DERA
 */
public class Projet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){ 
        // connexion a la bdd
        Connexion connexion;
        connexion = new Connexion();
        connexion.accesConnexion();
        if (connexion.accesConnexion() == 1){//pas de connexion
        } else { // acces, on affiche le menu
            Menu menu;
            menu = new Menu();
            menu.Accueil();
        }
    }
    
}
