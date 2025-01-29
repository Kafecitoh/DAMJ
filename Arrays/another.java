import java.util.Scanner;

public class another {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            //el array para las alturas (1000 max)
            int[] montañas = new int[1000];
            int cantidad = 0;

            //lee las alturas de las montañas
        System.out.println("Introduce las alturas de las montañas de oeste a este (numero negativo para terminar)");

            while(true){
                int altura = sc.nextInt();
                if (altura < 0 || cantidad >= 1000){
                    break;
                }
                montañas[cantidad] = altura;
                cantidad ++;
            }
            //para  abadias desde el Este hacia Oeste
        System.out.println("Indices de las montañas donde se pueden construit abadias");
        int maxAltura =-1;
        int totalAbadias = 0;

            for (int i = cantidad - 1; i >= 0; i--);{
                if (montañas[cantidad] > maxAltura){
                    maxAltura = montañas[cantidad];
                     totalAbadias ++;

                    System.out.println(cantidad + 1);
                    //indice en 1;




                }
        }
        System.out.println("Numero maixmo de abadias que se pueden construit es : " + totalAbadias);
    }
}
