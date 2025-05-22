//
package ud6.ASMEXAMENREC;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

//clase facil para definir al musico
public class Musico implements Comparable<Musico> {
    private String nombre;
    private String alias;
    private List<String> instrumentos;
    private List<Cancion> repertorio;

    public Musico(String nombre, String alias, List<String> instrumentos, List<Cancion> repertorio) {
        this.nombre = nombre;
        this.alias = alias;
        this.instrumentos = new ArrayList<>(new TreeSet<>(instrumentos));
        this.repertorio = repertorio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAlias() {
        return alias;
    }

    public List<String> getInstrumentos() {
        return instrumentos;
    }

    public List<Cancion> getRepertorio() {
        return repertorio;
    }

    @Override
    public int compareTo(Musico o) {
        return this.alias.compareToIgnoreCase(o.alias);
    }

    @Override
    public String toString() {
        return "[" + alias + "] (" + nombre + "): " + instrumentos + " | Repertorio: " + repertorio.size() + " canciones";
    }
}