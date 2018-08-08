/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.lambda;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 *
 * @author Aditia_RS458
 */
public class BuildingBlockBinaryConsumerSupplier {

    public static void main(String[] args) {

        //First Variation Binary Operation
        BinaryOperator<Integer> addition = (a, b) -> a + b;
        int res = addition.apply(58, 45);
        System.out.println("Example result of binary operator : " + res);

        //First Variation Binary Operation
        Consumer<Integer> printMe = t -> System.out.println("Example result of binary operator printed by consumer " + t);
        printMe.accept(res);

        //Second Variation Binary Operation
        Consumer<Integer> setMe = t -> {
            t = 6;
            System.out.println("The new value of Example result of binary operator printed by consumer " + t);
        };
        setMe.accept(res);
   
        //First(Only have one actually) Supplier
        Supplier<String> iAmSupplier = () -> "The animportant one!!!";
        System.out.println(iAmSupplier.get());

    }
}
