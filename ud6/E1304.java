package ud6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class E1304 {
    public static <U> List <U> filtrarLista (List<U> lista, Predicate<U> condicion){
        // se crea la nueva lista donde se guarda los elementos de la condicion
        List <U> resultado = new ArrayList<>();
        //recorremos la lista y añadimos lo que cumple el predicado
            for(U elemento : lista){
                //si el elemento cumple la condicion del predicado, se añade
                if
                (condicion.test(elemento)) {
                    resultado.add(elemento);
                }
                    //se devuelve la lista filtrada
            }
                return resultado;
    }
   
}
