/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.concurrency;

/**
 *
 * @author Aditia_RS458
 */
public class MyRunnable implements Runnable{
    private final long countUntil;

    public MyRunnable(long limit) {
        this.countUntil = limit;
    }
    
    
    @Override
    public void run() {
        long sum = 0;
        for(long i = 1; i<countUntil; i++){
            sum += i;
        }
        System.out.println("Summing from 1 to "+countUntil+" is "+sum);
    }
}
