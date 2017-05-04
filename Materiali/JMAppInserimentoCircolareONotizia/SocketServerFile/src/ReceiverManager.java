import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
 
public class ReceiverManager implements Runnable {
 
  private final String SAVE_DIR = "/home/crx/uploads";
 
  private Socket socket;
 
  public ReceiverManager(Socket socket) {
      this.socket = socket;
  }
 
  public void run() {
      try {
          System.out.println("presa in carico nuova connessione da " + socket);
 
          // intercetto il file in arrivo
          ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());
 
          // eseguo un cast dell' oggetto come file
          File inFile = (File) oin.readObject();
 
          // imposto il nuovo file che dovro' salvare
          // prendendone il nome originale
          File saveFile = new File(SAVE_DIR + "/" + inFile.getName());
 
          // salvo il file
          save(inFile, saveFile);
 
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
          try {
              socket.close();
          } catch (IOException e) { }
      }
  }
 
  /**
   * Esegue il salvattaggio 
   *
   * @param in
   * @param out
   * @throws IOException
   */
  private void save(File in, File out) throws IOException {
      System.out.println(" --ricezione file " + in.getName());
      System.out.println(" --dimensione file " + in.length());
 
      // apro uno stream sul file che e' stato inviato
      FileInputStream fis  = new FileInputStream(in);
      // scrivo uno stram per il salvataccio del nuovo file
      FileOutputStream fos = new FileOutputStream(out);
 
      byte[] buf = new byte[1024];
      int i = 0;
      // riga per riga leggo il file originale per 
      // scriverlo nello stram del file destinazione
      while((i=fis.read(buf))!=-1) {
          fos.write(buf, 0, i);
      }
      // chiudo gli strams
      fis.close();
      fos.close();
 
      System.out.println(" --ricezione completata");
  }
}