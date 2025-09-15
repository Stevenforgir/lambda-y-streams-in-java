package com.debuggeando_ideas.real_appplications;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class ComparatorLambdas {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4,3,6,8,7,5,8,10);
        numbers.sort((a, b) -> a-b); //ordena de menor a mayor
        System.out.println(numbers);

        List<String> names = Arrays.asList("Max", "Alex", "Opal");
        names.sort(String::compareTo);
        System.out.println(names);
        names.sort(Comparator.reverseOrder());
        System.out.println(names);

        List<Person> persons = Arrays.asList(
                new Person("Robert", 31),
                new Person("Andy", 32),
                new Person("Peter", 27),
                new Person("Ben", 32));
        persons.sort(Comparator.comparingInt(Person::getAge).thenComparing(Person::getName));
        System.out.println(persons);
    }

}

@Data
@AllArgsConstructor
class Person {
    private String name;
    private Integer age;
}
