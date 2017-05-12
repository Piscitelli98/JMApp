import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
 
public class Client {
 
  private final String SERVER_HOST = "127.0.0.1";
  private final int SERVER_PORT = 3333;
 
  public static void main(String[] args) {
      Client c = new Client();
      try {
          c.sendFile();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
 
  private void sendFile() throws IOException {
    try {
        Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
        FileInputStream fis = new FileInputStream("2017-04-20 TeP - web service WSDL SOAP FILA A - wsdl.pdf");
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
      /*Socket socket = null;
      try {
          socket = new Socket(SERVER_HOST, SERVER_PORT);
      } catch (UnknownHostException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }
 
      ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
      oos.reset();
      oos.writeObject(file);
      oos.flush();
      oos.close();
  }*/
