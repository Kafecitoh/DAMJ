package ud6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class E1305 {
    //metodo generico para transfomrar una lista o aplicando una funcion a cada elemetno
    public static <T, V> List<V> transformar(List<T> origen, Function<T, V> funcion){
        List <V> resultado = new ArrayList<>();
            for (T elemento : origen){
                resultado.add(funcion.apply(elemento));
                //aplica la funcion  y devuelve el resultado
            }
        return resultado;
    }
}
