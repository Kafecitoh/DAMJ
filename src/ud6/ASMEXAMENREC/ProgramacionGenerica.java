//ARONSANTOMEMAGALLANES
package ud6.ASMEXAMENREC;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ProgramacionGenerica {
    public static <T> int contarCoincidencias(Collection<T> c1, Collection<T> c2){
        Set <T> set1= new HashSet<>(c1);
        Set <T> set2= new HashSet<>(c2);
            //usade de ejerciciosrepasogenericos igual al de los camiones cisterna
            set1.retainAll(set2);
            return set1.size();
    }
}

