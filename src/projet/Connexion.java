/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;


//librairies 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author  DERA
 */
public class Connexion {
    public int accesConnexion(){ 
    
        // Information d'acces a la bdd
        int testCo = 0;
       String ev = "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";

       String url = "jdbc:mysql://localhost/gestion"+ ev;
       String login = "root";
       String pass = "";

       Connection con = null;
       Statement st = null;


       try {
           // Chargement du driver
           Class.forName("com.mysql.cj.jdbc.Driver");
           // recuperation de la connection

           con = DriverManager.getConnection(url,login, pass);
           // creation d'un statement
           st = con.createStatement();     

       }
       catch(SQLException | ClassNotFoundException e){
           System.out.println("Erreur de conneexion a la base de donnee ");
           System.out.println("----> Verifier que le serveur est demarre ");
           testCo = 1;
       }
       return testCo;

   }   
  

    
}
    
