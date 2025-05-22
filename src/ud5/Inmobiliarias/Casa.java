package ud5.Inmobiliarias;

public class Casa extends Inmueble {
    private int terreno;

    public Casa(String direccion, int metrosCuadrados, int habitaciones, int baños, int terreno) {
        super(direccion, metrosCuadrados, habitaciones, baños);
        this.terreno = terreno;
    }

    @Override
    public String detalle() {
        String info = "Casa en " + getDireccion() + ".\n" +
                getMetrosCuadrados() + " m2, " + getHabitaciones() + " hab, " +
                getBaños() + " baños, con terreno de " + terreno + " m2.";
        if (getPrecioAlquiler() > 0) info += "\nPrecio de Alquiler: " + getPrecioAlquiler() + " €";
        if (getPrecioVenta() > 0) info += "\nPrecio de Venta: " + getPrecioVenta() + " €";
        return info;
    }
}