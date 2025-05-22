// ARON SANTOME MAGLALANES
package ud5.asmexamen;
//vale esta clase represeta un servicio de red para un server

public class Servicio {
    private String nombre;
    private int puerto;
    private String protocolo; // el tcp o udp

    //constructo con nombre puerto y protocolo
    public Servicio(String nombre, int puerto, String protocolo) {
        this.nombre = nombre;
        this.puerto = puerto;
        this.protocolo = protocolo = protocolo.toUpperCase();
    }

    public int getPuerto() {
        return puerto;
    }

    public String getProtocolo() {
        return protocolo;
    }


    //dos servicios son iguales si tienes ele mismo protoclo y servicio
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Servicio))
            return false;
            Servicio otro = (Servicio) o;
            return this.puerto == otro.puerto && this.protocolo.equalsIgnoreCase(otro.protocolo);
        }

    public String toString() {
        return "*" + nombre + "(" + puerto + "/" + protocolo + ")";

    }
}

