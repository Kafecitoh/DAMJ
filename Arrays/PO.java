
import java.util.ArrayList;
import java.util.Scanner;
public class PO {
            // Función que devuelve un array con las posiciones de la letra buscada
            public static int[] buscarLetra(String cadena, char letra) {
                ArrayList posiciones = new ArrayList<>();
                char[] caracteres = cadena.toCharArray();
                for (int i = 0; i < caracteres.length; i++) {
                    if (caracteres[i] == letra) {
                        posiciones.add(i);
                    }
                }

              // Convertimos la lista de posiciones a un array
                int[] resultado = new int[posiciones.size()];
                for (int i = 0; i < posiciones.size(); i++) {
                    resultado[i] = (int) posiciones.get(i);
                }

                return resultado;
            }

            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                String cadena = "Hola Mundo"; // Puedes cambiar la cadena si lo deseas
                char letra;

                System.out.println("Cadena: " + cadena);

                while (true) {
                    System.out.print("Introduce una letra para buscar (o un carácter que no esté para terminar): ");
                    letra = sc.next().charAt(0);

                    int[] posiciones = buscarLetra(cadena, letra);

                    if (posiciones.length == 0) {
                        System.out.println("La letra '" + letra + "' no se encuentra en la cadena. Fin del programa.");
                        break;
                    } else {
                        System.out.print("La letra '" + letra + "' aparece en las posiciones: ");
                        for (int pos : posiciones) {
                            System.out.print(pos + " ");
                        }
                        System.out.println();
                    }
                }

                sc.close();
            }
        }
