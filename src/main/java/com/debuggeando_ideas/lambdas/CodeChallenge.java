package com.debuggeando_ideas.lambdas;

import java.util.List;

public class CodeChallenge {
    public static void main(String[] args) {
        List<String> countries =List.of("Colombia", "Venezuela", "Bolivia", "Brasil");
        countries.forEach(c -> System.out.println(c));
        countries.forEach(city -> {
            if(city.length() < 8){
                System.out.println("Ciudad corta " + city);
            } else {
                System.out.println("Ciudad larga: " + city);
            }
        });
    }
}
