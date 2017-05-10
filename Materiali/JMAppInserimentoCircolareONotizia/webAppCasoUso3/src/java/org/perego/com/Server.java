package org.perego.com;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
 
 
public class Server {
 
  private final int SERVER_PORT = 3333;
 
  public static void main(String[] args) {
      Server s = new Server();
      try {
          s.listen();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
 
  public void listen() throws IOException {
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