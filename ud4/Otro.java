import javax.imageio.stream.ImageInputStream;
import java.nio.file.FileAlreadyExistsException;

public class Otro {
    public static int filaMayorSuma(int[][] matriz) {

        //variables para lamaecnar la fila con mayor suma y el valor de ella

        int mayorSuma = Integer.MIN_VALUE;
        int filaMayorSuma = -1;
        // recorre la matriz fila a fila
        for (int i = 0; i < matriz.length; i++) {
            int sumaFila = 0;
        //suma los elementos  dela fila q este
            for (int j = 0; j < matriz[i].length; j++) {
                sumaFila += matriz[i][j];
            }
        // se actualiza si esta fila tiene la suma mayor que la actual
            if (sumaFila > mayorSuma) {
                mayorSuma = sumaFila;
                    filaMayorSuma = i;
            }

        }
        //devuelve el indice de la fila con mas suma
        return filaMayorSuma;
    }

    public static void main(String[] args) {
        int[][] matriz = {
                {1,2,3},
                {4,5,6},
                {7,8,9}

        };
        int fila = filaMayorSuma(matriz);
        System.out.println("la mayor suma en las filas es " + fila);
    }
}