/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 *
 * @author Aditia_RS458
 */
public class StreamCreation {

    public static void main(String[] args) {
        //Empty Stream
        Stream<String> streamEmpty = Stream.empty();

        //Stream of Collection
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();

        //Stream of Array
        Stream<String> streamOfArray = Stream.of("a", "b", "c");
        String[] arrayString = new String[]{"a", "b", "c"};
        streamOfArray = Arrays.stream(arrayString);

        //Stream Builder
        Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();

        //Stream Generate
        Stream<String> streamGenerate = Stream.generate(() -> "element").limit(10);

        //Stream iterate
        Stream<Integer> streamIterate = Stream.iterate(40, n -> n + 2).limit(10);
        streamIterate.forEach(System.out::println);

        //Stream primitive
        IntStream intStream = IntStream.range(1, 3);
        List<Integer> fromIntStream = intStream.boxed().collect(Collectors.toList());
        fromIntStream.forEach(System.out::println);

        LongStream longStream = LongStream.rangeClosed(1, 3);
 
    }

}
