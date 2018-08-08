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
 * Main App : Implements Runnable
 *
 *• Advantages
– Easy to access main app.
• run is already inside main app. Can access any public or private methods or instance
variables.
• Disadvantages
– Tight coupling
• run method tied closely to this application
– Cannot pass arguments to run
• So, you either start a single thread only (quite common), or all the threads do very
similar tasks
– Danger of race conditions
• You usually use this approach specifically because you want to access data in main
application. So, if run modifies some shared data, you must synchronize.
 */
public class App2 implements Runnable{

    private final int loopLimit;

    public App2(int loopLimit) {
        this.loopLimit = loopLimit;
        ExecutorService taskList = Executors.newFixedThreadPool(100);
        taskList.execute(this);
        taskList.execute(this);
        taskList.execute(this);
        taskList.shutdown();
    }

    private void pause(double seconds) {
        try {
            Thread.sleep(Math.round(1000.0 * seconds));
        } catch (InterruptedException ie) {
        }
    }

    public void run() {
        for (int i = 0; i < loopLimit; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.printf("%s: %s%n", threadName, i);
            pause(Math.random());
        }
    }
}
