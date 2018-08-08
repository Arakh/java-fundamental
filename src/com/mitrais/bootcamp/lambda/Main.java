/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.lambda;

import java.time.LocalDate;

/**
 *
 * @author Aditia_RS458
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    interface NumericTest {

        boolean computeTest(int n);
    }

    public static void main(String[] args) {

        //Basic Lambda Expression
        NumericTest isEven = no -> (no % 2) == 0;
        NumericTest isNegative = n -> (n < 0);
        
        System.out.println(isEven.computeTest(5));
        System.out.println(isNegative.computeTest(-1));

        LocalDate birthday = LocalDate.parse("2010-10-10");
        System.out.println(birthday.toString());
        
    }

}
