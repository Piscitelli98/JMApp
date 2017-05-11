
import java.net.InetAddress;
import java.net.Socket;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author piscitelli_federico
 */


public class ClientSocket {
    private final String HOST = "127.0.0.1";
    private final int PORT = 3333;
    
    public static void main(String[] args) {
        ClientSocket c = new ClientSocket();
        c.sendFile();
    }
        
    private void sendFile() {
        try {
            Socket socket = new Socket(HOST, PORT); //creo socket
            System.out.println("Connessione con server creata...");
            FileInputStream file = new FileInputStream("E:\\Piscitelli\\workspace\\InvioFileSocket\\Asso.jpg");
            OutputStream out = socket.getOutputStream(); //creo output stream per inviare alla socket
            byte[] buffer = new byte[1024];
            int read;
            System.out.println("Inizio invio file...");
            while ((read = file.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            System.out.println("File inviato con successo");
            file.close(); //chiudo stream da file
            out.close(); //chiudo stream output
            socket.close(); //chiudo la socket
        } catch (UnknownHostException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    

}