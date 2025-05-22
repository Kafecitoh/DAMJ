import java.util.Arrays;
import java.util.Scanner;

public class ArraysInsercion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            final int NUM = 5;
            double[] puntuaciones = new double  [NUM];

        System.out.println("Introduce las puntuaciones de l@s " + NUM + " programadores");
        for (int i = 0 ; i < NUM; i++){
            puntuaciones [i] = sc.nextDouble();

        }
    Arrays.sort (puntuaciones);
        System.out.println("Mejores puntuacoiones: " + Arrays.toString(puntuaciones));
        System.out.println("Introduce las puntuaciones de los programadores de exhibición, introduce -1 para salir");

            //Proceso de lectura anticiapada!!!
        double nota = sc.nextDouble();
        while (nota != -1){
            //Proceso : añadir ordenado
            double[] tAUX = new double [puntuaciones.length + 1];
            int posicion =  Arrays.binarySearch(puntuaciones,nota);
            if (posicion < 0 )
                posicion = -posicion -1;
            System.arraycopy(posicion,0,tAUX,0,posicion);
            tAUX[posicion] = nota ;
            System.arraycopy(puntuaciones,posicion,tAUX,posicion + 1,puntuaciones.length - posicion);
            puntuaciones = tAUX;
            nota = sc.nextDouble();
        }
        System.out.println("Puntuaciones finales " + Arrays.toString(puntuaciones));



    }
}
