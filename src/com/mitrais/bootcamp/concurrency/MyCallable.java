/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.concurrency;

import java.util.concurrent.Callable;

/**
 *
 * @author Aditia_RS458
 */
public class MyCallable implements Callable<Long>{
    private final long countUntil;

    public MyCallable(long limit) {
        this.countUntil = limit;
    }

    @Override
    public Long call() throws Exception {
        long sum = 0;
        for(long i = 1; i<countUntil; i++){
            sum += i;
        }
        return  sum;
    }
}
