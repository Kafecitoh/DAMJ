package ud6;

import java.sql.ClientInfoStatus;

import ud5.asmexamen.Cliente;

public class MainSaludo {
    public static void main(String[] args) {
        
        GeneradorSaludo<String> saludoNombre = nombre -> "Hola, " + nombre + "!";
        System.out.println(saludoNombre.saludar("Ana"));

            GeneradorSaludo<Cliente> saludoCliente = cliente -> "Bienvenido, estimado cliente " + cliente.getNombre() + ".";
                Cliente cliente1 = new Cliente ("Luis");
                System.out.println(saludoCliente.saludar(cliente1));
                Cliente cliente2 = new Cliente ("María");
                System.out.println(saludoCliente.saludar(cliente2));


    }
}
