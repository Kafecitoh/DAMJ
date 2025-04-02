package CONTORNOS.BadSmells.LongMethod;

class ClienteBien {
    private String nombre;
    private String direccion;
    private String telefono;

    // Constructor
    public ClienteBien(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getter para el nombre
    public String getNombre() {
        return nombre;
    }
}

class Cuenta {
    private double saldo;

    // Constructor
    public Cuenta(double saldo) {
        this.saldo = saldo;
    }

    // Método para pagar factura
    public void pagarFactura(double monto) {
        saldo -= monto;
    }
}

class Notificador {
    // Método para enviar notificación
    public void enviarNotificacion(ClienteBien cliente) {
        System.out.println("Enviando notificación a " + cliente.getNombre());
    }
    public static void main(String[] args) {
        // Crear instancias de Cliente, Cuenta y Notificador
        ClienteBien cliente = new ClienteBien("Juan Pérez", "Calle Falsa 123", "555-1234");
        Cuenta cuenta = new Cuenta(500.0);
        Notificador notificador = new Notificador();

        // Procesar el pago de la factura
        cuenta.pagarFactura(100);

        // Enviar notificación
        notificador.enviarNotificacion(cliente);
    }
}

