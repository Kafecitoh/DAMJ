//AronSantomeMagallanes
package ud6.xxxexamen.genericos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class UtilGenerico2 {
    public static <T> List <T> filtrarMayores(Collection<T> coleccion, T referencia, Comparator <T> comparador){
        List<T> resultado = new ArrayList<>();
        for(T elemen : coleccion){
            if(comparador.compare(elemen,referencia) <= 0){
                resultado.add(elemen);
             }

            }
            return resultado;
        }

    
}

