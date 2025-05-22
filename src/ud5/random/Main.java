package ud5;

// Clase Main para probar si todo funciona bien
public class Main {
    public static void main(String[] args) {
        Conjunto c1 = new Conjunto();
        c1.insertar(1);
        c1.insertar(2);
        c1.insertar(3);
        c1.insertar(2); // No debería meterlo porque ya está

        Conjunto c2 = new Conjunto();
        c2.insertar(3);
        c2.insertar(1);
        c2.insertar(2);

        // Mostramos los conjuntos a ver si son iguales
        System.out.println("Conjunto 1: " + c1);
        System.out.println("Conjunto 2: " + c2);
        System.out.println("Son iguales: " + c1.equals(c2)); // A veces da false aunque los elementos son los mismos :/
    }
}
