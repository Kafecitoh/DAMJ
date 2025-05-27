// Autor: Aron Santomé Magallanes

// ========== 1. CLASE AppNotas ==========
// Este programa lee un archivo de texto llamado notas.txt donde vienen los nombres de los alumnos
// junto con sus notas separadas por comas. Calcula el promedio de cada uno y guarda los resultados
// en un nuevo archivo llamado promedios.txt.
// Se usa cuando quieres procesar datos numéricos de un fichero de texto y generar un resumen.
package notas;

import java.io.*;
import java.util.Scanner;

public class AppNotas {
    static final String PATH = "src/notas/"; // Ruta base donde están los ficheros

    public static void main(String[] args) {
        try {
            // Abro el archivo notas.txt para leer
            BufferedReader reader = new BufferedReader(new FileReader(PATH + "notas.txt"));
            // Preparo otro archivo para escribir los resultados
            BufferedWriter writer = new BufferedWriter(new FileWriter(PATH + "promedios.txt"));
            Scanner sc = new Scanner(reader); // uso Scanner porque permite trabajar línea a línea

            // Leo cada línea del fichero mientras haya
            while (sc.hasNextLine()) {
                String linea = sc.nextLine(); // leo una línea tipo "Juan,8,7,9"
                String[] partes = linea.split(","); // separo por comas

                String nombre = partes[0]; // el primer valor siempre es el nombre
                double suma = 0;

                // desde la posición 1 en adelante son las notas
                for (int i = 1; i < partes.length; i++) {
                    suma += Double.parseDouble(partes[i]); // convierto cada nota a double y la sumo
                }

                // calculo el promedio dividiendo entre el nº de notas
                double promedio = suma / (partes.length - 1);
                // escribo en el archivo destino el nombre y su promedio
                writer.write(nombre + ": " + promedio);
                writer.newLine(); // salto de línea
            }

            // cierro todos los flujos, muy importante
            writer.close();
            sc.close();
            reader.close();

        } catch (FileNotFoundException e) {
            // Si el fichero no existe, lo aviso
            System.out.println("Fichero no encontrado: " + e.getMessage());
        } catch (IOException e) {
            // Errores de lectura o escritura
            System.out.println("Error de lectura/escritura: " + e.getMessage());
        } catch (NumberFormatException e) {
            // Por si alguna nota no es un número
            System.out.println("Error en formato numérico: " + e.getMessage());
        }
    }
}


// ========== 2. CLASE AppInventario ==========
// Este programa permite gestionar un inventario de productos usando un menú por consola.
// Usa un fichero binario para guardar y recuperar los datos usando serialización.
// Útil cuando necesitas guardar objetos enteros (como productos) entre sesiones del programa.
package inventario;

import java.io.*;
import java.util.*;

public class AppInventario {
    static final String PATH = "src/inventario/inventario.dat"; // Ruta del fichero binario
    static List<Producto> inventario = new ArrayList<>(); // lista donde guardamos los productos

    public static void main(String[] args) {
        cargarInventario(); // intenta cargar productos previos desde el fichero binario

        Scanner sc = new Scanner(System.in);
        int opcion;

        // Menú principal. Se repite hasta que pongas 0 para salir.
        do {
            System.out.println("\n1. Agregar producto\n2. Listar productos\n3. Buscar por código\n0. Salir");
            opcion = sc.nextInt();

            // según la opción llamo a un método diferente
            switch (opcion) {
                case 1 -> agregarProducto(sc); // Añadir un nuevo producto al inventario
                case 2 -> listarProductos();  // Mostrar todos los productos
                case 3 -> buscarProducto(sc); // Buscar un producto por código
            }
        } while (opcion != 0);

        guardarInventario(); // guarda todo al salir
        sc.close();
    }

    // Pide datos al usuario para crear un nuevo producto y lo añade al inventario si es válido
    static void agregarProducto(Scanner sc) {
        System.out.print("Código: ");
        int codigo = sc.nextInt();
        sc.nextLine(); // para limpiar salto de línea

        // Evito códigos duplicados
        if (existeCodigo(codigo)) {
            System.out.println("Ya existe un producto con ese código.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        if (nombre.isBlank()) {
            System.out.println("El nombre no puede estar en blanco.");
            return;
        }

        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();

        // Creo el objeto y lo añado a la lista
        inventario.add(new Producto(codigo, nombre, cantidad, precio));
        System.out.println("Producto agregado.");
    }

    // Comprueba si ya existe un producto con ese código
    static boolean existeCodigo(int codigo) {
        return inventario.stream().anyMatch(p -> p.getCodigo() == codigo);
    }

    // Muestra todos los productos ordenados por código
    static void listarProductos() {
        inventario.stream()
                .sorted(Comparator.comparingInt(Producto::getCodigo))
                .forEach(System.out::println);
    }

    // Busca un producto por su código y lo muestra si existe
    static void buscarProducto(Scanner sc) {
        System.out.print("Introduce el código a buscar: ");
        int codigo = sc.nextInt();
        Producto encontrado = inventario.stream()
                .filter(p -> p.getCodigo() == codigo)
                .findFirst()
                .orElse(null);

        if (encontrado == null) {
            System.out.println("No se encontró el producto.");
        } else {
            System.out.println(encontrado);
        }
    }

    // Carga la lista desde el archivo binario si existe
    static void cargarInventario() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PATH))) {
            inventario = (List<Producto>) in.readObject();
        } catch (Exception e) {
            // Si hay error o no existe, empiezo con la lista vacía
            inventario = new ArrayList<>();
        }
    }

    // Guarda la lista en el archivo binario
    static void guardarInventario() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PATH))) {
            out.writeObject(inventario);
        } catch (IOException e) {
            System.out.println("Error al guardar inventario: " + e.getMessage());
        }
    }
}

// ========== 3. CLASE Producto ==========
// Esta clase representa un producto del inventario.
// Es Serializable para que se pueda guardar en fichero binario.
package inventario;

import java.io.Serializable;

public class Producto implements Serializable {
    private int codigo;
    private String nombre;
    private int cantidad;
    private double precio;

    // Constructor con todos los campos
    public Producto(int codigo, String nombre, int cantidad, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getter necesario para ordenar o buscar por código
    public int getCodigo() {
        return codigo;
    }

    // Método para mostrar bonito por consola
    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
} 
