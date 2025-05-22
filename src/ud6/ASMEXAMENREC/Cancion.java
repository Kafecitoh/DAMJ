//ARON SANTOME MAGALLANES

package ud6.ASMEXAMENREC;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;



//clase cancion
public class Cancion implements Comparable<Cancion> {
    private String nombre;
    private String autor;
    private String estiloMusical;
    private List<String> instrumentosRequeridos;

    public Cancion(String nombre, String autor, String estiloMusical, List<String> instrumentosRequeridos) {
        this.nombre = nombre;
        this.autor = autor;
        this.estiloMusical = estiloMusical;
        this.instrumentosRequeridos = new ArrayList<>(new TreeSet<>(instrumentosRequeridos));
        
    //getters
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public String getEstiloMusical() {
        return estiloMusical;
    }

    public List<String> getInstrumentosRequeridos() {
        return instrumentosRequeridos;
    }

    public static List<String> instrumentosDistintos(Collection<Cancion> canciones) {
        Set<String> instrumentos = new TreeSet<>();
        for (Cancion c : canciones) {
            instrumentos.addAll(c.instrumentosRequeridos);
        }
        return new ArrayList<>(instrumentos);
    }

    @Override
    public int compareTo(Cancion o) {
        return this.nombre.compareToIgnoreCase(o.nombre);
    }

    @Override
    public String toString() {
        return "\"" + nombre + "\" (" + autor + ") - " + estiloMusical + " | Instrumentos: " + instrumentosRequeridos;
    }
}
