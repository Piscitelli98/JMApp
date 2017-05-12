
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MTManager implements Runnable {

//private final String DIR_SAVE = "E:\\temp\\file.pdf";
private String DIR_SAVE = "salvataggio\\";
private Socket socket;
public static final String URL = "jdbc:mysql://localhost/testcircolare";

// username per la connessione al database
public static final String USERNAME = "root";

//The password per la connessione al database
public static final String PASSWORD = "";

public MTManager(Socket socket) {
this.socket = socket;
    try {
        DIR_SAVE = "salvataggio\\"+getNomeFile();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(MTManager.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(MTManager.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public void run() {
    try {
        InputStream is = socket.getInputStream();
        
        FileOutputStream fos = new FileOutputStream(new File(DIR_SAVE), true);
        byte[] buf = new byte[1024];
        int read;
        System.out.println("inizio lettura");
        while ((read = is.read(buf)) != -1) {
            fos.write(buf, 0, read);
            System.out.println("num: "+ read);
        }
        System.out.println("finisco lettura");
    fos.close();
    System.out.println("fos chiuso");
    is.close();
    System.out.println("is chiuso");
    socket.close();
    System.out.println("socket chiusa");
    } catch (Exception e) {
    System.out.println(e.getMessage());
    } finally {
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    }
 private String getNomeFile() throws ClassNotFoundException, SQLException{
            Connection connection = null;
            try {
			Class.forName("com.mysql.jdbc.Driver");

			// Ottenere la connessione dal driver manager
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                        

		} finally {
			if (connection != null) {
				connection.close();
			}
            } 
            
            //---------------
             String query = "SELECT nomeCircolare FROM circolari";

      // create the java statement
      java.sql.Statement st = connection.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
      
      String result="";
      while (rs.next())
      {
        result = rs.getString("nomeCircolare");
        /*String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        Date dateCreated = rs.getDate("date_created");
        boolean isAdmin = rs.getBoolean("is_admin");
        int numPoints = rs.getInt("num_points");
        // print the results
        System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);*/
        
      }
      st.close();
    /*}
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }*/
            
            //---------------
       
            return result;
 }
}