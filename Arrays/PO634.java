package Arrays;

public class PO634 {

    public static void main(String[] args) {
        String frase = "En un luga de la Mancha ";

        String abecedario = "abcdefghijklmnñópqrstuvwxyz";
        int[] repeticiones = new int[abecedario.length()];


        for (int i = 0; i < frase.length(); i++){
            char letra = Character.toLowerCase(frase.charAt(i));
            int pos = abecedario.indexOf(frase.charAt(i));
            if ( pos !=-1){
                repeticiones[pos] ++;
            }
    }

        System.out.println("Frase" + frase);
        System.out.println("Resultado: " );
            for (int i = 0; i < repeticiones.length; i++){
                if (repeticiones[i] > 0){
                    System.out.println(abecedario.charAt(i) + ": " + repeticiones);
                    System.out.println(repeticiones[i] > i ? " veces" : " vez");

                }
            }




    }
}
