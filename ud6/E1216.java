package ud6;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.TreeMap;

import javax.print.DocFlavor.READER;

public class E1216 {
    public static void main(String[] args) throws Exception {
        Map<Character, Academico> mapaAcademicos = new TreeMap<>();
        //Leer contineod del fichero pq NO va
        String texto = Files.readString(Path.of("Academicos.txt"));
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()){
            String linea = scanner.nextLine();
                if(linea.contains("Silla ") && linea.contains"("))
        }
        
        }

    }
    

