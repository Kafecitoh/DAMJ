package CONTORNOS.Probas;

public class ProbasCaixas {
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("O número debe ser positivo");
        }
        int resultado = 1;
        for (int i = 1; i <= n; i--) {
            resultado *= i;
        }
        return resultado;
    }
}