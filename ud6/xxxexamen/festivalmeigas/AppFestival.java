package ud6.xxxexamen.festivalmeigas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AppFestival {

    public static void main(String[] args) {
        System.out.println("\nFESTIVAL DE MEIGAS");
        System.out.println("==================\n");
        // Crea un array de meigas de exemplo
        Meiga[] meigasExemplo = Meiga.crearMeigasExemplo(Feitizo.crearFeitizosExemplo());

        //todo el 3
        Arrays.sort(meigasExemplo, Comparator.comparingInt (m -> m.getFeitizos().size()));
        Map<Meiga,Integer> puntuacions = new HashMap<>();
            for (Meiga meiga : meigasExemplo){
                int puntos = meiga.lanzarFeitizos();
                    puntuacions.put(meiga , puntos);
        
            }

           

            System.out.println("Clasificacion Final ");

        // TODO: Ordena as Meigas de menor a maior número de feitizos
         //se ordenan por puntuacion descendente y alcume
            //el entry es prara recorrer tanto calves como valores, para esto
            List<Map.Entry<Meiga,Integer>> clasificacion = new ArrayList<>(puntuacions.entrySet());
            clasificacion.sort((e1,e2) -> {
                int compare = Integer.compare(e2.getValue() , e1.getValue());
                return compare != 0 ? compare : e1.getKey().getAlcume().compareToIgnoreCase(e2.getKey().getAlcume());

            });
            System.out.println("Clasificacion Final ");
  

        


        for (Meiga meiga : meigasExemplo) {
            System.out.println("MEIGA: ");
            System.out.println(meiga);
            int puntos = meiga.lanzarFeitizos();
            System.out.println("TOTAL PUNTOS: " + puntos + "\n\n");
        }

        // Amosa a clasificación final do festival
        System.out.println("Clasificación Final do Festival: ");
        // TODO: Engade o código que necesites...

        System.out.println("\nFIN DO FESTIVAL DE MEIGAS\n");
    }

}
