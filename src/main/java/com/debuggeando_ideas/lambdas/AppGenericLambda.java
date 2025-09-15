package com.debuggeando_ideas.lambdas;

import com.debuggeando_ideas.fundamentals.Employee;
import com.debuggeando_ideas.fundamentals.Product;

public class AppGenericLambda {

    public static void main(String[] args) {
        Printer<String> printString = string -> System.out.println(string);
        printString.print("Hola mundo");

        Printer<Product> printProduct = product -> System.out.println(product);
        Product product = new Product();
        product.setId(123L);
        product.setPrice(7000.5);
        product.setName("smartphone");
        printProduct.print(product);
    }
}
