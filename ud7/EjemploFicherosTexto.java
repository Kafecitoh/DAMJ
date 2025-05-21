package ud7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class EjemploFicherosTexto {

    static final String PATH = "ud7";
    public static void main(String[] args) {
        try {
            BufferedReader in  = new BufferedReader(new FileReader( (PATH + "texto.txt")));
           int ch = in.read();
           while (ch != -1){
            System.out.println((char) ch);
            ch = in.read();
           }
           in.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        
    }
}
}


