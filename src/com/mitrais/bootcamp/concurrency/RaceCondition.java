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
 */
public class RaceCondition implements Runnable {

    private final static int LOOP_LIMIT = 5;
    private final static int POOL_SIZE = 10;
    private int latestThreadNum = 0;

    public RaceCondition() {
        ExecutorService taskList;
        taskList = Executors.newFixedThreadPool(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            taskList.execute(this);
        }
    }

    @Override
    public void run() {
        int currentThreadNum;
        synchronized (this) {
            currentThreadNum = latestThreadNum;
            System.out.println("Set currentThreadNum to " + currentThreadNum);
            latestThreadNum = latestThreadNum + 1;
            for (int i = 0; i < LOOP_LIMIT; i++) {
                doSomethingWith(currentThreadNum, i);
            }
        }
    }

    private void doSomethingWith(int currentThreadNum, int loop) {
        System.out.printf("Set currentThreadNum %d to %d%n", currentThreadNum, loop);
    }

    public static void main(String[] args) {
        new RaceCondition();
    }
}
