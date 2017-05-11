/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myserverpr;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author piscitelli_federico
 */
class MyServer {

    private final int SERVER_PORT = 3333;
    ServerSocket ss;

    MyServer() {
        try {
            ss = new ServerSocket(SERVER_PORT);
            System.out.println("Sono sulla " + ss);
        } catch (IOException ex) {
            Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listen() throws IOException {
        // ciclo infinito per accettare per sempre connessioni
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
        } catch (InterruptedException e) {
        }
    }

    
}
