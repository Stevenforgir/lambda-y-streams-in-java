package com.debuggeando_ideas.util_function;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 * Hereda de la BiFunction
 */
public class ExampleBinaryOperator {

    public static void main(String[] args) {
        BiFunction<String, String, String> normalizerFun = (a, b) -> a.toUpperCase() + " - " + b.toLowerCase();
        System.out.println(normalizerFun.apply("hola", "Mundo"));

        BinaryOperator<String> normalizer = (a, b) -> a.toUpperCase() + " - " + b.toLowerCase();
        System.out.println(normalizer.apply("hola", "Mundo"));
    }
}
