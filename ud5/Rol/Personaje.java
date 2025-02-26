package ud5.Rol;


import java.util.Random;

public class Personaje { private String nombre; private String raza; private int fuerza, agilidad, constitucion, inteligencia, intuicion, presencia; private int nivel, experiencia, puntosDeVida;

    private static final String[] RAZAS_VALIDAS = {"HUMANO", "ELFO", "ENANO", "HOBBIT", "ORCO", "TROLL"};
    private static final Random rand = new Random();

    public Personaje(String nombre, String raza, int fuerza, int agilidad, int constitucion, int inteligencia,int intuicion, int presencia) {
        if (!esRazaValida(raza) || fuerza <= 0 || agilidad <= 0 || constitucion <= 0 ||
                inteligencia <= 0 || intuicion <= 0 || presencia <= 0) {
            throw new IllegalArgumentException("Valores inválidos");
        }

        this.nombre = nombre;
        this.raza = raza;
        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.constitucion = constitucion;
        this.inteligencia = inteligencia;
        this.intuicion = intuicion;
        this.presencia = presencia;
        this.nivel = 1;
        this.experiencia = 0;
        this.puntosDeVida = 50 + constitucion;
    }

    public Personaje(String nombre, String raza) {
        this(nombre, raza, getRandomAtributo(), getRandomAtributo(), getRandomAtributo(),
                getRandomAtributo(), getRandomAtributo(), getRandomAtributo());
    }

    public Personaje(String nombre) {
        this(nombre, "HUMANO");
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Raza: " + raza);
        System.out.println("Fuerza: " + fuerza);
        System.out.println("Agilidad: " + agilidad);
        System.out.println("Constitución: " + constitucion);
        System.out.println("Nivel: " + nivel);
        System.out.println("Experiencia: " + experiencia);
        System.out.println("Puntos de Vida: " + puntosDeVida);
    }

    private static boolean esRazaValida(String raza) {
        for (String r : RAZAS_VALIDAS) {
            if (r.equalsIgnoreCase(raza)) {
                return true;
            }
        }
        return false;
    }

    private static int getRandomAtributo() {
        return rand.nextInt(100) + 1;
    }

}
