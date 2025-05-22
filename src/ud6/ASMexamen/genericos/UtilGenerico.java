package ud6.xxxexamen.genericos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilGenerico {
    public static <T> List <T> repetidos(List<T> lista){
        // se corrije depsues
        Map <T ,Integer> contador = new HashMap<>();
            for(T elemen : lista  ){
                contador.put(elemen,contador.getOrDefault(elemen,0) + 1);
            }
            List <T> resultado = new ArrayList<>();
                for ( T elemen : lista){
                    if (contador.get(elemen) > 1){
                            resultado.add(elemen);
                      
                    }
                }
                return resultado;


    }
}


