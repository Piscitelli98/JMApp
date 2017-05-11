package myserverpr;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
/**
 *
 * @author piscitelli_federico
 */


public class MTManager implements Runnable {

    
    private Socket socket;

    public MTManager(Socket socket) {
    this.socket = socket;
    }

    public void run() {
        try {
            InputStream is = socket.getInputStream();
            FileOutputStream fos = new FileOutputStream(new File("E:\\img.jpg"), true);
            byte[] buf = new byte[1024];
            int read;
            
            while ((read = is.read(buf)) != -1) {
                fos.write(buf, 0, read);
            }
            fos.close();
            is.close();
            socket.close();
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
}