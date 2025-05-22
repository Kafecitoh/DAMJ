
import java.util.Random;
import java.util.Scanner;

public class Combinacion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Bienvenido al juego 'La Cámara Secreta'");
        System.out.print("Por favor, introduce la longitud de la combinación secreta (entre 1 y 5): ");
        int longitud = scanner.nextInt();


        while (longitud < 1 || longitud > 5) {
            System.out.print("Longitud inválida. Por favor, introduce un número entre 1 y 5: ");
            longitud = scanner.nextInt();
        }

//  combinación secreta
        int[] combinacionSecreta = new int[longitud];
        for (int i = 0; i < longitud; i++) {
            combinacionSecreta[i] = random.nextInt(5) + 1; // Números entre 1 y 5
        }

        System.out.println("¡La combinación secreta ha sido generada!");

        boolean acertado = false;
        while (!acertado) {
            System.out.print("Introduce tu combinación (separada por espacios): ");
            int[] intento = new int[longitud];
            for (int i = 0; i < longitud; i++) {
                intento[i] = scanner.nextInt();
            }

// Comprobar la combinación pistas
            acertado = true;
            for (int i = 0; i < longitud; i++) {
                if (intento[i] < combinacionSecreta[i]) {
                    System.out.println("El número en la posición " + (i + 1) + " es menor que el secreto.");
                    acertado = false;
                } else if (intento[i] > combinacionSecreta[i]) {
                    System.out.println("El número en la posición " + (i + 1) + " es mayor que el secreto.");
                    acertado = false;
                } else {
                    System.out.println("El número en la posición " + (i + 1) + " es correcto.");

                }
            }

            if (acertado) {
                System.out.println("¡Felicidades! Has descubierto la combinación secreta.");
            } else {
                System.out.println("Inténtalo de nuevo.");
            }
        }

        scanner.close();
    }
}

