import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Empresa {

    public static void guardarFichero(String path, List empresas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (Empresa e : empresas) {
                writer.write(e.getNombre() + "," + e.getCif() + "," + e.getLocalidad());
                writer.newLine();
            }
            System.out.println("Datos guardados correctamente en " + path);
        } catch (IOException ex) {
            System.err.println("Error al guardar el fichero: " + ex.getMessage());
        }
    }
}
