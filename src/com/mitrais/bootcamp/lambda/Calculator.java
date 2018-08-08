/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.lambda;

/**
 *
 * @author Aditia_RS458
 */
public class Calculator {

    interface IntegerMath {
        int operation(int a, int b);
    }
    
    int operateBinary(int a, int b, IntegerMath op){
        return op.operation(a, b);
    }

    
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        
        System.out.println(String.format("A(%d) + B(%d) =%d", 5, 8, cal.operateBinary(5, 8, addition)));
        System.out.println(String.format("A(%d) + B(%d) =%d", 5, 8, cal.operateBinary(5, 8, subtraction)));
    }

}
