package com.debuggeando_ideas.streams;

import com.debuggeando_ideas.real_appplications.StrategyLambdas;
import com.debuggeando_ideas.util.Database;
import com.debuggeando_ideas.util.Videogame;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamFinalOperators {
    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();
        //countOperator(videogames);
        //forEachOperator(videogames);
        //anyMatchOperator(videogames);
        //allMatchOperator(videogames);
        //noneMatchOperator(videogames);
        //findFirstOperator(videogames);
        //findAnyOperator(videogames);
        //reduceOperator(videogames);
        //maxOperator(videogames);
        minOperator(videogames);
    }

    static void countOperator(Stream<Videogame> stream){
        System.out.println(stream.count());
    }

    static void forEachOperator(Stream<Videogame> stream){
        stream.forEach(System.out::println);
    }

    static void anyMatchOperator(Stream<Videogame> stream){
        boolean r = stream.anyMatch(v -> v.getTotalSold() > 5);
        System.out.println(r);
    }

    static void allMatchOperator(Stream<Videogame> stream){
        boolean r = stream.allMatch(v -> v.getTotalSold() > 5);
        System.out.println(r);
    }

    static void noneMatchOperator(Stream<Videogame> stream){
        boolean r = stream.noneMatch(v -> v.getReviews().isEmpty());
        System.out.println(r);
    }

    static void findFirstOperator(Stream<Videogame> stream){
        Optional<Videogame> r = stream.findFirst();
        System.out.println(r);
    }

    static void findAnyOperator(Stream<Videogame> stream){
        Optional<Videogame> r = stream.findAny();
        System.out.println(r);
    }

    static void reduceOperator(Stream<Videogame> stream){
        Optional<Integer> r = stream
                .filter(Videogame::getIsDiscount)
                .map(Videogame::getTotalSold)
                .reduce(Integer::sum);
        System.out.println(r);
    }

    static void maxOperator(Stream<Videogame> stream){
        Optional<Videogame> r = stream.max(Comparator.comparing(Videogame::getName));
        System.out.println(r.get().getName());
    }

    static void minOperator(Stream<Videogame> stream){
        Optional<Videogame> r = stream.min(Comparator.comparing(Videogame::getName));
        System.out.println(r.get().getName());
    }
}
