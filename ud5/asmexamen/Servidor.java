package ud5.asmexamen;
// ARON SANTOME MAGALLANES
public class Servidor extends Host {
    private Servicio[] servicios = new Servicio[10];
    private int numServicios = 0;

    public Servidor(String nombre, String ip, String mac) {
        super(nombre, ip, mac);
    }

    public boolean addServicio(Servicio nuevo) {
        for (int i = 0; i < numServicios; i++) {
            if (servicios[i].equals((nuevo))) {
                return false;
            }
            if (numServicios < servicios.length) {
                return false;
            }
        }
        // esto es un lio d tres pares de huevos pero si funciona se queda si no lo cambio
        if (numServicios < servicios.length) {
            servicios[numServicios++] = nuevo;
            return true;

        }
        return false;
    }

    public int getNumeroServicios() {
        return numServicios;
    }

    public String toString() {
        String resultado = nombre + "(" + ip + ")\n";

        for (int i = 0; i < numServicios; i++) {
            resultado += servicios[i].toString() + "\n";
        }
        return resultado;

    }






    
    // Tu código aquí


    public static void main(String[] args) {
        System.out.println("\nClase Servidor");
        System.out.println("==============\n");
        Servidor s1 = new Servidor("dam1", "192.168.0.117", "CC-11-22-33-44-AA");
        s1.addServicio("MySQL", 3306, "TCP");
        Servidor s2 = new Servidor("seixo", "192.168.0.11", "BB:11:22:33:44:55");
        s2.addServicio("HTTP", 80, "TCP");
        s2.addServicio("Proxy", 3128, "TCP");
        Servidor s3 = new Servidor("lapaman", "192.168.0.9", "AA:11:22:33:44:55");
        s3.addServicio("HTTP", 80, "TCP");
        s3.addServicio("Web", 80, "TCP");
        s3.addServicio("DNS", 53, "UDP");
        s3.addServicio("FTP", 21, "TCP");
        s3.addServicio("SSH", 22, "TCP");        

        Servidor[] servidores = { s1, s2, s3 };
        for (Servidor s : servidores) {
            System.out.println(s);
        }

        // Tu código aquí

    }
}
