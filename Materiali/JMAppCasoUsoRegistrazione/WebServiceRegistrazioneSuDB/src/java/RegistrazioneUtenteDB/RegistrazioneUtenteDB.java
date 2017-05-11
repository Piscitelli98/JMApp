/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegistrazioneUtenteDB;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Federico Piscitelli
 */
@WebService(serviceName = "RegistrazioneUtenteDB")
public class RegistrazioneUtenteDB {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "RegisterUser")
    public boolean RegisterUser(@WebParam(name = "Nome") String Nome, @WebParam(name = "Cognome") String Cognome, @WebParam(name = "Email") String Email, @WebParam(name = "Password") String Password) {
        boolean registrazioneAvvenuta=false;
        String nome=Nome;
        String cognome=Cognome;
        String email=Email;
        String psw=Password;
        
        String query="INSERT INTO utenti(id,email,nome,cognome,password) "
                + "   VALUES (null,'"+email+"','"+nome+"','"+cognome+"','"+psw+"')";
        
        String dbUrl="jdbc:mysql://localhost/web_service_test";
        String user="root";
        String pswDb="";
        
        try {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connessione = DriverManager.getConnection(dbUrl,user,pswDb);
           Statement st = connessione.createStatement();
            if(st.executeUpdate(query)==1)
                registrazioneAvvenuta=true;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistrazioneUtenteDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RegistrazioneUtenteDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RegistrazioneUtenteDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrazioneUtenteDB.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        
        return registrazioneAvvenuta;
    }
}
