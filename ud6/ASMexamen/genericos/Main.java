package ud6.xxxexamen.genericos;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        List<String> lista = List.of("uva","pera","manzana","kiwi");
        System.out.println("Original : " + lista);
        System.out.println("Repetiods " + repetidos(lista));
    List<Integer> numeros = List.of(2, 6, 3, 8, 1, 9);
    System.out.println("Mayores o iguales que 5: " + filtrarMayores(numeros,5,Integer::compare));
    }
    
}
