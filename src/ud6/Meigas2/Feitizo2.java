package ud6.Meigas2;


import java.util.List;

public class Feitizo2 {
private String nome;
private List ingredientes;
private int dificuldade;

public Feitizo2(String nome, List ingredientes, int dificuldade) {
this.nome = nome;
this.ingredientes = ingredientes;
this.dificuldade = dificuldade;
}

public String getNome() {
return nome;
}

public List getIngredientes() {
return ingredientes;
}

public int getDificuldade() {
return dificuldade;
}

@Override
public String toString() {
return nome + " (dificultade: " + dificuldade + ", ingredientes: " + ingredientes + ")";
}

public static Feitizo2[] crearFeitizosExemplo() {
Feitizo2[] feitizos = new Feitizo2[] {
new Feitizo2("Encantamento da Chuvia Mansa", List.of("auga de río encantada", "pétalos de rosa silvestre", "fume de lavanda"), 3),
new Feitizo2("Invocación Mariña", List.of("auga do mar", "salicornia", "berberechos místicos"), 4),
new Feitizo2("Luz do Luar", List.of("raíz de toxo", "auga bendita", "po de estrela fugaz"), 2),
new Feitizo2("Garda da Fraga", List.of("auga de río encantada", "raíz de toxo", "pel de serpe"), 3),
new Feitizo2("Respiro Oceánico", List.of("auga do mar", "po de estrela fugaz", "cinza de bidueiro"), 4),
new Feitizo2("Bendición Floral", List.of("auga bendita", "pétalos de rosa silvestre", "brétema das fragas"), 2)
};
return feitizos;
}
}
