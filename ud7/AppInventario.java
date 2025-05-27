// ========= CLASE PRINCIPAL DEL INVENTARIO =========
// Menú en consola para añadir, buscar y listar productos
package inventario;

import java.io.*;
import java.util.*;

public class AppInventario {
    static final String PATH = "src/inventario/inventario.dat";
    static List<Producto> inventario = new ArrayList<>();

    public static void main(String[] args) {
        cargarInventario();

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n1. Agregar producto\n2. Listar productos\n3. Buscar por código\n0. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> agregarProducto(sc); // meto un nuevo producto
                case 2 -> listarProductos();  // muestro todos
                case 3 -> buscarProducto(sc); // busco uno por código
            }
        } while (opcion != 0);

        guardarInventario();
        sc.close();
    }

    static void agregarProducto(Scanner sc) {
        System.out.print("Código: ");
        int codigo = sc.nextInt();
        sc.nextLine();
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

        inventario.add(new Producto(codigo, nombre, cantidad, precio));
        System.out.println("Producto agregado.");
    }

    static boolean existeCodigo(int codigo) {
        return inventario.stream().anyMatch(p -> p.getCodigo() == codigo);
    }

    static void listarProductos() {
        inventario.stream()
                .sorted(Comparator.comparingInt(Producto::getCodigo))
                .forEach(System.out::println);
    }

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

    static void cargarInventario() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PATH))) {
            inventario = (List<Producto>) in.readObject();
        } catch (Exception e) {
            inventario = new ArrayList<>();
        }
    }

    static void guardarInventario() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PATH))) {
            out.writeObject(inventario);
        } catch (IOException e) {
            System.out.println("Error al guardar inventario: " + e.getMessage());
        }
    }
}