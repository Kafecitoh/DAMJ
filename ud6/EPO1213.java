package ud6;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*E1213. Implementar la clase Sorteo con parámetros genéricos. Deberá guardar un 
conjunto de valores distintos de tipo genérico, suministrados por consola y será capaz de 
generar una combinación premiada de un tamaño determinado. Deberán implementarse. 
como minimo, los métodos: 
●  boolean add (T elemento) que añadirá un elemento nuevo al conjunto de 
valores posibles en una apuesta. Si el elemento se añade, devuelve true y, en 
caso contrario, debido a que ya estaba presente, false. 
●  Set<T> premiados (int numPremiados)  que devolverá una combinación 
ganadora de numPremiados elementos distintos. 
  */
public class EPO1213 {
    public class Sorteo <T> {
        private Set <T> valores;
        private Random random;

        public Sorteo() {
            this.valores = new HashSet<>();
            this.random = new Random();
        }
        public boolean add (T elemento) {
            return valores.add(elemento);
        }
        public Set <T> premiados (int numPremiados){
                if (numPremiados > valores.size()) {
                    throw new IllegalArgumentException("No hay suficientes elementos para premiar");
                }
        }
    }
    
}
