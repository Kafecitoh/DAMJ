package ud5;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int FILAS = 3;
        final int NUM_MIN = 1;
        final int NUM_MAX = 99;
        final int MAX_JUGADORES = 5;
        final Random random = new  Random();
        final boolean [] bombo = new boolean [NUM_MAX + 1 ];
        //bombo pa los numeros

        //solicitar numero a los jugadores
        System.out.println(" Ingrese el numero de jugadores (Mximo " + MAX_JUGADORES);
        int numJugadores = scanner.nextInt();
        

    }
}
