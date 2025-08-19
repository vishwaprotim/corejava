package com.protim.corejava;



import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class LoopVsStream {

    static final int DATA_SIZE = 60_000_000;

    static List<Long> dataset = new ArrayList<>(DATA_SIZE);


    static {
        for(int i = 0; i < DATA_SIZE; i++){
            dataset.add((long) i);
        }
    }

    static long sumByLoop(){
        long sum = 0;
        for(long i : dataset){
            sum = sum + i;
        }
        return sum;
    }

    static long sumByStream(){
        return dataset.stream().reduce(0L, Long::sum);
    }

    static long sumByLongStream(){
        return dataset.stream().mapToLong(Long::longValue).sum();
    }

    static long sumByParallelStream(){
        return dataset.parallelStream().mapToLong(Long::longValue).sum();
    }



   public static void main(String[] args){
        System.out.println("JVM is warming up...");
        for(int i=0; i < 5; i++){
            sumByLoop();
            sumByStream();
            sumByLongStream();
            sumByParallelStream();
        }
        System.out.println("JVM warmup completed...");
        long startTime;
        long sum;

        startTime = System.currentTimeMillis();
        sum = sumByLoop();
        System.out.println(MessageFormat.format("Operation: {0} | Sum: {1} | Time Taken: {2}ms",
                "Loop",
                sum,
                (System.currentTimeMillis()-startTime)));

        startTime = System.currentTimeMillis();
        sum = sumByStream();
        System.out.println(MessageFormat.format("Operation: {0} | Sum: {1} | Time Taken: {2}ms",
                "Stream",
                sum,
                (System.currentTimeMillis()-startTime)));

        startTime = System.currentTimeMillis();
        sum = sumByLongStream();
        System.out.println(MessageFormat.format("Operation: {0} | Sum: {1} | Time Taken: {2}ms",
                "Int Stream",
                sum,
                (System.currentTimeMillis()-startTime)));

        startTime = System.currentTimeMillis();
        sum = sumByParallelStream();
        System.out.println(MessageFormat.format("Operation: {0} | Sum: {1} | Time Taken: {2}ms",
                "Parallel Stream",
                sum,
                (System.currentTimeMillis()-startTime)));
    }


}