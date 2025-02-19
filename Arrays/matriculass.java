/*ackage Arrays;

import java.lang.ref.SoftReference;
import java.util.ConcurrentModificationException;

public class matriculass {

    //validar si una matricula es correcta

    public static boolean esMatriculaValida(String matricula) {
        if (matricula.length() != 7)
            return false;
//Validar que los pirmoeros 4 sean dijitos
        for (int i = 0; i < 4; i++) {
            if (!Character.isDigit(matricula.charAt(i)))
                return false;

        }
        for (int i = 4; i < 7; i++) {
            if (!letraValida(matricula.charAt(i)))
                return false;
        }
        return true;
    }

    //para valiadr letra, sin ñ ni q
    private static boolean letraValida(char cc) {
        //sacado de otro ejercicio
        return (cc >= 'B' && cc <= 'N' && cc != 'Ñ' && cc != 'Q') || (cc >= 'p' && cc <= 'z');

    }

    //metodo para obtener la matriucla siguietnte
    public static String siguienteMatricula(String matricula) {
        if (!esMatriculaValida(matricula))
            return "Matricul Invalida";
        char[] chars = matricula.toCharArray();
        //aupa los digitos
        //sacado de otro ejercicio
        int numero = Integer.parseInt(matricula.substring(0, 4)) + 1;
        if (numero > 9999) {
            numero = 0; //para reiniciar

            for (int i = 6; i >= 4; i--) {
                chars[i] = siguienteLetra(chars[i]);
                if (chars[i] != 'B')
                    break; // si no hubo reinico, q pare
            }
        }
        return String.format("%04d%s", numero, new String(chars, 4, 3));
    }

    //para tener la siguiente letra valida
    public static char siguienteLetra(char cc) {
        switch (cc) {
            case 'N':
                return 'P';
            case 'Z':
                return 'B';
            case 'Ñ':
                return 'Q';


        }
    }
}
*/







