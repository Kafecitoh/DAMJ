package ud6.Meigas;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class UtilidadesMeigas {

public static Set rexistroIngredientesUnicos(Feitizo[] feitizos) {
Set ingredientesUnicos = new HashSet<>();

for (Feitizo f : feitizos) {

ingredientesUnicos.addAll(Arrays.asList(f.getIngredientes()));
}

return ingredientesUnicos;
}
}