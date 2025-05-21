package musicollab;
//APP
import java.util.*;
import java.util.stream.Collectors;

public class AppMusicCollab {

    public static List<Musico> musicosParaCancion(Cancion c, List<Musico> musicos) {
        return musicos.stream()
            .filter(m -> m.getInstrumentos().stream().anyMatch(i -> c.getInstrumentosRequeridos().contains(i))
                      && m.getRepertorio().contains(c))
            .sorted()
            .collect(Collectors.toList());
    }

    public static List<Cancion> cancionesPosibles(List<Musico> grupo, List<Cancion> canciones) {
        List<Cancion> posibles = new ArrayList<>();
        for (Cancion cancion : canciones) {
            Map<String, Musico> asignacion = new HashMap<>();
            for (String instrumento : cancion.getInstrumentosRequeridos()) {
                for (Musico m : grupo) {
                    if (m.getRepertorio().contains(cancion)) {
                        if (instrumento.equals("voz") && !asignacion.containsKey("voz") && m.getInstrumentos().contains("voz")) {
                            asignacion.put("voz", m);
                        } else if (!instrumento.equals("voz") && m.getInstrumentos().contains(instrumento)
                                && !asignacion.containsValue(m)) {
                            asignacion.put(instrumento, m);
                        }
                    }
                }
            }
            if (asignacion.keySet().containsAll(cancion.getInstrumentosRequeridos())) {
                posibles.add(cancion);
            }
        }
        Collections.sort(posibles);
        return posibles;
    }

    public static void main(String[] args) {
        // Crear canciones
        List<Cancion> canciones = List.of(
            new Cancion("Imagine", "John Lennon", "Balada", List.of("voz", "piano")),
            new Cancion("Smells Like Teen Spirit", "Nirvana", "Grunge", List.of("voz", "guitarra", "bajo", "batería")),
            new Cancion("Rolling in the Deep", "Adele", "Pop", List.of("voz", "piano", "batería")),
            new Cancion("Billie Jean", "Michael Jackson", "Pop", List.of("voz", "bajo", "batería")),
            new Cancion("Yesterday", "The Beatles", "Pop", List.of("voz", "guitarra")),
            new Cancion("Hotel California", "Eagles", "Rock", List.of("voz", "guitarra", "bajo", "batería")),
            new Cancion("Sweet Child O'Mine", "Guns N' Roses", "Rock", List.of("voz", "guitarra", "bajo", "batería")),
            new Cancion("Bohemian Rhapsody", "Queen", "Rock", List.of("voz", "piano", "guitarra", "batería"))
        );

        // Mostrar ordenadas por nombre
        System.out.println("Canciones ordenadas por nombre:");
        System.out.println("================================");
        canciones.stream().sorted().forEach(System.out::println);

        // Mostrar ordenadas por estilo, autor, nombre
        System.out.println("\nCanciones ordenadas por estilo musical, luego por autor y luego por nombre:");
        System.out.println("===============================================================================");
        canciones.stream()
                .sorted(Comparator.comparing(Cancion::getEstiloMusical)
                                  .thenComparing(Cancion::getAutor)
                                  .thenComparing(Cancion::getNombre))
                .forEach(System.out::println);

        // Instrumentos distintos
        System.out.println("\nLista de instrumentos distintos:");
        System.out.println(Cancion.instrumentosDistintos(canciones));

        // Crear músicos
        List<Musico> musicos = List.of(
            new Musico("Ana López", "BassQueen", List.of("bajo", "voz"), canciones),
            new Musico("Carlos Ruiz", "GuitarHero", List.of("guitarra", "voz"), canciones),
            new Musico("Elena Díaz", "MultiInstrumentalist", List.of("guitarra", "piano", "voz"), canciones),
            new Musico("Pablo Martín", "PianoMaster", List.of("piano"), canciones)
        );

        // Músicos para una canción concreta
        System.out.println("\nMúsicos para 'Bohemian Rhapsody':");
        System.out.println("==================================");
        musicosParaCancion(canciones.get(7), musicos).forEach(System.out::println);

        // Canciones posibles por grupo
        System.out.println("\nCanciones posibles para el grupo:");
        cancionesPosibles(musicos, canciones).forEach(System.out::println);
    }
}