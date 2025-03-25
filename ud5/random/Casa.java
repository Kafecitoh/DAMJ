package ud5;

    // Constructor
    public class Casa extends Inmueble {
        private int terreno;

        // Constructor
        public Casa(String direccion, int metrosCuadrados, int habitaciones, int baños, int terreno) {
            super(direccion, metrosCuadrados, habitaciones);
            this.terreno = terreno;
        }

        // Implementación del método detalle sin StringBuilder
        @Override
        public String detalle() {
            String resultado = "Casa en " + getDireccion() + ".\n" +
                    getMetrosCuadrados() + " m2, " + getHabitaciones() + " hab, con terreno de " + terreno + " m2.";

            if (getPrecioAlquiler() > 0) {
                resultado += " Precio de Alquiler: " + getPrecioAlquiler() + " €";
            }
            if (getPrecioVenta() > 0) {
                resultado += "\nPrecio de Venta: " + getPrecioVenta() + " €";
            }

            return resultado;
        }
    }
