/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.*;

/**
 *
 * @author DERA
 */
public class Traitements {//extends Connexion{
    GestionDip gest = new GestionDip();
    Scanner scan = new Scanner(System.in);
    String ev = "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";

    String url = "jdbc:mysql://localhost/gestion"+ ev;
    String login = "root";
    String pass = "";

    Connection con = null;
    Statement st = null;
    private ResultSet resultMat;
    private int executed, executed1,executed2, executed3, executed4, executed5, executed6, executed7, executed8, executed9;
    
    public void ajouterDip(){
        try{
            System.out.println("------------------------------------------- ");
            System.out.println("---Ajouter un diplomé");
            System.out.println("**Informations d'identification**");
            System.out.println("Matricule: ");
            gest.setMatricule(scan.nextLine());
            System.out.println("Nom: ");
            gest.setNom(scan.nextLine());
            System.out.println("Prenom: ");
            gest.setPrenom(scan.nextLine());
            System.out.println("Sexe: ");
            gest.setSexe(scan.nextLine());
            System.out.println("-------- ");
            System.out.println("**Informations academiques** ");
            System.out.println("Diplome(s) //Taper L ou l pour la licence, M ou m pour le master, et N ou n si " +gest.getNom() +" "+ gest.getPrenom() +" " + "possede les 2 diplomes: ");
            String dip = scan.nextLine();scan.nextLine();
            switch (dip) {
                case "l":
                case "L":
                    {   
                         gest.setPossedeL(1);
                         gest.setPossedeM(0);
                        System.out.println("Filiere de la licence: ");
                        gest.setFiliereL(scan.nextLine());
                        System.out.println("Annee d'obtention de la licence: "); // promotionAnnee = anneObetntion
                        gest.setAnneeObtentionL(scan.nextInt());
                        System.out.println("Note a la soutenance de la licence: ");
                        gest.setNoteSoutenanceL(scan.nextFloat());
                        break;
                    }
                case "m":
                case "M":
                    {   
                        gest.setPossedeL(0);
                        gest.setPossedeM(1);
                        System.out.println("Filiere du Mater: ");
                        
                        gest.setFiliereM(scan.nextLine());
                        System.out.println("Annee d'obtention du Master: "); // promotionAnnee = anneObetntion
                        
                        gest.setAnneeObtentionM(scan.nextInt());
                        System.out.println("Note a la soutenance du Master: ");
                        
                        gest.setNoteSoutenanceM(scan.nextFloat());
                        break;
                    }
                case "n":
                case "N":
                    {
                         gest.setPossedeL(1);
                        gest.setPossedeM(1);
                        System.out.println("Informations sur la licence ");
                        System.out.println("Filiere de la licence: ");
                        
                        gest.setFiliereL(scan.nextLine());
                        System.out.println("Annee d'obtention de la licence: "); // promotionAnnee = anneObetntion
                       
                        gest.setAnneeObtentionL(scan.nextInt());
                        System.out.println("Note a la soutenance de la licence: ");
                       
                        gest.setNoteSoutenanceL(scan.nextFloat());
                        System.out.println("Informations sur le master ");
                        String testerr = scan.nextLine();
                        System.out.println("Filiere du master: ");
                      
                        gest.setFiliereM(scan.nextLine());
                        System.out.println("Annee d'obtention du master: "); // promotionAnnee = anneObetntion
                        
                        gest.setAnneeObtentionM(scan.nextInt());
                        System.out.println("Note a la soutenance du master: ");
                        
                        gest.setNoteSoutenanceM(scan.nextFloat());
                        break;
                    }
                default:
                    System.out.println("Faites un choix correct");
                    break;
            }
           
           
          
            System.out.println("------ ");
           
            System.out.println("Les informations sur l'adresse");
  
                System.out.println("**Adresses** ");
                String tester = scan.nextLine();
                
                System.out.println("Email: ");
                
                gest.setEmail(scan.nextLine());
                System.out.println("Telephone: ");
                
                gest.setTelephone(scan.nextLine());
                System.out.println("Lieu de residence: ");
                
                gest.setLieuResidence(scan.nextLine());
            
            
            
            System.out.println("------ ");
            System.out.println("Taper o ou O pour remplir les informations sur le travail, une autre lettre si non");
          
                System.out.println("**Travail** ");
                System.out.println("Possede un travail?: [O/N] ");
                String posseTravail = scan.nextLine();scan.nextLine();
                gest.setPossedeTravail(0); // par defaut
                if (posseTravail.equals ("o") || posseTravail.equals("O")){
                    gest.setPossedeTravail(1);
                    System.out.println("Poste actuel: ");
                    gest.setPosteActuel(scan.nextLine());
                    
                    System.out.println("Lieu de travail: ");
                    gest.setLieuTravail(scan.nextLine());
                   
                }
            
            System.out.println("------ ");
            System.out.println("Traitements des informations en cours... ");
        
            // insertion infos personnelles
            try {
                // Chargement du driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // recuperation de la connection

                con = DriverManager.getConnection(url,login, pass);
                // creation d'un statement
                st = con.createStatement();
                // insertion
          
                executed = st.executeUpdate("INSERT INTO etudiant(matricule, nom, prenom, sexe) VALUES('"+gest.getMatricule()+"','"+gest.getNom()+"','"+gest.getPrenom()+"','"+gest.getSexe()+"')");
                 if (executed==0){
                     System.out.println("Erreur d'ajout des informations personnelles ");
                 } 
                 
                 executed4 = st.executeUpdate("INSERT INTO adresse(matricule, telephone, email, lieuResidence) VALUES('"+gest.getMatricule()+"','"+gest.getTelephone()+"','"+gest.getEmail()+"','"+gest.getLieuResidence()+"')");
                 if (executed4==0){
                     System.out.println("Erreur d'ajout des informations sur l'adresse ");
                 } 
                 
                 executed5 = st.executeUpdate("INSERT INTO travail(matricule, posteActuel, lieuTravail, possedeTravail) VALUES('"+gest.getMatricule()+"','"+gest.getPosteActuel()+"','"+gest.getLieuTravail()+"','"+gest.getPossedeTravail()+"')");
                 if (executed5==0){
                     System.out.println("Erreur d'ajout des informations personnelles ");
                 }
                 
                if (gest.getPossedeL()==1 && gest.getPossedeM()==0){
                      if(gest.getAnneeObtentionL() < 2003 || gest.getAnneeObtentionL()> 2019){
                             System.out.println("Attention l'annee Obtention du diplome est incorrect!");
               
                         }
                    executed1 = st.executeUpdate("INSERT INTO diplome(matricule, filiereL, noteSoutenanceL, promotionAnnee, anneeObtentionL,  detientLicence, detientMaster) VALUES('"+gest.getMatricule()+"','"+gest.getFiliereL() +"','"+gest.getNoteSoutenanceL() +"','"+gest.getAnneeObtentionL() +"','"+gest.getAnneeObtentionL() +"','"+gest.getPossedeL()+"','"+gest.getPossedeM()+"')");
                    if (executed1==0){
                        System.out.println("Erreur d'ajout des informations academiques ");
                    } 
                } 
                else if(gest.getPossedeL()==0 && gest.getPossedeM()==1){
                     if(gest.getAnneeObtentionM() < 2003 || gest.getAnneeObtentionM()> 2019){
                            System.out.println("Attention l'annee Obtention du diplome est incorrect!");
                            }
                    executed2 = st.executeUpdate("INSERT INTO diplome(matricule, filiereM, noteSoutenanceM, promotionAnnee, anneeObtentionM,  detientLicence, detientMaster) VALUES('"+gest.getMatricule() +"','"+gest.getFiliereM() +"','"+gest.getNoteSoutenanceM() +"','"+gest.getAnneeObtentionM() +"','"+gest.getAnneeObtentionM() +"','"+gest.getPossedeL()+"','"+gest.getPossedeM()+"')");
                    if (executed2==0){
                        System.out.println("Erreur d'ajout des informations academiques");
                    } 
                
                } else if (gest.getPossedeL()==1 && gest.getPossedeM()==1){
                    if(gest.getAnneeObtentionL() < 2003 || gest.getAnneeObtentionL()> 2019){
                             System.out.println("Attention l'annee Obtention du diplpme est incorrect!");
               
                         }
                     if(gest.getAnneeObtentionM() < 2003 || gest.getAnneeObtentionM()> 2019){
                            System.out.println("Attention l'annee Obtention du diplpme est incorrect!");
                            }
                    executed3 = st.executeUpdate("INSERT INTO diplome(matricule, filiereL, noteSoutenanceL,promotionAnnee, anneeObtentionL, filiereM, noteSoutenanceM, anneeObtentionM,  detientLicence, detientMaster) VALUES('"+gest.getMatricule() +"','"+gest.getFiliereL() +"','"+gest.getNoteSoutenanceL() +"','"+gest.getAnneeObtentionM() +"','"+gest.getAnneeObtentionL() +"','"+gest.getFiliereM()+"','"+gest.getNoteSoutenanceM() +"','"+gest.getAnneeObtentionM() +"','"+gest.getPossedeL()+"','"+gest.getPossedeM()+"')");
                    if (executed3==0){
                        System.out.println("Erreur d'ajout des informations academiques ");
                    }   
                }else System.out.println("Erreur d'ajout des informations academiques ");
                
                System.out.println("Toutes les informations de "+gest.getNom() +" "+ gest.getPrenom() +" " + "ont ete enregistre avec succes! ");

                 
             }
             catch(SQLException | ClassNotFoundException e){
                 System.out.println("******ATTENTION CETTE MATRICULE EXISTE DEJA********** ");
                
                 Menu menu;
                menu = new Menu();
                menu.MenuDip();
             }
            //insertions infos academiques
            
            
        }
        catch (InputMismatchException e){
        System.out.println("Entrer un type correct"); 
                 Menu menu;
                menu = new Menu();
                menu.MenuDip();
        }
        

                Menu menu;
                menu = new Menu();
                menu.MenuDip();
    }
    
    
    public void modifierDip(){
        System.out.println("--------------------------------------- ");
        System.out.println("****Mofiider un diplomé********");
        System.out.println("Entrer le matricule du diplomé");
        gest.setMatricule(scan.nextLine());
        
        try {
                // Chargement du driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // recuperation de la connection

                con = DriverManager.getConnection(url,login, pass);
                // creation d'un statement
                st = con.createStatement();
        
                
                        System.out.println("Quelles informations voulez vous modifier?");
                        System.out.println("1--> Informations personnelles");
                        
                        System.out.println("2--> Toutes les informations");
                       
               
                
                
                try{
            
            int choix1 = scan.nextInt();
            if(choix1 == 1){
            System.out.println("**Informations d'identification**");
            String tutu = scan.nextLine();
           
            System.out.println("Nom: ");
            gest.setNom(scan.nextLine());
            System.out.println("Prenom: ");
            gest.setPrenom(scan.nextLine());
            System.out.println("Sexe: ");
            gest.setSexe(scan.nextLine());
            System.out.println("-------- ");
            //executed = st.executeUpdate("UPDATE etudiant SET  nom=?,prenom=?,sexe=? WHERE matricule=?");
            String exec = "UPDATE etudiant SET  nom=?,prenom=?,sexe=? WHERE matricule=?";
            PreparedStatement preparedStatement = con.prepareStatement(exec);
            preparedStatement.setString(1, gest.getNom());
            preparedStatement.setString(2, gest.getPrenom());
            preparedStatement.setString(3, gest.getSexe());
             preparedStatement.setString(4, gest.getMatricule());
             executed = preparedStatement.executeUpdate();
           
                 if (executed==0){
                     System.out.println("Erreur d'ajout des informations personnelles ");
                 } else System.out.println("Les informations personnelles ont ete modifie avec succes ");
                 
                
            }
            
            
              else if(choix1 == 2){
                  System.out.println(" ");
            String test2 = scan.nextLine();
                System.out.println("Nom: ");
            gest.setNom(scan.nextLine());
            System.out.println("Prenom: ");
            gest.setPrenom(scan.nextLine());
            System.out.println("Sexe: ");
            gest.setSexe(scan.nextLine());
            System.out.println("-------- ");
            System.out.println("**Informations academiques** ");
            System.out.println("Diplome(s) //Taper L ou l pour la licence, M ou m pour le master, et N ou n si " +gest.getNom() +" "+ gest.getPrenom() +" " + "possede les 2 diplomes: ");
            String dip = scan.nextLine();scan.nextLine();
            switch (dip) {
                case "l":
                case "L":
                    {   
                         gest.setPossedeL(1);
                         gest.setPossedeM(0);
                        System.out.println("Filiere de la licence: ");
                        gest.setFiliereL(scan.nextLine());
                        System.out.println("Annee d'obtention de la licence: "); // promotionAnnee = anneObetntion
                        gest.setAnneeObtentionL(scan.nextInt());
                        System.out.println("Note a la soutenance de la licence: ");
                        gest.setNoteSoutenanceL(scan.nextFloat());
                        break;
                    }
                case "m":
                case "M":
                    {   
                        gest.setPossedeL(1);
                        gest.setPossedeM(0);
                        System.out.println("Filiere du Mater: ");
                        
                        gest.setFiliereM(scan.nextLine());
                        System.out.println("Annee d'obtention du Master: "); // promotionAnnee = anneObetntion
                        
                        gest.setAnneeObtentionM(scan.nextInt());
                        System.out.println("Note a la soutenance du Master: ");
                        
                        gest.setNoteSoutenanceM(scan.nextFloat());
                        break;
                    }
                case "n":
                case "N":
                    {
                         gest.setPossedeL(1);
                        gest.setPossedeM(1);
                        System.out.println("Informations sur la licence ");
                        System.out.println("Filiere de la licence: ");
                        
                        gest.setFiliereL(scan.nextLine());
                        System.out.println("Annee d'obtention de la licence: "); // promotionAnnee = anneObetntion
                       
                        gest.setAnneeObtentionL(scan.nextInt());
                        System.out.println("Note a la soutenance de la licence: ");
                       
                        gest.setNoteSoutenanceL(scan.nextFloat());
                        System.out.println("Informations sur le master ");
                        String testerr = scan.nextLine();
                        System.out.println("Filiere du master: ");
                      
                        gest.setFiliereM(scan.nextLine());
                        System.out.println("Annee d'obtention du master: "); // promotionAnnee = anneObetntion
                        
                        gest.setAnneeObtentionM(scan.nextInt());
                        System.out.println("Note a la soutenance du master: ");
                        
                        gest.setNoteSoutenanceM(scan.nextFloat());
                        break;
                    }
                default:
                    System.out.println("Faites un choix correct");
                    break;
            }
           
           
          
            System.out.println("------ ");
          
            System.out.println("Les informations sur l'adresse");
  
                System.out.println("**Adresses** ");
                String tester = scan.nextLine();
                
                System.out.println("Email: ");
                
                gest.setEmail(scan.nextLine());
                System.out.println("Telephone: ");
                
                gest.setTelephone(scan.nextLine());
                System.out.println("Lieu de residence: ");
                
                gest.setLieuResidence(scan.nextLine());
            
            
            
                System.out.println("**Travail** ");
                System.out.println("Possede un travail?: [O/N] ");
                String posseTravail = scan.nextLine();scan.nextLine();
                gest.setPossedeTravail(0); // par defaut
                if (posseTravail.equals ("o") || posseTravail.equals("O")){
                    gest.setPossedeTravail(1);
                    System.out.println("Poste actuel: ");
                    gest.setPosteActuel(scan.nextLine());
                    
                    System.out.println("Lieu de travail: ");
                    gest.setLieuTravail(scan.nextLine());
                   
                }
             String exec = "UPDATE etudiant SET  nom=?,prenom=?,sexe=? WHERE matricule=?";
            PreparedStatement preparedStatement = con.prepareStatement(exec);
            preparedStatement.setString(1, gest.getNom());
            preparedStatement.setString(2, gest.getPrenom());
            preparedStatement.setString(3, gest.getSexe());
             preparedStatement.setString(4, gest.getMatricule());
             executed = preparedStatement.executeUpdate();
             if (executed==0){
                     System.out.println("Erreur d'ajout des informations personnelles ");
                 } 
               if (gest.getPossedeL()==1 && gest.getPossedeM()==0){
                      if(gest.getAnneeObtentionL() < 2003 || gest.getAnneeObtentionL()> 2019){
                             System.out.println("Attention l'annee Obtention du diplome est incorrect!");
               
                         }else{
                   String exect1 = "UPDATE diplome SET  filiereL= ?, noteSoutenanceL=?, promotionAnnee= ?, anneeObtentionL=?, detientLicence= ?, detientMaster= ? WHERE matricule = ?";
                    
                    PreparedStatement preparedStatementt = con.prepareStatement(exect1);
                    preparedStatementt.setString(1, gest.getFiliereL());
                    preparedStatementt.setFloat(2, gest.getNoteSoutenanceL());
                    preparedStatementt.setInt(3, gest.getAnneeObtentionL());
                     preparedStatementt.setInt(4, gest.getAnneeObtentionL());
                      preparedStatementt.setInt(5, gest.getDetientLicence());
                     preparedStatementt.setInt(6, gest.getDetientMaster());
                      preparedStatementt.setString(7, gest.getMatricule());
                     executed1 = preparedStatementt.executeUpdate();
                    
                    
                    
                    if (executed1==0){
                        System.out.println("Erreur de modifications des informations academiques ");
                    } else System.out.println("Les informations academiques  ont ete modifie avec succes");
                      }
                } 
                else if(gest.getPossedeL()==0 && gest.getPossedeM()==1){
                     if(gest.getAnneeObtentionM() < 2003 || gest.getAnneeObtentionM()> 2019){
                            System.out.println("Attention l'annee Obtention du diplome est incorrect!");
                            }else{
                    String exec3 = "UPDATE diplome SET  filiereM= ?, noteSoutenanceM=?, promotionAnnee= ?, anneeObtentionM=?,  detientLicence=?, detientMaster= ? WHERE matricule = ?";
                   
                    PreparedStatement preparedStatement2 = con.prepareStatement(exec3);
                    preparedStatement2.setString(1, gest.getFiliereM());
                    preparedStatement2.setFloat(2, gest.getNoteSoutenanceM());
                    preparedStatement2.setInt(3, gest.getAnneeObtentionM());
                     preparedStatement2.setInt(4, gest.getAnneeObtentionM());
                      preparedStatement2.setInt(5, gest.getDetientLicence());
                     preparedStatement2.setInt(6, gest.getDetientMaster());
                      preparedStatement2.setString(7, gest.getMatricule());
                     executed2 = preparedStatement2.executeUpdate();
                    
                    
                    if (executed2==0){
                        System.out.println("Erreur d'ajout des informations academiques");
                    } else System.out.println("Les informations academiques  ont ete modifie avec succes");
                     }
                } else if (gest.getPossedeL()==1 && gest.getPossedeM()==1){
                    if(gest.getAnneeObtentionL() < 2003 || gest.getAnneeObtentionL()> 2019){
                             System.out.println("Attention l'annee Obtention du diplpme est incorrect!");
               
                         }
                    else if(gest.getAnneeObtentionM() < 2003 || gest.getAnneeObtentionM()> 2019){
                            System.out.println("Attention l'annee Obtention du diplpme est incorrect!");
                            }else{
                    String exec6 = "UPDATE diplome SET   filiereL= ?, anneeObtentionL=?, noteSoutenanceL= ? , promotionAnnee= ?,filiereM=?, noteSoutenanceM= ?, anneeObtentionM=?,  detientLicence=?, detientMaster= ? WHERE matricule = ?";
                    
                    PreparedStatement preparedStatement6 = con.prepareStatement(exec6);
                    preparedStatement6.setString(1, gest.getFiliereL());
                    preparedStatement6.setInt(2, gest.getAnneeObtentionL());
                    preparedStatement6.setFloat(2, gest.getNoteSoutenanceL());
                    preparedStatement6.setInt(3, gest.getAnneeObtentionM());
                      preparedStatement6.setString(4, gest.getFiliereM());
                    preparedStatement6.setFloat(5, gest.getNoteSoutenanceM());
                     preparedStatement6.setInt(6, gest.getAnneeObtentionM());
                      preparedStatement6.setInt(7, gest.getDetientLicence());
                     preparedStatement6.setInt(8, gest.getDetientMaster());
                      preparedStatement6.setString(9, gest.getMatricule());
                     executed3 = preparedStatement6.executeUpdate();
                    
                    
                    if (executed3==0){
                        System.out.println("Erreur d'ajout des informations academiques ");
                    }   
                }
                }else System.out.println("Erreur d'ajout des informations academiques ");
                 
            
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
                  System.out.println("----------------------------------------------");
        }
        catch(SQLException | ClassNotFoundException e){
                System.out.println("**************ATTENTION CETTE MATRICULE N'EXISTE PAS************ ");       
           
             }
                 Menu menu;
                menu = new Menu();
                menu.MenuDip();
       
    }
    
    
    public void supprimerDip(){
        System.out.println("------------------------------------------- ");
        
        System.out.println("****Supprimer un diplomé*******");
        System.out.println("Entrer le matricule du diplomé");
        gest.setMatricule(scan.nextLine());
        
        
        try {
                // Chargement du driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // recuperation de la connection
                con = DriverManager.getConnection(url,login, pass);
                // creation d'un statement
                st = con.createStatement();
         System.out.println("Confirmer la suppression? [O/N]");
          String rempB = scan.nextLine();scan.nextLine();
            if (rempB.equals("o")  || rempB.equals("O")) {
                // delete
                
                executed6 = st.executeUpdate("DELETE FROM etudiant WHERE matricule="+gest.getMatricule()+"");
                executed7 = st.executeUpdate("DELETE FROM diplome WHERE matricule="+gest.getMatricule()+"");
                executed8 = st.executeUpdate("DELETE FROM travail WHERE matricule="+gest.getMatricule()+"");
                executed9 = st.executeUpdate("DELETE FROM adresse WHERE matricule="+gest.getMatricule()+"");
                    if (executed6==0 || executed7==0 || executed8==0 || executed9==0){
                        System.out.println("Erreur d'ajout des informations academiques ");
                    }  else  System.out.println("Le diplome a ete supprime avec succes");
            }
        }
        catch(SQLException | ClassNotFoundException e){
                 System.out.println("**************ATTENTION CETTE MATRICULE N'EXISTE PAS************ ");       
             }
        
                 Menu menu;
                menu = new Menu();
                menu.MenuDip();
       
        
        
    }
    
    
    public void rechercherDip(){
        System.out.println("------------------------------------------- ");
        
        System.out.println("**** Rechercher un diplomé********");
        System.out.println("Entrer le matricule du diplomé");
        gest.setMatricule(scan.nextLine());
        
        
        try {
                // Chargement du driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // recuperation de la connection

                con = DriverManager.getConnection(url,login, pass);
                // creation d'un statement
                st = con.createStatement();
        
                //resultMat = st.executeQuery("SELECT * FROM etudiant  WHERE matricule ="+gest.getMatricule()+" INNER JOIN travail ON etudiant.matricule =travail.matricule");
               resultMat = st.executeQuery("SELECT * FROM etudiant, travail, adresse, diplome  WHERE etudiant.matricule = travail.matricule AND etudiant.matricule = adresse.matricule AND etudiant.matricule= diplome.matricule   ");
               
// resultMat1 = st.executeQuery("SELECT * FROM travail WHERE matricule ="+gest.getMatricule()+"");
                
              int x=1;
              String nom = null;
              String prenom=null;
                
                 String sexe=null;
                 String poste=null;
                 String phone =null;
                 String travail=null ;
                 String residence=null;
                 String mail =null;
                 String fl = null;
                 String fm = null;
                 int aol = 0;
                 int aom = 0;
                 int prom = 0;
                 int pot = 0;
                
                 int dl = 0;
                 int dm = 0;
                 while (resultMat.next())
                { String matriculet = resultMat.getString("matricule");
                     
                       if (gest.getMatricule().equals(matriculet)){
                        x = 1;
                         nom = resultMat.getString("nom");
                  prenom = resultMat.getString("prenom");
                
                 sexe = resultMat.getString("sexe");
                 poste = resultMat.getString("posteActuel");
                 phone = resultMat.getString("telephone");
                 travail = resultMat.getString("lieuTravail");
                 residence = resultMat.getString("lieuResidence");
                 mail = resultMat.getString("email");
                fl = resultMat.getString("filiereL");
                 fm = resultMat.getString("filiereM");
                 aol = resultMat.getInt("anneeObtentionL");
                 aom = resultMat.getInt("anneeObtentionM");
                 prom = resultMat.getInt("promotionAnnee");
                 pot = resultMat.getInt("possedeTravail");
               
                 
                  dl = resultMat.getInt("detientLicence");
                 dm = resultMat.getInt("detientMaster");
                  } else{
                       x = 0;
                       }
                           
                }
                 
                 if (x == 0)System.out.println("***********ATTENTION CETTE MATRICULE N'EXISTE PAS**************");
                 else {
                     System.out.println("Affichage des elements  ");
                     System.out.println("------------------------------------------- ");
                     
                     
                     
                     
                     System.out.println("********************************************");
                     System.out.println("******Informations personnelles*****");
                     System.out.println("***NOM***************Prenom****************Sexe**********Email*********** Telephone ***************Lieu de residence*****");
                     System.out.println("*****"+nom+"**************"+prenom+"***************"+sexe+"************"+mail+"*************"+phone+"******************"+residence+"******");
                     System.out.println("********************************************");
                     if (dl==1 && dm==0){
                         System.out.println("******Informations academiques*****");
                         System.out.println("-------Ce diplome possede uniquement la licence");
                         System.out.println("****Filiere de la licence*********Annee obtention***********Annee de promotion***************");
                         System.out.println("********"+fl+"****************************"+aol+"**********************"+prom+"*******************");
                         System.out.println("********************************************");
                     }else if(dl==0 && dm==1){
                         
                         System.out.println("******Informations academiques*****");
                         System.out.println("-------Ce diplome possede uniquement le master");
                         System.out.println("****Filiere du master*********Annee obtention***********Annee de promotion***************");
                         System.out.println("*******"+fm+"***********************"+aom+"***********************"+prom+"*******************");
                         System.out.println("********************************************");
                     }else if (dl==1 && dm==1){
                         System.out.println("******Informations academiques*****");
                         System.out.println("-------Ce diplome possede la licence et le master");
                         System.out.println("****Filiere licence*****Annee obtention  licence**************Filiere du master*******Annee obtention  master************Annee de promotion***************");
                         System.out.println("*******"+fl+"************************"+aol+"******************************"+fm+"********************************* "+aom+"*******************************"+prom+"*************************");
                     }
                     System.out.println("********************************************");
                     if (pot==1){
                         System.out.println("******Informations professionnelles*****");
                         System.out.println("***Poste Actuel*********Lieu de travail******************");
                         System.out.println("****"+poste+"********"+travail+"*******************");
                     }
                     else{
                         System.out.println("******Informations professionnelles*****");
                         
                         System.out.println("Ce diplome ne possede aucun travail pour le moment");
                         
                     }
                     
                     System.out.println("********************************************");
            }
                     
          
                  System.out.println("----------------------------------------------");
        }
        catch(SQLException | ClassNotFoundException e){
                 System.out.println("Erreur de conneexion a la base de donnee ");
                 System.out.println("----> Verifier que le serveur est demarre ");
             }
        
                 Menu menu;
                menu = new Menu();
                menu.MenuDip();
    }
    
    
    public void AllDip(){
        System.out.println("--------------------------------------- ");
        
        
        try {
                // Chargement du driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // recuperation de la connection

                con = DriverManager.getConnection(url,login, pass);
                // creation d'un statement
                st = con.createStatement();
        
                //resultMat = st.executeQuery("SELECT * FROM etudiant  WHERE matricule ="+gest.getMatricule()+" INNER JOIN travail ON etudiant.matricule =travail.matricule");
               resultMat = st.executeQuery("SELECT * FROM etudiant, travail, adresse, diplome  WHERE etudiant.matricule = travail.matricule AND etudiant.matricule = adresse.matricule AND etudiant.matricule= diplome.matricule   ");
               
// resultMat1 = st.executeQuery("SELECT * FROM travail WHERE matricule ="+gest.getMatricule()+"");
                
              int i = 1;
              String nom = null;
              String prenom=null;
                String matricule =null;
                 String sexe=null;
                 String poste=null;
                 String phone =null;
                 String travail=null ;
                 String residence=null;
                 String mail =null;
                 String fl = null;
                 String fm = null;
                 int aol = 0;
                 int aom = 0;
                 int prom = 0;
                 int pot = 0;
                
                 int dl = 0;
                 int dm = 0;
                 while (resultMat.next())
                { 
                   
                         nom = resultMat.getString("nom");
                  prenom = resultMat.getString("prenom");
                matricule = resultMat.getString("matricule");
                 sexe = resultMat.getString("sexe");
                 poste = resultMat.getString("posteActuel");
                 phone = resultMat.getString("telephone");
                 travail = resultMat.getString("lieuTravail");
                 residence = resultMat.getString("lieuResidence");
                 mail = resultMat.getString("email");
                fl = resultMat.getString("filiereL");
                 fm = resultMat.getString("filiereM");
                 aol = resultMat.getInt("anneeObtentionL");
                 aom = resultMat.getInt("anneeObtentionM");
                 prom = resultMat.getInt("promotionAnnee");
                 pot = resultMat.getInt("possedeTravail");
               
                 
                  dl = resultMat.getInt("detientLicence");
                 dm = resultMat.getInt("detientMaster");
                 
                
                     System.out.println("Affichage des informations du diplome numero  "+i+"");
                  System.out.println("------------------------------------------- ");
                  
                 
            System.out.println("********************************************");
            System.out.println("******Informations personnelles*****");
            System.out.println("**Matricule***********Nom***************Prenom****************Sexe**********Email*********** Telephone ***************Lieu de residence*****");
            System.out.println("*******"+matricule+"************"+nom+"**************"+prenom+"***************"+sexe+"************"+mail+"*************"+phone+"******************"+residence+"******");
            System.out.println("********************************************");
           if (dl==1 && dm==0){
            System.out.println("******Informations academiques*****");
            System.out.println("-------Ce diplome possede uniquement la licence");
            System.out.println("****Filiere de la licence*********Annee obtention***********Annee de promotion***************");
            System.out.println("********"+fl+"****************************"+aol+"**********************"+prom+"*******************");
            System.out.println("********************************************");
            }else if(dl==0 && dm==1){
            
            System.out.println("******Informations academiques*****");
            System.out.println("-------Ce diplome possede uniquement le master");
            System.out.println("****Filiere du master*********Annee obtention***********Annee de promotion***************");
            System.out.println("*******"+fm+"***********************"+aom+"***********************"+prom+"*******************");
            System.out.println("********************************************");
            }else if (dl==1 && dm==1){
            System.out.println("******Informations academiques*****");
            System.out.println("-------Ce diplome possede la licence et le master");
            System.out.println("****Filiere licence*****Annee obtention  licence**************Filiere du master*******Annee obtention  master************Annee de promotion***************");
            System.out.println("*******"+fl+"************************"+aol+"******************************"+fm+"********************************* "+aom+"*******************************"+prom+"*************************");
            }
            System.out.println("********************************************");
            if (pot==1){
            System.out.println("******Informations professionnelles*****");
            System.out.println("***Poste Actuel*********Lieu de travail******************");
            System.out.println("****"+poste+"********"+travail+"*******************");
            }
            else{
            System.out.println("******Informations professionnelles*****");
            
            System.out.println("Ce diplome ne possede aucun travail pour le moment");
            
            }
            
            System.out.println("********************************************");
        
          
                  System.out.println("---------------------------------------");
                    i++;
                }
                 
                 
               System.out.println("********************Fin de l'affichage des informations************************");
               System.out.println(""+(i-1)+" DIPLOME AU TOTAL");
        }
        catch(SQLException | ClassNotFoundException e){
                 System.out.println("Erreur de conneexion a la base de donnee ");
                 System.out.println("----> Verifier que le serveur est demarre ");
             }
        
        
        
                Menu menu;
                menu = new Menu();
                menu.MenuDip();
    }
}
    