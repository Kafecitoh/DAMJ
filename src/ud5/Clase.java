package ud5;

import java.util.Comparator;

class Clase {
    static class claseAnidadaEstatica{

    }

     class ClaseInterna{

     }

    public static void main(String[] args) {
        class ClaseInternaLocal{

        }
        Comparator claseAnonima = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
    }

}
