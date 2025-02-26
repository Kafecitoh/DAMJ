package ud5;

public class InstrumetoAbstracto {
    enum NotaMusical {
        DO , RE , MI , FA , SOL , LA;
    }
    abstract  class Instrumento{
        NotaMusical nota;
    }
}
