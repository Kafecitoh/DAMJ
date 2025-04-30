package ud6.Meigas;

import java.util.ArrayList;
import java.util.List;

public class Meiga {
    private String nome;
    private String AlcumeMaxico;
    private List<Feitizo> feitizosFavoritos;


public Meiga(String nome, String AlcumeMaxico, List<Feitizo> feitizosFavoritos){
    this.nome = nome;
    this.AlcumeMaxico = AlcumeMaxico;
    this.feitizosFavoritos = new ArrayList<>();
}

public String getNome(){
    return nome;

}
public String getAlcumeMaxico(){
    return AlcumeMaxico;
}
public List<Feitizo> getFeitizosFavoritos(){
    return feitizosFavoritos;
}
public void engadirFeitizoFavorito(Feitizo f){
    feitizosFavoritos.add(f);
}


}


