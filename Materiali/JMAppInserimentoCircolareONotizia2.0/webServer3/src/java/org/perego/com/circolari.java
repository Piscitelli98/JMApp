/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.perego.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ricca
 */
@WebService(serviceName = "circolari")
public class circolari {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "set_nomeCircolare")
    public String set_nomeCircolare(@WebParam(name = "nomeDocumento") String nomeDocumento) {

        String connectionString="jdbc:mysql://localhost:3306/testcircolare?user=root&password=";
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    Connection connection = null;
 
try {
    connection = DriverManager.getConnection(connectionString);
    //PreparedStatement prepared = connection.prepareStatement("insert into circolari (nomeCircolare) values (?)");
    //prepared.setString(1, nomeDocumento);
    //prepared.executeUpdate();
  
    PreparedStatement pstmt;
    
    
    pstmt = connection.prepareStatement("INSERT INTO circolari " +
                    "(nomeCircolare) values (?)");
 
            pstmt.setString(1, nomeDocumento);
           // pstmt.setString(2, "Rossi");
            pstmt.execute();
           /* pstmt.setString(1, "Marco");
            pstmt.setString(2, "Bianchi");
            pstmt.execute();*/
    
    //Statement stm = connection.createStatement();
    //ResultSet rs = stm.executeQuery("insert into circolari (nomeCircolare) values ('"+nomeDocumento+"')");
    //while (rs.next()) {
       // System.out.println(rs.getInt("id") + " " + rs.getString("nomeCircolare") );
    //}
 
} catch (SQLException e) {
    e.printStackTrace();
} catch (Exception e) {
    System.out.println(e.getMessage());
} finally {
    try {
        if (connection != null)
            connection.close();
    } catch (SQLException e) {
        // gestione errore in chiusura
    }
}

        return "qualcosa è stato fatto, credo";
    }
}
