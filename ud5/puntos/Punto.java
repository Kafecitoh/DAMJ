package ud5;

import java.util.logging.XMLFormatter;

// Clase Punto en 2D
public class Punto {
    private int x, y;

    // Constructor
    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public double distancia(Punto otroPunto) {
        return Math.sqrt(Math.pow(otroPunto.x - this.x, 2) + Math.pow(otroPunto.y - this.y, 2));
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Punto punto = (Punto) obj;
        return x == punto.x && y == punto.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}



