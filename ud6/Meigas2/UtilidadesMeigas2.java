package ud6.Meigas2;



import java.util.*;

public class UtilidadesMeigas2 {

public static Set obterIngredientesUnicos(Feitizo2[] feitizos) {
Set ingredientes = new HashSet<>();
for (Feitizo2 f : feitizos) {
ingredientes.addAll(f.getIngredientes());
}
return ingredientes;
}

public static List feitizosConIngredientes(Feitizo2[] feitizos, List ingredientesDisponibles) {
List resultado = new ArrayList<>();
for (Feitizo2 f : feitizos) {
if (ingredientesDisponibles.containsAll(f.getIngredientes())) {
resultado.add(f);
}
}
return resultado;
}

public static List ingredientesMaisUsados(Feitizo2[] feitizos) {
Map contador = new HashMap<>();
for (Feitizo2 f : feitizos) {
for (String ing : f.getIngredientes()) {
contador.put(ing, contador.getOrDefault(ing, 0) + 1);
}
}
List listaContados = new ArrayList<>(contador.entrySet());
listaContados.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

List top3 = new ArrayList<>();
for (int i = 0; i < Math.min(3, listaContados.size()); i++) {
top3.add(listaContados.get(i).getKey());
}
return top3;
}

public static List getFeitizosRnd(Feitizo2[] feitizos, int cantidad) {
List listaFeitizos = Arrays.asList(feitizos);
Collections.shuffle(listaFeitizos);
return listaFeitizos.subList(0, Math.min(cantidad, listaFeitizos.size()));
}

public static Map getIngredientesRnd(List ingredientes, int maxCantidad) {
Map resultado = new HashMap<>();
Random rnd = new Random();
for (String ing : ingredientes) {
resultado.put(ing, 1 + rnd.nextInt(maxCantidad));
}
return resultado;
}

public static void lanzarFeitizo(Meiga2 meiga, Feitizo2 feitizo) {
System.out.println("A meiga " + meiga.getNome() + " ('" + meiga.getAlcumeMaxico() + "') lanza o feitizo: " + feitizo.getNome());
System.out.println("Ingredientes utilizados:");
for (String ing : feitizo.getIngredientes()) {
System.out.println("- " + ing);
}
}
}