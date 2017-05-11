/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aggiuntautentewebservicedb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chicc
 */
public class AggiuntaUtenteWebServiceDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      if(registerUser("Federico","Piscitelli", "kikko@mail.com","pippo")==true)
          System.out.println("Utente registrato");

    }
    
    private static boolean registerUser(java.lang.String nome, java.lang.String cognome, java.lang.String email, java.lang.String password) {
        registrazioneutentedb.RegistrazioneUtenteDB_Service service = new registrazioneutentedb.RegistrazioneUtenteDB_Service();
        registrazioneutentedb.RegistrazioneUtenteDB port = service.getRegistrazioneUtenteDBPort();
        return port.registerUser(nome, cognome, email, password);
    }
    
        
    
}
