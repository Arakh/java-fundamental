/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.parallel;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Aditia_RS458
 */
class NumberFinderTask extends RecursiveTask<Integer> {

    private final List<Integer> intCollectios;
    private final int matcher;
    
    public NumberFinderTask(List<Integer> intCollectios, int matcher){
        this.intCollectios = intCollectios;
        this.matcher = matcher;
    }

    @Override
    protected Integer compute() {
        int counter = 0;
        System.out.println(intCollectios);
        for (int i : intCollectios) {
            if (String.valueOf(i).contains(String.valueOf(matcher))) {
                counter++;
            }
        }
        System.out.println("Result: "+counter);
        return counter;
    }
}

public class NumberFinder {

    public static void main(String[] args) {
        List<Integer> numbers = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());

        NumberFinderTask nFT1 = new NumberFinderTask(numbers.subList(0, (numbers.size()/2)), 1);
        NumberFinderTask nFT2 = new NumberFinderTask(numbers.subList((numbers.size()/2), numbers.size()-1), 1);

        nFT1.fork();
        System.out.println("After fork");
        Integer rightOcc = nFT2.compute();
        System.out.println("After compute");
        Integer leftOcc = nFT1.join();
        System.out.println("After join");
        System.out.println(leftOcc+" - "+rightOcc);
        System.out.println("The occurance is : "+(rightOcc + leftOcc));
    }

}
