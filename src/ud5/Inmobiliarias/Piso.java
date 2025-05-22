package ud5.Inmobiliarias;

public class Piso extends Inmueble {
    private int planta;

    public Piso(String direccion, int metrosCuadrados, int habitaciones, int baños, int planta) {
        super(direccion, metrosCuadrados, habitaciones, baños);
        this.planta = planta;
    }

    @Override
    public String detalle() {
        String info = "Piso en " + getDireccion() + ".\n" +
                getMetrosCuadrados() + " m2, " + getHabitaciones() + " hab, " +
                getBaños() + " baños, " + planta + "ª planta.";
        if (getPrecioAlquiler() > 0) info += "\nPrecio de Alquiler: " + getPrecioAlquiler() + " €";
        if (getPrecioVenta() > 0) info += "\nPrecio de Venta: " + getPrecioVenta() + " €";
        return info;
    }
}