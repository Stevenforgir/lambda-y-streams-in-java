package com.debuggeando_ideas.pallalel_streams;

import java.util.List;
import java.util.stream.IntStream;

public class StreamTimed {

    /**
     * Para este caso es mas rapido el stream que no esta paralelizado
     * @param args
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        IntStream.rangeClosed(1,200000000).reduce(0, Integer::sum);
        long endTime = System.currentTimeMillis();
        System.out.println("Total time: " + (endTime - startTime));
    }
}
