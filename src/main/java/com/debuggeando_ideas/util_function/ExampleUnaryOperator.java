package com.debuggeando_ideas.util_function;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

/**
 * En esencia es una interfaz Function, pero solo se especifica una vez el tipo de dato, ya que se asume
 * que el mismo que tipo que se revibe es el que se retorna
 */
public class ExampleUnaryOperator {

    //static Function<String, String> funToUpper = s -> s.toUpperCase();
    static Function<String, String> funToUpper = String::toUpperCase;
    static UnaryOperator<String> unaryOperator = String::toUpperCase;

    static UnaryOperator<Integer> int1 = n -> n*n;
    static IntUnaryOperator int2 = n-> n * n;

    public static void main(String[] args) {
        String arg = "lambdas";
        System.out.println(funToUpper.apply(arg));
        System.out.println(unaryOperator.apply(arg));

        System.out.println(int1.apply(3));
        System.out.println(int2.applyAsInt(2));
    }

}
