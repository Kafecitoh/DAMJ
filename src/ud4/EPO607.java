import java.util.Scanner;

public class EPO607 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase ="";
        System.out.println("Introduzca frases separadas por ENETER para formar una frase. \"Fin\" para terminar: ");
        String palabra = sc.nextLine();
        //Lectura anticipada
            while(!palabra.toUpperCase().equals("Fin")){
                if(!palabra.isEmpty())
                    frase +=palabra + " ";

                //Leer siguiente palabra
                palabra = sc.nextLine();

            }

            frase = frase.stripTrailing();
        System.out.println(frase);
    }
}
