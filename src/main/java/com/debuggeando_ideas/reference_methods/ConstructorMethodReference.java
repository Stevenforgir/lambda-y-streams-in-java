package com.debuggeando_ideas.reference_methods;

import lombok.ToString;

import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

public class ConstructorMethodReference {
    public static void main(String[] args) {
        //Supplier<MyObjectConstructed> object = () -> new MyObjectConstructed();
        Supplier<MyObjectConstructed> object = MyObjectConstructed::new;
        System.out.println(object.get());
    }
}
@ToString
class MyObjectConstructed {
    private String string;

    private Integer num;

    MyObjectConstructed() {
        this.string = UUID.randomUUID().toString();
        this.num= new Random().nextInt(1000);
    }
}