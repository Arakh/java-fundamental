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
public class Counter implements Runnable{
    private final App1 mainApp;
    private final int loop;
    
    public Counter(App1 mainApp, int loop){
        this.mainApp = mainApp;
        this.loop = loop;
    }

    @Override
    public void run() {
        for(int i=0; i<loop; i++){
            String threadName = Thread.currentThread().getName();
            System.out.printf("%s: %s%n", threadName, i);
            mainApp.pause(Math.random());
        }
    }
    
}
