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


}
