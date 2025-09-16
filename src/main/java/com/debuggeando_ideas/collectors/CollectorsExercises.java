package com.debuggeando_ideas.collectors;

import com.debuggeando_ideas.util.Console;
import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Review;
import com.debuggeando_ideas.util.Videogame;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Los collectors son operaciones de recoleccion utiles, como acumular elementos en colecciones (listas o conjuntos)
 * resumir elementos segun distintos criterios como agrupaciones o particiones. El metodo collect es un operador final
 */
public class CollectorsExercises {

    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();
        getReviews(videogames);
        System.out.println("------------------");
        Stream<Videogame> videogames2 = Database.videogames.stream();
        getWebSites(videogames2);
        System.out.println("------------------");
        Stream<Videogame> videogames3 = Database.videogames.stream();
        getConsolesPricesAvg(videogames3);
    }

    /*
     *Regresar una lista inmutable con todos los reviews del stream.
     */
    static List<Review> getReviews(Stream<Videogame> stream) {
        return stream
                .flatMap(v -> v.getReviews().stream())
                .peek(System.out::println)
                .collect(Collectors.toUnmodifiableList());
    }

    /*
     * Regresar un mapa true con todos los videojuegos que tengan una url(website) con una longitud menor a 15
     *  de lo contrario regresar false con una lista de los videojuegos que no cumplan la condition.
     */
    static Map<Boolean, List<Videogame>> getWebSites(Stream<Videogame> stream) {
        Map<Boolean, List<Videogame>> result =
                stream
                        .collect(Collectors.partitioningBy(v -> v.getOfficialWebsite().length() < 15));
        result.forEach((k, v) -> System.out.println(k + " - " + v));
        return result;
    }

    /*
     *  Regresar en un mapa el promedio de ventas todas las consolas
     *  la clave del mapa será la consola y el valor el promedio de ventas.
     */
    static Map<Console, Double> getConsolesPricesAvg(Stream<Videogame> stream) {
        Map<Console, Double> result = stream
                .collect(Collectors.groupingBy(
                        Videogame::getConsole,
                        Collectors.averagingDouble(Videogame::getPrice)));
        result.forEach((k, v) -> System.out.println(k + " - " + v));
        return result;
    }
}
