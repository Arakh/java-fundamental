/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Aditia_RS458
 * 
 * Approach Three: Inner Class that Implements Runnable
 * 
 * Advantages
– Easy to access main app.
• Methods in inner classes can access any public or private methods or instance
variables of outer class
– Can pass arguments to run
• As with separate classes, you pass args to constructor, which stores them in instance
variables that run uses
• Disadvantages
– Tight coupling
• run method tied closely to this application
– Danger of race conditions
• You usually use this approach specifically because you want to access data in main
application. So, if run modifies some shared data, you must synchronize.
 */
public class App3 {

    public App3() {
        ExecutorService taskList = Executors.newFixedThreadPool(100);
        taskList.execute(new Counter(6));
        taskList.execute(new Counter(5));
        taskList.execute(new Counter(4));
        taskList.shutdown();
    }

    private void pause(double seconds) {
        try {
            Thread.sleep(Math.round(1000.0 * seconds));
        } catch (InterruptedException ie) { }
    }

    private class Counter implements Runnable { // Inner class

        private final int loopLimit;

        public Counter(int loopLimit) {
            this.loopLimit = loopLimit;
        }

        public void run() {
            for (int i = 0; i < loopLimit; i++) {
                String threadName = Thread.currentThread().getName();
                System.out.printf("%s: %s%n", threadName, i);
                pause(Math.random());
            }
        }
    }
}
