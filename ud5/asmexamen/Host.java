package ud5.asmexamen;
//ARON SANTOME MAGALLANES
import java.util.Arrays;

//pues clase base q represetna SI un equipoo esta en red
public class Host implements Comparable <Host> {
    protected String nombre;
    protected String mac;
    protected String ip;
    //con sus consntantes y toda la pesca
    private static final String MASCARA_REDE = "255.255.0.0";
    private static final String PUERTA_ENLACE = "192.168.0.11";
    private static final String SERVIDOR_DNS = "192.168.0.11";
    // constructor para validar (antes de asignar)lo q pude el pdf del diablo

    public Host(String nombre, String ip, String mac) {
        if (nombre == null || !validarIP(mac)) {
            throw new IllegalArgumentException("Host no valido");
        }
        this.nombre = nombre;
        this.ip = ip;
        // pa luego
        this.mac = normalizarMac(mac);
    }
    // y a tope con los metodos
//para validar la ip
    public static boolean ValidarIp(String ip) {
        return ip.matches("\\d{1,3} (\\.\\.d{3,3}){3}");
    }
//para validar el mac
    private boolean ValidarMac(String mac) {
        return mac.matches("([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})");
    }
//para la
    public String normalizarMac(String mac) {
        return mac.replace("-", ":").toUpperCase();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Host))
            return false;
        Host otro = (Host) obj;
        return this.mac.equalsIgnoreCase((otro.mac));
    }

    @Override
    public String toString() {
        return nombre + " ( " + ip + "/ " + mac + ")";

    }
    @Override
    public int compareTo(Host otro) {
        return this.nombre.compareTo(otro.nombre);
    }


// Tu código aquí


    boolean validarIP(String ip) {
        return ip.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
    }

    boolean validarMAC(String mac) {
        return mac.matches("([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})");
    }


    public static void main(String[] args) {
        System.out.println("\nClase Host");
        System.out.println("==========\n");
        Host h100 = new Host("host100", "192.168.117.100", "00:11:22:33:44:55");
        Host h101 = new Host("equipo101", "192.168.117.101", "00:11:22:33:44:55");
        Host h102 = new Host("nodo100", "192.168.117.100", "00-11-22-33-44-AA");
        Host h103 = new Host("host103", "192.168.117.103", "00-11-22-33-44-55");

        Host[] Hosts = {h100, h101, h102, h103};
        Arrays.sort(Hosts);
        for (Host h : Hosts) {
            System.out.println(h);
        }

        System.out.println(h100.nombre + " = " + h101.nombre + "? " + h100.equals(h101)); // true
        System.out.println(h100.nombre + " = " + h102.nombre + "? " + h100.equals(h102)); // false
        System.out.println(h100.nombre + " = " + h103.nombre + "? " + h100.equals(h103)); // true
    }
}