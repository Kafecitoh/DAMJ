package ud6;

import java.sql.Array;
import java.util.Arrays;

public class EP120<T>{

    T[] objetos;

    void insertarAlPrincipio( T nuevo) {
        objetos = Arrays.copyOf(objetos, objetos.length + 1);
        System.arraycopy(objetos, 0, objetos , 1 , objetos.length);
        objetos[0] = nuevo;
    }
    void instertarAlfinal  (T nuevo){
        objetos = Arrays.copyOf(objetos,objetos.length + 1);
        objetos [objetos.length - 1] = nuevo;

    }
    T estraerDelPrincipio(){
        return null;
    }
    T extraerDelFinal(){
        return null;
    }
    void ordenar(){

    }

    @Override
    public String toString() {
        return Arrays.toString(objetos);

    }

    public static void main(String[] args) {
        EP120<Integer> lista = new EP120<>();
        lista.insertarAlPrincipio(1);
        lista.insertarAlPrincipio(2);
        lista.insertarAlPrincipio(3);
    }
}
