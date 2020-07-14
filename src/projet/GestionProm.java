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
public class GestionProm {
    GestionDip gest = new GestionDip();
    Scanner scan = new Scanner(System.in);
    String ev = "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";

    String url = "jdbc:mysql://localhost/gestion"+ ev;
    String login = "root";
    String pass = "";

    Connection con = null;
    Statement st = null;
    private ResultSet resultMat;
    private int executed, executed1;
    
    
    public void allProm(){
        
        
        System.out.println("------------------------------------------- ");
        System.out.println("Saisissez une annee entre 2003 et 2019(compris)");
        System.out.println("----------------------------------------------");
        gest.setPromYear(scan.nextInt());
        
       try{
           int z =0;
            if(gest.getPromYear() >= 2003 && gest.getPromYear()<= 2019){
             try{// Chargement du driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // recuperation de la connection

                con = DriverManager.getConnection(url,login, pass);
                // creation d'un statement
                st = con.createStatement();
        
                //resultMat = st.executeQuery("SELECT * FROM etudiant  WHERE matricule ="+gest.getMatricule()+" INNER JOIN travail ON etudiant.matricule =travail.matricule");
               resultMat = st.executeQuery("SELECT * FROM  diplome  WHERE diplome.promotionAnnee = "+gest.getPromYear()+" ");
               
                
               while (resultMat.next())
                { z++;}
               if (z==0){
                  System.out.println("*************AUCUN DIPLOME TROUVE POUR L'ANNEE  "+gest.getPromYear()+"***************** ");
                    Menu menu;
                    menu = new Menu();
                    menu.Accueil();
               } else {
                   
                
                System.out.println("--------------------------------------- ");
        System.out.println("------------- Les informations sur la promotion "+gest.getPromYear()+" --------------------- ");
        System.out.println("----Affichage du nombre de diplomé par type de diplome ");
        try {
                // Chargement du driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // recuperation de la connection

                con = DriverManager.getConnection(url,login, pass);
                // creation d'un statement
                st = con.createStatement();
        
                //resultMat = st.executeQuery("SELECT * FROM etudiant  WHERE matricule ="+gest.getMatricule()+" INNER JOIN travail ON etudiant.matricule =travail.matricule");
               resultMat = st.executeQuery("SELECT * FROM  diplome  WHERE diplome.promotionAnnee = "+gest.getPromYear()+" ");
               
// resultMat1 = st.executeQuery("SELECT * FROM travail WHERE matricule ="+gest.getMatricule()+"");
                
              
              int nl = 0;
              int nm = 0;
              int nt = 0;
             
                
                 int dl = 0;
                 int dm = 0;
                 while (resultMat.next())
                { 
                   
                
                 dl = resultMat.getInt("detientLicence");
                 dm = resultMat.getInt("detientMaster");
                 if(dl==1) nl++;
                 if (dm==1)nm++;
                         
                 
      
            System.out.println("");
        
          
             }
                 nt = nl +nm;
              System.out.println("-------Licence----------------Master------------------Total------");
             System.out.println("-------"+nl+"----------------------"+nm+"---------------------"+nt+"------");   
             System.out.println("--------------------------------------- ");
        }
        catch(SQLException | ClassNotFoundException e){
                 System.out.println("Erreur de connexion a la base de donnee ");
                 System.out.println("----> Verifier que le serveur est demarre ");
             }
        
        System.out.println("*************La liste de tous les diplomés de cette promotion******************* ");
        
    try {
                // Chargement du driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // recuperation de la connection

                con = DriverManager.getConnection(url,login, pass);
                // creation d'un statement
                st = con.createStatement();
        
                //resultMat = st.executeQuery("SELECT * FROM etudiant  WHERE matricule ="+gest.getMatricule()+" INNER JOIN travail ON etudiant.matricule =travail.matricule");
               resultMat = st.executeQuery("SELECT * FROM etudiant, travail, adresse, diplome  WHERE etudiant.matricule = travail.matricule AND etudiant.matricule = adresse.matricule AND etudiant.matricule= diplome.matricule AND diplome.promotionAnnee="+gest.getPromYear()+"  ");
            
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
                menu.Accueil();
                   
         
               }
             }catch(SQLException | ClassNotFoundException e){
                 System.out.println("Erreur de conneexion a la base de donnee ");
                 System.out.println("----> Verifier que le serveur est demarre ");
             }
             
             
     
            }//if test annee

            else {
                System.out.println(" L'année saisie est incorrecte. Faites un choix correct! L'IBAM ne peut pas avoir de diplômés à cette année !");
                GestionProm menu;
                menu = new GestionProm();
                menu.allProm();
            }
        }//fin grand try
        catch (InputMismatchException e){
        System.out.println("Entrer un chiffre!");
                GestionProm menu;
                menu = new GestionProm();
                menu.allProm();
        }
    
    }
    
}
