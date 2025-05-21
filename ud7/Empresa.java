package ud7;

public class Empresa {
    private String nombre;
    private String direccion;

    public Empresa(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "Empresa: " + nombre + " | Dirección: " + direccion;
    }
}