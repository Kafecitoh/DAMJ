//ADNRE Y ARON
package ud5.Mulleres;

// Clase abstracta base
abstract class MullerTraballadora {
    protected String nome;
    protected String apelidos;
    protected int anoNascimento;

    public MullerTraballadora(String nome, String apelidos, int anoNascimento) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.anoNascimento = anoNascimento;
    }

    public abstract String descripcionContribucion();

    public int getIdade(int anoActual) {
        return anoActual - this.anoNascimento;
    }
}

// Interfaces
interface IPioneira {
    String getDescubrimentoOuAporte();
}

interface IActivista {
    String getCausaDefendida();
}

// Clases concretas
class Cientifica extends MullerTraballadora implements IPioneira {
    private String descubrimento;

    public Cientifica(String nome, String apelidos, int anoNascimento, String descubrimento) {
        super(nome, apelidos, anoNascimento);
        this.descubrimento = descubrimento;
    }

    @Override
    public String descripcionContribucion() {
        return "Descubriu " + descubrimento;
    }

    @Override
    public String getDescubrimentoOuAporte() {
        return descubrimento;
    }
}

class Artista extends MullerTraballadora {
    private String estilo;

    public Artista(String nome, String apelidos, int anoNascimento, String estilo) {
        super(nome, apelidos, anoNascimento);
        this.estilo = estilo;
    }

    @Override
    public String descripcionContribucion() {
        return "Destacou na arte co estilo: " + estilo;
    }
}

class Politica extends MullerTraballadora implements IActivista {
    private String causa;

    public Politica(String nome, String apelidos, int anoNascimento, String causa) {
        super(nome, apelidos, anoNascimento);
        this.causa = causa;
    }

    @Override
    public String descripcionContribucion() {
        return "Foi unha política e activista destacada por: " + causa;
    }

    @Override
    public String getCausaDefendida() {
        return causa;
    }
}





