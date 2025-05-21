package ud6.Meigas2;

/*
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Meiga2 {
private String nome;
private String alcumeMaxico;
private List feitizosFavoritos;
private Map inventarioIngredientes;

public Meiga2(String nome, String alcumeMaxico) {
this.nome = nome;
this.alcumeMaxico = alcumeMaxico;
this.feitizosFavoritos = new ArrayList<>();
this.inventarioIngredientes = new HashMap<>();
}

public String getNome() {
return nome;
}

public String getAlcumeMaxico() {
return alcumeMaxico;
}

public List getFeitizosFavoritos() {
return feitizosFavoritos;
}

public Map getInventarioIngredientes() {
return inventarioIngredientes;
}

public void engadirFeitizoFavorito(Feitizo2 f) {
if (!feitizosFavoritos.contains(f)) {
feitizosFavoritos.add(f);
}
}

public void engadirIngrediente(String ingrediente, int cantidade) {
inventarioIngredientes.put(ingrediente, inventarioIngredientes.getOrDefault(ingrediente, 0) + cantidade);
}

public void eliminarIngrediente(String ingrediente) {
inventarioIngredientes.remove(ingrediente);
}

public void substituirIngrediente(String antigo, String novo, int cantidade) {
eliminarIngrediente(antigo);
engadirIngrediente(novo, cantidade);
}

@Override
public String toString() {
return nome + " ('" + alcumeMaxico + "') Feitizos favoritos: " + feitizosFavoritos + ", Inventario: " + inventarioIngredientes;
}
}

 */