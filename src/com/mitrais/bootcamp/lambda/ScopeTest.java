/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.lambda;

import java.util.function.Consumer;

/**
 *
 * @author Aditia_RS458
 */
public class ScopeTest {

    public int x = 0;
    
    class FirstLevel {
        public int x = 1;
        
        void methodFirstLevel(int x){
            Consumer<Integer> myConsumer = (y) -> {
                System.out.println("x = "+x);
                System.out.println("y = "+y);
                System.out.println("this.x = "+this.x);
                System.out.println("LambdaScopeTestThis.x = "+ScopeTest.this.x);
            };
            
            myConsumer.accept(x);
        }
    }
    
    public static void main(String[] args) {
        ScopeTest st = new ScopeTest();
        ScopeTest.FirstLevel fl = st.new FirstLevel();
        
        fl.methodFirstLevel(10);
        
    }
}
