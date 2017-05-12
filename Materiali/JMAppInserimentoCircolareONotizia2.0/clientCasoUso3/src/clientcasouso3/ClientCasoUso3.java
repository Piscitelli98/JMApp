/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientcasouso3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author ricca
 */
public class ClientCasoUso3 {

    private static final String SERVER_HOST = "127.0.0.1";
  private static final int SERVER_PORT = 3333;
  private static String nomeFile="testSendPDF.pdf";
  
  
    public static void main(String[] args) {
        String risultato=setNomeCircolare(nomeFile);
        System.out.println(risultato);
        try {
          sendFile();
      } catch (IOException e) {
          e.printStackTrace();
      }
    }

    private static String setNomeCircolare(java.lang.String nomeDocumento) {
        org.perego.com.Circolari_Service service = new org.perego.com.Circolari_Service();
        org.perego.com.Circolari port = service.getCircolariPort();
        return port.setNomeCircolare(nomeDocumento);
    }
    private static void sendFile() throws IOException {
            try {
                Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
                FileInputStream fis = new FileInputStream(nomeFile);
                OutputStream out = socket.getOutputStream();
                byte[] buf = new byte[1024];
                int read;
                while ((read = fis.read(buf)) != -1) {
                out.write(buf, 0, read);
                }
                fis.close();
                out.close();
                socket.close();
                } catch (UnknownHostException ex) {
                System.out.println(ex.getMessage());
                } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }  
}
