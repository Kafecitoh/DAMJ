package ud5.Maquinaria;

 class Vagon {
    int id;
    int cargaMaxima;
    int cargaActual;
    String tipoMercancia;

     public Vagon(int cargaActual, String tipoMercancia, int cargaMaxima, int id) {
         this.cargaActual = cargaActual;
         this.tipoMercancia = tipoMercancia;
         this.cargaMaxima = cargaMaxima;
         this.id = id;
     }
 }


