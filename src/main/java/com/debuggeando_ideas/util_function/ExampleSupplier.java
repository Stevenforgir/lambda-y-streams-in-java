package com.debuggeando_ideas.util_function;

import java.util.Random;
import java.util.function.Supplier;

/**
 * Es lo contrario a la interfaz consumer
 * Su objetivo es proveer algun tipo de objeto
 */
public class ExampleSupplier {
    static Supplier<Integer> randomInt = () -> new Random().nextInt(100);
    static Supplier<MyProduct> productSupplier = () -> new MyProduct(100, "Smartphone");

    public static void main(String[] args) {
        System.out.println(randomInt.get());
        System.out.println(randomInt.get());
        System.out.println(randomInt.get());
        System.out.println(productSupplier.get());


    }
}
