package ud5.Inmobiliarias;



import java.util.Comparator;

public class Comparadores {
    public static abstract class PorMetrosCuadradosAsc implements Comparator, ud5.Inmobiliarias.PorMetrosCuadradosAsc {
        @Override
        public int compare(Inmueble i1, Inmueble i2) {
            return Integer.compare(i1.getMetrosCuadrados(), i2.getMetrosCuadrados());
        }
    }
}
