package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.Console;
import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Review;
import com.debuggeando_ideas.util.Videogame;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Un Stream es un objeto que permite realizar de forma sencilla operaciones de busqueda,
 * filtrado, recoleccion y otras operaciones sobre una coleccion de datos
 *
 * Un stream recorre todos los elementos de una coleccion y durante el proceso realiza
 * alguna operacion. Una vez terminada la ejecucion el stream se cierra y no se puede volver a utilizar.
 */
public class ExerciseLambdas {

    public static void main(String[] args) {
        List<Videogame> videogameList = Database.videogames;
        Stream<Videogame> videogames1 = videogameList.stream();
        Stream<Videogame> videogames2 = videogameList.stream();
        Stream<Videogame> videogames3 = videogameList.stream();
        Stream<Videogame> videogames4 = videogameList.stream();
        Stream<Videogame> videogames5 = videogameList.stream();
        exercise1(videogames1);
        System.out.println("----------exercise2-----------");
        exercise2(videogames2);
        System.out.println("----------exercise3-----------");
        exercise3(videogames3);
        System.out.println("----------exercise4-----------");
        exercise4(videogames4);
        System.out.println("----------exercise5-----------");
        exercise5(videogames5);
    }

    /*
    *Regresar true si el stream contiene al menos un videojuego con número de ventas mayor a 10
    * y no este en descuento o su precio sea mayor a 9.99 de lo contrario regresar false.
     */
    static Boolean exercise1(Stream<Videogame> stream) {
        Boolean result = stream
                .anyMatch(v -> (v.getTotalSold() > 10 && !v.getIsDiscount())|| v.getPrice() >9.99);
        System.out.println("exercise1: " + result);
        return result;
    }

    /*
     *Regresar un Stream unicamente con los titulos de todas las consolas que sean de XBOX
     * durante el proceso imprimir los resultados ignorando los repetidos.
     */
    static Stream<String> exercise2(Stream<Videogame> stream) {
        Stream<String> result = stream
                .distinct()
                .filter(v -> v.getConsole().equals(Console.XBOX))
                .peek(System.out::println)
                .map(Videogame::getName);
        result.forEach(System.out::println);
        return result;
    }

    /*
     *Regresar el videojuego con el mayor número de ventas
     * unicamente contemplando los primers 10 elementos del stream.
     */
    static Videogame exercise3(Stream<Videogame> stream) {
        Videogame result = stream
                .limit(10)
                .max(Comparator.comparingInt(Videogame::getTotalSold))
                .orElseThrow(NoSuchElementException::new);
        System.out.println("exercise3: " + result);
        return result;
    }

    /*
     *Regresar un stream con todos los comentarios del cada review de todos los videojuegos del stream.
     */
    static Stream<String> exercise4(Stream<Videogame> stream) {
        Stream<String> result = stream
                .flatMap(v -> v.getReviews().stream()
                        .map(Review::getComment));
        result.forEach(System.out::println);
        return result;
    }

    /*
     *Regresar un stream con los todos los videojuegos con precio menores a 20.0
     * sin utilizar el operador filter().
     */
    static Stream<Double> exercise5(Stream<Videogame> stream) {
        Stream<Double> result = stream
                .sorted(Comparator.comparingDouble(v -> v.getPrice()))
                .takeWhile(v -> v.getPrice() < 20.0)
                .map(v -> v.getPrice());
        result.forEach(System.out::println);
        return result;
    }

}
