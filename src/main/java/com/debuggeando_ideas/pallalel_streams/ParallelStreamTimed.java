package com.debuggeando_ideas.pallalel_streams;

import java.util.stream.IntStream;

/**
 * Se debe usar cuando se va a trabajar con cantidades muy grandes de datos
 *
 */
public class ParallelStreamTimed {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        IntStream.rangeClosed(1,200000000).parallel().reduce(0, Integer::sum);
        long endTime = System.currentTimeMillis();
        System.out.println("Total time: " + (endTime - startTime));
    }

}
