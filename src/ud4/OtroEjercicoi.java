import java.util.Arrays;

public class OtroEjercicoi {
    public static int suma(double[] numeros) {

        int suma = 0;
        for (double num : numeros) {
            suma += num;
        }
        return suma;
    }

    static int minimo(int[] numeros) {
        int min = Integer.MAX_VALUE;
        for (int num : numeros) {
            if (num <= min) {
                min = num;
            }

        }
        return min;
    }

    static int maximo(int[] numeros) {
        int max = Integer.MIN_VALUE;
        for (int num : numeros) {
            if (num >= max) {
                max = num;
            }
        }
        return max;


    }

    static double media(double[] numeros) {
        return (double) suma(numeros) / numeros.length;

    }

    static double mediana(int[] numeros) {
        Arrays.sort(numeros);
        int n = numeros.length;
        if (n % 2 == 1) {
            return numeros[n / 2];
        } else {
            return (numeros[(n / 2) - 1] + numeros[n / 2]) / 2.0;


        }

    }

    static int moda(int[] numeros) {
        int moda = numeros[0];
        int maxFrecuencia = 0;
        for (int i = 0; i < numeros.length; i++) {
            int frecuencia = 0;
            for (int j = 0; j < numeros.length; j++) {
                if (numeros[i] == numeros[j]) {
                    frecuencia++;
                }

            }

        }
        return moda;
    }




    public static void main(String[] args) {
        // Declaración de variables y constantes
        int[] numeros1 = {2, 4, 6, 7, 4, 7, 9, 2, 5, 6, 7};
        int[] numeros2 = {2, 4, 6, 7, 4, 9, 2, 5, 6, 7};
        // Proceso y salida
        imprimeEstadisticas(numeros1);
        imprimeEstadisticas(numeros2);
    }

    static void imprimeEstadisticas(int[] numeros) {
        System.out.println("ARRAY ORIGINAL: " + Arrays.toString(numeros));
        System.out.println("---------------------------------------------");
        System.out.println("Longitud: " + numeros.length);
       // System.out.println("Suma: " + suma(numeros));
        System.out.println("Máximo: " + maximo(numeros));
        System.out.println("Mínimo: " + minimo(numeros));
       // System.out.println("Media: " + media(numeros));
        System.out.println("Mediana: " + mediana(numeros));
        System.out.println("Moda: " + moda(numeros));
        Arrays.sort(numeros);
        System.out.println("ARRAY ORDENADO: " + Arrays.toString(numeros));

        System.out.println("---------------------------------------------\n\n");
    }
}




