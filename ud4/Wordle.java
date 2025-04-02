package Arrays;

import java.util.*;

import java.util.*;

class Palabra {
    private String palabra;
    private int vecesOculta = 0;
    private int vecesAcertada = 0;
    private int vecesIntentada = 0;

    public Palabra(String palabra) {
        this.palabra = palabra;
    }

    public String getPalabra() {
        return palabra;
    }

    public void incrementarOculta() {
        vecesOculta++;
    }

    public void incrementarAcertada() {
        vecesAcertada++;
    }

    public void incrementarIntentada() {
        vecesIntentada++;
    }

    public void estadisticas() {
        System.out.println("Palabra: " + palabra + " | Oculta: " + vecesOculta + " | Acertada: " + vecesAcertada + " | Intentada: " + vecesIntentada);
    }
}

public class Wordle {
    private static List<Palabra> palabras = Arrays.asList(
            new Palabra("perro"), new Palabra("gato"), new Palabra("raton"), new Palabra("luz"), new Palabra("hoja")
    );
    private static final int INTENTOS_MAX = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        Palabra palabraOculta = palabras.get(rand.nextInt(palabras.size()));
        palabraOculta.incrementarOculta();
        String palabraSecreta = palabraOculta.getPalabra();

        System.out.println("¡Bienvenido a Wordle! Intenta adivinar la palabra de 5 letras.");

        for (int intento = 1; intento <= INTENTOS_MAX; intento++) {
            System.out.print("Intento " + intento + ": ");
            String entrada = scanner.next().toLowerCase();

            Optional<Palabra> palabraExistente = palabras.stream().filter(p -> p.getPalabra().equals(entrada)).findFirst();

            if (!palabraExistente.isPresent()) {
                System.out.println("Palabra no en la lista. ¿Quieres añadirla? (s/n)");
                if (scanner.next().equalsIgnoreCase("s")) {
                    System.out.println("No se puede añadir la palabra, ya que la lista es inmutable.");
                }
                continue;
            }

            palabraExistente.get().incrementarIntentada();

            if (entrada.equals(palabraSecreta)) {
                palabraOculta.incrementarAcertada();
                System.out.println("¡Felicidades! Has adivinado la palabra.");
                return;
            }

            mostrarPistas(entrada, palabraSecreta);
        }
        System.out.println("Lo siento, se han agotado los intentos. La palabra era: " + palabraSecreta);
    }

    private static void mostrarPistas(String intento, String secreto) {
        for (int i = 0; i < 5; i++) {
            if (intento.charAt(i) == secreto.charAt(i)) {
                System.out.print("[" + intento.charAt(i) + "] ");
            } else if (secreto.contains(String.valueOf(intento.charAt(i)))) {
                System.out.print("(" + intento.charAt(i) + ") ");
            } else {
                System.out.print(" " + intento.charAt(i) + "  ");
            }
        }
        System.out.println();
    }
}