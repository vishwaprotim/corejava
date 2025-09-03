package com.protim.corejava.sort;

public class BubbleSort {

    /*
        Check the details and write up here:
        https://github.com/vishwaprotim/corejava/wiki/01.-Bubble-Sort
     */


    public static int[] bubbleSort(int[] arr){
        if(arr.length <= 1){
            return arr;
        }
        for(int j = 0; j < arr.length - 1 ; j++){
            boolean swapped = false;
            for(int i = 0; i < arr.length - 1 - j; i++){
                if(arr[i] > arr[i +1]) {
                    // swap these
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;

                    swapped = true;
                }
            }
            if(!swapped){
                // No swapping in current iteration, i.e., the array has been sorted
                return arr;
            }
        }

        return arr;
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

    public static void printArr(int[] arr){
        System.out.print("[ ");
        for(var x : arr){
            System.out.print(x + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        // run the code
        int[] arr = new int[]{4,3,2,1,0,12,11, 14, 13, -1, -2, 3, 6};
        printArr(arr);
        System.out.println("Sorted array: ");
        bubbleSort(arr);
        printArr(arr);

    }

}
