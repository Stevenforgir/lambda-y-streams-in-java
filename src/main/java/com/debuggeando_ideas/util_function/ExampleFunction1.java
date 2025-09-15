package com.debuggeando_ideas.util_function;

import java.util.function.Function;

public class ExampleFunction1 {
    static Function<Integer, Integer> multiply = n -> n*10;
    static Function<Integer, Integer> sum = n -> n+10;
    static Function<Integer, Integer> multiplyThenAdd = multiply.andThen(sum);
    static Function<Integer, Integer> composeMultiply = multiply.compose(sum);

    public static void main(String[] args) {
        System.out.println(multiply.apply(10));
        System.out.println(sum.apply(5));
        System.out.println("multiply.andThen(sum) -> (5*10) + 10 = " +multiplyThenAdd.apply(5));
        System.out.println("multiply.compose(sum) -> (10+5) * 10 = " +composeMultiply.apply(5));
    }
}
