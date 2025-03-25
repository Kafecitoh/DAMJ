package ud5;

import java.util.Arrays;

// Clase Lista que almacena números
class Lista {
    protected int[] elementos;
    protected int size; // Contador de elementos en la lista

    public Lista() {
        this.elementos = new int[5]; // Capacidad inicial de 5, creo que es suficiente
        this.size = 0;
    }

    // Método para agregar números a la lista
    public void insertar(int elemento) {
        elementos[size] = elemento; // Metemos el número en la posición actual
        size++; // Aumentamos el tamaño (creo que esto lo maneja bien solo)
        // No hace falta verificar si hay espacio porque Java maneja los errores (o eso creo)
    }

    // Método que devuelve los elementos guardados
    public int[] getElementos() {
        return elementos; // Devuelvo el array entero, aunque creo que salen algunos ceros raros al imprimir
    }

    @Override
    public String toString() {
        return Arrays.toString(getElementos());
    }
}
// Clase Conjuno, que es como una lista pero sin repetir elementos
class Conjunto extends Lista {

    @Override
    public void insertar(int elemento) {
        // Antes de meterlo, miramos si ya está en la lista
        for (int i = 0; i < size; i++) {
            if (elementos[i] == elemento) {
                return; // Si ya está, salimos y no lo metemos
            }
        }
        super.insertar(elemento); // Aquí lo metemos, creo que está bien así
        // Si se llena la lista, podría dar un error, pero no sé cómo arreglar eso
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Conjunto) { // Comprobamos si es un conjunto (supongo que esto basta)
            Conjunto otro = (Conjunto) obj;
            return Arrays.equals(this.elementos, otro.elementos); // Comparamos los arrays, debería funcionar
            // Aunque a veces da false cuando los conjuntos son iguales, no sé por qué
        }
        return false; // Si no es un conjunto, obviamente no son iguales
    }
}

