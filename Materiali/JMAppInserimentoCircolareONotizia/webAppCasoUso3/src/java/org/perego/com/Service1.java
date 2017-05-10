/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.perego.com;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;



@WebService(serviceName = "Service1")
public class Service1 {
 
    boolean loggato=true;
    String nomeUtente="admin";//settato da login
    Vector<circolare> circolari;
     private final int SERVER_PORT = 3333;
     
     
    //database
   String connectionString="jdbc:mysql://localhost:8080/JMApp?user=root&password=secret";



    

    private void aggiornaCircolari() throws SQLException{
        //connessione al db
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) 
        {
            // gestione dell'eccezione
        }
        Vector<String> tpStr= new Vector<String>();
        tpStr.add("studenti");
        circolare tpCirc = null;
         Connection conn = DriverManager.getConnection(connectionString); 
         Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from circolare where username="+nomeUtente);
            while (rs.next()) {
                
                tpCirc.setNome(rs.getString("nome"));
                tpCirc.setPrivacy(rs.getString("privacy"));
                tpCirc.setDescrizione(rs.getString("descrizione"));
                tpCirc.setTesto(rs.getString("testo"));
                tpCirc.setInseritaDa(rs.getString("username"));
                tpCirc.setNomeCategoria(rs.getString("nomeCategoria"));
                tpCirc.setDestinatari(tpStr);
            }
       
    }
    
     
    
    
    public Service1() {
        circolari = new Vector<circolare>();        
    }
    
    @WebMethod(operationName = "verificaCredenziali")
    public boolean verificaCredenziali() {
        return loggato;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_circolariENotizieInserite")
    public Vector<String> get_circolariENotizieInserite(@WebParam(name = "username") String username) {
        Vector<String> temp = new Vector<String>();
        circolare Circtp=null;
        for (int i = 0; i < circolari.size(); i++) {
            Circtp=circolari.elementAt(i);
            if(Circtp.getInseritaDa().equals(username)){temp.add(Circtp.getNome());}
        }
        return temp;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_tipiCircolari")
    public Vector<String> get_tipiCircolari() {
        //connessione a db per sapere quali circolari sono presenti
         Vector<String> temp = new Vector<String>();
         temp.add("Categoria A");
          temp.add("Categoria B");
           temp.add("Categoria C");
        return temp;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_destinatari")
    public Vector<String> get_destinatari() {
        //connessione a db per sapere quali destinatari sono presenti
         Vector<String> temp = new Vector<String>();
         temp.add("Destinatario A");
          temp.add("Destinatario B");
           temp.add("Destinatario C");
        return temp;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "get_controlloCircolare")
    public Vector<String> get_controlloCircolare(@WebParam(name = "oggetto") String oggetto, @WebParam(name = "nome") String nome, @WebParam(name = "testo") String testo) {
         Vector<String> temp = new Vector<String>();
         circolare Circtp=null;
        for (int i = 0; i < circolari.size(); i++) {
            Circtp=circolari.elementAt(i);
            if(Circtp.getNome().equals(nome)){
                if(Circtp.getTesto().equals(oggetto)){
                    if(Circtp.getTesto().equals(testo)){
                        temp.add(Circtp.getNome());
                    }
                }
            }
        }
        return temp;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "set_salvaCircolare")
    public Vector<String> set_salvaCircolare() {
        
        Server s = new Server();
      try {
          s.listen();
      } catch (IOException e) {
          e.printStackTrace();
      }
       
        return null;
    }


}
/*
 circolare CircTp= new circolare( tipo, destinatari, privacy, oggetto,  testo, nomeUtente);
        circolari.add(CircTp);
        Vector<String> temp = new Vector<String>();
        temp.add("Corretto");
        return temp;
*/