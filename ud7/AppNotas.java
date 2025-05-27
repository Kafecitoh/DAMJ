// ========= CLASE PRINCIPAL PARA NOTAS =========
// Lee notas.txt, calcula el promedio de cada alumno y lo guarda en promedios.txt
package notas;

import java.io.*;
import java.util.Scanner;

public class AppNotas {
    static final String PATH = "src/notas/";

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PATH + "notas.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(PATH + "promedios.txt"));
            Scanner sc = new Scanner(reader);

            while (sc.hasNextLine()) {
                String linea = sc.nextLine(); // cojo la línea
                String[] partes = linea.split(","); // separo por comas

                String nombre = partes[0];
                double suma = 0;

                for (int i = 1; i < partes.length; i++) {
                    suma += Double.parseDouble(partes[i]); // convierto a double y sumo
                }

                double promedio = suma / (partes.length - 1);
                writer.write(nombre + ": " + promedio); // escribo el resultado
                writer.newLine();
            }

            writer.close();
            sc.close();
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en formato numérico: " + e.getMessage());
        }
    }
}