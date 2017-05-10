package org.perego.com;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class MTManager implements Runnable {

//private final String DIR_SAVE = "E:\\temp\\file.pdf";
private final String DIR_SAVE = "salvataggio\\file.pdf";
private Socket socket;

public MTManager(Socket socket) {
this.socket = socket;
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
}