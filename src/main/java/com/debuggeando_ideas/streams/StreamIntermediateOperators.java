package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.util.BasicVideogame;
import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Review;
import com.debuggeando_ideas.util.Videogame;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntermediateOperators {

    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();
        //System.out.println(videogames.count());
        //distinctOperator(videogames);
        //limitOperator(videogames);
        //skipOperator(videogames);
        //filterOperator(videogames);
        //mapOperator(videogames);
        //flatMapOperator(videogames);
        //mapVSFlatMap(videogames);
        //peekOperator(videogames);
        //sortOperator(videogames);
        //takeWhileOperator(videogames);
        dropWhileOperator(videogames);
    }

    static void distinctOperator(Stream<Videogame> stream){
        System.out.println(stream.distinct().count());
    }

    static void limitOperator(Stream<Videogame> stream){
        List<Videogame> r = stream.limit(5).collect(Collectors.toList());
        r.forEach(System.out::println);
    }

    /**
     * Omite los primeros n objetos que se especifican
     * @param stream
     */
    static void skipOperator(Stream<Videogame> stream){
        List<Videogame> r = stream.skip(15).collect(Collectors.toList());
        r.forEach(System.out::println);
    }

    static void filterOperator(Stream<Videogame> stream){
        List<Videogame> r = stream
                .filter(v -> v.getPrice() > 12.0)
                .filter(v -> !v.getIsDiscount())
                .filter(v -> v.getOfficialWebsite().contains("forza"))
                .collect(Collectors.toList());
        r.forEach(System.out::println);
    }

    static void mapOperator(Stream<Videogame> stream){
        List<BasicVideogame> basicVideogames = stream
                .map(v -> BasicVideogame.builder()
                        .name(v.getName())
                        .price(v.getPrice())
                        .console(v.getConsole())
                        .build())
                .collect(Collectors.toList());
        basicVideogames.forEach(System.out::println);
        System.out.println("------");
        List<String> titles = basicVideogames.stream().map(BasicVideogame::getName).collect(Collectors.toList());
        titles.forEach(System.out::println);
    }

    /**
     * Para mapear listas de listas
     * @param stream
     */
    static void flatMapOperator(Stream<Videogame> stream){
        List<Review> r = stream.flatMap(v -> v.getReviews().stream()).collect(Collectors.toList());
        System.out.println(r);
    }

    static void mapVSFlatMap(Stream<Videogame> stream){
        //var totalReviews = stream.map(v -> v.getReviews().size()).collect(Collectors.toList());
        var totalReviews = stream.flatMap(v -> v.getReviews().stream()).count();
        System.out.println(totalReviews);
    }

    /**
     * Peek es similar al forEach pero es un operador intermedio, tiene que haber un
     * operador final como collect o algun otro en algun punto despues del peek
     * Permite hacer una operacion sobre el stream y genera otro stream para seguirlo procesando despues
     * @param stream
     */
    static void peekOperator(Stream<Videogame> stream){
        stream.peek(v -> v.setName("")).forEach(System.out::println);
    }

    static void sortOperator(Stream<Videogame> stream){
        List<Videogame> listSorted = stream
                .sorted(Comparator.comparingInt(v -> v.getReviews().size()))
                .collect(Collectors.toList());
        listSorted.forEach(System.out::println);
    }

    /*
    casi siempre se debe ordernar la lista antes de usar el takeWWhile
     */
    static void takeWhileOperator(Stream<Videogame> stream){
        List<Videogame> listSorted = stream
                .sorted(Comparator.comparing(Videogame::getName))
                .takeWhile(v -> !v.getName().startsWith("M"))
                .collect(Collectors.toList());
        listSorted.forEach(System.out::println);
    }

    static void dropWhileOperator(Stream<Videogame> stream){
        List<Videogame> listSorted = stream
                .sorted(Comparator.comparing(Videogame::getName))
                .dropWhile(v -> !v.getName().startsWith("M"))
                .collect(Collectors.toList());
        listSorted.forEach(System.out::println);
    }
}
