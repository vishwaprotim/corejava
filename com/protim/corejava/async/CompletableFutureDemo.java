package com.protim.corejava.async;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class CompletableFutureDemo {


    // Completable future execution starts as soon as we call supplyAsync
    // When we call supplyAsync or runAsync, task is assigned to a thread
    // from fork join pool, ready for execution.
    // There is no need to call get() to retrieve the result, as execution
    // has already started.

    public static void main(String[] args){
        var task = CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("Execution Started for thread: " + Thread.currentThread().getName());
                    var op = IntStream.rangeClosed(1, 10_000).map(x -> x*x*x).sum();
                    delay(2);
                    return op;
                }
        );
        task.thenAccept(x ->  System.out.println("This is the result: " + x));
        System.out.println("This is from main");
        delay(5);
        System.out.println("Exiting main");
    }

    public static void delay(int seconds){
        try{
            Thread.sleep(seconds * 1000L);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
