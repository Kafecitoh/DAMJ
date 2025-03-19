package ud5.Interfaces;
/*EP0913_Futbolista.
Diseñar la clase Futbolista con los siguientes atributos: dni,
nombre, edad y número de goles. Implementar:
        ● Un constructor y los métodos toString() y equals() (este último basado en el
DNI).
        ● La interfaz Comparable con un criterio de ordenación basado también en el DNI.
● Un comparador para hacer ordenaciones basadas en el nombre y otro basado en la
edad.
Crear una tabla con 5 futbolistas y mostrarlos ordenados por DNI, por nombre y por edad.
Añade un comparador que ordene los futbolistas por edades y, para aquellos que tienen la
        misma edad, por nombres.
        */
import java.util.Comparator;

// Clase Futbolista con Comparable basado en DNI
abstract class Futbolista implements Comparable, Futbolistas {
    public int get;
    private int dni;
    private String nombre;
    private int edad;
    private int goles;

    public Futbolista(int dni, String nombre, int edad, int goles) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.goles = goles;
    }

    public int getDni()
    { return dni;
    }
    public String getNombre()
    { return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public int getGoles()
    { return goles;
    }

    // Implementar Comparable para ordenar por DNI
    @Override
    public int compareTo(Futbolista otro) {
        return Integer.compare(this.dni, otro.dni);
    }

    // toString para mostrar datos
    @Override
    public String toString() {
        return "DNI: " + dni + ", Nombre: " + nombre + ", Edad: " + edad + ", Goles: " + goles;
    }
}

// Comparador por Nombre
abstract class ComparadorNombre implements Comparator, ComparadorNombres {
    @Override
    public int compare(Futbolista f1, Futbolista f2) {
        return f1.get;
    }
}


