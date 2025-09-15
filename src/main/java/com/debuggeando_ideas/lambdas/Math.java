package com.debuggeando_ideas.lambdas;

@FunctionalInterface
public interface Math {

    Double execute(Double a, Double b);
/*
   Da error porque una interfaz funcional solo puede tener un metodo abstracto
    Double excecute2(Double a, Double b);
*/

    default Double sum(Double a, Double b) { return (Double) (a + b); }
}
