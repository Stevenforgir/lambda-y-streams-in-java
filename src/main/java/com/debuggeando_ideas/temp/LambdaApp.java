package com.debuggeando_ideas.temp;

import com.debuggeando_ideas.lambdas.Math;

public class LambdaApp {

    public static void main(String[] args) {
        Math substract = new Math() {
            @Override
            public Double execute(Double a, Double b){
                return a - b;
            }
        };

        Math multiply = (a,b) -> a*b;

        Math divide = (a, b) -> {
            System.out.println("divide");
            return a/b;
        };

        System.out.println(substract.execute(15.0,5.0));
        System.out.println(multiply.execute(5.0, 7.0));
        System.out.println(divide.execute(500.0, 2.0));
        System.out.println(divide.sum(500.0, 2.0));

        Math substractLambda = (a,b) -> a-b;
    }
}
