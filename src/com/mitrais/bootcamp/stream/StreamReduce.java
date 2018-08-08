/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.stream;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Aditia_RS458
 */
public class StreamReduce {

    public static void main(String[] args) {

        //With accumulator
        System.out.println("With accumulator");
        int[] array = {23, 43, 56, 97, 32};
        Arrays.stream(array).reduce((x, y) -> x + y).ifPresent(s -> System.out.println(s));
        Arrays.stream(array).reduce(Integer::sum).ifPresent(s -> System.out.println(s));
        Arrays.stream(array).reduce(StatisticsUtility::addIntData).ifPresent(s -> System.out.println(s));

        //With identity & accumulator
        System.out.println("With identity &  accumulator");
        int startValue = 100;
        int sum = Arrays.stream(array).reduce(startValue, (x, y) -> x + y);
        System.out.println(sum);
        sum = Arrays.stream(array).reduce(startValue, Integer::sum);
        System.out.println(sum);
        sum = Arrays.stream(array).reduce(startValue, StatisticsUtility::addIntData);
        System.out.println(sum);

        //With identity & accumulator & combiner
        System.out.println("With identity & accumulator & combiner");
        List<Integer> list2 = Arrays.asList(2, 3, 4);
        //Here result will be 2*2 + 2*3 + 2*4 that is 18. 
        int res = list2.parallelStream().reduce(100, (s1, s2) -> s1 * s2, (p, q) -> p + q);
        System.out.println(res);
    }

}

class StatisticsUtility {

    public static int addIntData(int num1, int num2) {
        return num1 + num2;
    }
}
