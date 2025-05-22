package ud5;

class Punto3D extends Punto {
    private int z;


    public Punto3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public double distancia(Punto3D otroPunto) {
        double dist2D = super.distancia(otroPunto); // Distancia en 2D
        return Math.sqrt(Math.pow(dist2D, 2) + Math.pow(otroPunto.z - this.z, 2));
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Punto3D punto3D = (Punto3D) obj;
        return z == punto3D.z;
    }
    @Override
    public String toString() {
        return super.toString().replace(")", ", " + z + ")");
    }
}
