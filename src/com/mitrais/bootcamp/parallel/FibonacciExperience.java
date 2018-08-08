/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.parallel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.TemporalField;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author Aditia_RS458
 */
class FibonacciProblem {
    
    public int n;
    
    public FibonacciProblem(int n) {
        this.n = n;
    }
    
    public long solve() {
        return fibonacci(n);
    }
    
    private long fibonacci(int n) {
        System.out.println("Thread: "
                + Thread.currentThread().getName() + " calculates " + n);
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}

class FibonacciTask extends RecursiveTask<Long> {
    
    private static final long serialVersionUID = 6136927121059165206L;
    
    private static final int THRESHOLD = 5;
    
    private FibonacciProblem problem;
    public long result;
    
    public FibonacciTask(FibonacciProblem problem) {
        this.problem = problem;
    }
    
    @Override
    public Long compute() {
        if (problem.n < THRESHOLD) { // easy problem, don't bother with parallelism
            result = problem.solve();
        } else {
            FibonacciTask worker1 = new FibonacciTask(new FibonacciProblem(problem.n - 1));
            FibonacciTask worker2 = new FibonacciTask(new FibonacciProblem(problem.n - 2));
            worker1.fork();
            result = worker2.compute() + worker1.join();
            
        }
        return result;
    }
    
}

public class FibonacciExperience {
    
    public static long fibonacciRecursive(int i) {
        if (i <= 1) {
            return i;
        } else {
            return fibonacciRecursive(i - 1) + fibonacciRecursive(i - 2);
        }
    }
    
    public static long fibonacciNonRecursive(int i) {
        if (i <= 1) {
            return i;
        } else {
            int a = 0;
            int b = 1;
            int temp = 0;
            for (int x = 1; x < i; x++) {
                temp = b;
                b += a;
                a = temp;
            }
            return b;
        }
    }
    
    public static float elapsedSeconds(long start, long end) {
        return (end - start) / 1_000_000_000;
    }
    
    public static void main(String[] args) {
        
        int n = 50;

//        int processors = Runtime.getRuntime().availableProcessors();
//        startTime = System.nanoTime();
//        FibonacciProblem bigProblem = new FibonacciProblem(n);
//
//        FibonacciTask task = new FibonacciTask(bigProblem);
//        ForkJoinPool pool = new ForkJoinPool(processors);
//        pool.invoke(task);
//
//        long result = task.result;
//        endTime = System.nanoTime();
//        System.out.println("Parallel Fibonacci : " + result);
//        System.out.printf("Elapsed Time: %f seconds%n", elapsedSeconds(startTime, endTime));
        TimingUtils.timeOp(new Op() {
            @Override
            public String runOp() {
                System.out.println("Fibonacci Recursive");
                long result = fibonacciRecursive(n);
                return "Hasilnya : "+result;
            }
        });
        
        TimingUtils.timeOp(new Op() {
            @Override
            public String runOp() {
                System.out.println("Fibonacci Non Recursive");
                long result = fibonacciNonRecursive(n);
                return "Hasilnya : "+result;
            }
        });
        
    }
    
}
