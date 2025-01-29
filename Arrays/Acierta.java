import java.util.Scanner;

public class Acierta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Jugador 1: Introduce la contraseña: ");
        String contraseña = sc.nextLine();

        System.out.println("Jugador 2: Adivina la contraseña: ");
        String intento = sc.nextLine();


        do {
            intento = sc.nextLine();
            if (!intento.equals(contraseña)) {
                System.out.println(" Contraseña incorrecta. Intentalo de nuevo");

            }

        }while (!intento.equals(contraseña));
            System.out.println("Has ganado!");
    }

}


