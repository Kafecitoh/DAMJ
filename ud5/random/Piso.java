package ud5;

public class Piso extends Inmueble {
    private int planta;

    // Constructor
    public Piso(String direccion, int metrosCuadrados, int habitaciones, int baños, int planta) {
        super(direccion, metrosCuadrados, habitaciones);
        this.planta = planta;
    }

    // Implementación del método detalle sin StringBuilder
    @Override
    public String detalle() {
        String resultado = "Piso en " + getDireccion() + ".\n" +
                getMetrosCuadrados() + " m2, " + getHabitaciones() + " hab, " + planta + "ª planta.";

        if (getPrecioAlquiler() > 0) {
            resultado += " Precio de Alquiler: " + getPrecioAlquiler() + " €";
        }
        if (getPrecioVenta() > 0) {
            resultado += "\nPrecio de Venta: " + getPrecioVenta() + " €";
        }

        return resultado;
    }
}