import java.util.Scanner;

public class EPO606 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String PREFIJO = "Javalin, Javalón";
        final String SUFIJO = " javalin, len len";
        System.out.println("Introduzca una frase normal o en el dialecto: "
                + " que comience por \" Javalin, javalón\""
            + "o que comience por \"" + PREFIJO + "\""
        + "o que termine por \"" + SUFIJO + "\"");
        String frases = sc.nextLine();

        if(frases.startsWith(PREFIJO)){
            System.out.println("La frase esta en idioma de Javalandia");
            String traduccion = frases.substring(PREFIJO.length());
        }else if (frases.endsWith(SUFIJO)){
            System.out.println(" La frase esta escrita en dialecto de javalandia");
            String traduccion = frases.substring(0, frases.length() - SUFIJO.length()).strip();
            System.out.println("Traduccion : "+ traduccion);


        }


    }
}
