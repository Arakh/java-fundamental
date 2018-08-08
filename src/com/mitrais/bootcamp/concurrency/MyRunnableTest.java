/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aditia_RS458
 */
public class MyRunnableTest {

    public static void main(String[] args) {
        List<Thread> thread = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            Runnable task = new MyRunnable(1_000_000 + i);
            Thread worker = new Thread(task);
            worker.setName("The Number " + i);
            worker.start();
            thread.add(worker);
        }

        int running = 0;
        do {
            running = 0;
            for (Thread t : thread) {
                if (t.isAlive()) {
                    System.out.println("Thread "+t.getName()+" is still alive");
                    running++;
                }
            }
            System.out.printf("We have %d running thread%n", running);
        }while(running > 0);
    
    }
}
