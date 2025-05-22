package Arrays;

import com.sun.source.tree.NewArrayTree;

import java.util.Random;
import java.util.Scanner;

public class EPO614 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Jugado 1: Introduzca una palabra: ");
        String palabra = sc.nextLine();

        char[] letras = palabra.toCharArray();
        for (int i= 0; i < letras.length; i++){
            Random rnd = new Random();
            int nuevaPosicion = rnd.nextInt(letras.length);
            char letra = letras[nuevaPosicion];
            letras[nuevaPosicion] = letras[1];
            letras[i] = letra;

        }
        String anagrama = String.valueOf(letras);
        System.out.println("Anagrama: "  + anagrama);
    }

}
