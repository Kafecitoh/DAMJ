import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] t= {5,2,7,9,4,1,8,5,4,2,8};

        int[] pares = new int [0];
        int[] impares= new int[0];

        for(int e : t){
            if (e % 2 == 0){

                pares = Arrays.copyOf(pares,pares.length +1);
                pares [pares.length - 1 ] = e;

            }else{
                impares = Arrays.copyOf(pares,pares.length +1);
                impares [pares.length - 1 ] = e;
            }

        }
        Arrays.sort(pares);
        Arrays.sort(impares);

        System.out.println(t);
        System.out.println(Arrays.toString(pares));
        System.out.println(Arrays.toString(impares));



    }

}

