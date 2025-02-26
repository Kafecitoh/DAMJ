package ud5.Cajitas;
public class Caja {
    public enum Unidad { CM, M }

    final int ancho;
    final int alto;
    final int fondo;
    private final Unidad unidad;
    private String etiqueta;

    public Caja(int ancho, int alto, int fondo, Unidad unidad) {
        this.ancho = ancho;
        this.alto = alto;
        this.fondo = fondo;
        this.unidad = unidad;
        this.etiqueta = "";
    }

    public double getVolumen() {
        double factor = (unidad == Unidad.CM) ? 0.01 : 1.0;
        return (ancho * factor) * (alto * factor) * (fondo * factor);
    }

    public void setEtiqueta(String etiqueta) {
        if (etiqueta.length() > 30) {
            this.etiqueta = etiqueta.substring(0, 30);
        } else {
            this.etiqueta = etiqueta;
        }
    }

    @Override
    public String toString() {
        return "Caja{" +
                "ancho=" + ancho + " " + unidad +
                ", alto=" + alto + " " + unidad +
                ", fondo=" + fondo + " " + unidad +
                ", volumen=" + getVolumen() + " m³" +
                ", etiqueta='" + etiqueta + '\'' +
                '}' ;
    }

    public static void main(String[] args) {
        Caja caja1 = new Caja(50, 30, 40, Unidad.CM);
        caja1.setEtiqueta("Destinatario: Juan Pérez, Dirección: Calle 123");
        System.out.println(caja1);
        Caja caja2 = new Caja(1, 2, 3, Unidad.M);
        caja2.setEtiqueta("Paquete grande");.,mnbvcx
        System.out.println(caja2);
    }
}
