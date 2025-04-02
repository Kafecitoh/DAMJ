package Arrays;
public class MontanaRusa {
    //metodo q recibe el arreglo de enteros q son las alturas con la cantidad de alturas q encuentre
    public static int contarPicos(int[] alturas) {

// Si el arreglo es null o tiene menos de 3 elementos, NO hay pico, esto para casos especiales
        if (alturas == null || alturas.length < 3) {

            return 0;
        }
        int n = alturas.length;
        int contador = 0;

// bucle para q recorra el array entero
        for (int i = 0; i < n; i++) {

// El elemento anterior y el siguiente se determinan de forma cirula
            int indiceAnterior = (i - 1 + n) % n;
            int indiceSiguiente = (i + 1) % n;

//ver si el elemento actual es mayor que sus vecinos.
            if (alturas[i] > alturas[indiceAnterior] && alturas[i] > alturas[indiceSiguiente]) {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
//  prueba
        int[] alturas = {4, 10, 3, 2};
        int numeroPicos = contarPicos(alturas);
        System.out.println("Número de picos: " + numeroPicos);
    }
}