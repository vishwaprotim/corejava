package com.protim.corejava;

public class ArrayUtils {

    public static void printArray(int[] arr){
        System.out.print("[ ");
        for(var x : arr){
            System.out.print(x + " ");
        }
        System.out.println("]");
    }


    public static void swap(int a, int b){
        // Remember, as Java uses pass by value, this method will never work
        // In simpler words, you cannot actually create a swap method in Java.
        // There are alternatives, e.g., swapping within an array, but let's
        // not make this complicated.
        int temp = a;
        a = b;
        b = temp;
    }
}
