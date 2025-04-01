package ud6;

public class MetodosGenericos {
    //Metodo generico para agregar un elemento al final de  unarray
    public static <U>  U[] add(U e, U[] t){
        //Creo un array con un tamaño mayor q 1
        U[] nuevoArray = java.util.Arrays.copyOf(t, t.length + 1);
        //se mete un nuevo elemento en la ultima posicion
        nuevoArray[t.length] = e;
        return nuevoArray; //devuelve el array con lo añadido

    }
    public static <U> boolean buscar(U e, U[] t){
        //Recorre el array para verificar si el elemento está
        for(U elemento : t){
            if (elemento.equals(e)){
                return true; //si el elemento se encuentra, devuelve l oq viene siendo true
            }
        }
        return false; // si no false
    }
}
