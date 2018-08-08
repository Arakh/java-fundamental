/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitrais.bootcamp.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Aditia_RS458
 */
public class CompletableFutureCallback {

    public static void main(String[] args) {
        long started = System.currentTimeMillis();

        CompletableFuture<String> data = createCompletableFuture()
                .thenApply((Integer count) -> {
                    int transformedValue = count * 10;
                    return transformedValue;
                }).thenApply(transformed -> "Finally creates a string: " + transformed);

        try {
            System.out.println(data.get());
        } catch (InterruptedException | ExecutionException e) {

        }
    }

    public static CompletableFuture<Integer> createCompletableFuture() {
        CompletableFuture<Integer> result = CompletableFuture.supplyAsync(() -> {
            try {
                // simulate long running task
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            return 20;
        });
        return result;
    }
}
