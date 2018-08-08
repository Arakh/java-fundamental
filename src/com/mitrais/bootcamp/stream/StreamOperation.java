/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.stream;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Aditia_RS458
 */
class Product {

    private String name;
    private int id;

    public Product(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}

public class StreamOperation {

    private static long counter;

    private static void wasCalled() {
        counter++;
    }

    public static void main(String[] args) {
        //Referencing Stream
        System.out.println("Referencing Stream");
        List<String> elements = Stream.of("a", "b", "c").filter(element -> element.contains("b"))
                .collect(Collectors.toList());
        Optional<String> anyElement = elements.stream().findAny();
        System.out.println(anyElement.get());
        Optional<String> firstElement = elements.stream().findFirst();
        System.out.println(firstElement.get());

        //Stream pipeline
        System.out.println("Stream Pipeline");
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        Stream<String> size = list.stream().skip(1)
                .map(element -> element.substring(0, 3)).sorted();
        size.forEach(System.out::println);

        //Lazy invocation
        System.out.println("Lazy Invocation");
        List<String> listInvocation = Arrays.asList("abc1", "abc2", "abc3");
        counter = 0;
        Stream<String> streamInvocation = listInvocation.stream().filter(element -> {
            wasCalled();
            return element.contains("2");
        });
        streamInvocation.forEach(System.out::println);

        //Reduce Method
        System.out.println("Reduce Method");
        OptionalInt reduced = IntStream.range(1, 4).reduce((a, b) -> a + b);
        System.out.println(reduced.getAsInt());

        int reducedTwoParams = IntStream.range(1, 4).reduce(10, (a, b) -> a + b);
        System.out.println(reducedTwoParams);

        int reducedParams = Stream.of(1, 2, 3).reduce(10, (a, b) -> a + b, (a, b) -> {
            System.out.println("combiner was called");
            return a + b;
        });
        System.out.println(reducedParams);

        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream().reduce(10, (a, b) -> a + b, (a, b) -> {
            System.out.println("combiner was called");
            return a + b;
        });
        System.out.println(reducedParallel);

        //Collect Method
        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugaro"));

        List<String> collectorCollection = productList.stream().map(Product::getName).collect(Collectors.toList());
        String listToString = collectorCollection.stream().collect(Collectors.joining(", "));
        System.out.println(listToString);

        double averageId = productList.stream().collect(Collectors.averagingDouble(Product::getId));
        System.out.println(averageId);

        DoubleSummaryStatistics statistic = productList.stream().collect(Collectors.summarizingDouble(Product::getId));
        System.out.println(statistic);

        Map<Integer, List<Product>> collectorMapOfLists = productList.stream().collect(Collectors.groupingBy(Product::getId));
        collectorMapOfLists.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });

        Map<Boolean, List<Product>> mapPartioned = productList.stream().collect(Collectors.partitioningBy(element -> element.getId() > 15));
        mapPartioned.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });

        //Stream peek
        Stream.of("bus", "car", "bycle", "flight", "train")
                .peek(e -> System.out.println(e))
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

        //findAny vs findFirst
        List<Integer> listFind = Arrays.asList(3, 5, 4, 1, 3);

        Optional<Integer> resultAny = listFind
                .stream().parallel()
                .filter(num -> num < 4).findAny();

        Optional<Integer> resultFirst = listFind
                .stream().parallel()
                .filter(num -> num < 4).findFirst();

        System.out.println(String.format("Any : %d \nFirst : %d", resultAny.get(), resultFirst.get()));

        //Match
        Predicate<Product> p1 = p -> p.getName().length() > 0 && p.getId() > 13;
        Predicate<Product> p2 = p -> p.getId() == 24;
        //using allMatch
        boolean b1 = productList.stream().allMatch(p1);
        System.out.println(b1);
        boolean b2 = productList.stream().allMatch(p2);
        System.out.println(b2);
        //using anyMatch
        boolean b3 = productList.stream().anyMatch(p1);
        System.out.println(b3);
        boolean b4 = productList.stream().anyMatch(p2);
        System.out.println(b4);
        //using noneMatch
        boolean b5 = productList.stream().noneMatch(p1);
        System.out.println(b5);

    }

}
