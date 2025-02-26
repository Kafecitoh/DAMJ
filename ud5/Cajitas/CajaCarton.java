package ud5.Cajitas;


public class CajaCarton extends Caja {
    private static double superficieTotalCarton = 0;

    public CajaCarton(int ancho, int alto, int fondo) {
        super(ancho, alto, fondo, Unidad.CM);
        superficieTotalCarton += calcularSuperficie();
    }

    @Override
    public double getVolumen() {
        return super.getVolumen() * 0.8;
    }

    public double calcularSuperficie() {
        int ancho = super.ancho;
        int alto = super.alto;
        int fondo = super.fondo;
        return 2 * ((ancho * alto) + (ancho * fondo) + (alto * fondo));
    }

    public static double getSuperficieTotalCarton() {
        return superficieTotalCarton;
    }

    @Override
    public String toString() {
        return super.toString() + " (volumen ajustado: " + getVolumen() + " m³)";
    }

    public static void main(String[] args) {
        CajaCarton caja1 = new CajaCarton(50, 30, 40);
        CajaCarton caja2 = new CajaCarton(60, 40, 50);

        System.out.println(caja1);
        System.out.println(caja2);
        System.out.println("Superficie total de cartón utilizada: " + CajaCarton.getSuperficieTotalCarton() + " cm²");
    }
}