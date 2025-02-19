package Arrays;

import java.util.Scanner;

public class Pruebas {
    static void contarParesImpares(){
        int contPares = 0;
        int contImp = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese 10 numeros");

        for(int i = 0; i<10; i++){
            int num = sc.nextInt();

            if (num % 2 == 0){

                contPares++;

            }else{
                contImp++;
            }
        }
        System.out.printf("Pares: %d\n Impares: %d ", contPares, contImp);
    }
}
