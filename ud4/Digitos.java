 import java.util.Scanner;

public class Digitos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(" ESCRIBE UN CARACTER Y PULSA ENTER:  ");
        String linea;
        do {
                linea = sc.nextLine();
        }while (linea.equals(" "));
        char ch = linea.charAt(0);
        sc.close();

        System.out.println(" Analisis de caracter_ " + ch);
        System.out.println("Es un digito?  " + Character.isDigit(ch));
        System.out.println("Es una letra?" + Character.isLetter(ch));
        System.out.println("Es un digito o una letra?" +Character.isLetterOrDigit(ch) );
        System.out.println("Es una minuscula?" + Character.isLowerCase(ch));
            if(Character.isLowerCase(ch))
                System.out.println(" En mayusculas seria = " + Character.toUpperCase(ch));
        System.out.println("Es una mayuscula?" + Character.isUpperCase(ch));
            if(Character.isUpperCase(ch))
                System.out.println(" En minuscula seria = " + Character.toLowerCase(ch));
        System.out.println(" Es un caracter de esapcio");
}

}