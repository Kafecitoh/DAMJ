package ud6;

public interface GeneradorSaludo <T> {
    String saludar (T objeto);

    class Cliente {
        String nombre;
        public Cliente(String nombre){
            this.nombre = nombre;
        }
        public String getNombre(){
            return nombre;
        }
    }
    
}
