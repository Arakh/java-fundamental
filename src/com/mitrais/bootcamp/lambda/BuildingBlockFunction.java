/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author Aditia_RS458
 */
public class BuildingBlockFunction {

    public static <T, R> R transform(T value, Function<T, R> f) {
        return f.apply(value);
    }

    private static String[] words
            = {"hi", "hello", "hola", "bye", "goodbye", "adios"};

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Abdul", 189),
                new Person("Aceng", 190),
                new Person("Maman", 140));

        Function<List<Person>, Integer> aggregator
                = p -> p.stream().collect(Collectors.summingInt(Person::getHeight));
        int sumHeight = aggregator.apply(people);

        //First variation
        System.out.println("Summing the height of all people : " + sumHeight);

        //Second variation
        String newString = BuildingBlockFunction.transform("i am lower", String::toUpperCase);
        System.out.println("Uppercasing : " + newString);

      
    }
}
