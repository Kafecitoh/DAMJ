import java.util.Scanner;

public class Introducir2frases {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la primera frase: ");
            String frase1 = sc.nextLine();

        System.out.println("Escribe la segunda frase: ");
            String frase2 = sc.nextLine();
            if(frase1.length()<frase2.length()){
                System.out.println(" La frase mas corta es \"" + frase1 + "\"");
            }else if (frase2.length () < frase1.length()){
                System.out.println(" La frase mas corta es \"" + frase2 + "\"");

        }else{
                System.out.println("Ambas frases tienen la misma longitud ");
            }
    }
}
