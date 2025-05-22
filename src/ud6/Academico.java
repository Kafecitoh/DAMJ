package ud6;
/*E1216. Los miembros de la Real Academia de la Lengua ocupan sillones con las letras 
del abecedario español, minúsculas y mayúsculas (en la práctica, las letras v, w, x, y, z, N, 
W, Y nunca se ocupan, pero nosotros no lo tendremos en cuenta). Cuando un sillón 
queda vacante, se nombra un nuevo académico para ocuparlo. 
 
Implementar la clase Academico cuyos atributos son el nombre y el año de ingreso. El 
criterio de ordenación natural será por nombres. 
 
Implementar un programa donde se cargan los datos de los académicos se crean cinco 
objetos Academico, que se insertan en 
un mapa en el que la clave es la letra del sillón que ocupan, y el valor un objeto de la 
clase Academico. Para ello implementar el método estático: 
 
static boolean nuevoAcademico (Map<Character, Academico> academia, Academico 
nuevo, Character letra) 
 
donde se lleva a cabo la inserción después de comprobar que el carácter pasado como 
parámetro es una letra del abecedario. 
 
Hacer diversos listados de los académicos:  
1.  primero sin letra, por orden de nombre y de año de ingreso;  
2.  y después con letra, por orden de letra (clave), nombre y fecha de ingreso. 
 
Debemos recordar que en código Unicode, las mayúsculas van antes que las minúsculas. 
 
Utiliza el método del repositorio para cargar y preparar los datos del fichero de texto:  

public static String readFileToString(String filePath)  */ 

public class Academico implements Comparable <Academico>{
    private String nombre;
    private int anioIngreso;

public Academico (String nombre, int anioIngreso){
    this.nombre = nombre;
    this.anioIngreso = anioIngreso;
}
    public String getNombre(){
        return nombre;
    }
    public int getAnioIngreso(){
        return anioIngreso;
    }
    @Override
    public int compareTo(Academico otro) {
        return this.nombre.compareTo(otro.nombre);
    }
    @Override
    public String toString() {
        return  "anioIngreso=" + anioIngreso;
    } 
}


    

