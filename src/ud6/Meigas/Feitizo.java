package ud6.Meigas;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Feitizo {
    private String nome;
    private String[]ingredientes;
    private int dificultade;

    public Feitizo(String nome, String[] ingredientes, int dificultade){
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.dificultade= dificultade;
    }

    public String getNome(){
        return nome;
    }
    public String[] getIngredientes(){
        return ingredientes;
    }

    public int getDificultade(){
        return dificultade;
    }
    public class UtilidadesMeigas {
        public Set<String> rexistroIngredientesUnicos(Feitizo[]feitizos){
            Set<String> ingredientesUnicos = new HashSet<>();
                for(Feitizo f : feitizos){
                    ingredientesUnicos.addAll(Arrays.asList(f.getIngredientes()));
                }
                return ingredientesUnicos;
        }
    }


public static Feitizo[] crearFeitizosExemplo() {
    String[] ingredientes1 = {"auga de río encantada", "pétalos de rosa silvestre", "fume de lareira"};
    String[] ingredientes2 = {"auga do mar", "salicornia", "berberechos místicos"};
    String[] ingredientes3 = {"raíz de toxo", "auga bendita", "po de estrela fugaz"};
    String[] ingredientes4 = {"auga de río encantada", "raíz de toxo", "pel de serpe"};
    String[] ingredientes5 = {"auga do mar", "po de estrela fugaz", "cinza de bidueiro"};
    String[] ingredientes6 = {"auga bendita", "pétalos de rosa silvestre", "brétema das fragas"};
    
    Feitizo f1 = new Feitizo("Encantamento da Chuvia Mansa", ingredientes1, 3);
    Feitizo f2 = new Feitizo("Invocación Mariña", ingredientes2, 4);
    Feitizo f3 = new Feitizo("Luz do Luar", ingredientes3, 2);
    Feitizo f4 = new Feitizo("Garda da Fraga", ingredientes4, 3);
    Feitizo f5 = new Feitizo("Respiro Oceánico", ingredientes5, 4);
    Feitizo f6 = new Feitizo("Bendición Floral", ingredientes6, 2);
    
    return new Feitizo[]{f1, f2, f3, f4, f5, f6};
    }
    

}
