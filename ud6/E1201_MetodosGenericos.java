package ud6;

import ud5.Persona;

public class E1201_MetodosGenericos {
    static <U> int numeroDeNulos(U[] tabla) {
        int cont = 0;
        for (U e : tabla)
            if (e == null)
                cont++;
        return cont;
    }

    public static void main(String[] args) {
        Integer[] numeros = {3, 5, 8, null, 2, null};
        //Persona[] persona = {new persona("Pepe")}
    }
}
