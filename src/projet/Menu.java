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
import java.util.*;
public class Menu {
    Scanner scan = new Scanner(System.in);
    GestionDip gest = new GestionDip();
    public void Accueil(){
        System.out.println("------------------------------------------- ");
        System.out.println("Choisir une fonctionalite  ");
        System.out.println("1--> Gestion des diplomes");
        System.out.println("2--> Gestion des promotions");
        System.out.println("3--> Quitter le programme");
        System.out.println("----------------------------------------------");
        try{
            
            int choix = scan.nextInt();
            if(choix == 1){
                Menu menu;
                menu = new Menu();
                menu.MenuDip();
            }
            else if(choix == 2){
               /* Menu menu;
                menu = new Menu();
                menu.MenuProm();*/
                GestionProm menu;
                menu = new GestionProm();
                menu.allProm();
            }
            else if(choix == 3){
               System.out.println("*-*FIN DE L'EXECUTION DU PROGRAMME*-*");
            }
            else {
                System.out.println("Faites un choix correct!");
                Menu menu;
                menu = new Menu();
                menu.Accueil();
            }
        }
        catch (InputMismatchException e){
            System.out.println("Entrer un chiffre!");
            Menu menu;
                menu = new Menu();
                menu.Accueil();
        }
    }
    
    public void MenuDip(){
        System.out.println("------------------------------------------- ");
        System.out.println("1--> Ajouter un diplome");
        System.out.println("2--> Modifier un diplome");
        System.out.println("3--> Supprimer un diplome");
        System.out.println("4--> Rechercher un diplome");
        System.out.println("5--> Afficher tous les diplomes");
        System.out.println("6--> Retour au menu principal");
        System.out.println("----------------------------------------------");
        
        try{
           
            int choix1 = scan.nextInt();
            if(choix1 == 1){
                Traitements traitements;
                traitements = new Traitements();
                traitements.ajouterDip();
            }
            else if(choix1 == 2){
                Traitements traitements;
                traitements = new Traitements();
                traitements.modifierDip();
            }
             else if(choix1 == 3){
                Traitements traitements;
                traitements = new Traitements();
                traitements.supprimerDip();
            }
              else if(choix1 == 4){
                Traitements traitements;
                traitements = new Traitements();
                traitements.rechercherDip();
            }
              else if(choix1 == 5){
                Traitements traitements;
                traitements = new Traitements();
                traitements.AllDip();
            }
               else if(choix1 == 6){
                Menu menu;
                menu = new Menu();
                menu.Accueil();
            }
            else {
                System.out.println("Faites un choix correct!");
                Menu menu;
                menu = new Menu();
                menu.MenuDip();
            }
        }
        catch (InputMismatchException e){
        System.out.println("Entrer un chiffre!");
        Menu menu;
                menu = new Menu();
                menu.MenuDip();
        }
    }
    
    
    
}
