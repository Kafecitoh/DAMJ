package ud6;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public static Set union(Set conjunto1, Set conjunto2) {
        Set resultado = new HashSet<>(conjunto1);
        resultado.addAll(conjunto2); // Agrega todos los elementos del segundo conjunto
        return resultado;
    }

    // Método para la intersección de dos conjuntos
    public static Set interseccion(Set conjunto1, Set conjunto2) {
        Set resultado = new HashSet<>(conjunto1);
        resultado.retainAll(conjunto2); // Mantiene solo los elementos comunes
        return resultado;
    }

    public static void main(String[] args) {
// jemplo de prueba
        Set conjuntoA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set conjuntoB = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        System.out.println("Conjunto A: " + conjuntoA);
        System.out.println("Conjunto B: " + conjuntoB);

        Set union = union(conjuntoA, conjuntoB);
        System.out.println("Unión: " + union);

        Set interseccion = interseccion(conjuntoA, conjuntoB);
        System.out.println("Intersección: " + interseccion);
    }
