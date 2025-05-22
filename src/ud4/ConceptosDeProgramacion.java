import java.util.Random;

public class ConceptosDeProgramacion {

    //  devolver un término aleatorio de un string array
    public static String conceptoAleatorio(String[] conceptos) {
        Random random = new Random();
        int indice = random.nextInt(conceptos.length); // indfice aleatorio


        return conceptos[indice];
    }

    public static void main(String[] args) {
        //metodos
        String[] conceptos = {
                "Algoritmo",
                "Lenguaje de programación",
                "Entorno de desarrollo",
                "Compilación",
                "Ejecución",
                "Código fuente",
                "Bytecode",
                "Código objeto"
        };

        String elegido = conceptoAleatorio(conceptos);
        System.out.println("El concepto elegido al azar es: " + elegido);
    }
}

