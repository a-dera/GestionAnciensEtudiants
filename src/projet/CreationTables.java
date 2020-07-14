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
//librairies 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreationTables {
    
   public void accesCreation(){ //throws VerifRayonException{
    
    // Information d'acces a la bdd
   String ev = "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";

   String url = "jdbc:mysql://localhost/test"+ ev;
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


        st.close();
        con.close();



    }
    catch(SQLException | ClassNotFoundException e){
    }
   }   
    
}
