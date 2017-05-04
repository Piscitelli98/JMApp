
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author piscitelli_federico
 */
 
public class Server{
 
  private final int SERVER_PORT = 3333;
 
  public static void main(String[] args){
      Server s = new Server();
      try {
          s.listen();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
 
  private void listen() throws IOException {
      ServerSocket ss = new ServerSocket(SERVER_PORT);
      System.out.println("Sono sulla " + ss);
 
      // ciclo infinito per accettare per sempre connessioni
      while(true) {
          // prendo la connessione in ingresso
          Socket s = ss.accept();
          System.out.println("Conessione da " + s);
 
          // creo ed eseguo il thread per questa connessione 
          // cosi il ciclo continua e rimane in attesa di 
          // nuove connessioni
          new MTManager(s).run();
 
          // faccio respirare un po il ciclo
          try {
              Thread.sleep(100);
          } catch (InterruptedException e) { }
      }
  }
  

}