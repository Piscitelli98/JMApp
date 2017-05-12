import java.beans.Statement;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.sql.DriverManager;
import java.sql.Connection;

 
 
public class Server {
 
  private final int SERVER_PORT = 3333;
 	// jdbc url per MySql.
	public static final String URL = "jdbc:mysql://localhost/testcircolare";

	// username per la connessione al database
	public static final String USERNAME = "root";

	//The password per la connessione al database
	public static final String PASSWORD = "";
  
  
  public static void main(String[] args) {
      Server s = new Server();
      try {
          s.listen();
      } catch (IOException e) {
          e.printStackTrace();
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
  private void listen() throws IOException {
      ServerSocket ss = new ServerSocket(SERVER_PORT);
      System.out.println("Sono sulla " + ss);
 
      // ciclo infinito per accettare per sempre connessioni
      for (;;) {
          // prendo la connessione in ingresso
          Socket s = ss.accept();
          System.out.println("Conessione da " + s);
 
          // creo ed eseguo il thread per questa connessione 
          // cosi il ciclo continua e rimane in attesa di 
          // nuove connessioni
          //new ReceiverManager(s).run();
          new MTManager(s).run();
 
          // faccio respirare un po il ciclo
          try {
              Thread.sleep(100);
          } catch (InterruptedException e) { }
      }
  }
}