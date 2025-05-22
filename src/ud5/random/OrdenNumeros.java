package ud5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class OrdenNumeros {
    public static void main(String[] args) {
// cear un array de 20 números aleatorios entre 1 y 100
        Integer[] numeros = new Integer[20];
        Random random = new Random();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(100) + 1; // Genera números entre 1 y 100
        }


// mstrar antes de ordenar
        System.out.println("Antes de ordenar: " + Arrays.toString(numeros));

//  rdnar en sentido decreciente usando la clase Comparator de los apuntes
        Arrays.sort(numeros, new ComparadorNumeros());

// Mostrar después de ordenar
        System.out.println("Después de ordenar en sentido decreciente: " + Arrays.toString(numeros));
    }
}

class ComparadorNumeros implements Comparator <Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return b.compareTo(a); // Ordena de mayor a menor
    }
    }







