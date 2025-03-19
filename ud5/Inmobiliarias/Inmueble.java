package ud5.Inmobiliarias;


public abstract class Inmueble {
    private String direccion;
    private int metrosCuadrados;
    private int habitaciones;
    private int baños;
    private double precioAlquiler;
    private double precioVenta;

    public Inmueble(String direccion, int metrosCuadrados, int habitaciones, int baños) {
        this.direccion = direccion;
        this.metrosCuadrados = metrosCuadrados;
        this.habitaciones = habitaciones;
        this.baños = baños;
    }

    public String getDireccion() { return direccion; }
    public int getMetrosCuadrados() { return metrosCuadrados; }
    public int getHabitaciones() { return habitaciones; }
    public int getBaños() { return baños; }
    public double getPrecioAlquiler() { return precioAlquiler; }
    public double getPrecioVenta() { return precioVenta; }

    public void setPrecioAlquiler(double precioAlquiler) { this.precioAlquiler = precioAlquiler; }
    public void setPrecioVenta(double precioVenta) { this.precioVenta = precioVenta; }

    @Override
    public String toString() {
        return "Inmueble en " + direccion + " (" + metrosCuadrados + " m2, " + habitaciones + " hab)";
    }

    // Método abstracto para los detalles específicos de Piso y Casa
    public abstract String detalle();
}