package ud5;

public abstract class Inmueble {
    private String direccion;
    private int metrosCuadrados;
    private int habitaciones;
    private double precioAlquiler;
    private double precioVenta;

    // Constructor
    public Inmueble(String direccion, int metrosCuadrados, int habitaciones) {
        this.direccion = direccion;
        this.metrosCuadrados = metrosCuadrados;
        this.habitaciones = habitaciones;
        this.precioAlquiler = 0;
        this.precioVenta = 0;
    }

    // Métodos setters
    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    // Métodos get
    public String getDireccion() {
        return direccion;
    }

    public int getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    // Método abstracto paral inmubele
    public abstract String detalle();

    // Método para imprimir el resumen del inmueble

    @Override
    public String toString() {
        return "Inmueble en " + direccion + " (" + metrosCuadrados + " m2, " + habitaciones + " hab)";
    }
}
